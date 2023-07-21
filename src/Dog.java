public class Dog extends Animal implements Soundable, Runnable, Swimable {

    private int runSpeed;
    private int swimSpeed;

    public Dog() {
        this("Barbos", null, null, false, 11, 3);
    }

    public Dog(String nameAnimal, String ownerName, String diagnosis, boolean isVaccinated, int runSpeed, int swimSpeed) {
        super(nameAnimal, ownerName, diagnosis, isVaccinated);
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
    }


    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " лает");
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
