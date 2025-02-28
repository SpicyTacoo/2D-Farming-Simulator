public abstract class Tool {
    private String name;
    private int cost;
    private double experienceGain;

    public Tool(String name, int cost, double experienceGain) {
        this.name = name;
        this.cost = cost;
        this.experienceGain = experienceGain;
    }

    // Template method
    public final void useTool(FarmLot farmLot, int tileIndex) {
        if (isUsable(farmLot, tileIndex)) {
            performAction(farmLot, tileIndex);
            gainExperience(farmLot.getPlayer());
            farmLot.getReport().updateToolMessage(getSuccessMessage(tileIndex));
            System.out.println(getSuccessMessage(tileIndex));
        } else {
            farmLot.getReport().updateToolMessage(getFailureMessage(tileIndex));
            System.out.println(getFailureMessage(tileIndex));
        }
    }

    protected abstract boolean isUsable(FarmLot farmLot, int tileIndex);
    protected abstract void performAction(FarmLot farmLot, int tileIndex);
    protected abstract String getSuccessMessage(int tileIndex);
    protected abstract String getFailureMessage(int tileIndex);
    
    private void gainExperience(Player player) {
        player.gainExperience(experienceGain);
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getExperienceGain() {
        return experienceGain;
    }
}