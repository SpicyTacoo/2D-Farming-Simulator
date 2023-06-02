import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MyFarm {
    /* Driver class
                    */

    public static void main(String[] args) {

        Root turnip = new Root("Turnip", 2, 1, 2, 0, 1, 5, 6, 5, 1, 2);
        Root carrot = new Root("Carrot", 3, 1, 2, 0, 1, 10, 9, 7.5, 1, 2);
        Root potato = new Root("Potato", 5, 3, 4, 1, 2, 20, 3, 12.5, 1, 10);

        Flower rose = new Flower("Rose", 1, 1, 2, 0,1,5, 5, 2.5, 1, 1);
        Flower tulip = new Flower("Tulip", 2, 2, 3, 0,1,10, 9, 5, 1, 1);
        Flower sunflower = new Flower("Sunflower", 3, 2, 3, 1,2,20, 19, 7.5, 1, 1);

        FruitTree mango = new FruitTree("Mango", 10, 7, 7, 4, 4, 100, 8, 25, 5, 15);
        FruitTree apple = new FruitTree("Apple", 10, 7, 7, 5, 5, 200, 5, 25, 10, 15);

        Plow plow = new Plow("plow", 0, 0.5);
        WateringCan wateringCan = new WateringCan("watering can", 0, 0.5);
        Fertilizer fertilizer = new Fertilizer("fertilizer", 10, 4);
        Pickaxe pickaxe = new Pickaxe("pickaxe", 50, 15);
        Shovel shovel = new Shovel("shovel", 7, 2);

        GUI gui = new GUI();
        Player player = new Player(plow, wateringCan, fertilizer, pickaxe, shovel);
        Report report = new Report();
        FarmLot farmLot = new FarmLot(player, report, turnip, carrot, potato, rose, tulip, sunflower, mango, apple);
        GUIController controller = new GUIController(gui, farmLot);

        Path file = Paths.get("rocks.txt");
        ArrayList<String> rockList = new ArrayList<>();

        try{
            BufferedReader reader = Files.newBufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isBlank()){
                    String[] rocks = line.split(",");

                    for (int i = 0; i < rocks.length; i++){
                        rockList.add(rocks[i]);
                    }
                }
            }
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < 50; i++) {
            farmLot.getTile().add(new Tile());
        }

        farmLot.initializeTileRock(rockList);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (farmLot.getTile().get((i * 10) + j).isRocked())
                    gui.getTiles()[i][j].setBackground(new Color(0x808080));
            }
        }
    }

}