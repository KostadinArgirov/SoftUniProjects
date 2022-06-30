package advanced.definingClassesExercises.CatLady;

public class Siamese extends Cat{

    private final double earSize;

    public Siamese(String name, String breed, double earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getName(), this.earSize);
    }
}