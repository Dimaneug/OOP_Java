public class HeadNurse extends Nurse implements Operating, Vaccinating, Teaching{
    public HeadNurse(String name, String surname, boolean isBusy) {
        super(name, surname, isBusy);
    }

    @Override
    public void performOperation(Animal animal) {
        if (animal.getDiagnosis() != null && !isBusy) {
            System.out.println(name+" проводит операцию " + animal.getNameAnimal());
            animal.setDiagnosis(null);
        }
    }

    @Override
    public void vaccinate(Animal animal) {
        if (!animal.isVaccinated() && !isBusy) {
            System.out.println(name + " вакцинирует " + animal.getNameAnimal());
            animal.setVaccinated(true);
        }
    }

    @Override
    public void teach(Staff intern) {
        if (intern instanceof Nurse && !isBusy && !intern.isBusy) {
            System.out.println(name + " обучает " + intern.getName());
        }
    }
}
