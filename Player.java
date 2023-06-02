
public class Player {
    private int level;
    private double experience;
    private double objectCoins;
    private FarmerType farmerType;

    private Plow plow;
    private WateringCan wateringCan;
    private Fertilizer fertilizer;
    private Pickaxe pickaxe;
    private Shovel shovel;

    private FarmerType defaultFarmer;
    private FarmerType registeredFarmer;
    private FarmerType distinguishedFarmer;
    private FarmerType legendaryFarmer;


    // CONSTRUCTORS

    public Player(Plow plow, WateringCan wateringCan, Fertilizer fertilizer, Pickaxe pickaxe, Shovel shovel) {
        this.defaultFarmer = new FarmerType(0,0, 0, 0, 0, 0);
        this.registeredFarmer = new FarmerType(5,1, -1, 0, 0, 200);
        this.distinguishedFarmer = new FarmerType(10,2, -2, 1, 0, 300);
        this.legendaryFarmer = new FarmerType(15,4, -3, 2, 1, 400);

        this.level = 9;
        this.experience = 999.0;
        this.objectCoins = 1000.0;
        this.farmerType = defaultFarmer;

        this.plow = plow;
        this.wateringCan = wateringCan;
        this.fertilizer = fertilizer;
        this.pickaxe = pickaxe;
        this.shovel = shovel;
    }

    // METHODS
    public void computeLevel() {
        this.level = (int)(this.experience / 100);
    }

    public void gainExperience(double experience) {
        this.experience += experience;

        computeLevel();
    }

    public void useTool(double cost){
        this.objectCoins -= cost;

    }

    public void harvestTile(double earnings, double experience) {
        this.objectCoins += earnings;
        gainExperience(experience);
    }

    public boolean isEligibleToRegister(int levelRequirement, int registrationFee) {
        if (level >= levelRequirement && objectCoins >= registrationFee) {
            return true;
        }
        return false;
    }

    public void plantTile(int cost) {
        this.objectCoins -= cost;
    }


