import java.util.*;

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
        pharmacy1.addComponent(new Component("Penicillin", "2", 17))
                .addComponent(new Component("Water", "0.5", 6));

        Pharmacy pharmacy2 = new Pharmacy();
        pharmacy2.addComponent(new Component("Penicillin", "2", 17))
                .addComponent(new Component("Wator", "0.5", 6));

        Pharmacy pharmacy3 = new Pharmacy();
        pharmacy3.addComponent(new Component("Penicillin", "2", 7))
                .addComponent(new Component("Water", "0.5", 1));

        Pharmacy pharmacy4 = new Pharmacy();
        pharmacy4.addComponent(new Component("Penicillin", "2", 7))
                .addComponent(new Component("Water", "0.5", 1));

        Set<Pharmacy> pharmacies = new HashSet<>();
        pharmacies.add(pharmacy1);
        pharmacies.add(pharmacy2);
        pharmacies.add(pharmacy3);
        pharmacies.add(pharmacy4);

        System.out.println(pharmacies.size());

        System.out.println(pharmacy1.compareTo(pharmacy2));

//        while(pharmacy.hasNext()) {
//            System.out.println(pharmacy.next());
//        }



    }
}
