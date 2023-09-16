/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a1q2;

import java.util.ArrayList;

public class Magazine {
    
    private double mainPartWeeklyCost;
    private ArrayList<Supplement> magazineSupplements;
    private ArrayList<Customer> magazineCustomers;
    SupplementDatabase supplementData = new SupplementDatabase();
    
    
    /**
     * Constructs a Magazine object with all its attributes initialised to deafult
     */
    public Magazine(){
        this.mainPartWeeklyCost = mainPartWeeklyCost;
        this.magazineSupplements = new ArrayList<>();
        this.magazineCustomers = new ArrayList<>();
    }
    
    
    /**
     * Constructs a Magazine object with the specified main part weekly cost.
     *
     * @param mainPartWeeklyCost the weekly cost of the main part of the magazine
     * 
     * Precondition:
     * - The mainPartWeeklyCost must be a valid non-negative value.
     * 
     * Post-condition:
     * - A Magazine object is created with the specified main part weekly cost.
     * - The magazineSupplements and magazineCustomers lists are initialized.
     */
    public Magazine(double mainPartWeeklyCost){
        this.mainPartWeeklyCost = mainPartWeeklyCost;
        //System.out.println("Creating supplement(s) for magazine...");
        this.magazineSupplements = supplementData.getChoiceAndInitNewSupplementList();
        this.magazineCustomers = new ArrayList<>();
    }

    
    /**
     * Returns the weekly cost of the main part of the magazine.
     *
     * @return the main part weekly cost
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The main part weekly cost is returned.
     */
    public double getMainPartWeeklyCost() {
        return mainPartWeeklyCost;
    }
    
    
    /**
     * Returns the list of magazine supplements.
     *
     * @return the magazine supplements list
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The magazine supplements list is returned.
     */
    public ArrayList<Supplement> getMagazineSupplement(){
        return magazineSupplements;
    }
  
    
    /**
     * Returns the list of magazine customers.
     *
     * @return the magazine customers list
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The magazine customers list is returned.
     */   
    public ArrayList<Customer> getMagzineCustomers(){
        return magazineCustomers;
    }
    
    
    /**
     * Sets the list of magazine supplements.
     *
     * @param supplementList the list of supplements to be set
     * 
     * Precondition:
     * - The supplementList must be a valid non-null value.
     * 
     * Post-condition:
     * - The magazine supplements list is set to the specified list of supplements.
     */    
    public void setMagazineSupplement(ArrayList<Supplement> supplementList) {
        this.magazineSupplements = supplementList;
    }
    
    
    /**
     * Sets the list of magazine customers.
     *
     * @param customerList the list of customers to be set
     * 
     * Precondition:
     * - The customerList must be a valid non-null value.
     * 
     * Post-condition:
     * - The magazine customers list is set to the specified list of customers.
     */    
    public void setMagazineCustomer(ArrayList<Customer> customerList){
        this.magazineCustomers = customerList;
    }
    
    
    /**
     * Adds customers to the magazine customers list.
     *
     * @param customers the customers to be added
     * 
     * Precondition:
     * - The customers must be valid non-null values.
     * 
     * Post-condition:
     * - The specified customers are added to the magazine customers list.
     */   
    public void addMagazineCustomers(Customer... customers) {
        for (Customer cust : customers){
            magazineCustomers.add(cust);
        }
    }

    
    /**
     * Removes customers from the magazine customers list.
     *
     * @param customers the customers to be removed
     * 
     * Precondition:
     * - The customers must be valid non-null values.
     * 
     * Post-condition:
     * - The specified customers are removed from the magazine customers list, if they exist.
     * - If a customer is not found in the list, a message is displayed indicating that the customer was not found.
     */    
    public void removeMagazineCustomers(Customer... customers) {
        if (magazineCustomers != null){
            for(Customer cust : customers){
                if (magazineCustomers.contains(cust)){
                    magazineCustomers.remove(cust);
                } else {
                    System.out.println("Unable to remove customer as it is not found!\n");
                    System.out.println("Name: "+cust.getName()+"\n"+"Email: "+cust.getEmail());
                }
            }
        } else {
            System.out.println("No customer(s) to remove.");
        }
    }
    

