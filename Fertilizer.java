public class Fertilizer extends Tool implements Usable{

    public Fertilizer(String name, int cost, double experienceGain) {
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

            if (!farmLot.getTile().get(index).isFertilized() && farmLot.getTile().get(index).isOccupied()){
                farmLot.getTile().get(index).fertilizeTile();
                farmLot.getPlayer().useTool(getCost());
                farmLot.getPlayer().gainExperience(getExperienceGain());

                farmLot.getReport().updateToolMessage("You successfully used the fertilizer on tile " + tileNumber + ". You gained " + getExperienceGain() + " xp. and spent " + getCost() + " ObjectCoins." +
                        "\nYou now have " + farmLot.getPlayer().getObjectCoins() + " ObjectCoins left");
                System.out.println("You used the Fertilizer and gained " + getExperienceGain() + " xp.");
                System.out.println("You spent " + getCost() + " objectCoins." + "You now have " + farmLot.getPlayer().getObjectCoins() + " ObjectCoins left");
            }

            else if (farmLot.getTile().get(index).isFertilized()) {
                farmLot.getReport().updateToolMessage("Tile " + tileNumber + " already been fertilized for the day");
                System.out.println("Tile has already been fertilized for the day");
            }

            else {
                farmLot.getReport().updateToolMessage("Tile " + tileNumber + " does not contain anything!");
                System.out.println("Tile " + tileNumber + " does not contain anything!");
            }
        }

        else {
            farmLot.getReport().updateToolMessage("You do not have enough ObjectCoins!");
            System.out.println("You do not have enough ObjectCoins!");
        }
    }
}