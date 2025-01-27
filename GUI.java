import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

public class GUI {

    private JFrame frame = new JFrame("MyFarm");
    private String message = new String("Welcome to MyFarm!");
    private double objectCoins = 0.0;
    private int nDay = 1;
    private int nLevel = 0;
    private double dExperience = 0.0;

    private int tileNo = 0;
    private boolean hasRocks = false;
    private boolean isPlowed = false;
    private boolean isOccupied = false;
    private boolean isWatered = false;
    private boolean isFertilized = false;
    private boolean isWithered = false;
    private int daysBeforeHarvest = 0;
    private int timesWatered = 0;
    private int timesFertilized = 0;

    private JButton[][] tiles = new JButton[5][10];

    private ImageIcon icon = new ImageIcon("Images/gameicon.png"); // for window icon
    private ImageIcon plowIcon = new ImageIcon("Images/plow.png");
    private ImageIcon wateringCanIcon = new ImageIcon("Images/wateringcan.png");
    private ImageIcon fertilizerIcon = new ImageIcon("Images/fertilizer.png");
    private ImageIcon pickaxeIcon = new ImageIcon("Images/pickaxe.png");
    private ImageIcon shovelIcon = new ImageIcon("Images/shovel.png");

    private ImageIcon turnipIcon = new ImageIcon("Images/turnip.png");
    private ImageIcon carrotIcon = new ImageIcon("Images/carrot.png");
    private ImageIcon potatoIcon = new ImageIcon("Images/potato.png");
    private ImageIcon roseIcon = new ImageIcon("Images/rose.png");
    private ImageIcon tulipIcon = new ImageIcon("Images/tulip.png");
    private ImageIcon sunflowerIcon = new ImageIcon("Images/sunflower.png");
    private ImageIcon mangoIcon = new ImageIcon("Images/mango.png");
    private ImageIcon appleIcon = new ImageIcon("Images/apple.png");

    // panels
    private JPanel panel1 = new JPanel(new BorderLayout());
    private JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    private JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    private JPanel panel4 = new JPanel(new GridLayout(1, 4));
    private JPanel panel5 = new JPanel(new GridLayout(5, 10));

