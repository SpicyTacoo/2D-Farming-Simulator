class Plow extends Tool {
    public Plow(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    @Override
    protected boolean isUsable(FarmLot farmLot, int tileIndex) {
        return !farmLot.getTile().get(tileIndex).isOccupied() &&
                !farmLot.getTile().get(tileIndex).isRocked() &&
                !farmLot.getTile().get(tileIndex).isPlowed();
    }

    @Override
    protected void performAction(FarmLot farmLot, int tileIndex) {
        farmLot.getTile().get(tileIndex).plowTile();
    }

    @Override
    protected String getFailureMessage(int tileIndex) {
        return "Tile " + (tileIndex + 1) + " is already plowed, has rocks, or has crops.";
    }

    protected String getSuccessMessage(int tileIndex) {
        return "Plow used successfully on Tile " + (tileIndex + 1) + ". " +
                "You gained " + getExperienceGain() + " xp and spent " + getCost() + " ObjectCoins.";
    }
}
