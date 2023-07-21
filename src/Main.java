import java.util.ArrayList;
import java.util.Collections;
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
        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.addComponent(new Component("Penicillin", "2", 13))
                .addComponent(new Component("Water", "0.5", 2));

        Pharmacy pharmacy2 = new Pharmacy();
        pharmacy2.addComponent(new Component("Penicillin", "2", 17))
                .addComponent(new Component("Water", "0.5", 6));

        Pharmacy pharmacy3 = new Pharmacy();
        pharmacy3.addComponent(new Component("Penicillin", "2", 7))
                .addComponent(new Component("Water", "0.5", 1));

        Pharmacy pharmacy4 = new Pharmacy();
        pharmacy4.addComponent(new Component("Penicillin", "2", 7))
                .addComponent(new Component("Water", "0.5", 1));

        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(pharmacy1);
        pharmacies.add(pharmacy2);
        pharmacies.add(pharmacy3);
        System.out.println(pharmacies);
        System.out.println("--------");

        Collections.sort(pharmacies);
        System.out.println(pharmacies);

        System.out.println(pharmacy3.equals(pharmacy4));

//        while(pharmacy.hasNext()) {
//            System.out.println(pharmacy.next());
//        }



    }
}
