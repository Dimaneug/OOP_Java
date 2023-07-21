public class Whale extends Animal implements Illable, Swimable{

    private int swimSpeed;

    public Whale() {
        this("Max", null, null, false, 20);
    }

    public Whale(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated, int swimSpeed) {
        super(nameAnimal, ownerName, diagnosis, isVaccinated);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void ill() {

    }

    @Override
    public void swim() {

    }

    @Override
    public int getSwimSpeed() {
        return swimSpeed;
    }
}
