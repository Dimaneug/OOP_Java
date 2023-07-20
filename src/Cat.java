public class Cat extends Animal {
    private int countPaws;

    public Cat() {
        this("Max", null, null, false, 4);
    }

    public Cat(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated, int countPaws) {
        super(nameAnimal, ownerName, diagnosis, isVaccinated);
        this.countPaws = countPaws;
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
    protected void fly() {
        System.out.println("Кошка не умеет летать");
    }
}
