package myFileRepository;

public class Main {
    public static void main(String[] args) {
        TestID id = new TestID();
        TestData data = new TestData("pupsik", 332);
        TestData data1 = new TestData("pipsik", 892);
        FileRepository<TestData, TestID> fr = new FileRepository<>("test", id);
        fr.write(data);
        fr.write(data1);
        System.out.println(fr.read(id.increase()));
        fr.update(id.increase(), data);
        System.out.println(fr.read(id.increase()));
        fr.delete(id.increase());
        System.out.println(fr.read(id.increase()));

    }
}
