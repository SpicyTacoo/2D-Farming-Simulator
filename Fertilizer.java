class Fertilizer extends Tool {
    public Fertilizer(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    @Override
    protected boolean isUsable(FarmLot farmLot, int tileIndex) {
        return !farmLot.getTile().get(tileIndex).isFertilized() &&
                farmLot.getTile().get(tileIndex).isOccupied() &&
                farmLot.getPlayer().getObjectCoins() >= getCost();
    }

    @Override
    protected void performAction(FarmLot farmLot, int tileIndex) {
        farmLot.getTile().get(tileIndex).fertilizeTile();
        farmLot.getPlayer().useTool(getCost());
    }

    @Override
    protected String getFailureMessage(int tileIndex) {
        return "Tile " + (tileIndex + 1) + " is already fertilized or empty. Or not enough ObjectCoins.";
    }

    protected String getSuccessMessage(int tileIndex) {
        return "Fertilizer used successfully on Tile " + (tileIndex + 1) + ". " +
                "You gained " + getExperienceGain() + " xp and spent " + getCost() + " ObjectCoins.";
    }
}
