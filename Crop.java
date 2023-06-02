
abstract public class Crop {
    private String name;
    private int harvestTime;

    private int waterNeeded;
    private int waterBonus;

    private int fertilizerNeeded;
    private int fertilizerBonus;

    private int seedCost;
    private int basePrice;
    private double experience;

    private int minimumProduce;
    private int maximumProduce;

    // CONSTRUCTORS

    public Crop(String name, int harvestTime,
                int waterNeeded, int waterBonus,
                int fertilizerNeeded, int fertilizerBonus,
                int seedCost, int basePrice, double experience,
                int minimumProduce, int maximumProduce) {

        this.name = name;
        this.harvestTime = harvestTime;

        this.waterNeeded = waterNeeded;
        this.waterBonus = waterBonus;
        this.fertilizerNeeded = fertilizerNeeded;
        this.fertilizerBonus = fertilizerBonus;

        this.seedCost = seedCost;
        this.basePrice = basePrice;
        this.experience = experience;
        this.minimumProduce = minimumProduce;
        this.maximumProduce = maximumProduce;
    }

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getWaterBonus() {
        return waterBonus;
    }
    public void setWaterBonus(int waterBonus) {
        this.waterBonus = waterBonus;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public int getFertilizerBonus() {
        return fertilizerBonus;
    }
    public void setFertilizerBonus(int fertilizerBonus) {
        this.fertilizerBonus = fertilizerBonus;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getExperience() {
        return experience;
    }

    public int getMinimumProduce() {
        return minimumProduce;
    }

    public int getMaximumProduce() {
        return maximumProduce;
    }
}