    /**
     * Generates weekly emails for the magazine customers.
     *
     * @param week the week number for the email
     * 
     * Precondition:
     * - The week must be a valid non-negative value.
     * 
     * Post-condition:
     * - Weekly emails are generated for each customer in the magazine customers list.
     * - The generated email text is displayed.
     */    
    public void generateWeeklyEmailsForCustomers(int week) {
        for (Customer customer : magazineCustomers) {
            String emailText = customer.generateWeeklyEmail(week); //static binding happens here
            // Send email to customer with emailText
            System.out.println(emailText);
        }
    }


    /**
     * Displays the details of the magazine.
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The magazine details, including the weekly subscription cost and supplement details, are displayed.
     */    
    public void displayMagazineDetails() {
        System.out.println("Your magazine details: \n");
        System.out.println("Weekly magazine subsription cost: $"+getMainPartWeeklyCost()+"\n");
        String contents = supplementData.displayList(this.magazineSupplements, "Your magazine supplements");
        System.out.println(contents);
    }
    

     /**
     * Displays the customers in the magazine.
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The customers in the magazine are displayed, including their names and emails.
     */   
    public void displayCustomersInMagazine(){
        StringBuilder sb = new StringBuilder();
        if (this.magazineCustomers.isEmpty()) {
            sb.append("No customers currently in this Magazine service.\n");
        } else {
            sb.append("Customers in this Magazine Service").append("\n");
            sb.append("-----------------------------------------\n");
            sb.append(String.format("%-2s %-20s %s%n", "No.", "Name", "Email"));
            sb.append("-----------------------------------------\n");

            int index = 1;
            for (Customer customer : magazineCustomers) {
                String name = customer.getName();
                String email = customer.getEmail();
                sb.append(String.format("%-2d %-20s %s%n", index++, name, email));
            }
            sb.append("-----------------------------------------\n");
        }
        System.out.println(sb.toString());
    }
    

