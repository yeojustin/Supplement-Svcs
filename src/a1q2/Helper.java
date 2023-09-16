package a1q2;

import java.util.*;
import java.io.*;

/**
 * The Helper class provides various helper methods for console input and output. 
 * It also includes a scanner object to get input from the console.
 * @author yeojustin
 */
public class Helper {
    
        /**
         * Scanner class used to get input from console/user.            
         */
        public Scanner kb = new Scanner(System.in);

        
        /**
         * Helper method to get user to input integer value with error validation.                      
         * <p>
         * This class is a used to get a valid integer input with InputMismatchError validation. The user is prompted to input an integer indefinitely until an integer is received.
         * </p>
         * <p>Precondition- There needs to be a valid String parsed into this method as a prompt statement or message in the console.</p>
         * <p>Post-condition - An integer in returned.</p>
         * @param msg A prompt statement or message to be displayed in the console.
         * @return n A user input integer is returned.
         */
        public int getInt(String msg) {
            int n = 0;
            boolean carryOn = true;
            while (carryOn) {
                try {
                    System.out.println(msg);
                    n = kb.nextInt();
                    kb.nextLine(); // Consume newline character
                    carryOn = false;
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter only menu option numbers.\n");
                    kb.nextLine();
                }
            }
            return n;
        }
        
        
        /**
         * Helper method to get user to input datatype double value with error validation.                      
         * <p>
         * This class is a used to get a valid double input with InputMismatchError validation. The user is prompted to input an integer indefinitely until a long datatype is received.
         * </p>
         * <p>Precondition - There needs to be a valid String parsed into this method as a prompt statement or message in the console.</p>
         * <p>Post-condition - A datatype double is returned.</p>
         * @param msg A prompt statement or message to be displayed in the console.
         * @return n A user input double value is returned.
         */
        public double getDouble(String msg) {
            double n = 0;
            boolean carryOn = true;
            while (carryOn) {
                try {
                    System.out.println(msg);
                    n = kb.nextDouble();
                    kb.nextLine(); // Consume newline character
                    carryOn = false;
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter only numbers.\n");
                    kb.nextLine();
                }
            }
            return n;
        }
        
        
        /**
         * Helper method to get user to input String value.                     
         * <p>
         * This class is a used to get a String input from the user.
         * </p>
         * Precondition - There needs to be a valid String parsed into this method as a prompt statement or message in the console.. <br>
         * Post-condition - A String is returned.
         * @param msg A prompt statement or message to be displayed in the console.
         * @return s A String of message input from the user.
         */
        public String getString(String msg) {
            System.out.println(msg);
            String s = kb.nextLine();
            return s;
        }

       /**
        * Runs internal testing on the 'Helper' class by instantiating an object 'helper'.
        * <p>
        * Pre-condition: N.A. </p>
        * <p>Post-condition: Depends on the intention of the user testing the methods in Helper class.</p>
        */ 
        public static void testrun(){
            Helper helper = new Helper();
           
//            // Test user input integer function with error validaton
//            int num = helper.getInt("Please enter a num: ");
//            System.out.println(num);
//            
//            // Test user input String function
//            String name1 = helper.getString("Please enter a name: ");
//            System.out.println(name1);
            
            // Other test methods here
        }
        
}