    private JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 38));
    private JPanel panel7 = new JPanel();
    private JPanel panel8 = new JPanel();
    private JPanel panel9 = new JPanel();

    // north
    private JLabel screenMessage = new JLabel(message);

    // east
    // tools idea : can put icons instead of names
    private JLabel lTools = new JLabel("Tools");
    private JButton bPlow = new JButton();
    private JButton bWateringCan = new JButton();
    private JButton bFertilizer = new JButton();
    private JButton bPickaxe = new JButton();
    private JButton bShovel = new JButton();

    private JLabel lPricesOne = new JLabel("0     0    10    50");
    private JLabel lPricesTwo = new JLabel("7");
    // seeds idea : can put icons instead of names
    private JLabel lSeeds = new JLabel("Seeds");
    private JButton bTurnip = new JButton();
    private JButton bCarrot = new JButton();
    private JButton bPotato = new JButton();
    private JButton bRose = new JButton();
    private JButton bTulip = new JButton();
    private JButton bSunflower = new JButton();
    private JButton bMango = new JButton();
    private JButton bApple = new JButton();

    private JLabel lPricesThree = new JLabel(" 5    10    20     5 ");
    private JLabel lPricesFour = new JLabel("10    20    100   200");
    // harvest
    private JButton bHarvest = new JButton("HARVEST");

    // west
    private JLabel lCoins = new JLabel("ObjectCoins");
    private JLabel coins = new JLabel("" + objectCoins + "");

    private JLabel lDay = new JLabel("Day");
    private JLabel day = new JLabel("" + nDay + "");

    private JLabel lLevel = new JLabel("Level");
    private JLabel level = new JLabel("" + nLevel + "");

    private JLabel lExperience = new JLabel("Experience");
    private JLabel experience = new JLabel("" + dExperience + "");

    private JButton bUpgradeFarmer = new JButton("Upgrade Farmer");
    private JButton bAdvanceDay = new JButton("Advance Day");

    // south
    private JLabel lTileStatus = new JLabel("Tile # " + tileNo + " Status.");

    private JLabel lHasRocks = new JLabel("Has Rocks: " + hasRocks);
    private JLabel lPlowed = new JLabel("Plowed: " + isPlowed);
    private JLabel lOccupied = new JLabel("Occupied: " + isOccupied);

    private JLabel lWatered = new JLabel("Watered: " + isWatered);
    private JLabel lFertilized = new JLabel("Fertilized: " + isFertilized);
    private JLabel lWithered = new JLabel("Withered: " + isWithered);

    private JLabel lDaysBeforeHarvest = new JLabel("Days Before Harvest: " + daysBeforeHarvest);
    private JLabel lTimesWatered = new JLabel("Total Times Watered: " + timesWatered);
    private JLabel lTimesFertilized = new JLabel("Total Times Fertilized: " + timesFertilized);

    public GUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setResizable(false);
        frame.setSize(1500, 750);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);

        panel1.setBackground(new Color(0xD1B7A1));
        panel2.setBackground(new Color(0xA39885));
        panel3.setBackground(new Color(0xA39885));
        panel4.setBackground(new Color(0xD1B7A1));
        panel5.setBackground(new Color(0xA4B07E));
        panel6.setBackground(new Color(0xA4B07E));
        panel7.setBackground(new Color(0xD1B7A1));
        panel8.setBackground(new Color(0xD1B7A1));
        panel9.setBackground(new Color(0xD1B7A1));

        panel1.setPreferredSize(new Dimension(1500, 100));
        panel2.setPreferredSize(new Dimension(200, 750));
        panel3.setPreferredSize(new Dimension(200, 750));
        panel4.setPreferredSize(new Dimension(1500, 100));

        // panel6.add(Box.createRigidArea(new Dimension(10, 20)));
        // panel6.setLayout(new BoxLayout(panel6, BoxLayout.PAGE_AXIS));
        panel7.add(Box.createRigidArea(new Dimension(10, 20)));
        panel7.setLayout(new BoxLayout(panel7, BoxLayout.PAGE_AXIS));
        panel8.add(Box.createRigidArea(new Dimension(10, 20)));
        panel8.setLayout(new BoxLayout(panel8, BoxLayout.PAGE_AXIS));
        panel9.add(Box.createRigidArea(new Dimension(10, 20)));
        panel9.setLayout(new BoxLayout(panel9, BoxLayout.PAGE_AXIS));

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.SOUTH);
        panel4.add(panel6);
        panel4.add(panel7);
        panel4.add(panel8);
        panel4.add(panel9);
        frame.add(panel5, BorderLayout.CENTER);

        // MESSAGES ( NORTH )

        screenMessage.setHorizontalAlignment(JLabel.CENTER);
        screenMessage.setVerticalTextPosition(JLabel.CENTER);
        screenMessage.setFont(new Font("Lucida Console", Font.PLAIN, 15));
        panel1.add(screenMessage);

        // BUTTONS ( EAST )

        // TOOLS BUTTONS

        lTools.setFont(new Font("Lucida Console", Font.BOLD, 15));
        lTools.setHorizontalAlignment(JLabel.CENTER);
        lTools.setPreferredSize(new Dimension(175, 30));
        panel2.add(lTools);

        lPricesOne.setFont(new Font("Lucida Console", Font.BOLD, 13));
        lPricesOne.setHorizontalAlignment(JLabel.CENTER);
        lPricesOne.setPreferredSize(new Dimension(175, 13));
        lPricesTwo.setFont(new Font("Lucida Console", Font.BOLD, 13));
        lPricesTwo.setHorizontalAlignment(JLabel.CENTER);
        lPricesTwo.setPreferredSize(new Dimension(175, 13));

        bPlow.setPreferredSize(new Dimension(40, 40));
        bWateringCan.setPreferredSize(new Dimension(40, 40));
        bFertilizer.setPreferredSize(new Dimension(40, 40));
        bPickaxe.setPreferredSize(new Dimension(40, 40));
        bShovel.setPreferredSize(new Dimension(40, 40));

        bPlow.setBackground(new Color(0xd4ccb4));
        bWateringCan.setBackground(new Color(0xd4ccb4));
        bFertilizer.setBackground(new Color(0xd4ccb4));
        bPickaxe.setBackground(new Color(0xd4ccb4));
        bShovel.setBackground(new Color(0xd4ccb4));

        Image plowImg = plowIcon.getImage();
        Image newPlowImg = plowImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        plowIcon = new ImageIcon(newPlowImg);
        bPlow.setIcon(plowIcon);

        Image wateringCanImg = wateringCanIcon.getImage();
        Image newWateringCanImg = wateringCanImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        wateringCanIcon = new ImageIcon(newWateringCanImg);
        bWateringCan.setIcon(wateringCanIcon);

        Image fertilizerImg = fertilizerIcon.getImage();
        Image newFertilizerImg = fertilizerImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        fertilizerIcon = new ImageIcon(newFertilizerImg);
        bFertilizer.setIcon(fertilizerIcon);

        Image pickaxeImg = pickaxeIcon.getImage();
        Image newPickaxeImg = pickaxeImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        pickaxeIcon = new ImageIcon(newPickaxeImg);
        bPickaxe.setIcon(pickaxeIcon);

        Image shovelImg = shovelIcon.getImage();
        Image newShovelImg = shovelImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        shovelIcon = new ImageIcon(newShovelImg);
        bShovel.setIcon(shovelIcon);

        panel2.add(bPlow, BorderLayout.CENTER);
        panel2.add(bWateringCan, BorderLayout.CENTER);
        panel2.add(bFertilizer, BorderLayout.CENTER);
        panel2.add(bPickaxe, BorderLayout.CENTER);
        panel2.add(lPricesOne);
        panel2.add(bShovel, BorderLayout.CENTER);
        panel2.add(lPricesTwo);

        // SEEDS BUTTONS

        lSeeds.setFont(new Font("Lucida Console", Font.BOLD, 15));
        lSeeds.setHorizontalAlignment(JLabel.CENTER);
        lSeeds.setPreferredSize(new Dimension(175, 30));
        panel2.add(lSeeds);

        lPricesThree.setFont(new Font("Lucida Console", Font.BOLD, 13));
        lPricesThree.setHorizontalAlignment(JLabel.CENTER);
        lPricesThree.setPreferredSize(new Dimension(175, 13));
        lPricesFour.setFont(new Font("Lucida Console", Font.BOLD, 13));
        lPricesFour.setHorizontalAlignment(JLabel.CENTER);
        lPricesFour.setPreferredSize(new Dimension(175, 13));

        bTurnip.setPreferredSize(new Dimension(40, 40));
        bCarrot.setPreferredSize(new Dimension(40, 40));
        bPotato.setPreferredSize(new Dimension(40, 40));
        bRose.setPreferredSize(new Dimension(40, 40));
        bTulip.setPreferredSize(new Dimension(40, 40));
        bSunflower.setPreferredSize(new Dimension(40, 40));
        bMango.setPreferredSize(new Dimension(40, 40));
        bApple.setPreferredSize(new Dimension(40, 40));

        bTurnip.setBackground(new Color(0xd4ccb4));
        bCarrot.setBackground(new Color(0xd4ccb4));
        bPotato.setBackground(new Color(0xd4ccb4));
        bRose.setBackground(new Color(0xd4ccb4));
        bTulip.setBackground(new Color(0xd4ccb4));
        bSunflower.setBackground(new Color(0xd4ccb4));
        bMango.setBackground(new Color(0xd4ccb4));
        bApple.setBackground(new Color(0xd4ccb4));

        Image turnipImg = turnipIcon.getImage();
        Image newTurnipImg = turnipImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        turnipIcon = new ImageIcon(newTurnipImg);
        bTurnip.setIcon(turnipIcon);

        Image carrotImg = carrotIcon.getImage();
        Image newCarrotImg = carrotImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        carrotIcon = new ImageIcon(newCarrotImg);
        bCarrot.setIcon(carrotIcon);

        Image potatoImg = potatoIcon.getImage();
        Image newPotatoImg = potatoImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        potatoIcon = new ImageIcon(newPotatoImg);
        bPotato.setIcon(potatoIcon);

        Image roseImg = roseIcon.getImage();
        Image newRoseImg = roseImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        roseIcon = new ImageIcon(newRoseImg);
        bRose.setIcon(roseIcon);

        Image tulipImg = tulipIcon.getImage();
        Image newTulipImg = tulipImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        tulipIcon = new ImageIcon(newTulipImg);
        bTulip.setIcon(tulipIcon);

        Image sunflowerImg = sunflowerIcon.getImage();
        Image newSunflowerImg = sunflowerImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        sunflowerIcon = new ImageIcon(newSunflowerImg);
        bSunflower.setIcon(sunflowerIcon);

        Image mangoImg = mangoIcon.getImage();
        Image newMangoImg = mangoImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        mangoIcon = new ImageIcon(newMangoImg);
        bMango.setIcon(mangoIcon);

        Image appleImg = appleIcon.getImage();
        Image newAppleImg = appleImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        appleIcon = new ImageIcon(newAppleImg);
        bApple.setIcon(appleIcon);

        panel2.add(bTurnip, BorderLayout.CENTER);
        panel2.add(bCarrot, BorderLayout.CENTER);
        panel2.add(bPotato, BorderLayout.CENTER);
        panel2.add(bRose, BorderLayout.CENTER);
        panel2.add(lPricesThree);
        panel2.add(bTulip, BorderLayout.CENTER);
        panel2.add(bSunflower, BorderLayout.CENTER);
        panel2.add(bMango, BorderLayout.CENTER);
        panel2.add(bApple, BorderLayout.CENTER);
        panel2.add(lPricesFour);

        // HARVEST BUTTON

        JLabel filler = new JLabel(" ");
        filler.setPreferredSize(new Dimension(150, 30));
        panel2.add(filler);
        bHarvest.setBackground(new Color(0xFFD447));
        bHarvest.setPreferredSize(new Dimension(150, 40));
        panel2.add(bHarvest);

        // COINS AND DAYS ( WEST )

        lCoins.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lCoins.setHorizontalAlignment(JLabel.CENTER);
        lCoins.setPreferredSize(new Dimension(175, 30));
        panel3.add(lCoins);

        coins.setFont(new Font("Lucida Console", Font.BOLD, 30));
        coins.setHorizontalAlignment(JLabel.CENTER);
        coins.setPreferredSize(new Dimension(175, 30));
        panel3.add(coins);

        lDay.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lDay.setHorizontalAlignment(JLabel.CENTER);
        lDay.setPreferredSize(new Dimension(175, 30));
        panel3.add(lDay);

        day.setFont(new Font("Lucida Console", Font.BOLD, 30));
        day.setHorizontalAlignment(JLabel.CENTER);
        day.setPreferredSize(new Dimension(175, 30));
        panel3.add(day);

        lLevel.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lLevel.setHorizontalAlignment(JLabel.CENTER);
        lLevel.setPreferredSize(new Dimension(175, 30));
        panel3.add(lLevel);

        level.setFont(new Font("Lucida Console", Font.BOLD, 30));
        level.setHorizontalAlignment(JLabel.CENTER);
        level.setPreferredSize(new Dimension(175, 30));
        panel3.add(level);

        lExperience.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lExperience.setHorizontalAlignment(JLabel.CENTER);
        lExperience.setPreferredSize(new Dimension(175, 30));
        panel3.add(lExperience);

        experience.setFont(new Font("Lucida Console", Font.BOLD, 30));
        experience.setHorizontalAlignment(JLabel.CENTER);
        experience.setPreferredSize(new Dimension(175, 30));
        panel3.add(experience);

        bUpgradeFarmer.setPreferredSize(new Dimension(160, 40));
        bUpgradeFarmer.setBackground(new Color(0xd4ccb4));
        panel3.add(bUpgradeFarmer, BorderLayout.CENTER);

        bAdvanceDay.setPreferredSize(new Dimension(160, 40));
        bAdvanceDay.setBackground(new Color(0xd4ccb4));
        panel3.add(bAdvanceDay, BorderLayout.CENTER);

        // TILE STATUS ( SOUTH )

        lTileStatus.setFont(new Font("Lucida Console", Font.PLAIN, 25));
        panel6.add(lTileStatus);

        lHasRocks.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        lPlowed.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        lOccupied.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        panel7.add(lHasRocks);
        panel7.add(lPlowed);
        panel7.add(lOccupied);

        lWatered.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        lFertilized.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        lWithered.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        panel8.add(lWatered);
        panel8.add(lFertilized);
        panel8.add(lWithered);

        lDaysBeforeHarvest.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        lTimesWatered.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        lTimesFertilized.setFont(new Font("Lucida Console", Font.PLAIN, 18));
        panel9.add(lDaysBeforeHarvest);
        panel9.add(lTimesWatered);
        panel9.add(lTimesFertilized);

        // FARM/ACTUAL GAME ( CENTER )

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                int tileNo = (i * 10) + j + 1;
                tiles[i][j] = new JButton();
                tiles[i][j].setBackground(new Color(0x6D4930));
                tiles[i][j].setText(tileNo + "");
                tiles[i][j].setFocusable(false);
                panel5.add(tiles[i][j]);
            }
        }

        panel1.updateUI();
        panel2.updateUI();
        panel3.updateUI();
        panel4.updateUI();
        panel5.updateUI();
        panel6.updateUI();
        panel7.updateUI();
        panel8.updateUI();
        panel9.updateUI();

    }

    // GETTERS AND SETTERS

    public JButton[][] getTiles() {
        return tiles;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public JLabel getScreenMessage() {
        return screenMessage;
    }

    public JButton getbUpgradeFarmer() {
        return bUpgradeFarmer;
    }

    public JButton getbAdvanceDay() {
        return bAdvanceDay;
    }

    public JLabel getlHasRocks() {
        return lHasRocks;
    }

    public JLabel getlPlowed() {
        return lPlowed;
    }

    public JLabel getlFertilized() {
        return lFertilized;
    }

    public JLabel getlWithered() {
        return lWithered;
    }

    public JLabel getlDaysBeforeHarvest() {
        return lDaysBeforeHarvest;
    }

    public JLabel getlTimesWatered() {
        return lTimesWatered;
    }

    public JLabel getlTimesFertilized() {
        return lTimesFertilized;
    }

    public JButton getbPlow() {
        return bPlow;
    }

    public JButton getbWateringCan() {
        return bWateringCan;
    }

    public JButton getbFertilizer() {
        return bFertilizer;
    }

    public JButton getbPickaxe() {
        return bPickaxe;
    }


    public JButton getbShovel() {
        return bShovel;
    }


    public JLabel getlSeeds() {
        return lSeeds;
    }

    public JButton getbTurnip() {
        return bTurnip;
    }

    public JButton getbCarrot() {
        return bCarrot;
    }

    public JButton getbPotato() {
        return bPotato;
    }

    public JButton getbRose() {
        return bRose;
    }

    public JButton getbTulip() {
        return bTulip;
    }

    public JButton getbSunflower() {
        return bSunflower;
    }

    public JButton getbMango() {
        return bMango;
    }

    public JButton getbApple() {
        return bApple;
    }

    public JLabel getCoins() {
        return coins;
    }

    public JLabel getlDay() {
        return lDay;
    }

    public JLabel getDay() {
        return day;
    }

    public JLabel getLevel() {
        return level;
    }

    public JLabel getExperience() {
        return experience;
    }

    public JLabel getlTileStatus() {
        return lTileStatus;
    }

    public JLabel getlOccupied() {
        return lOccupied;
    }

    public JLabel getlWatered() {
        return lWatered;
    }

    public JButton getbHarvest() {
        return bHarvest;
    }

    public ImageIcon getTurnipIcon() {
        return turnipIcon;
    }

    public ImageIcon getCarrotIcon() {
        return carrotIcon;
    }

    public ImageIcon getPotatoIcon() {
        return potatoIcon;
    }

    public ImageIcon getRoseIcon() {
        return roseIcon;
    }

    public ImageIcon getTulipIcon() {
        return tulipIcon;
    }

    public ImageIcon getSunflowerIcon() {
        return sunflowerIcon;
    }

    public ImageIcon getMangoIcon() {
        return mangoIcon;
    }

    public ImageIcon getAppleIcon() {
        return appleIcon;
    }

}
