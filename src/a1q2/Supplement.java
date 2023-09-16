package a1q2;

/**
 * The Supplement class represents a supplement.
 * It contains information about the supplement's name and weekly cost.
 * 
 * @author Justin
 */
public class Supplement {
    
    private String name;
    private double weeklyCost;
    
    /**
     * Constructs a Supplement object with the specified name and weekly cost.
     * 
     * @param name The name of the supplement.
     * @param weeklyCost The weekly cost of the supplement.
     */
    public Supplement(String name, double weeklyCost){
        this.name = name;
        this.weeklyCost = weeklyCost;
    }

    /**
     * Returns the name of the supplement.
     * 
     * @return The name of the supplement.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the weekly cost of the supplement.
     * 
     * @return The weekly cost of the supplement.
     */
    public double getWeeklyCost() {
        return weeklyCost;
    }

    /**
     * Returns a string representation of the supplement.
     * 
     * @return A string representation of the supplement.
     */
    @Override
    public String toString(){
        return "Supplement: " + getName() + "\n" + "Weekly Cost: $" + getWeeklyCost();
    }
}
