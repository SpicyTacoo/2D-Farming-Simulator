public class Flower extends Crop {

    private boolean isDoubleWatered;

    public Flower(String name, int harvestTime,
                  int waterNeeded, int waterBonus,
                  int fertilizerNeeded, int fertilizerBonus,
                  int seedCost, int basePrice, double experience,
                  int minimumProduce, int maximumProduce) {

        super(name, harvestTime, waterNeeded, waterBonus,
                fertilizerNeeded, fertilizerBonus, seedCost, basePrice,
                experience, minimumProduce, maximumProduce);
    }

    public void doubleWaterTile() {
        this.isDoubleWatered = true;
    }

    public boolean isDoubleWatered() {
        return isDoubleWatered;
    }

    public void setDoubleWatered(boolean doubleWatered) {
        isDoubleWatered = doubleWatered;
    }
}
