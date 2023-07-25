package myLinkedList.main;

import myLinkedList.main.classes.GBLinkedList;

public class Main {
    public static void main(String[] args) {
        GBLinkedList<Integer> list = new GBLinkedList<>();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list);
        list.addFirst(2);
        System.out.println(list);
        list.addLast(3);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.update(1, 5);
        System.out.println(list);

        var test = list.iterator();
        while (test.hasNext()) {
            System.out.println(test.next());
        }
    }
}
