public class FarmerType {
    private int levelRequirement;
    private int bonusEarningsPerProduce;
    private int seedCostReduction;
    private int waterBonusLimitIncrease;
    private int fertilizerBonusLimitIncrease;
    private int registrationFee;

    public FarmerType(int levelRequirement, int bonusEarningsPerProduce, int seedCostReduction, int waterBonusLimitIncrease, int fertilizerBonusLimitIncrease, int registrationFee) {
        this.levelRequirement = levelRequirement;
        this.bonusEarningsPerProduce = bonusEarningsPerProduce;
        this.seedCostReduction = seedCostReduction;
        this.waterBonusLimitIncrease = waterBonusLimitIncrease;
        this.fertilizerBonusLimitIncrease = fertilizerBonusLimitIncrease;
        this.registrationFee = registrationFee;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public int getBonusEarningsPerProduce() {
        return bonusEarningsPerProduce;
    }

    public int getSeedCostReduction() {
        return seedCostReduction;
    }

    public int getWaterBonusLimitIncrease() {
        return waterBonusLimitIncrease;
    }

    public int getFertilizerBonusLimitIncrease() {
        return fertilizerBonusLimitIncrease;
    }

    public int getRegistrationFee() {
        return registrationFee;
    }
}
