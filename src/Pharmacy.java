import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Pharmacy implements Iterable<Component> {
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


}
