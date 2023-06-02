public class WateringCan extends Tool {

    public WateringCan(String name, int cost, double experienceGain) {
        super(name, cost, experienceGain);
    }

    @Override
    public void useTool(FarmLot farmLot, int index) {

        int tileNumber = index + 1;

        if (!farmLot.getTile().get(index).isWatered() && farmLot.getTile().get(index).isOccupied()) {
            farmLot.getTile().get(index).waterTile();
            farmLot.getPlayer().gainExperience(getExperienceGain());

            farmLot.getReport().updateToolMessage("You successfully watered tile " + tileNumber + ". You gained " + getExperienceGain() + " xp.");
        }

        else if (farmLot.getTile().get(index).isOccupied()) {
            if (farmLot.getTile().get(index).getPlantedCrop() instanceof Flower) {
                if (!((Flower) farmLot.getTile().get(index).getPlantedCrop()).isDoubleWatered()){
                    ((Flower) farmLot.getTile().get(index).getPlantedCrop()).doubleWaterTile();
                    farmLot.getPlayer().gainExperience(getExperienceGain());

                    farmLot.getReport().updateToolMessage("You successfully watered tile " + tileNumber + " twice. You gained " + getExperienceGain() + " xp.");
                }
                else{
                    farmLot.getReport().updateToolMessage("You have already watered the maximum times for this tile");
                    System.out.println("You have already watered the maximum times for this tile");
                }
            }

            else {
                farmLot.getReport().updateToolMessage("You have already watered the maximum times for this tile");
                System.out.println("You have already watered the maximum times for this tile");
            }
        }
    }
}