    public void registerTitle(Report report,
                              Root turnip, Root carrot, Root potato,
                              Flower rose, Flower tulip, Flower sunflower,
                              FruitTree mango, FruitTree apple) {

        if (farmerType.equals(defaultFarmer)) {
            if (isEligibleToRegister(registeredFarmer.getLevelRequirement(), registeredFarmer.getRegistrationFee())){
                this.farmerType = registeredFarmer;

                objectCoins -= registeredFarmer.getRegistrationFee();
                report.updateRegisterTitleMessage("Successfully upgraded to registered farmer. You spent" + registeredFarmer.getRegistrationFee() +
                                                            "ObjectCoins. You now have +" +registeredFarmer.getBonusEarningsPerProduce() +
                                                            "bonus earnings per produce, " +registeredFarmer.getSeedCostReduction() + " seed cost reduction.");
                return;
            }

            else if (this.level < registeredFarmer.getLevelRequirement()) {
                report.updateRegisterTitleMessage("Insufficient level!");
            }
            else if (this.objectCoins < registeredFarmer.getRegistrationFee()) {
                report.updateRegisterTitleMessage("Insufficient ObjectCoins!");
            }
        }

        if (farmerType.equals(registeredFarmer)) {
            if (isEligibleToRegister(distinguishedFarmer.getLevelRequirement(), distinguishedFarmer.getRegistrationFee())){
                this.farmerType = distinguishedFarmer;

                updateBonus(turnip, carrot, potato, rose, tulip, sunflower, mango, apple, distinguishedFarmer.getWaterBonusLimitIncrease(), distinguishedFarmer.getFertilizerBonusLimitIncrease());
                objectCoins -= distinguishedFarmer.getRegistrationFee();
                report.updateRegisterTitleMessage("Successfully upgraded to registered farmer. You spent" + distinguishedFarmer.getRegistrationFee() +
                                                            "ObjectCoins. You now have +" + distinguishedFarmer.getBonusEarningsPerProduce() +
                                                            "bonus earnings per produce, " + distinguishedFarmer.getSeedCostReduction() + " seed cost reduction, +" +
                                                            distinguishedFarmer.getWaterBonusLimitIncrease() + " water bonus limit increase.");
                return;
            }

            else if (this.level < distinguishedFarmer.getLevelRequirement()){
                report.updateRegisterTitleMessage("Insufficient level!");
            }

            else if (this.objectCoins < distinguishedFarmer.getRegistrationFee()) {
                report.updateRegisterTitleMessage("Insufficient ObjectCoins!");
            }
        }

        if (farmerType.equals(distinguishedFarmer)) {
            if (isEligibleToRegister(legendaryFarmer.getLevelRequirement(), legendaryFarmer.getRegistrationFee())){
                this.farmerType = legendaryFarmer;

                updateBonus(turnip, carrot, potato, rose, tulip, sunflower, mango, apple, legendaryFarmer.getWaterBonusLimitIncrease(), legendaryFarmer.getFertilizerBonusLimitIncrease());
                objectCoins -= legendaryFarmer.getRegistrationFee();
                report.updateRegisterTitleMessage("Successfully upgraded to registered farmer. You spent" + legendaryFarmer.getRegistrationFee() +
                                                            "ObjectCoins. You now have +" + legendaryFarmer.getBonusEarningsPerProduce() +
                                                            "bonus earnings per produce, " + legendaryFarmer.getSeedCostReduction() + " seed cost reduction, +" +
                                                            legendaryFarmer.getWaterBonusLimitIncrease() + " water bonus limit increase, +" +
                                                            legendaryFarmer.getFertilizerBonusLimitIncrease() + " fertilizer bonus limit increase.");
                return;
            }

            else if (this.level < legendaryFarmer.getLevelRequirement()){
                report.updateRegisterTitleMessage("Insufficient level!");
            }

            else if (this.objectCoins < legendaryFarmer.getRegistrationFee()) {
                report.updateRegisterTitleMessage("Insufficient ObjectCoins!");
            }
        }

        if (farmerType.equals(legendaryFarmer)) {
            report.updateRegisterTitleMessage("You are already at the highest farmer title!");
        }
    }

    public void updateBonus(Root turnip, Root carrot, Root potato,
                            Flower rose, Flower tulip, Flower sunflower,
                            FruitTree mango, FruitTree apple,
                            int waterBonus, int fertilizerBonus) {

        shortcutUpdate(turnip, waterBonus, fertilizerBonus);
        shortcutUpdate(carrot, waterBonus, fertilizerBonus);
        shortcutUpdate(potato, waterBonus, fertilizerBonus);
        shortcutUpdate(rose, waterBonus, fertilizerBonus);
        shortcutUpdate(tulip, waterBonus, fertilizerBonus);
        shortcutUpdate(sunflower, waterBonus, fertilizerBonus);
        shortcutUpdate(mango, waterBonus, fertilizerBonus);
        shortcutUpdate(apple, waterBonus, fertilizerBonus);
    }

    public void shortcutUpdate(Crop crop, int waterBonus, int fertilizerBonus) {
        crop.setWaterBonus(crop.getWaterBonus() + waterBonus);
        crop.setFertilizerBonus(crop.getFertilizerBonus() + fertilizerBonus);
    }
    // GETTERS AND SETTERS

    public int getLevel() {
        return level;
    }

    public double getExperience() {
        return experience;
    }

    public double getObjectCoins() {
        return objectCoins;
    }

    public FarmerType getFarmerType() {
        return farmerType;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public Plow getPlow() {
        return plow;
    }

    public WateringCan getWateringCan() {
        return wateringCan;
    }

    public Fertilizer getFertilizer() {
        return fertilizer;
    }

    public Pickaxe getPickaxe() {
        return pickaxe;
    }
}
