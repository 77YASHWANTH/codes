/* C) Form a number system with only 3 and 4. Find the nth number of the number system.
Eg.) The numbers are: 3, 4, 33, 34, 43, 44, 333, 334, 343, 344, 433, 434, 443, 444, 3333, 3334, 3343, 3344, 3433, 3434, 3443, 3444 ….
*/
import java.util.*;
public class LuckyNumber {
    
    public static void luckyNumber(int n,Queue<String> q)
    { 
        int ct = 3;
        if(n>=1){
             System.out.print(3+" ");
         } 
        if(n>=2){
            System.out.print(4+" ");
        } 
        
        
        while(true){
            
            String k = q.poll(); 
           
            q.add(k+"3");
            System.out.print(k+"3 ");
            ct++;
            if(ct==n){
                break;
            }
            
            q.add(k+"4");
            System.out.print(k+"4 ");
            ct++; 
            if(ct==n){
                break;
            }
            
        }
        
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        Queue<String> q = new LinkedList<String>();
        q.add(String.valueOf(3));
        q.add(String.valueOf(4));
        luckyNumber(n,q);
    
    }
}
