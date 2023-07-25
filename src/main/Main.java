package main;

public class Main {
    public static void main(String[] args) {
        GBList<Integer> list = new GBArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.update(2, 20);
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list);
    }
}
