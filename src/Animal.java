public class Animal {
    protected String nameAnimal;
    protected String ownerName;
    protected String diagnosis;
    protected Boolean isVaccinated;

    protected final String TYPE = getClass().getSimpleName();

    public Animal(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated) {
        this.nameAnimal = nameAnimal;
        this.ownerName = ownerName;
        this.diagnosis = diagnosis;
        this.isVaccinated = isVaccinated;
    }

    public Animal() {
    }

    public boolean isVaccinated() {
        return this.isVaccinated;
    }

    public void setVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public String getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return String.format("%s{name = %s, owner = %s}", TYPE, nameAnimal, ownerName);
    }

    public String getTYPE(String arg) {
        return arg + TYPE;
    }

    protected void toGo() {
        System.out.println("Животное двигается");
    }

    protected void fly() {
        System.out.println("Животное летает");
    }

    protected void swim() {
        System.out.println("Животное плывёт");
    }
}
