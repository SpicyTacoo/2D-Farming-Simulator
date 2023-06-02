public class Root extends Crop {

    public Root(String name, int harvestTime,
                int waterNeeded, int waterBonus,
                int fertilizerNeeded, int fertilizerBonus,
                int seedCost, int basePrice, double experience,
                int minimumProduce, int maximumProduce) {

        super(name, harvestTime, waterNeeded, waterBonus,
                fertilizerNeeded, fertilizerBonus, seedCost, basePrice,
                experience, minimumProduce, maximumProduce);
    }
}
