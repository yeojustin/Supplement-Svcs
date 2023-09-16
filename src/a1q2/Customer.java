package a1q2;

import java.util.*;

/**
 * Represents a customer of the Magazine Service.
 * 
 * <p>
 * This class stores information about a customer, including their name, email, and the list of supplements they are interested in.
 * </p>
 * 
 * 
 * Preconditions:
 * <ul>
 * <li>The SupplementDatabase object, suppDatabase, must be initialized with the appropriate supplements.</li>
 * </ul>
 * 
 * 
 * 
 * Post-condition:
 * <ul>
 * <li>The customer's interested supplements are set.</li>
 * </ul>
 * 
 * 
 * @author Justin
 */
public class Customer {
    
    private String name;
    private String email;
    private ArrayList<Supplement> interestedSupplement;
    SupplementDatabase suppDatabase = new SupplementDatabase();
    
    
    /**
     * Constructs a Customer object with the specified name and email.
     * 
     * @param name  The name of the customer.
     * @param email The email of the customer.
     */
    public Customer (String name, String email){
        this.name = name;
        this.email = email;
        this.interestedSupplement = new ArrayList<>(); //initialised to null
    }
    
    
    /**
     * Sets the interested supplements for the customer.
     * 
     * <p>
     * This method retrieves the customer's supplement choices from the SupplementDatabase and assigns them to the interestedSupplement attribute.
     * </p>
     * 
     * 
     * Precondition:
     * <ul>
     * <li>The SupplementDatabase object, suppDatabase, must be initialized with the appropriate supplements.</li>
     * </ul>
     * 
     * 
     * 
     * Post-condition:
     * <ul>
     * <li>The interestedSupplement attribute is populated with the customer's supplement choices.</li>
     * </ul>
     *
     */
    public void setInterestedSupplement(){
        interestedSupplement = suppDatabase.getChoiceAndInitNewSupplementList();
    }
    
    
    /**
     * Retrieves the interested supplements of the customer.
     * 
     * <p>
     * This method returns the ArrayList of supplements that the customer is interested in.
     * </p>
     * 
     * <p>
     * Precondition: None
     * </p>
     * 
     * <p>
     * Post-condition: None
     * </p>
     * 
     * @return ArrayList of Supplement objects representing the customer's interested supplements.
     */
    public ArrayList<Supplement> getInterestedSupplement() {
        return interestedSupplement;
    }

    
    /**
     * Retrieves the name of the customer.
     * 
     * <p>
     * This method returns the name of the customer.
     * </p>
     * 
     * <p>
     * Precondition: None
     * </p>
     * 
     * <p>
     * Post-condition: None
     * </p>
     * 
     * @return The name of the customer as a String.
     */
    public String getName() {
        return name;
    }

    
    /**
     * Retrieves the email address of the customer.
     * 
     * <p>
     * This method returns the email address of the customer.
     * </p>
     * 
     * <p>
     * Precondition: None
     * </p>
     * 
     * <p>
     * Post-condition: None
     * </p>
     * 
     * @return The email address of the customer as a String.
     */
    public String getEmail() {
        return email;
    }
    
    
    /**
     * Generates a weekly email for the customer.
     * 
     * <p>
     * This method generates a weekly email for the customer, including the customer's name, 
     * the message that the magazine is ready to look at, the week number, and the list of
     * interested supplements.
     * </p>
     * 
     * <p>
     * Precondition: None
     * </p>
     * 
     * <p>
     * Post-condition: None
     * </p>
     * 
     * @param week The week number for which the email is generated.
     * @return The generated weekly email as a String.
     */
    public String generateWeeklyEmail(int week) {                
        StringBuilder content = new StringBuilder();
        content.append("Dear ").append(this.name).append(",\n\n");
        content.append("Your magazine is ready to look at!\n\n");
        content.append("Your week ").append(week).append(" supplements:\n\n");
        content.append(displayInterestedSupplement()).append("\n");
        content.append("\n\n");
        content.append("Best Regards,\n").append("The Magazine Team\n\n");
        
        return content.toString();
    }
    
    
    /**
     * Displays the list of interested supplements for the customer.
     * 
     * <p>
     * This method retrieves the list of interested supplements for the customer from the supplement database
     * and returns a formatted string representation of the list.
     * </p>
     * 
     * <p>
     * Precondition: The supplement database must be initialized and contain valid supplement data.
     * </p>
     * 
     * <p>
     * Post-condition: None
     * </p>
     * 
     * @return A formatted string representation of the customer's interested supplements.
     */
    public String displayInterestedSupplement(){
        return suppDatabase.displayList(interestedSupplement, name+"'s supplement");
    }
       
    
    /**
     * Returns a string representation of the Customer object.
     * 
     * <p>
     * This method returns a formatted string representation of the Customer object,
     * including the customer's name and email.
     * </p>
     * 
     * <p>
     * Precondition: None
     * </p>
     * 
     * <p>
     * Post-condition: None
     * </p>
     * 
     * @return A string representation of the Customer object.
     */
    @Override 
    public String toString(){
        return "Name: "+getName()+"\n"+"Email: "+getEmail()+"\n";
    }
    
    
    /**
     * Runs a test scenario for the Customer class.
     * 
     * <p>
     * This method creates a Customer object, sets the interested supplements,
     * and displays the list of interested supplements for the customer.
     * </p>
     * 
     * <p>
     * Precondition: None
     * </p>
     * 
     * <p>
     * Post-condition: The interested supplements are displayed for the customer.
     * </p>
     */
    public static void testrun(){
        Customer c1 = new Customer("Justin","justin123@gmail.com");
        c1.setInterestedSupplement();
        System.out.println(c1.displayInterestedSupplement());
    }
}
