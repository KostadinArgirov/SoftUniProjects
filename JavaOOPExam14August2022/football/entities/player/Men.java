package football.entities.player;

public class Men extends BasePlayer {
//    I can only play on NaturalGrass!
    private static final double MEN_INITIAL_KILOGRAMS = 85.50;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(MEN_INITIAL_KILOGRAMS);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 145);
    }
}