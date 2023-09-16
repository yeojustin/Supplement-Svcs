package a1q2;
/**
 *
 * @author yeojustin
 */
import java.util.*;

public class Client {
    
    private ArrayList<Customer> customersList;
    Helper helper = new Helper();
    SupplementDatabase supplementData = new SupplementDatabase();
    
    
    /**
     * Creates a new magazine object with the provided main magazine cost.
     * <p>
     * This method prompts the user to enter the main magazine cost and creates a new Magazine object
     * using the given cost.
     * </p>
     * <p><b>Precondition:</b></p>
     * <ul>
     *     <li>The helper object must be properly initialized and functional.</li>
     * </ul>
     * <p><b>Postcondition:</b></p>
     * <ul>
     *     <li>A new Magazine object is created with the specified main magazine cost.</li>
     * </ul>
     *
     * @return The newly created Magazine object.
     */
    public Magazine createNewMagazine(){
        System.out.print("Creating new magazine...\n");
        double mainPartCost = helper.getDouble("Enter main magazine cost: ");
        return new Magazine(mainPartCost);
    }  
    
    
    
    /**
     * Creates a list of customers with their associated payment and interested supplement information.
     * <p>
     * This method prompts the user to enter details for paying customers and their associate customers,
     * including name, email, payment type, card details, and interested supplements. It creates customer
     * objects and adds them to the customersList ArrayList.
     * </p>
     * <p><b>Precondition:</b></p>
     * <ul>
     *     <li>The helper object must be properly initialized and functional.</li>
     * </ul>
     * <p><b>Postcondition:</b></p>
     * <ul>
     *     <li>An ArrayList of Customer objects is created and populated with the entered customer details.</li>
     * </ul>
     *
     * @return The ArrayList of Customer objects containing the created customers.
     */
    public ArrayList<Customer> createCustomers(){
        System.out.println("Creating customers...");
        System.out.println("-----------------------------------------\n");
        
        customersList = new ArrayList<>();
        Payment payment;
        boolean continueFlag = true;
        
        while(continueFlag){
            String name = helper.getString("Enter paying customer name: ").trim().replaceAll("\\s"," ");
            String email = helper.getString("Enter email: ").trim().replaceAll("\\s",""); 
            boolean errorFlag = true;
            while (errorFlag){
                int paymentChoice = helper.getInt("""
                                            Payment type
                                            ->Enter '1' for Credit Card
                                            ->Enter '2' for Direct Debit""");
                String details = helper.getString("Enter card details: ");
                String method = "Invalid input. Card not set";

                if (paymentChoice == 1){
                    method = "Credit_Card";
                } else if (paymentChoice == 2) {
                    method = "Direct_Debit";
                } else {
                    System.out.println(method);
                    continue;
                }
                payment = new Payment(method,details);
                PayingCustomer payer = new PayingCustomer(name,email,payment);
                payer.setInterestedSupplement();
                customersList.add(payer);
                System.out.println("Paying customer created...\n");
                System.out.println(payer.toString());
                System.out.println(payer.displayInterestedSupplement());
                errorFlag = false;
                
                boolean addAssocCustFlag = true; 
                while (addAssocCustFlag){
                    String createAssocChoice = helper.getString("Enter any key to add associate customers to this paying customer [0 to abort]: ");
                    if (!createAssocChoice.equalsIgnoreCase("0")){
                        String acName = helper.getString("Enter associate customer name: ").trim().replaceAll("\\s"," ");
                        String acEmail = helper.getString("Enter email: ").trim().replaceAll("\\s","");
                        AssociateCustomer associate = new AssociateCustomer(acName,acEmail,payer);
                        associate.setInterestedSupplement();
                        payer.addAssociateCustomer(associate); //add assoc cust to current payer 
                        customersList.add(associate); //add assoc to the customer list 
                        
                        System.out.println("Associate customer created...\n\n"+associate.toString());
                        System.out.println(associate.displayInterestedSupplement());
                        System.out.println("Payer:\n"+payer.toString());
                        
                    } else if(createAssocChoice.equalsIgnoreCase("0")) {
                        addAssocCustFlag = false;
                    } else {
                        System.out.println("Invalid choice, enter again.");
                    }
                }
            }
            
            String toExit = helper.getString("Enter any key to continue adding paying customer [0 to exit]: ");
            continueFlag = !toExit.equalsIgnoreCase("0");
            System.out.println();
        }
        return customersList;
    }
    
    
    
