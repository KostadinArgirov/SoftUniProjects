package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {

    private static final double GLACIER_EXPLORER_STARTING_ENERGY = 40.00;

    public GlacierExplorer(String name) {

        super(name, GLACIER_EXPLORER_STARTING_ENERGY);
    }
}
