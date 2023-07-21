public class Cat extends Animal implements Soundable, Illable, Runnable, Swimable {
    private int countPaws;
    private int runSpeed;
    private int swimSpeed;

    public Cat() {
        this("Barsik", null, null, false, 4, 10, 2);
    }

    public Cat(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated, int countPaws, int runSpeed, int swimSpeed) {
        super(nameAnimal, ownerName, diagnosis, isVaccinated);
        this.countPaws = countPaws;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
    }

    private void wakeUp() {
        System.out.println("Кот проснулся");
    }

    private void findFood() {
        System.out.println("Кот нашёл еду");
    }

    private void eat() {
        System.out.println("Кот поел");
    }

    private void sleep() {
        System.out.println("Кот уснул");
    }

    public void hunt() {
        this.wakeUp();
        this.findFood();
        this.eat();
        this.sleep();
    }

    @Override
    public void ill() {

    }

    @Override
    public void sound() {

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