    /**
     * Creates associate customers and adds them to the existing list of customers.
     * <p>
     * This method prompts the user to enter details for associate customers and associates them with a paying customer
     * based on the payer's email. The associate customer is then added to the customers ArrayList.
     * </p>
     * <p><b>Precondition:</b></p>
     * <ul>
     *     <li>The helper object must be properly initialized and functional.</li>
     *     <li>The customers ArrayList must be populated with existing paying customers.</li>
     * </ul>
     * <p><b>Postcondition:</b></p>
     * <ul>
     *     <li>An associate customer is created and associated with a paying customer, if the payer's email is found.</li>
     *     <li>The associate customer is added to the customers ArrayList.</li>
     * </ul>
     *
     * @param customers The ArrayList of Customer objects containing the existing paying customers.
     */
    public void createAssociateCustomer(ArrayList<Customer> customers) {
        System.out.println("Creating associate customers...");
        System.out.println("-----------------------------------------\n");
        boolean continueFlag = true;

        while (continueFlag) {
            String payerEmail = helper.getString("Enter the payer's email to add the associate customer: ");
            boolean payingCustFound = false;
            for (Customer cust : customers) {
                if (cust instanceof PayingCustomer payer) {
                    if (payer.getEmail().equalsIgnoreCase(payerEmail)) {
                        System.out.println("Email found...\n");
                        String addName = helper.getString("Enter associate customer name:  ");
                        String addEmail = helper.getString("Enter email: ");
                        AssociateCustomer associate = new AssociateCustomer(addName, addEmail, payer);
                        associate.setInterestedSupplement();
                        customers.add(associate);
                        System.out.println(associate.toString()+"\n");
                        associate.displayInterestedSupplement();
                        payingCustFound = true;
                        break;
                    }
                }
            }

            if (!payingCustFound) {
                System.out.println("Paying customer not found.");
            }

            String toExit = helper.getString("Enter any key to continue adding paying customer [0 to exit]: ");
            continueFlag = !toExit.equalsIgnoreCase("0");
            System.out.println();
        }
    }
    
    
   /**
    * Adds customers to a magazine.
    * <p>
    * This method adds the customers from the provided ArrayList to the specified magazine. It checks if the customer
    * list is empty before adding them to the magazine.
    * </p>
    * <p><b>Precondition:</b></p>
    * <ul>
    *     <li>The magazine object must be properly initialized.</li>
    *     <li>The customers ArrayList should contain the customers to be added.</li>
    * </ul>
    * <p><b>Postcondition:</b></p>
    * <ul>
    *     <li>The customers are added to the magazine's customer list.</li>
    *     <li>If the customers ArrayList is empty, an error message is displayed.</li>
    * </ul>
    *
    * @param magazine  The Magazine object to which customers will be added.
    * @param customers The ArrayList of Customer objects containing the customers to be added.
    */
    public void addCustomerToMagazine(Magazine magazine, ArrayList<Customer> customers){
        if (!customers.isEmpty()){
            for (Customer customer : customers){
                magazine.addMagazineCustomers(customer);
            }
        } else {
            System.out.println("Error. Customer list is empty!");
            System.out.println("Unable to add customer(s)...");
        }
    }
    
    
    /**
     * Removes a customer from the magazine.
     * <p>
     * This method allows the user to remove a customer from the specified magazine. The method displays the list of
     * customers in the magazine and prompts the user for the customer number to remove. It also provides confirmation
     * before removing the customer. The user can choose to remove multiple customers until they decide to abort the
     * operation.
     * </p>
     * <p><b>Precondition:</b></p>
     * <ul>
     *     <li>The magazine object must be properly initialized.</li>
     * </ul>
     * <p><b>Postcondition:</b></p>
     * <ul>
     *     <li>The specified customer is removed from the magazine's customer list.</li>
     *     <li>The user is prompted for confirmation before removing the customer.</li>
     *     <li>The user can choose to remove multiple customers until they decide to abort the operation.</li>
     * </ul>
     *
     * @param magazine The Magazine object from which a customer will be removed.
     */
    public void removeCustomerFromMagazine(Magazine magazine){      
        boolean outsideLoop = true;
        
        while (outsideLoop){
            ArrayList<Customer> customers = magazine.getMagzineCustomers();
            magazine.displayCustomersInMagazine();
            System.out.println();
            
            int choice = helper.getInt("Enter the cust no. to remove [0 to abort]: "); 
            
            if (choice == 0){
                System.out.println("System aborted...");
                outsideLoop = false;
            } else {
                String toConfirm = helper.getString("Are you sure? [Y/N]: ");
                if (toConfirm.equalsIgnoreCase("y")){
                    magazine.removeMagazineCustomers(customers.get(choice-1));
                } else if (toConfirm.equalsIgnoreCase("n")){
                    System.out.println("Aborted...");
                } else {
                    System.out.println("Invalid input. Aborted...");
                }
            }
            
            boolean validFlag = true;
            while(validFlag){
                if (!customers.isEmpty()){
                    String repeat = helper.getString("Do you want to remove another customer? [Y/N]: ");
                    repeat = repeat.trim();
                    if (repeat.equalsIgnoreCase("y")){
                        validFlag = false;
                    } else if (repeat.equalsIgnoreCase("n")){
                        validFlag = false;
                        outsideLoop = false;
                    } else {
                        System.out.println("Invalid input.");
                    }
                } else {
                    System.out.println("No more customers to remove.");
                    validFlag = false;
                    outsideLoop = false;
                }
            }
            System.out.println();
        }
        System.out.println("System exited...");
    }
    

