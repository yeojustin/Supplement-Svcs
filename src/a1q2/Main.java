package a1q2;

import java.util.ArrayList;

/**
 * Main class for the Magazine Service program.
 * 
 * @author Justin
 */
public class Main {

    
    /**
     * Returns a formatted string containing student details.
     * 
     * @return the formatted string containing student details
     */
    public static String studentDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------\n");
        sb.append("Name:                  Justin Yeo\n");
        sb.append("Student No.:           34831634\n");
        sb.append("Mode of Enrolment:     Full-time\n");
        sb.append("Tutor Name:            Cheng Hong Low\n");
        sb.append("Submission Date:       18 Jun 2023\n");
        sb.append("--------------------------------------\n\n");
        return sb.toString();
    }

    
    
    public static void main(String[] args) {

        // TODO 1: Print Student Details

        System.out.println(studentDetails());

        // TODO 2: Main program

        ArrayList<Customer> customerList = new ArrayList<>();

        Client client = new Client();
        Helper helper = new Helper();

        Magazine magazine = new Magazine();
        boolean initMag = false;
        boolean cont = true;

        do {
            System.out.println("\n------ Magazine Service Menu ------\n");
            System.out.println("1. Add a new magazine\n");
            System.out.println("2. Create a customer\n");
            System.out.println("3. Add new associate customer\n");
            System.out.println("4. Add new customer to magazine\n");
            System.out.println("5. Remove customer from magazine\n");
            System.out.println("6. Print weekly emails for all customers\n");
            System.out.println("7. Print end of month email for paying customers\n");
            System.out.println("8. Exit the program\n");
            System.out.println("-----------------------------------\n\n");

            int choice = helper.getInt("Enter choice [1-8]: ");

            switch (choice) {
                case 1:
                    if (initMag) {
                        System.out.println("You are overwriting your previous magazine\n");
                        String toOverwrite = helper.getString("Are you sure to continue creating magazine? [Y/N]");

                        if (toOverwrite.equalsIgnoreCase("y")) {
                            magazine = client.createNewMagazine();
                            magazine.displayMagazineDetails();
                        }
                    } else {
                        magazine = client.createNewMagazine();
                        magazine.displayMagazineDetails();
                        initMag = true;
                    }
                    break;

                case 2:
                    customerList = client.createCustomers();
                    break;

                case 3:
                    if (customerList.isEmpty()) {
                        System.out.println("No customer created yet\n");
                    } else {
                        client.createAssociateCustomer(customerList);
                    }
                    break;

                case 4:
                    if (customerList.isEmpty()) {
                        System.out.println("No customer to add\n");
                    } else if (magazine == null) {
                        System.out.println("No magazine to add to\n");
                    } else {
                        client.addCustomerToMagazine(magazine, customerList);
                        System.out.println("Customers added...");
                        magazine.displayCustomersInMagazine();
                    }
                    break;

                case 5:
                    if (customerList.isEmpty()) {
                        System.out.println("No customer to remove\n");
                    } else if (magazine == null) {
                        System.out.println("No magazine to remove customer\n");
                    } else {
                        client.removeCustomerFromMagazine(magazine);
                        System.out.println("Customer removed...");
                        magazine.displayCustomersInMagazine();
                    }
                    break;

                case 6:
                    if (customerList.isEmpty() || magazine.getMagzineCustomers().isEmpty()) {
                        System.out.println("No customer or magazine data to print\n");
                    } else {
                        System.out.println("Printing all emails...\n\n");
                        client.printAllEmails(magazine);
                    }
                    break;

                case 7:
                    if (customerList.isEmpty() || magazine.getMagzineCustomers().isEmpty()) {
                        System.out.println("No customer or magazine data to print\n");
                    } else {
                        System.out.println("Printing end of month email...\n\n");
                        client.printEndOfMonthEmails(magazine);
                    }
                    break;

                case 8:
                    cont = false; // Set the loop control variable to false to exit the loop
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.\n");
                    break;
            }

        } while (cont);

        // TODO 3: Uncomment to test run each individual classes

        //Customer.testrun();    
        //PayingCustomer.testrun();
        //SupplementDatabase.testrun();
        //Magazine.testrun();
        //Client.testrun();
        //Helper.testrun();

    }
}
