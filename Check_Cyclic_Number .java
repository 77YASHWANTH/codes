//To Check It Is An Cyclic : Three condition Should be Satisfied:
//1.All the digits in the number should not be same
//2.if the number of digits is equal, two half should not be equal. 
//3.check the number by rotating is divisible by the given number. 

/*Ex:
Input : 142857
Output : Yes
Explanation
    142857 × 1 = 142857
    142857 × 2 = 285714
    142857 × 3 = 428571
    142857 × 4 = 571428
    142857 × 5 = 714285
    142857 × 6 = 857142 */


import java.util.*;
import java.lang.Math;
public class Check_Cyclic_Number {
    
    public static boolean isCyclic(long n){
        int count = 0;
        long num = n;
        long sameInt = n%10; 
        boolean Same = true;
        while(num>0){
             count++;
             if(num%10!=sameInt){
                 Same = false; 
             }
             num/=10;
        } 
        //Condition 1
        if(Same){
            return false;
        }
        num = n;
        
        //Condition 2
        if(count%2==0){
            
            long digits = (long)Math.pow(10,count/2);
            long firstHalf = (long)num%digits; 
            long secondHalf = (long)num/digits;
            
            if(firstHalf==secondHalf && isCyclic(firstHalf)){
             return false;   
            }
        } 
        num = n; 
        //Conditon 3
        for(int i=0;i<count;i++){
            
            long cyclicUnitDigit = (long)num%10;
            long digits = (long)Math.pow(10,count-1); 
            long remainingFirstHalf =  num/10;
            num = (cyclicUnitDigit * digits) + remainingFirstHalf;
            if(num%n!=0){
                return false;
            }
        }
        
        
        return true;
    }

    public static void main(String[] args) 
	{ 
		long N = ; 
		if (isCyclic(N)) 
			System.out.print("Yes"); 
		else
			System.out.print("No"); 
	} 
}
//For Refernce.
//https://www.geeksforgeeks.org/generating-random-numbers-in-java/
