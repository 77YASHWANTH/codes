/*  Given a two dimensional array of string like
  <”luke”, “shaw”>
  <”wayne”, “rooney”>
  <”rooney”, “ronaldo”>
  <”shaw”, “rooney”> 
Where the first string is “child”, second string is “Father”. 
And given “ronaldo” we have to find his no of grandchildren Here “ronaldo” has 2 grandchildren.
 So our output should be 2. */

import java.util.*;
public class GrandChildren{
    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    HashMap<String,ArrayList<String>>  hm = new HashMap<String,ArrayList<String>>();
    String child,parent; 
    
    for(int i=0;i<4;i++){
       String[] s = sc.nextLine().split(" ");
       System.out.println(s[0]+" "+s[1]); 
   
        child = s[0];
        parent = s[1];
        
        ArrayList<String> al;
        if(hm.containsKey(parent)){
            al = hm.get(parent);
        }
        else{
            al = new ArrayList<String>(); 
           
        } 
         al.add(child);
        hm.put(parent,al);
        
    } 
    
    String find = sc.nextLine();
    
    Iterator it = hm.get(find).iterator();
    
    int count = 0;
    while(it.hasNext()){
        count = count + hm.get(it.next()).size();
    }
    System.out.println(count);
    }
}