    /**
     * Prints all emails for the customers in the magazine.
     * <p>
     * This method generates and prints the weekly emails for all the customers in the specified magazine. The user is
     * prompted to enter the number of weeks for which emails should be generated. The method then iterates over each
     * customer and generates the weekly email for each week, printing it to the console.
     * </p>
     * <p><b>Precondition:</b></p>
     * <ul>
     *     <li>The magazine object must be properly initialized.</li>
     *     <li>The customers in the magazine must have valid email addresses.</li>
     * </ul>
     * <p><b>Postcondition:</b></p>
     * <ul>
     *     <li>The weekly emails for all customers in the magazine are generated and printed to the console.</li>
     *     <li>The user is prompted to enter the number of weeks for which emails should be generated.</li>
     * </ul>
     *
     * @param magazine The Magazine object containing the customers for whom emails will be generated.
     */    
    public void printAllEmails(Magazine magazine) {
        ArrayList<Customer> customers = magazine.getMagzineCustomers();
        int numWeeks = helper.getInt("Enter the no. of weeks of email to generate for each customer: ");
        for (Customer customer : customers) {
            for (int week = 1; week <= numWeeks; week++) {
                System.out.println(customer.generateWeeklyEmail(week));
            }
        }
    }

    
    /**
     * Prints the end-of-month email for the magazine.
     * <p>
     * This method prompts the user to generate the end-of-month email by entering any key. If the user enters '0', the
     * end-of-month email is generated and printed to the console. Otherwise, the method displays a message indicating
     * that the system was aborted.
     * </p>
     * <p><b>Precondition:</b></p>
     * <ul>
     *     <li>The magazine object must be properly initialized.</li>
     * </ul>
     * <p><b>Postcondition:</b></p>
     * <ul>
     *     <li>The end-of-month email is generated and printed to the console if the user chooses to proceed.</li>
     *     <li>The user is prompted to enter any key to generate the end-of-month email or '0' to abort.</li>
     * </ul>
     *
     * @param magazine The Magazine object for which the end-of-month email will be generated.
     */    
    public void printEndOfMonthEmails(Magazine magazine) {
        String choice = helper.getString("Enter any key to generate end of month email [0 to abort]: ");
        if (!choice.equalsIgnoreCase("0")){
            System.out.println(magazine.generateEndOfMonthEmail());
        } else {
            System.out.println("System aborted...");
        }
    }

    
   /**
    * Method that runs the test scenarios for the magazine service.
    */
    public static void testrun(){
        Client client = new Client();

        /*
        TODO 1:
        Construct a magazine with an array of 3-4 supplements with 
        made-up details built in to the program (keep provision of inputs from 
        the user using the Java Scanner class) 
        */
        System.out.println("""
                           TODO 1:

                           Construct a magazine with an array of 3-4 supplements with 
                           made-up details built in to the program (keep provision of inputs from 
                           the user using the Java Scanner class) 

                           """);

        Magazine magazine = client.createNewMagazine(); 

        //Print out the magazine details
        magazine.displayMagazineDetails(); 


        /*
        TODO 2:
        Construct an array of 5-6 different customers of various types with 
        made-up details built in to the program (keep provision of inputs from 
        the user using the Java Scanner class)
        */
        System.out.println("""
                           TODO 2:
                           Construct an array of 5-6 different customers of various types with 
                           made-up details built in to the program (keep provision of inputs from 
                           the user using the Java Scanner class)
                           """);

        ArrayList<Customer> custList = client.createCustomers();

        //choice to add more associate customers to any paying customer
        client.createAssociateCustomer(custList);

        //Set customers to magazine
        magazine.setMagazineCustomer(custList);


        /*
        TODO 3:
        Add a new customer to the magazine service
        */
        System.out.println("""
                           TODO 3: 
                           Add a new customer to the magazine service
                           """);
        client.addCustomerToMagazine(magazine,custList);
        


        /*
        TODO 4:
        Remove an existing customer from the magazine service
        */
        System.out.println("""
                           TODO 4: 
                           Remove an existing customer from the magazine service
                           """);
        client.removeCustomerFromMagazine(magazine);

        /*
        TODO 5:
        Print out the text of all the emails for all customers 
        for four weeks of magazines
        */
        System.out.println("""
                           TODO 5:
                           Print out the text of all the emails for all customers 
                           for four weeks of magazines
                           """);
        client.printAllEmails(magazine);

        /*
        TODO 6:
        Print out the text for the end of month emails 
        for the paying customers
        */
        System.out.println("""
                           TODO 6:
                           Print out the text for the end of month emails 
                           for the paying customers
                           """);
        client.printEndOfMonthEmails(magazine);
    }
}

