
public class Plow extends Tool {

    public Plow(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    public boolean checkIfEmpty(Tile tile) {
        if(!tile.isOccupied() && !tile.isRocked())
            return true;
        return false;
    }

    @Override
    public void useTool(FarmLot farmLot, int index) {

        int tileNumber = index + 1;

        if (checkIfEmpty(farmLot.getTile().get(index)) && !farmLot.getTile().get(index).isPlowed()) {
            farmLot.getTile().get(index).plowTile();
            farmLot.getPlayer().gainExperience(getExperienceGain());

            farmLot.getReport().updateToolMessage("You successfully used the plow on tile " + tileNumber + ". You gained " + getExperienceGain() + " xp." );
            System.out.println(farmLot.getReport().getToolMessage());
        }
        else if (farmLot.getTile().get(index).isOccupied()) {
            farmLot.getReport().updateToolMessage("Tile " + tileNumber + " is occupied. \n" +
                    "Nothing happened");
            System.out.println("Tile is occupied");

        }
        else if (farmLot.getTile().get(index).isRocked()) {
            farmLot.getReport().updateToolMessage("Tile " + tileNumber + " has rocks. \n" +
                    "Please remove them first before using plow tool.");
            System.out.println("Rocks!");
        }
        else {
            farmLot.getReport().updateToolMessage("Tile " + tileNumber + " has already been plowed.");
            System.out.println("Tile " + tileNumber + " has already been plowed.");
        }
    }
}