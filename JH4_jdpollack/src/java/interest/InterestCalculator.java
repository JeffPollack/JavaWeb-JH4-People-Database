/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interest;
/**
 * @author Jeff
 */
public class InterestCalculator {
    private double interestPaid;
    private double newPrincipal;
    private double monthPayment;
    
    InterestCalculator(double interestRate, double principal, double monthPayment, double years)
    {
        this.newPrincipal = principal;
        this.monthPayment = monthPayment;
        
        interestPaid = (newPrincipal * interestRate)/(12*100);
        newPrincipal = newPrincipal + interestPaid - monthPayment;
    }
    public String getNewPrincipal()
    {
        String s = String.format("%.2f", newPrincipal);
        return s;
    }
    public String getNewInterest()
    {
        String s = String.format("%.2f", interestPaid);
        return s;
    }
     
}
