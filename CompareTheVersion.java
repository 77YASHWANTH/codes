//Compare The Version 
/*ex:
4.02.1  
4.02.02 
o/p:upgraded 
*/

import java.util.*;
public class CompareTheVersion{

    public static String indicates(String s1,String s2){
            int i=0,j=0,n1=0,n2=0;
        
            while(i<s1.length() || j<s2.length()){
                 n1 = 0;
                 n2 = 0;
                while(i<s1.length() && s1.charAt(i)!='.'){
                    n1  = n1*10+Integer.parseInt(String.valueOf(s1.charAt(i))); 
                    i++;
               } 
               
                while(j<s2.length() && s2.charAt(j)!='.'){
                    n2  = n2*10+Integer.parseInt(String.valueOf(s2.charAt(j))); 
                    j++;  
               }  
               
           
               if(n1>n2){
                   return "downgaded";
               } 
               if(n1<n2){
                   return "upgraded";
               }
               i++;
               j++;
               
           
            } 
        
        
       return "equal"; 
    }
    
    public static void main(String args[]) {
       
       Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine(); 
        String s = indicates(s1,s2);
        System.out.println(s);  
    }
}
