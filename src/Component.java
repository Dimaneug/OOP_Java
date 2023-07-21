import java.util.Objects;

public class Component {
    private String name;
    private String weight;
    private int power;

    public Component(String name, String weight, int power) {
        this.name = name;
        this.weight = weight;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s{name: %s, weight: %s, power: %d}", getClass().getSimpleName(), name, weight, power);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return power == component.power && Objects.equals(name, component.name) && Objects.equals(weight, component.weight);
    }

    @Override
    public int hashCode() {
        int prime = 37;
        int result = 1;
        result = prime*result + ((name == null) ? 0 : name.hashCode());
        result = prime*result + ((weight == null) ? 0 : weight.hashCode());
        result = prime*result + power;
        return result;
    }
}
