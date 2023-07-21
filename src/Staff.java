public class Staff {
    protected String name;
    protected String surname;
    protected boolean isBusy;

    public Staff(String name, String surname, boolean isBusy) {
        this.name = name;
        this.surname = surname;
        this.isBusy = isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isBusy() {
        return isBusy;
    }
}
