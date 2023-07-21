public class Whale extends Animal implements Illable{
    @Override
    protected void fly() {
        System.out.println("Кит не умеет летать");
    }

    @Override
    protected void toGo() {
        System.out.println("Кит не умеет ходить");
    }
}
