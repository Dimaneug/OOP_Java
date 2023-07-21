import java.util.*;
import java.util.function.Consumer;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Comparator<Pharmacy> {
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
        } else if (this.getPharmacyPower() < p.getPharmacyPower()) {
            return -1;
        }
        for (int i = 0; i < components.size(); i++) {
            int res = components.get(i).getName().compareTo(p.getComponents().get(i).getName());
            if (res != 0)
                return res;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Состав %s: %s, Общая сила - %d\n", getClass().getSimpleName(), components, this.getPharmacyPower());
    }

    @Override
    public int compare(Pharmacy o1, Pharmacy o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pharmacy pharmacy = (Pharmacy) obj;
        for (int i = 0; i < components.size(); i++) {
            if (!components.get(i).equals(pharmacy.getComponents().get(i))) return false;
        }
        return index == pharmacy.getIndex();
    }

    @Override
    public int hashCode() {
        int prime = 37;
        int result = 1;
        for (Component component : components
        ) {
            result = prime * result + component.hashCode();
        }
        result = prime * result + index;
        return result;
    }
}