    /**
     * Generates the end-of-month email for the magazine customers.
     *
     * @return the end-of-month email content
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The end-of-month email is generated for the magazine customers.
     * - The email content is returned as a string.
     */    
    public String generateEndOfMonthEmail() {
        ArrayList<Supplement> supplements;
        ArrayList<AssociateCustomer> associates;
        ArrayList<Customer> customers = getMagzineCustomers();

        double associateTotal = 0;
        double payerTotal = 0;
        StringBuilder content = new StringBuilder();
        
        for (Customer customer : customers){
            if (customer instanceof PayingCustomer payer){
                content.append("Dear ").append(payer.getName()).append("\n\n");
                content.append("Your month end payment invoice are as follows:\n\n");
                content.append("-----------------------------------------\n");
                content.append("Y O U R  I N V O I C E\n");
                content.append("-----------------------------------------\n");
                content.append("YOUR PAYMENT METHOD: ").append(payer.getPaymentDetails().getMethodType()).append("\n\n");
                
                //list out paying customer supplements
                supplements = payer.getInterestedSupplement();
                content.append(payer.displayInterestedSupplement());
                if (!supplements.isEmpty()){
                    double monthlyCostForPayingCust = 0;
                    for (Supplement supplement : supplements){
                        monthlyCostForPayingCust += (supplement.getWeeklyCost() * 4);
                    } 
                    //to keep track of running total for all supplments for payer
                    payerTotal += monthlyCostForPayingCust;
                } else {
                    content.append("You are currently not paying for any supplemnts...\n");
                }
                
                //display the calculated monthly cost for payer
                content.append("MONTHLY COST FOR ").append(payer.getName());
                content.append(" : $").append(String.format("%.2f",payerTotal)); 
                content.append("\n\n");
                
                //list out associate customers and its supplements
                content.append("\nYOUR ASSOCIATES:\n");
                content.append("-----------------------------------------\n");
                associates = payer.getAssociateCustomers();
                if (!associates.isEmpty()){

                    //for each associate under paying customer,
                    //display associate's current supplement and its weekly cost
                    for (AssociateCustomer associate : associates){
                        content.append(associate.toString());   
                        content.append(associate.displayInterestedSupplement());

                        //calculate monthly cost from each associate
                        double monthlyCostForAssociate = 0; //reset to 0 to calculate for each associate
                        supplements = associate.getInterestedSupplement();

                        if(!supplements.isEmpty()){
                            for (Supplement supplement : supplements){
                                monthlyCostForAssociate += (supplement.getWeeklyCost() * 4);
                            }

                            //to keep track of running total for associate
                            associateTotal += monthlyCostForAssociate;

                            //display the calculated monthly cost for each associate
                            content.append("MONTHLY COST FOR ").append(associate.getName());
                            content.append(" : $").append(String.format("%.2f",monthlyCostForAssociate)); 
                            content.append("\n\n\n");
                        } else {
                            content.append(associate.getName());
                            content.append(" is not subscribed to any supplements...\n\n");
                        }
                    }
                } else {
                    content.append("You are curently not paying for anyone...");
                }
                
                //display total costs and final total
                content.append("\n------------------------------------------------------\n");
                content.append("MAIN MAGAZINE COST: $").append(String.format("%.2f",getMainPartWeeklyCost()));
                content.append("\n------------------------------------------------------\n");
                content.append("RUNNING MONTHLY COST (ALL ASSOCIATES): $").append(String.format("%.2f",associateTotal));
                content.append("\n------------------------------------------------------\n");
                content.append("YOUR MONTHLY COST: $").append(String.format("%.2f",payerTotal));
                content.append("\n------------------------------------------------------\n");
                content.append("MONTHLY GRAND TOTAL: $").append(String.format("%.2f",payerTotal + associateTotal + getMainPartWeeklyCost()));
                content.append("\n------------------------------------------------------\n\n\n\n");
                content.append("Thank you for subscribing to our magazine service.\n\n");
                content.append("Best Regards,\n").append("The Magazine Team");  
            } else {
                content.append("No paying customer found.");
                content.append("Email not generated...");
            }
        }              
        return content.toString();
    }
    
    
    /**
     * Test method for the Magazine class.
     * <p>
     * This method tests the functionality of the Magazine class by creating instances
     * of PayingCustomer, AssociateCustomer, and Magazine objects, setting their properties,
     * and generating the end-of-month email.
     * </p>
     * Precondition:
     * <ul>
     * <li>None</li>
     * </ul>
     * Post-condition:
     * <ul>
     * <li>The Magazine object is created and tested.</li>
     * </ul>
     */    
    public static void testrun(){
       Magazine testMag = new Magazine(1.99);
       
       //initialising a paying customer
       Payment pmt1 = new Payment("CREDIT_CARD","12345");
       PayingCustomer payer1 = new PayingCustomer("Abel Lee","ablee@gmail.com",pmt1);
       System.out.println("Setting suplement for paying cutsomer 1");
       payer1.setInterestedSupplement();
       
       //initialise associate customer
       AssociateCustomer assoc1 = new AssociateCustomer("Ben Tan","bentan123@hotmail.com",payer1);
       AssociateCustomer assoc2 = new AssociateCustomer("Carly Li","carlyli@hotmail.com",payer1);
       AssociateCustomer assoc3 = new AssociateCustomer("Dick Lim","dicks@yahoo.com",payer1);
       AssociateCustomer assoc4 = new AssociateCustomer("Eddy Tan","tanjl@gmail.com",payer1);
       
       //set supplements from assoc1 and assoc2
       System.out.println("Setting suplement for paying associate customer 1");
       assoc1.setInterestedSupplement();
       
       //add associate customer to paying customer
       payer1.addAssociateCustomer(assoc1,assoc2,assoc3,assoc4);
       
       //add all customers to testMag
       testMag.addMagazineCustomers(payer1,assoc1,assoc2,assoc3,assoc4);
       
       //generate year end email
       String email = testMag.generateEndOfMonthEmail();
       System.out.println(email);
    }
}
