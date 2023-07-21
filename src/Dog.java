public class Dog extends Animal implements Soundable {
    @Override
    protected void fly() {
        System.out.println("Собака не умеет летать");
    }


    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " лает");
    }
}
