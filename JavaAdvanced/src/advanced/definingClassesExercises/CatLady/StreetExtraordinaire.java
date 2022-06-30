package advanced.definingClassesExercises.CatLady;

public class StreetExtraordinaire extends Cat{

    private final double decibelsOfMeows;

    public StreetExtraordinaire(String name, String breed, double decibelsOfMeows) {
        super(name, breed);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getName(), this.decibelsOfMeows);
    }
}