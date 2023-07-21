public class Animal {
    protected String nameAnimal;
    protected String ownerName;
    protected String diagnosis;
    protected Boolean isVaccinated;

    public Animal(String nameAnimal, String ownerName, String diagnosis, Boolean isVaccinated) {
        this.nameAnimal = nameAnimal;
        this.ownerName = ownerName;
        this.diagnosis = diagnosis;
        this.isVaccinated = isVaccinated;
    }

    public Animal() {
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }


    protected final String TYPE = getClass().getSimpleName();


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

}
