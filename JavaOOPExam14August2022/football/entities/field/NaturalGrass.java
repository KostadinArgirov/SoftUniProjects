package football.entities.field;

public class NaturalGrass extends BaseField {

    private static final int NATURAL_GRASS_CAPACITY = 150;

    public NaturalGrass(String name) {
        super(name, NATURAL_GRASS_CAPACITY);
    }
}