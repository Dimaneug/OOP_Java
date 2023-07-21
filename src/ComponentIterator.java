import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentIterator implements Iterator<Component> {
    private Pharmacy pharmacy;
    private int index;

    public ComponentIterator(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return pharmacy.getComponents().size() > index;
    }

    @Override
    public Component next() {
        return pharmacy.getComponents().get(index++);
    }
}
