package a1q2;

import java.util.ArrayList;

/**
 * The SupplementDatabase class represents a database of supplements.
 * It provides methods to add supplements, retrieve the list of supplements,
 * display the list of supplements, and manage the selection of supplements.
 */
public class SupplementDatabase {
    
    /**
     * Used to store the available supplements within the database
     */
    private final ArrayList<Supplement> suppplementListInDatabase; 
    /**
     * Helper method initialised to be used within SupplementDatabase class
     */
    public Helper helper = new Helper();
    
    /**
     * Constructs a new SupplementDatabase object.
     * Initializes the supplement list in the database with default supplements.
     */
    public SupplementDatabase() {
        suppplementListInDatabase = new ArrayList<>();
        
        //default supplements in database 
        Supplement healthFitness = new Supplement("Health & Fitness", 7.99);
        Supplement cookingRecipes = new Supplement("Cooking & Recipes", 6.99);
        Supplement travelAdventure = new Supplement("Travel & Adventure", 8.99);
        Supplement fashionTrends = new Supplement("Fashion & Trends", 5.99);
        Supplement technologyGadgets = new Supplement("Technology & Gadgets", 9.99);
        Supplement homeDecor = new Supplement("Home Decor", 6.49);
        Supplement sportsNews = new Supplement("Sports News", 7.49);
        Supplement businessFinance = new Supplement("Business & Finance", 8.49);
        Supplement entertainmentBuzz = new Supplement("Entertainment Buzz", 6.99);
        Supplement foodDrinks = new Supplement("Food & Drinks", 5.99);

        suppplementListInDatabase.add(healthFitness);
        suppplementListInDatabase.add(cookingRecipes);
        suppplementListInDatabase.add(travelAdventure);
        suppplementListInDatabase.add(fashionTrends);
        suppplementListInDatabase.add(technologyGadgets);
        suppplementListInDatabase.add(homeDecor);
        suppplementListInDatabase.add(sportsNews);
        suppplementListInDatabase.add(businessFinance);
        suppplementListInDatabase.add(entertainmentBuzz);
        suppplementListInDatabase.add(foodDrinks);
    }
    
    
    /**
     * Retrieves the list of supplements in the database.
     *
     * @return The ArrayList of Supplement objects representing the supplements in the database.
     */
    public ArrayList<Supplement> getSupplmentListInDatabase(){
        return this.suppplementListInDatabase;
    }
    
    
    /**
     * Adds one or more supplements to the database.
     *
     * @param supplements The Supplement objects to be added to the database.
     */
    public void addSupplementsToDatabase(Supplement...supplements){
        for (Supplement supplement:supplements){
            suppplementListInDatabase.add(supplement);
        }
    }
    
    
    /**
     * Displays the list of supplements with the provided title.
     *
     * @param supplementlist The ArrayList of Supplement objects to be displayed.
     * @param title The title to be displayed along with the list.
     * @return The formatted string representation of the list of supplements.
     */
    public String displayList(ArrayList<Supplement> supplementlist, String title) {
        StringBuilder sb = new StringBuilder();
        if (supplementlist.isEmpty()) {
            sb.append("No supplements to display.\n");
        } else {
            sb.append(title).append("\n");
            sb.append("-----------------------------------------\n");
            sb.append(String.format("%-2s %-20s %s%n", "No.", "Supplement Name", "Weekly Cost ($)"));
            sb.append("-----------------------------------------\n");

            int index = 1;
            for (Supplement supplement : supplementlist) {
                String name = supplement.getName();
                double weeklyCost = supplement.getWeeklyCost();
                sb.append(String.format("%-2d %-20s %10.2f%n", index++, name, weeklyCost));
            }
            sb.append("-----------------------------------------\n");
        }
        return sb.toString();
    }

    
    /**
     * Prompts the user to choose supplements from the available list and initializes a new supplement list.
     * 
     * <p>
     * Precondition:
     * <ul>
     * <li>The supplementListInDatabase must not be null.</li>
     * </ul>
     * Post-condition:
     * <ul>
     * <li>A new supplement list is created based on the user's choices and returned.</li>
     * </ul>
     *
     * @return The ArrayList of Supplement objects representing the user's selected supplements.
     */
    public ArrayList<Supplement> getChoiceAndInitNewSupplementList() {
        ArrayList<Supplement> newSupplementList = new ArrayList<>();
        
        System.out.println(displayList(suppplementListInDatabase,"Available supplements"));
        
        int len = suppplementListInDatabase.size();
        boolean flag = true;
        
        while (flag) {
            int choice = helper.getInt("Enter number 1-" + len + " for the supplement that you are interested: ");
            
            if (choice >= 1 && choice <= len) {
                Supplement suppToAdd = suppplementListInDatabase.get(choice-1);
                newSupplementList.add(suppToAdd);
                System.out.println("Supplement added to the list...\n");
            } else {
                System.out.println("Invalid item. Select only 1-" + len + ".");
            }
            
            String continueChoice = helper.getString("Enter any key to continue [0 to abort]: ");
            flag = !continueChoice.equalsIgnoreCase("0");
        }
        return newSupplementList;
    }
 
    
    /**
     * Removes a supplement from the initial supplement list.
     *
     * <p>
     * Precondition:
     * <ul>
     * <li>The supplementlist must not be null.</li>
     * </ul>
     * Post-condition:
     * <ul>
     * <li>The selected supplement is removed from the supplementlist.</li>
     * </ul>
     *
     * @param supplementlist The ArrayList of Supplement objects representing the initial supplement list.
     */
    public void removeSupplementFromInitList(ArrayList<Supplement> supplementlist){
            boolean flag = true;
            while (flag) {
                if (supplementlist != null){
                    displayList(supplementlist, "Your current supplement");
                    int len = supplementlist.size();
                    int suppNumToRemove = helper.getInt("Enter the supplement no. you wish to remove: ");
                    
                    if (suppNumToRemove >= 1 && suppNumToRemove <= len) {
                        supplementlist.remove(suppNumToRemove-1);
                        System.out.println("Supplement no."+ suppNumToRemove +" removed...\n");
                    } else {
                        System.out.println("Invalid item. Select only 1-" + len + ".");
                    }
                } else {
                    System.out.println("List is empty...");
                }
                String continueChoice = helper.getString("Enter any key to continue [0 to abort]: ");
                flag = !continueChoice.equalsIgnoreCase("0");
            }
    }
       
    /**
     * A test method to run the SupplementDatabase class.
     * It demonstrates the getChoiceAndInitNewSupplementList and removeSupplementFromInitList methods.
     */
    public static void testrun(){
        SupplementDatabase sd = new SupplementDatabase();
        ArrayList<Supplement> list = sd.getChoiceAndInitNewSupplementList();
        sd.removeSupplementFromInitList(list);
        String listview = sd.displayList(list, "Test After Removal");
        System.out.println(listview);
    }
}