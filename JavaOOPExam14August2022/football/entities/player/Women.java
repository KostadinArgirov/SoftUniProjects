package football.entities.player;

public class Women extends BasePlayer {
//    I can only play on ArtificialTurf!
    private static final double WOMEN_INITIAL_KILOGRAMS = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(WOMEN_INITIAL_KILOGRAMS);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 115);
    }
}