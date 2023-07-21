import java.util.ArrayList;
import java.util.List;

public class VetClinic {
    private final List<Animal> animals;

    public VetClinic() {
        this.animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public VetClinic addNewAnimal(Animal animal) {
        animals.add(animal);
        return this;
    }

    public List<Animal> getFlyable() {
        List<Animal> flyableAnimals = new ArrayList<>();
        for (Animal animal : animals
        ) {
            if (animal instanceof Flyable)
                flyableAnimals.add(animal);
        }
        return flyableAnimals;
    }

    public List<Animal> getIllable() {
        List<Animal> illableAnimals = new ArrayList<>();
        for (Animal animal : animals
        ) {
            if (animal instanceof Illable)
                illableAnimals.add(animal);
        }
        return illableAnimals;
    }

    public List<Animal> getSoundable() {
        List<Animal> soundableAnimals = new ArrayList<>();
        for (Animal animal : animals
        ) {
            if (animal instanceof Soundable)
                soundableAnimals.add(animal);
        }
        return soundableAnimals;
    }

    public List<Animal> getRunnable() {
        List<Animal> runnableAnimals = new ArrayList<>();
        for (Animal animal : animals
        ) {
            if (animal instanceof Runnable)
                runnableAnimals.add(animal);
        }
        return runnableAnimals;
    }




}
