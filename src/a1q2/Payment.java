/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a1q2;

/**
 *
 * @author yeojustin
 */
class Payment {
    
    private String methodType;
    private String details;

    public Payment(String methodType, String details) {
        this.methodType = methodType;
        this.details = details;
    }

    public String getMethodType() {
        return methodType;
    }
}
