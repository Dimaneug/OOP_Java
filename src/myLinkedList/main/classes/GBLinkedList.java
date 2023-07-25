package myLinkedList.main.classes;

import myLinkedList.main.interfaces.GBDeque;
import myLinkedList.main.interfaces.GBList;

import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T>, GBDeque<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public GBLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean addFirst(T t) {
        try {
            if (this.size == 0) {
                this.first = new Node<T>(t, null, null);
                this.last = first;
                this.size++;
                return true;
            }
            Node<T> tmp = first;
            first = new Node<T>(t, null, tmp);
            tmp.prev = first;
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addLast(T t) {
        try {
            if (this.size == 0) {
                this.first = new Node<T>(t, null, null);
                this.last = first;
                this.size++;
                return true;
            }
            Node<T> tmp = last;
            last = new Node<T>(t, tmp, null);
            tmp.next = last;
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean add(T t) {
        return this.addLast(t);
    }

    private Node<T> node(int index) {
        if (index > size - 1) {
//            throw new IndexOutOfBoundsException();
            return null;
        }
        if (index == 0)
            return this.first;
        if (index == this.size - 1)
            return this.last;
        Node<T> tmp;
        if (index < this.size / 2) {
            tmp = this.first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = this.last;
            for (int i = this.size - 1; i > index; i--) {
                tmp = tmp.prev;
            }
        }
        return tmp;
    }

    @Override
    public void remove(int index) {
        Node<T> removable = node(index);
        removable.prev.next = removable.next;
        removable.next.prev = removable.prev;
        removable.elem = null;
        this.size--;
    }

    @Override
    public T get(int index) {
        Node<T> tmp = this.node(index);
        if (tmp != null)
            return tmp.elem;
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void update(int index, T t) {
        this.node(index).elem = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = first;


            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T tmp = current.elem;
                current = current.next;
                return tmp;
            }
        };
    }

    private static class Node<T> {
        T elem;
        Node<T> prev;
        Node<T> next;

        public Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GBLinkedList{values=[");
        Node<T> current = this.first;
        sb.append(first.elem);
        // не вижу смысла использовать здесь выше реализованный итератор
        // без него получается меньше кода
        while (current.next != null) {
            sb.append(",");
            current = current.next;
            sb.append(current.elem);
        }
        sb.append("]}");
        return sb.toString();
    }
}
