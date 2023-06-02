abstract public class Tool {
    private String name;
    private int cost;
    private double experienceGain;

    // CONSTRUCTORS

    public Tool(String name, int cost, double experienceGain) {
        this.name = name;
        this.cost = cost;
        this.experienceGain = experienceGain;
    }

    abstract public void useTool(FarmLot farmLot, int index);

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getExperienceGain() {
        return experienceGain;
    }

}