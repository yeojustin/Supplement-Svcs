package a1q2;

/**
 * AssociateCustomer class inherits from the Customer class
 * @author yeojustin
 */
public class AssociateCustomer extends Customer {
    
    private PayingCustomer payingCustomer;

    
    /**
     * Constructs an AssociateCustomer object with the specified name and email.
     *
     * @param name  the name of the associate customer
     * @param email the email of the associate customer
     * 
     * Precondition:
     * - The name and email must be valid non-null values.
     * 
     * Post-condition:
     * - An AssociateCustomer object is created with the specified name and email.
     */
    public AssociateCustomer(String name, String email) {
        super(name, email);
    }


    /**
     * Constructs an AssociateCustomer object with the specified name, email, and paying customer.
     *
     * @param name           the name of the associate customer
     * @param email          the email of the associate customer
     * @param payingCustomer the paying customer associated with the associate customer
     * 
     * Precondition:
     * - The name, email, and payingCustomer must be valid non-null values.
     * 
     * Post-condition:
     * - An AssociateCustomer object is created with the specified name, email, and paying customer.
     */
    public AssociateCustomer(String name, String email, PayingCustomer payingCustomer) {
        super(name, email);
        this.payingCustomer = payingCustomer;
    }

    
    /**
     * Returns the paying customer associated with this associate customer.
     *
     * @return the paying customer
     * 
     * Precondition:
     * - None
     * 
     * Post-condition:
     * - The paying customer associated with this associate customer is returned.
     */    
    public PayingCustomer getPayingCustomer() {
        return payingCustomer;
    }

    
    /**
     * Sets the paying customer associated with this associate customer.
     *
     * @param payingCustomer the paying customer to be set
     * 
     * Precondition:
     * - The payingCustomer must be a valid non-null value.
     * 
     * Post-condition:
     * - The paying customer associated with this associate customer is set to the specified paying customer.
     */   
    public void setPayingCustomer(PayingCustomer payingCustomer) {
        this.payingCustomer = payingCustomer;
    }
}