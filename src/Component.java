public class Component {
    private String name;
    private String weight;
    private int power;

    public Component(String name, String weight, int power) {
        this.name = name;
        this.weight = weight;
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("%s{name: %s, weight: %s, power: %d}", getClass().getSimpleName(), name, weight, power);
    }
}
