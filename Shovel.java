public class Shovel extends Tool implements Usable{

    public Shovel(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    public boolean checkObjectCoins(double objectCoins) {
        if (objectCoins >= getCost())
            return true;
        return false;
    }

    public boolean checkIfWithered(Tile tile) {
        if (tile.isWithered())
            return true;
        return false;
    }

    @Override
    public void useTool(FarmLot farmLot, int index) {

        int tileNumber = index + 1;

        if (checkObjectCoins(farmLot.getPlayer().getObjectCoins())) {

            if (checkIfWithered(farmLot.getTile().get(index))) {
                farmLot.getTile().set(index, new Tile());
                farmLot.getPlayer().gainExperience(getExperienceGain());
                farmLot.getPlayer().useTool(getCost());
                farmLot.getPlayer().gainExperience(getExperienceGain());

                farmLot.getReport().updateToolMessage("You successfully used the shovel on tile " + tileNumber + ". You gained " + getExperienceGain() + " xp and" +
                        " spent " + getCost() + " ObjectCoins.\n" + "You now have " + farmLot.getPlayer().getObjectCoins() + " ObjectCoins left");
                System.out.println("You successfully used the shovel and gained " + getExperienceGain() + " xp.");
                System.out.println("You spent " + getCost() + " ObjectCoins." + " You now have " + farmLot.getPlayer().getObjectCoins() + " ObjectCoins left");
            }

            else {
                farmLot.getReport().updateToolMessage("Tile " + tileNumber + " is not withered. You just wasted money.");
                System.out.println("Tile is not withered. You just wasted money.");
                farmLot.getPlayer().useTool(getCost());
            }
        }

        else {
            farmLot.getReport().updateToolMessage("You do not have enough ObjectCoins");
            System.out.println("You do not have enough ObjectCoins");
        }
    }
}