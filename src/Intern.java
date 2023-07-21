public class Intern extends Doctor implements Vaccinating{
    public Intern(String name, String surname, boolean isBusy) {
        super(name, surname, isBusy);
    }

    @Override
    public void vaccinate(Animal animal) {
        if (!animal.isVaccinated() && !isBusy) {
            System.out.println(name + " вакцинирует " + animal.getNameAnimal());
            animal.setVaccinated(true);
        }
    }
}
