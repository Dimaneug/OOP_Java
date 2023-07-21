public class Duck extends Animal implements Flyable, Illable, Soundable, Runnable, Swimable {

    private int flySpeed;
    private int runSpeed;
    private int swimSpeed;

    public Duck() {
        this("Peter", null, null, false, 15, 3, 7);
    }

    public Duck(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated, int flySpeed, int runSpeed, int swimSpeed) {
        super(nameAnimal, ownerName, diagnosis, isVaccinated);
        this.flySpeed = flySpeed;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void fly() {
        System.out.println(getTYPE() + " летит");
    }

    @Override
    public int getFlySpeed() {
        return flySpeed;
    }

    @Override
    public void ill() {

    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " крякает");
    }

    @Override
    public void run() {

    }

    @Override
    public int getRunSpeed() {
        return runSpeed;
    }

    @Override
    public void swim() {

    }

    @Override
    public int getSwimSpeed() {
        return swimSpeed;
    }
}
