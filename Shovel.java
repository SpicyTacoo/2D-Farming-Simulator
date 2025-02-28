class Shovel extends Tool {
    public Shovel(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    @Override
    protected boolean isUsable(FarmLot farmLot, int tileIndex) {
        return farmLot.getTile().get(tileIndex).isWithered();
    }

    @Override
    protected void performAction(FarmLot farmLot, int tileIndex) {
        farmLot.getTile().set(tileIndex, new Tile());
        farmLot.getPlayer().useTool(getCost());
    }

    @Override
    protected String getFailureMessage(int tileIndex) {
        return "Tile " + (tileIndex + 1) + " is not withered.";
    }

    protected String getSuccessMessage(int tileIndex) {
        return "Shovel used successfully on Tile " + (tileIndex + 1) + ".";
    }
}