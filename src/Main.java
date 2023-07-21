import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Animal barsik = new Animal("Барсик", "Эдик", "Простуда", false);
//        System.out.println(barsik.isVaccinated());
//        barsik.setVaccinated(true);
//        System.out.println(barsik.isVaccinated());
//        System.out.println(barsik.getTYPE());
//        Cat cat = new Cat();
//        System.out.println(cat);
//
//        Animal muska = new Cat();
//        Animal pes = new Dog();
//        List<Animal> animals = new ArrayList<Animal>();
//        animals.add(cat);
//        animals.add(barsik);
//        animals.add(muska);
//        animals.add(pes);
//        System.out.println(animals);
//        System.out.println(muska.getTYPE());
//        System.out.println(muska.getTYPE("With arg "));
//
//        cat.hunt();
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.addComponent(new Component("Penicillin", "2", 13))
                .addComponent(new Component("Water", "0.5", 2));

//        while(pharmacy.hasNext()) {
//            System.out.println(pharmacy.next());
//        }

        for (Component item : pharmacy
        ) {
            System.out.println(item);
        }

        for (Component item : pharmacy
        ) {
            System.out.println(item);
        }

    }
}
