public class Parrot extends Animal implements Flyable, Runnable, Soundable{
    private int flySpeed;
    private int runSpeed;

    public Parrot() {
        this("Kesha", null, null, false, 12, 1);
    }

    public Parrot(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated, int flySpeed, int runSpeed) {
        super(nameAnimal, ownerName, diagnosis, isVaccinated);
        this.flySpeed = flySpeed;
        this.runSpeed = runSpeed;
    }

    @Override
    public void fly() {

    }

    @Override
    public int getFlySpeed() {
        return flySpeed;
    }

    @Override
    public void run() {

    }

    @Override
    public int getRunSpeed() {
        return runSpeed;
    }

    @Override
    public void sound() {

    }
}
