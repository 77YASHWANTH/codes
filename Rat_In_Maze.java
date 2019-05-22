//Rat In Maze Can e Solved Using Recursion 
/*     EX:
                {1, 0, 0, 0}
                {1, 1, 0, 1}
                {0, 1, 0, 0}
                {1, 1, 1, 1}  
                it has to reach the position matrix[n-1,n-1] through the path 1.
                
   */ 
                
import java.util.*;
public class MyClass { 
    
    
    public static boolean isSafe(int i,int j,int n){ 
        
        if(i<0 || j<0 || i>=n || j>=n){
            return false;
        } 
    
    return true;
        
    }
    
    public static boolean findPath(int[][] a,int n,int i,int j){
    
        if(i==n-1 && j==n-1){ 
            if(a[i][j]==0)
                return true;
            else 
                return false;
        } 
        
        
        if(!isSafe(i,j,n)){
            return false; 
        }
        
        if(a[i][j]==1){
            return false;
        } 
        
        return findPath(a,n,i,j+1) || findPath(a,n,i+1,j);

        
    }
    
    
    
    public static void main(String args[]) {
    
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    int[][] a = new int[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
        a[i][j] =sc.nextInt();
        }
    } 
    
    if(findPath(a,n,0,0)){
        System.out.println("Yes");
    }
    else{
        System.out.println("NO");
    }
    
    
    }
} 

