public class Tile {
    private boolean isPlowed;
    private boolean isWithered;
    private boolean isOccupied;
    private boolean isWatered;
    private boolean isFertilized;
    private boolean isRocked;
    private int waterCounter;
    private int fertilizerCounter;
    private int ageCounter;
    private Crop plantedCrop;

    // CONSTRUCTORS

    public Tile() {

    }

    // GETTERS AND SETTERS

    public boolean isPlowed() {
        return isPlowed;
    }
    public void setPlowed(boolean isPlowed) {
        this.isPlowed = isPlowed;
    }

    public boolean isWithered() {
        return isWithered;
    }
    public void setWithered(boolean isWithered) {
        this.isWithered = isWithered;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean isWatered() {
        return isWatered;
    }

    public void setWatered(boolean watered) {
        isWatered = watered;
    }

    public boolean isFertilized() {
        return isFertilized;
    }
    public void setFertilized(boolean fertilized) {
        isFertilized = fertilized;
    }

    public int getWaterCounter() {
        return waterCounter;
    }
    public void setWaterCounter(int waterCounter) {
        this.waterCounter = waterCounter;
    }

    public int getFertilizerCounter() {
        return fertilizerCounter;
    }
    public void setFertilizerCounter(int fertilizerCounter) {
        this.fertilizerCounter = fertilizerCounter;
    }

    public int getAgeCounter() {
        return ageCounter;
    }

    public Crop getPlantedCrop() {
        return plantedCrop;
    }

    public boolean isRocked() {
        return isRocked;
    }

    // METHODS

    public void plowTile() {
        isPlowed = true;
    }

    public boolean isPlantable(int cost, double balance) {
        if (balance >= cost)
            return true;
        return false;
    }

    public void plantCrop(Crop crop, Player player, Report report) {
        int newSeedCost = crop.getSeedCost() - player.getFarmerType().getSeedCostReduction();

        if (isPlantable(newSeedCost, player.getObjectCoins())) {
            this.plantedCrop = crop;
            this.isOccupied = true;
            player.plantTile(newSeedCost);

            report.updatePlantCropMessage("Successfully planted " + crop.getName() + ". You spent " + crop.getSeedCost() +" ObjectCoins." +
                    "You now only have " + player.getObjectCoins() + " ObjectCoins.");
            System.out.println("You spent " + newSeedCost + " ObjectCoins.");
            System.out.println("You now only have " + player.getObjectCoins() + " ObjectCoins.");
        }

        else {
            report.updatePlantCropMessage("You do not have enough ObjectCoins.");
            System.out.println("You do not have enough ObjectCoins.");
        }


    }

    public void waterTile() {
        waterCounter++;
        this.isWatered = true;
    }

    public void fertilizeTile() {
        fertilizerCounter++;
        this.isFertilized = true;
    }

    public void initializeRock() {
        this.isRocked = true;
    }

    public void removeRock() {
        this.isRocked = false;
    }

    public void addAgeCount() {
        ageCounter++;
    }

    public boolean hasWaterBonus() {
        return waterCounter > plantedCrop.getWaterNeeded();
    }

    public boolean hasFertilizerBonus() {
        return fertilizerCounter > plantedCrop.getFertilizerNeeded();
    }

    public boolean isHarvestable(Report report) {
        int daysLeft;
        int daysWithered;

        if (this.getPlantedCrop() != null) {
            if (ageCounter == getPlantedCrop().getHarvestTime()) {

                if (waterCounter >= getPlantedCrop().getWaterNeeded() && fertilizerCounter >= getPlantedCrop().getFertilizerNeeded()) {

                    return true;
                }
                else {
                    report.updateHarvestMessage("Your " + getPlantedCrop() +" did not reach the minimum requirements on it's harvest day");
                    System.out.println("Your " + getPlantedCrop() +" did not reach the minimum requirements on it's harvest day");
                    return false;
                }
            }
            else if (ageCounter < getPlantedCrop().getHarvestTime()) {
                daysLeft = this.plantedCrop.getHarvestTime() - this.ageCounter;
                report.updateHarvestMessage(getPlantedCrop().getName() + "is not yet harvestable. There are " + daysLeft + "days left till harvest day!");
                System.out.println(getPlantedCrop().getName() + "is not yet harvestable. There are " + daysLeft + "days left till harvest day!");
                return false;
            }
            else {
                daysWithered = this.ageCounter - this.plantedCrop.getHarvestTime();
                report.updateHarvestMessage("You forgot to harvest your " + getPlantedCrop().getName() + ". It has withered " + daysWithered + " day/s ago!");
                System.out.println("You forgot to harvest your " + getPlantedCrop().getName() + ". It has withered " + daysWithered + " day/s ago!");
                return false;
            }
        }
        else {
            report.updateHarvestMessage("Tile is empty!");
            return false;
        }
    }
}
