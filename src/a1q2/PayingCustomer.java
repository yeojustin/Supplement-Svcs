/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a1q2;

import java.util.*;
import java.lang.*;
/**
 * PayingCustomer inherits from Customer Class
 * @author yeojustin
 */
public class PayingCustomer extends Customer {
    
    private Payment paymentDetails;
    private ArrayList<AssociateCustomer> associateCustomers;
    
    
    /**
     * Constructs a PayingCustomer object with the specified name, email, and payment details.
     *
     * @param name           the name of the paying customer
     * @param email          the email of the paying customer
     * @param paymentDetails the payment details of the paying customer
     * 
     * Precondition:
     * <ul>
     * <li>The name and email parameters are non-null</li>
     * </ul>
     * 
     * Post-condition:
     * <ul>
     * <li>A PayingCustomer object is created with the specified name, email, and payment details</li>
     * <li>The associateCustomers list is initialized as an empty ArrayList</li>
     * </ul>
     */
    public PayingCustomer(String name, String email, Payment paymentDetails){
        super(name,email);
        this.associateCustomers = new ArrayList<>(); //init to null
        this.paymentDetails = paymentDetails;
    }
    
    
    /**
     * Adds the specified associate customers to the list of associate customers.
     *
     * @param assocCust the associate customers to add
     * 
     * Precondition:
     * <ul>
     * <li>The assocCust parameter is non-null</li>
     * </ul>
     * 
     * Post-condition:
     * <ul>
     * <li>The specified associate customers are added to the list of associate customers</li>
     * </ul>
     */
    public void addAssociateCustomer(AssociateCustomer...assocCust){
        for (AssociateCustomer ac: assocCust){
            this.associateCustomers.add(ac);
        }
    }
    
    
    /**
     * Removes the specified associate customers from the list of associate customers.
     *
     * @param assocCust the associate customers to remove
     * 
     * Precondition:
     * <ul>
     * <li>The assocCust parameter is non-null</li>
     * </ul>
     * 
     * Post-condition:
     * <ul>
     * <li>The specified associate customers are removed from the list of associate customers, if they exist and the current customer is the payer</li>
     * <li>If the current customer is not the payer or there are no associate customers, appropriate error messages are displayed</li>
     * </ul>
     */
    public void removeAssociateCustomer(AssociateCustomer...assocCust){
        if (this.associateCustomers != null){
            for (AssociateCustomer ac: assocCust){
                if (this.associateCustomers.contains(ac)){
                    this.associateCustomers.remove(ac);
                } else {
                    System.out.println("Unable to remove associate: "+ac.getName()+" as you are not the payer.\n");
                }
            }
        } else {
            System.out.println("You are not paying for anyone currently.\n");
        }
    }
    
    
    /**
     * Displays the information of associate customers.
     * 
     * Precondition:
     * <ul>
     * <li>The associateCustomers list is non-null</li>
     * </ul>
     * 
     * Post-condition:
     * <ul>
     * <li>If there are associate customers, their names and emails are printed</li>
     * <li>If there are no associate customers, an appropriate message is displayed</li>
     * </ul>
     */    
    public void displayAssociateCust(){
        if(this.associateCustomers != null){
            for (AssociateCustomer ac: this.associateCustomers){
                System.out.println("Name: "+ac.getName());
                System.out.println("Email: "+ac.getEmail()+"\n");
            }
        } else {
            System.out.println("You are curently not paying for anyone\n");
        }    
    }

    
    /**
     * Retrieves the payment details of the PayingCustomer.
     *
     * @return the payment details of the PayingCustomer
     */    
    public Payment getPaymentDetails() {
        return paymentDetails;
    }

    
    /**
     * Retrieves the list of associate customers associated with the PayingCustomer.
     *
     * @return the list of associate customers associated with the PayingCustomer
     */   
    public ArrayList<AssociateCustomer> getAssociateCustomers() {
        return associateCustomers;
    }
    
    
    /**
     * Runs a test scenario to demonstrate the functionality of the PayingCustomer class.
     */    
    public static void testrun(){
        Payment pc1Pay = new Payment("CREDIT_CARD","4234 1234 4321 1234");
        PayingCustomer pc1 = new PayingCustomer("Dan Leong", "danleong@hotmail.com", pc1Pay);
        Payment pc2Pay = new Payment("DIRECT_DEBIT", "4321 4444 1111 2222");
        PayingCustomer pc2 = new PayingCustomer("Tyrone Lim", "myneighbour@qq.com", pc2Pay);
        
        //initialise associate customer
        AssociateCustomer ac1 = new AssociateCustomer("Pao Gonzalez", "paogone95@gmail.com", pc1);
        AssociateCustomer ac2 = new AssociateCustomer("Isabel Tam", "isaisa@gmail.com", pc1);
        AssociateCustomer ac3 = new AssociateCustomer("Jayden Lim", "jayden99@gmail.com", pc1);
        AssociateCustomer ac4 = new AssociateCustomer("Lim Ah Geok", "lageok1955@gmail.com", pc1);
        AssociateCustomer ac5 = new AssociateCustomer("Okuhara Aoi", "okuharaoi@gmail.com", pc1);
        AssociateCustomer ac6 = new AssociateCustomer("Jacky Lim","jackyboy17@yahoo.com", pc2);
        pc1.addAssociateCustomer(ac1,ac2,ac3,ac4,ac5);
        pc1.displayAssociateCust();
        
        
        System.out.println("Set supplement for "+ac1.getName());
        ac1.setInterestedSupplement();
        System.out.println("Set supplement for "+ac2.getName());
        ac2.setInterestedSupplement();

        System.out.println("Set supplement for "+pc1.getName());
        pc1.setInterestedSupplement();
        
        //remove associate customer from paying customer
        pc1.removeAssociateCustomer(ac4, ac6); //removed Lim Ah Geok
        pc1.displayAssociateCust();
    }
}
