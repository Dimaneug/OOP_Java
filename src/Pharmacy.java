import java.util.*;
import java.util.function.Consumer;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Comparator<Pharmacy>{
    private List<Component> components;
    private int index;

    public Pharmacy() {
        components = new ArrayList<>();
        index = 0;
    }

    public Pharmacy addComponent(Component component) {
        this.components.add(component);
        return this;
    }

    private int getPharmacyPower() {
        int power = 0;
        for (Component component : components
        ) {
            power += component.getPower();
        }
        return power;
    }


    public List<Component> getComponents() {
        return components;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Iterator<Component> iterator() {
        return new ComponentIterator(this);
    }

    //    @Override
//    public Iterator<Component> iterator() {
//        return new Iterator<>() {
//            @Override
//            public boolean hasNext() {
//                return components.size() > index;
//            }
//
//            @Override
//            public Component next() {
//                return components.get(index++);
//            }
//        };
//    }
    @Override
    public int compareTo(Pharmacy p) {
        if (this.getPharmacyPower() > p.getPharmacyPower()) {
            return 1;
        } else if (this.getPharmacyPower() == p.getPharmacyPower()) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return String.format("Состав %s: %s, Общая сила - %d\n", getClass().getSimpleName(), components, this.getPharmacyPower());
    }

    @Override
    public int compare(Pharmacy o1, Pharmacy o2) {
        return o1.compareTo(o2);
    }

//    @Override
//    public boolean equals(Pharmacy p) {
//        return this.
//    }
}
