package interest;

import java.util.ArrayList;

public class InterestLoop {
    

    public static ArrayList<InterestCalculator> getInterestArr(double interestRate, double principal, double monthPayment, double years)
    {
        ArrayList<InterestCalculator> intArr = new ArrayList<InterestCalculator>();
        for(int y=0; y <= years; y++)
        {
            intArr.add (new InterestCalculator(interestRate, principal, monthPayment, y));
        }
        return intArr;
    }        
}
