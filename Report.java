
public class Report {
    private String toolMessage;
    private String harvestMessage;
    private String registerTitleMessage;
    private String plantCropMessage;

    // CONSTRUCTORS

    public Report() {

    }

    // METHODS
    public void updateToolMessage(String outcome) {
        this.toolMessage = outcome;
    }

    public void updateHarvestMessage(String outcome) {
        this.harvestMessage = outcome;
    }

    public void updateRegisterTitleMessage(String outcome) {
        this.registerTitleMessage = outcome;
    }

    public void updatePlantCropMessage(String outcome) {
        this.plantCropMessage = outcome;
    }

    // GETTERS AND SETTERS

    public String getToolMessage() {
        return toolMessage;
    }

    public String getHarvestMessage() {
        return harvestMessage;
    }

    public String getRegisterTitleMessage() {
        return registerTitleMessage;
    }

    public String getPlantCropMessage() {
        return plantCropMessage;
    }
}
