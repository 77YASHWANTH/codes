// NextGreaterElement 
/* Using Stack We Can Do this.
Conditions:If 
           the Element is lesser than the element in the stack peek
           then push. 
           else 
           The Element is NextGreaterElement for the stack peek() and pop until the peek of Stack element is Greater than the Arriving Element.
    */
            
import java.util.*;
public class NextGreaterElement{
    public static void main(String args[]) {
       
       Stack<Integer> s = new Stack<Integer>();
       int[] a = {45,56,23,46,66,11,22,39,77,89,46,10};  //56 66 46 66 22 39 77 89 0 0 0
       int[] b = new int[a.length]; 
       int n = a.length;
       for(int i=0;i<n;i++){ 
               while(!s.empty() && a[s.peek()]<a[i]){
                    b[s.peek()] = a[i];  
                    s.pop();
               } 
             
               s.push(i);
       }
       
     for(int i=0;i<n;i++){
         System.out.print(b[i]+" ");
     }
       
    }
}
