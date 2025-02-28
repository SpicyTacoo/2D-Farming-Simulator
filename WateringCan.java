class WateringCan extends Tool {
    public WateringCan(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    @Override
    protected boolean isUsable(FarmLot farmLot, int tileIndex) {
        return !farmLot.getTile().get(tileIndex).isWatered() &&
                farmLot.getTile().get(tileIndex).isOccupied();
    }

    @Override
    protected void performAction(FarmLot farmLot, int tileIndex) {
        farmLot.getTile().get(tileIndex).waterTile();
    }

    @Override
    protected String getFailureMessage(int tileIndex) {
        return "Tile " + (tileIndex + 1) + " has already been watered or is empty.";
    }

    protected String getSuccessMessage(int tileIndex) {
        return "Watering Can used successfully on Tile " + (tileIndex + 1) + ". " +
                "You gained " + getExperienceGain() + " xp and spent " + getCost() + " ObjectCoins.";
    }
}
