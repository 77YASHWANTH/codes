//Find minimum number of currency notes and values that sum to given amount
import java.util.*;
public class Minimum_Number_Of_Currency_Notes {
    public static void main(String args[]) {
      
      int[] a = {2000,500,200,100,50,20,10,5,1};
      int[] b = new int[9];
      int k = 2456;
      for(int i=0;i<9&&k>0;i++){
          
          if(k>=a[i]){
              int q = k/a[i];
              k = k - (q*a[i]);
              b[i] = q;
          }   
      } 
      
      for(int i=0;i<9;i++){
          
         if(b[i]>0){
              System.out.println(a[i]+"-"+b[i]);
         }
          
      }
     }
}
