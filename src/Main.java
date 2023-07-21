import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//
//
//        cat.hunt();
        VetClinic clinic = new VetClinic();
        clinic.addNewAnimal(new Cat())
                .addNewAnimal(new Dog())
                .addNewAnimal(new Duck())
                .addNewAnimal(new Parrot())
                .addNewAnimal(new Whale());

        System.out.println(clinic.getRunnable());

        System.out.println(clinic.getFlyable());

        HeadNurse sveta = new HeadNurse("Sveta", "Svetova", false);
        JuniorNurse natasha = new JuniorNurse("Natasha", "Natalieva", false);
        SeniorDoctor oleg = new SeniorDoctor("Oleg", "Olegov", false);
        Intern ivan = new Intern("Ivan", "Ivanov", false);

        sveta.vaccinate(new Dog());
        oleg.teach(ivan);
        natasha.setBusy(true);
        sveta.teach(natasha); // Наташа занята, поэтому нельзя обучить
        oleg.performOperation(new Cat()); // Без диагноза операции не будет
        oleg.performOperation(new Cat("Muska", null, "Prostuda", false, 4, 7, 3));


    }
}
