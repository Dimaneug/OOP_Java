package myFileRepository;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class FileRepository<T extends Serializable, ID extends IDable<ID> & Serializable> {
    File file;
    ID curID;

    public FileRepository(String path, ID id) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else System.out.println("Используется существующий файл");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.isFile() && file.canRead() && file.canWrite()) {
            this.file = file;
            curID = id;
        } else {
            System.out.println("Неправильный файл!");
        }
    }

    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    private static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    private static byte[] fromListToBytes(List<Byte> list) {
        byte[] result = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private byte[] getAllData() {
        byte[] allData = new byte[0];
        try (FileInputStream fis = new FileInputStream(this.file)) {
            allData = fis.readAllBytes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return allData;
    }

    private void deleteNulls(LinkedList<Byte> list) {
        byte[] byteLen = new byte[]{list.get(0), list.get(1), list.get(2), list.get(3)};
        int length = byteLen[0] << 24 | (byteLen[1] << 16 & 0xFF) | (byteLen[2] << 8 & 0xFF) | (byteLen[3] & 0xFF);
        for (int i = 0; i < 4; i++) {
            list.removeFirst();
        }
        // удаляем добавленные нули
        int i = list.size();
        while (i > length) {
            list.removeLast();
            i--;
        }
    }

    private int[] findPartById(byte[] allData, ID id) {
        LinkedList<Byte> listID = new LinkedList<>();
        LinkedList<Byte> dataById = new LinkedList<>();
        int startIndex = 0, endIndex = 0; // Показывают, какой "кусок" нужно вырезать
        boolean foundElement = false;
        boolean idWritten = false;
        int targetLen = 0, currentLen = 0;
        for (int i = 0; i < allData.length; i += 4) {
            if (targetLen == 0) {
                targetLen = allData[i] << 24 | (allData[i + 1] << 16 & 0xFF) | (allData[i + 2] << 8 & 0xFF) | (allData[i + 3] & 0xFF);
            }

            if (!idWritten) {
                listID.add(allData[i]);
                listID.add(allData[i + 1]);
                listID.add(allData[i + 2]);
                listID.add(allData[i + 3]);
            } else {
                dataById.add(allData[i]);
                dataById.add(allData[i + 1]);
                dataById.add(allData[i + 2]);
                dataById.add(allData[i + 3]);
            }
            currentLen += 4;
            if (currentLen >= targetLen + 4) {
                if (!idWritten) {
                    deleteNulls(listID);
                    idWritten = true;
                } else {
                    idWritten = false;
                    deleteNulls(dataById);
                    // преобразуем id из байтов в объект и сравниваем с переданным в функцию
                    try {
                        if (deserialize(fromListToBytes(listID)).equals(id)) {
                            startIndex = i - dataById.size() - listID.size() - (4 - (listID.size() % 4)) % 4 - 5;
                            endIndex = i + 3;
                            foundElement = true;
                            break;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    listID.clear();
                    dataById.clear();
                }
                targetLen = 0;
                currentLen = 0;
            }
        }
        if (foundElement) return new int[]{startIndex, endIndex};
        return null;
    }

    // Структура
    // 4 байта на длину ID
    // ID с добавлением нулей до кратности 4
    // 4 байта на длину Data
    // Data с добавлением нулей до кратности 4
    public void write(T t) {
        try (FileOutputStream fos = new FileOutputStream(this.file, true)) {
            byte[] tmp = serialize(this.curID);
            byte[] lengthID = ByteBuffer.allocate(4).putInt(tmp.length).array();
            fos.write(lengthID);
            fos.write(tmp);
            // дополняю нулями, чтобы длина айди была кратная 4
            for (int i = 0; i < (4 - (tmp.length % 4)) % 4; i++) {
                fos.write((byte) 0);
            }
            tmp = serialize(t);
            byte[] lengthData = ByteBuffer.allocate(4).putInt(tmp.length).array();
            fos.write(lengthData);
            fos.write(tmp);
            for (int i = 0; i < (4 - (tmp.length % 4)) % 4; i++) {
                fos.write((byte) 0);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        curID = curID.increase();
    }

    public void delete(ID id) {
        byte[] allData = this.getAllData();
        int[] partIndexes = this.findPartById(allData, id);
        if (partIndexes == null) return;

        int startIndex = partIndexes[0];
        int endIndex = partIndexes[1];
        byte[] newData = new byte[allData.length - (endIndex - startIndex + 1)];
        System.arraycopy(allData, 0, newData, 0, startIndex);
        System.arraycopy(allData, endIndex + 1, newData, startIndex, allData.length - endIndex - 1);
        try (FileOutputStream fos = new FileOutputStream(this.file)) {
            fos.write(newData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(ID id, T t) {
        byte[] allData = this.getAllData();
        int[] partIndexes = this.findPartById(allData, id);
        if (partIndexes == null) return;

        int startIndex = partIndexes[0];
        int endIndex = partIndexes[1];
        byte[] serializedID;
        byte[] serializedT;
        try {
            serializedID = serialize(id);
            serializedT = serialize(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int lenID = serializedID.length;
        int lenT = serializedT.length;
        byte[] newData = new byte[allData.length - (endIndex - startIndex + 1) + lenID + lenT + 8 + (4 - (lenID % 4)) % 4 + (4 - (lenT % 4)) % 4];
        System.arraycopy(allData, 0, newData, 0, startIndex);
        System.arraycopy(ByteBuffer.allocate(4).putInt(lenID).array(), 0, newData, startIndex, 4);
        System.arraycopy(serializedID, 0, newData, startIndex + 4, lenID);
        System.arraycopy(new byte[]{0, 0, 0}, 0, newData, startIndex + lenID + 4, (4 - (lenID % 4)) % 4);
        System.arraycopy(ByteBuffer.allocate(4).putInt(lenT).array(), 0, newData, startIndex + lenID + 4 + (4 - (lenID % 4)) % 4, 4);
        System.arraycopy(serializedT, 0, newData, startIndex + lenID + 8 + (4 - (lenID % 4)) % 4, serializedT.length);
        System.arraycopy(new byte[]{0, 0, 0}, 0, newData, startIndex + lenID + 8 + (4 - (lenID % 4)) % 4 + lenT, (4 - (lenT % 4)) % 4);
        System.arraycopy(allData, endIndex, newData, startIndex + lenID + 8 + (4 - (lenID % 4)) % 4 + lenT + (4 - (lenT % 4)) % 4, allData.length - endIndex - 1);
        try (FileOutputStream fos = new FileOutputStream(this.file, false)) {
            fos.write(newData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public T read(ID id) {
        byte[] allData = this.getAllData();
        int[] partIndexes = this.findPartById(allData, id);
        if (partIndexes == null) return null;

        int startIndex = partIndexes[0];
        int endIndex = partIndexes[1];
        T result;
        try {
            int idLen = serialize(id).length;
            startIndex += idLen + 4 + (4 - (idLen % 4)) % 4; // Смещаем на 4 байт (длина id) + размер id и кол-во добавленных нулей
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // считываем размер data и смещаем startIndex на 4 байта
        int dataLen = allData[startIndex] << 24 | (allData[startIndex + 1] << 16 & 0xFF) | (allData[startIndex + 2] << 8 & 0xFF) | (allData[startIndex + 3] & 0xFF);
        startIndex += 4;
        // убираем лишние нули
        endIndex -= (endIndex - startIndex) - dataLen;
        byte[] newData = new byte[endIndex - startIndex + 1];
        System.arraycopy(allData, startIndex, newData, 0, endIndex - startIndex);
        try {
            result = (T) deserialize(newData);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
