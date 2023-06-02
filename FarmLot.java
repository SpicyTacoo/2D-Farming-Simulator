import java.util.ArrayList;
import java.util.Random;

public class FarmLot {

    private int day;

    private double harvestTotal;
    private double waterBonus;
    private double fertilizerBonus;
    private double finalHarvestPrice;

    private Random random = new Random();
    private ArrayList<Tile> tile;
    private Player player;

    private Report report;

    private Root turnip;
    private Root carrot;
    private Root potato;

    private Flower rose;
    private Flower tulip;
    private Flower sunflower;

    private FruitTree mango;
    private FruitTree apple;

    public FarmLot(Player player, Report report,
                   Root turnip, Root carrot, Root potato,
                   Flower rose, Flower tulip, Flower sunflower,
                   FruitTree mango, FruitTree apple) {

        this.player = player;
        this.report = report;
        this.turnip = turnip;
        this.carrot = carrot;
        this.potato = potato;
        this.rose = rose;
        this.tulip = tulip;
        this.sunflower = sunflower;
        this.mango = mango;
        this.apple = apple;

        this.tile = new ArrayList<>();
        this.day = 1;
    }

    public boolean isPlantableFruitTree(int index) {
        if (index >= 0 && index <= 10)
            return false;
        if (index == 19 || index == 20 || index == 29 || index == 30)
            return false;
        if (index >= 39 && index <= 49)
            return false;
        if (tile.get(index - 11).isOccupied() || tile.get(index - 10).isOccupied() || tile.get(index - 9).isOccupied()
                || tile.get(index - 1).isOccupied() || tile.get(index + 1).isOccupied()
                || tile.get(index + 9).isOccupied() || tile.get(index + 10).isOccupied() || tile.get(index + 11).isOccupied())
            return false;
        return true;
    }

    public void plantTile(Crop crop, int tileIndex) {

        if (tile.get(tileIndex).isRocked()) {
            report.updatePlantCropMessage("Tile contains rocks! You cannot plant " + crop.getName() + " here!");
            return;
        }

        if (tile.get(tileIndex).isWithered()) {
            report.updatePlantCropMessage("Tile contains withered crop!");
            return;
        }

        if (!tile.get(tileIndex).isPlowed()) {
            report.updatePlantCropMessage("Tile is not plowed! You cannot plant " + crop.getName() + " here!");
            return;
        }

        if (tile.get(tileIndex).isOccupied()) {
            report.updatePlantCropMessage("Tile already has crop!");
            return;
        }

        if (crop instanceof FruitTree) {
            if (isPlantableFruitTree(tileIndex)){
                getTile().get(tileIndex).plantCrop(crop, player, report);
            }
            else {
                report.updatePlantCropMessage("You cannot plant " + crop.getName() + " here!");
                System.out.println("You cannot plant fruit tree type crop!");
            }
        }
        else {
            getTile().get(tileIndex).plantCrop(crop, player, report);
        }
    }

    public void harvestTile(int index){
        if (getTile().get(index).isHarvestable(this.report)){
            int productProduced = random.nextInt(tile.get(index).getPlantedCrop().getMaximumProduce() - tile.get(index).getPlantedCrop().getMinimumProduce() + 1) + 1;
            double experienceGain = productProduced * getTile().get(index).getPlantedCrop().getExperience();

            harvestTotal = productProduced * (tile.get(index).getPlantedCrop().getBasePrice() + player.getFarmerType().getBonusEarningsPerProduce()); // farmer type earning bonus

            if (tile.get(index).checkIfHasWaterBonus())
                waterBonus = harvestTotal * 0.2 * (tile.get(index).getPlantedCrop().getWaterBonus() - 1);
            if (tile.get(index).checkIfHasFertilizerBonus())
                fertilizerBonus = harvestTotal * 0.5 * tile.get(index).getPlantedCrop().getFertilizerBonus();

            finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

            if (tile.get(index).getPlantedCrop() instanceof Flower)
                finalHarvestPrice = finalHarvestPrice * 1.1;

            player.harvestTile(finalHarvestPrice, experienceGain);
            this.tile.set(index, new Tile());

            report.updateHarvestMessage("You gained " + finalHarvestPrice + " ObjectCoins & " + experienceGain + " xp!" +
                    "You now have " + player.getObjectCoins() + " ObjectCoins\n");

            System.out.println("You gained " + finalHarvestPrice + " ObjectCoins & " + experienceGain + " xp!");
            System.out.println("You now have " + player.getObjectCoins() + " ObjectCoins\n");
        }
    }

    public void initializeTileRock(ArrayList<String> rockList) {
        for (int i = 0; i < rockList.size(); i++) {
            if (rockList.get(i).equals("1"))
                tile.get(i).initializeRock();
        }
    }

    public void advanceDay() {
        day++;

        for (int i = 0; i < tile.size(); i++) {
            tile.get(i).setWatered(false);
            tile.get(i).setFertilized(false);

            if (tile.get(i).getPlantedCrop() instanceof Flower) {
                ((Flower) tile.get(i).getPlantedCrop()).setDoubleWatered(false);
            }

            if (tile.get(i).isOccupied()) {
                tile.get(i).addAgeCount();
            }

            if (tile.get(i).getPlantedCrop() != null) {
                if (tile.get(i).getAgeCounter() > tile.get(i).getPlantedCrop().getHarvestTime()) {
                    tile.get(i).setWithered(true);
                }
            }
        }

    }

    public int getDay() {
        return day;
    }

    public ArrayList<Tile> getTile() {
        return tile;
    }

    public Player getPlayer() {
        return player;
    }

    public Report getReport() {
        return report;
    }

    public Root getTurnip() {
        return turnip;
    }

    public Root getCarrot() {
        return carrot;
    }

    public Root getPotato() {
        return potato;
    }

    public Flower getRose() {
        return rose;
    }

    public Flower getTulip() {
        return tulip;
    }

    public Flower getSunflower() {
        return sunflower;
    }

    public FruitTree getMango() {
        return mango;
    }

    public FruitTree getApple() {
        return apple;
    }
}
