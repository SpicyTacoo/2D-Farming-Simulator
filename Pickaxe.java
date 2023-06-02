public class Pickaxe extends Tool implements Usable {

    public Pickaxe(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    public boolean checkObjectCoins(double objectCoins) {
        if (objectCoins >= getCost())
            return true;
        return false;
    }

    @Override
    public void useTool(FarmLot farmLot, int index) {

        int tileNumber = index + 1;

        if (checkObjectCoins(farmLot.getPlayer().getObjectCoins())) {

            if (farmLot.getTile().get(index).isRocked()) {
                farmLot.getTile().get(index).removeRock();
                farmLot.getPlayer().useTool(getCost());
                farmLot.getPlayer().gainExperience(getExperienceGain());

                farmLot.getReport().updateToolMessage("You successfully used the pickaxe on tile " + tileNumber + ". You gained " + getExperienceGain() + " xp. and spent " + getCost() + " ObjectCoins." +
                        "\nYou now have " + farmLot.getPlayer().getObjectCoins() + " objectCoins left");
                System.out.println("You used the pickaxe and gained " + getExperienceGain() + " xp.");
                System.out.println("You spent " + getCost() + " objectCoins." + "You now have " + farmLot.getPlayer().getObjectCoins() + " objectCoins left");
            }

            else {
                farmLot.getReport().updateToolMessage("Tile " + tileNumber + " has no rocks!");
                System.out.println("Tile " + tileNumber + "has no rocks!");
            }
        }

        else {
            farmLot.getReport().updateToolMessage("You do not have enough ObjectCoins!");
            System.out.println("You do not have enough ObjectCoins!");
        }
    }
}