package main;

import java.util.Arrays;
import java.util.Iterator;

public class GBArrayList<T> implements GBList<T>{
    private T[] values;

    @SuppressWarnings("unchecked")

    public GBArrayList() {
        this.values = (T[]) new Object[0];
    }

    @Override
    public boolean add(T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = t;
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public void remove(int index) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index+1, values, index, temp.length - index-1);
        } catch (ClassCastException e) {
            throw e;
        }
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T t) {
        values[index] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(values);
    }

    @Override
    public String toString() {
        return "main.GBArrayList{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
