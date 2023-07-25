package myLinkedList.main.interfaces;

public interface GBList<E> extends Iterable<E> {
    boolean add(E e);

    void remove(int index);

    E get(int index);

    int size();

    void update(int index, E e);
}