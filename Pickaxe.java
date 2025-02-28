class Pickaxe extends Tool {
    public Pickaxe(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    @Override
    protected boolean isUsable(FarmLot farmLot, int tileIndex) {
        return farmLot.getTile().get(tileIndex).isRocked() &&
                farmLot.getPlayer().getObjectCoins() >= getCost();
    }

    @Override
    protected void performAction(FarmLot farmLot, int tileIndex) {
        farmLot.getTile().get(tileIndex).removeRock();
        farmLot.getPlayer().useTool(getCost());
    }

    @Override
    protected String getFailureMessage(int tileIndex) {
        return "Tile " + (tileIndex + 1) + " has no rocks to remove. Or not enough ObjectCoins.";
    }

    protected String getSuccessMessage(int tileIndex) {
        return "Pickaxe used successfully on Tile " + (tileIndex + 1) + ". " +
                "You gained " + getExperienceGain() + " xp and spent " + getCost() + " ObjectCoins.";
    }
}
