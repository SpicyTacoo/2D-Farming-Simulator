import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener {
    private GUI gui;
    private FarmLot farmLot;
    private int tileIndex;

    public GUIController(GUI gui, FarmLot farmLot) {
        this.gui = gui;
        this.farmLot = farmLot;

        this.tileIndex = 0;

        gui.getCoins().setText("" + farmLot.getPlayer().getObjectCoins() + "");

        gui.getbUpgradeFarmer().addActionListener(this);

        gui.getbTurnip().addActionListener(this);
        gui.getbCarrot().addActionListener(this);
        gui.getbPotato().addActionListener(this);

        gui.getbRose().addActionListener(this);
        gui.getbTulip().addActionListener(this);
        gui.getbSunflower().addActionListener(this);

        gui.getbApple().addActionListener(this);
        gui.getbMango().addActionListener(this);

        gui.getbPlow().addActionListener(this);
        gui.getbWateringCan().addActionListener(this);
        gui.getbFertilizer().addActionListener(this);
        gui.getbPickaxe().addActionListener(this);
        gui.getbShovel().addActionListener(this);

        gui.getbHarvest().addActionListener(this);

        gui.getbAdvanceDay().addActionListener(this);

        gui.getPanel2().setVisible(false);
        gui.getPanel4().setVisible(false);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                gui.getTiles()[i][j].addActionListener(this);
            }
        }

    }

    public void updateInfo() {
        this.gui.getCoins().setText("" + farmLot.getPlayer().getObjectCoins() + "");
        this.gui.getDay().setText("" + farmLot.getDay() + "");
        this.gui.getLevel().setText("" + farmLot.getPlayer().getLevel() + "");
        this.gui.getExperience().setText("" + farmLot.getPlayer().getExperience() + "");
    }

    public void loseCondition() {
        int counter = 0;

        if (farmLot.getPlayer().getObjectCoins() < 12) {

            for (int i = 0; i < 50; i++) {
                if (farmLot.getTile().get(i).isWithered() || farmLot.getTile().get(i).isRocked()) {
                    counter++;
                }
            }

            if (counter == 50)
                gui.getScreenMessage().setText("Game Over!");
        }

        if (farmLot.getPlayer().getObjectCoins() < 5) {
            counter = 0;

            for (int i = 0; i < 50; i++) {
                if (farmLot.getTile().get(i).isWithered() || farmLot.getTile().get(i).isRocked() || !farmLot.getTile().get(i).isOccupied()) {
                    counter++;
                }
            }

            if (counter == 50)
                gui.getScreenMessage().setText("Game Over!");
        }


        if (farmLot.getPlayer().getObjectCoins() == 0) {
            counter = 0;

            for (int i = 0; i < 50; i++) {
                if (farmLot.getTile().get(i).isWithered() || farmLot.getTile().get(i).isRocked() || !farmLot.getTile().get(i).isOccupied()) {
                    counter++;
                }
                if (farmLot.getTile().get(i).getPlantedCrop() != null){
                    if (farmLot.getTile().get(i).getPlantedCrop().getFertilizerNeeded() > 0 && farmLot.getTile().get(i).isOccupied())
                        counter++;
                }
            }

            if (counter == 50)
                gui.getScreenMessage().setText("Game Over!");
        }
    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (e.getSource() == gui.getTiles()[i][j]) {

                    this.tileIndex = Integer.parseInt(gui.getTiles()[i][j].getText()) - 1;
                    gui.getPanel2().setVisible(true);
                    gui.getPanel4().setVisible(true);
                    gui.getlTileStatus().setText("Tile # " + gui.getTiles()[i][j].getText() + " Status.");
                    gui.getScreenMessage().setText("You selected tile " + gui.getTiles()[i][j].getText());

                    gui.getlHasRocks().setText("Has Rocks: " + farmLot.getTile().get(tileIndex).isRocked());
                    gui.getlPlowed().setText("Plowed: " + farmLot.getTile().get(tileIndex).isPlowed());
                    gui.getlOccupied().setText("Occupied: " + farmLot.getTile().get(tileIndex).isOccupied());
                    gui.getlWatered().setText("Watered: " + farmLot.getTile().get(tileIndex).isWatered());
                    gui.getlFertilized().setText("Fertilized: " + farmLot.getTile().get(tileIndex).isFertilized());
                    gui.getlWithered().setText("Withered: " + farmLot.getTile().get(tileIndex).isWithered());

                    if (farmLot.getTile().get(tileIndex).getPlantedCrop() != null){
                        gui.getlDaysBeforeHarvest()
                                .setText("Days Before Harvest: "
                                        + (farmLot.getTile().get(tileIndex).getPlantedCrop().getHarvestTime()
                                        - farmLot.getTile().get(tileIndex).getAgeCounter()));
                    }

                    gui.getlTimesWatered()
                            .setText("Total Times Watered: " + farmLot.getTile().get(tileIndex).getWaterCounter());
                    gui.getlTimesFertilized().setText(
                            "Total Times Fertilized: " + farmLot.getTile().get(tileIndex).getFertilizerCounter());

                    if (farmLot.getTile().get(tileIndex).isRocked())
                        gui.getTiles()[i][j].setBackground(new Color(0x808080));

                }
            }
        }

        int i = (((tileIndex) / 10) % 10);
        int j = ((tileIndex) % 10);

        if (e.getSource() == gui.getbTurnip()) {
            farmLot.plantTile(farmLot.getTurnip(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getTurnipIcon());
        }

        if (e.getSource() == gui.getbCarrot()) {
            farmLot.plantTile(farmLot.getCarrot(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getCarrotIcon());
        }

        if (e.getSource() == gui.getbPotato()) {
            farmLot.plantTile(farmLot.getPotato(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getPotatoIcon());
        }

        if (e.getSource() == gui.getbRose()) {
            farmLot.plantTile(farmLot.getRose(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getRoseIcon());
        }

        if (e.getSource() == gui.getbTulip()) {
            farmLot.plantTile(farmLot.getTulip(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getTulipIcon());
        }

        if (e.getSource() == gui.getbSunflower()) {
            farmLot.plantTile(farmLot.getSunflower(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getSunflowerIcon());
        }

        if (e.getSource() == gui.getbMango()) {
            farmLot.plantTile(farmLot.getMango(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getMangoIcon());
        }

        if (e.getSource() == gui.getbApple()) {
            farmLot.plantTile(farmLot.getApple(), tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getPlantCropMessage());

            if (farmLot.getTile().get(tileIndex).isPlowed() && farmLot.getTile().get(tileIndex).isOccupied())
                gui.getTiles()[i][j].setIcon(gui.getAppleIcon());
        }

        if (e.getSource() == gui.getbPlow()) {
            farmLot.getPlayer().getPlow().useTool(farmLot, tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getToolMessage());
        }

        if (e.getSource() == gui.getbWateringCan()) {
            farmLot.getPlayer().getWateringCan().useTool(farmLot, tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getToolMessage());
        }

        if (e.getSource() == gui.getbFertilizer()) {
            farmLot.getPlayer().getFertilizer().useTool(farmLot, tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getToolMessage());
        }

        if (e.getSource() == gui.getbPickaxe()) {
            farmLot.getPlayer().getPickaxe().useTool(farmLot, tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getToolMessage());
            gui.getTiles()[i][j].setBackground(new Color(0x6D4930));
        }

        if (e.getSource() == gui.getbShovel()) {
            farmLot.getPlayer().getShovel().useTool(farmLot, tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getToolMessage());
        }

        if (e.getSource() == gui.getbHarvest()) {
            farmLot.harvestTile(tileIndex);
            gui.getScreenMessage().setText(farmLot.getReport().getHarvestMessage());
            gui.getTiles()[i][j].setIcon(null);
        }


        if (e.getSource() == gui.getbUpgradeFarmer()) {

            farmLot.getPlayer().registerTitle(farmLot.getReport(),
                    farmLot.getTurnip(), farmLot.getCarrot(), farmLot.getPotato(),
                    farmLot.getRose(), farmLot.getTulip(), farmLot.getSunflower(),
                    farmLot.getMango(), farmLot.getApple());
            gui.getScreenMessage().setText(farmLot.getReport().getRegisterTitleMessage());
        }

        if (e.getSource() == gui.getbAdvanceDay()) {
            farmLot.advanceDay();
            gui.getPanel2().setVisible(false);
            gui.getPanel4().setVisible(false);

            int counter = 0;
            for (i = 0; i < 50; i++) {
                int tile = i + 1;
                if (farmLot.getTile().get(i).isHarvestable(farmLot.getReport())) {
                    counter++;

                    if (counter == 1) {
                        gui.getScreenMessage().setText("Tiles ready to be harvested are " + tile);
                    }
                    else {
                        gui.getScreenMessage().setText(gui.getScreenMessage().getText() + ", " + tile);
                    }

                }
            }
        }

        updateInfo();
        loseCondition();
    }
}
