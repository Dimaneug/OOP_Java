package myLinkedList.test;

import myLinkedList.main.classes.GBLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GBLinkedListTest {
    @Test
    void checkEmpty() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void addElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("GBLinkedList{values=[1]}", list.toString());
    }

    @Test
    void addFirstElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        list.addFirst(2);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("GBLinkedList{values=[2,1]}", list.toString());
    }

    @Test
    void addLastElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        list.addLast(2);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("GBLinkedList{values=[1,2]}", list.toString());
    }

    @Test
    void getElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        Assertions.assertEquals(1, list.get(0));
    }

    @Test
    void getNonExistentElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        Assertions.assertEquals(null, list.get(1));
    }

    @Test
    void removeFirstElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        list.addFirst(2);
        list.remove(0);
        System.out.println(list.get(0));
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("GBLinkedList{values=[1]}", list.toString());
    }

    @Test
    void removeLastElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        list.addFirst(2);
        list.remove(1);
        System.out.println(list.get(0));
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("GBLinkedList{values=[2]}", list.toString());
    }

    @Test
    void removeMiddleElement() {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        System.out.println(list.get(0));
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("GBLinkedList{values=[1,3]}", list.toString());
    }

    @Test
    void testIterator() {
        int[] arr = new int[]{4,2,7,3};
        GBLinkedList<Integer> list = new GBLinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        var test = list.iterator();
        int i = 0;
        while (test.hasNext()) {
            Assertions.assertEquals(arr[i], test.next());
            i++;
        }
    }

    // Далеко не полное покрытие тестами, но для примера хватит :)
}
