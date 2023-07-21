public class Duck extends Animal implements Flyable, Illable, Soundable {

    @Override
    public void fly() {
        System.out.println(getTYPE() + " летит");
    }

    @Override
    public void ill() {

    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " крякает");
    }
}
