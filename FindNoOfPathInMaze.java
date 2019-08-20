/*
  Find the No of Path In the Maze 
  case 1:
  i/p:
  3 3 
  * * | 
  | * * 
  | * *  
  
  o/p:2

*/
import java.util.*;
public class FindNoOfPathInMaze {
    static int m,n;
   
    public static boolean checkBound(int i,int j){
        if(i<0 || j<0 || i>=n || j>=m){
            return true;
        } 
        return false;
    }
    public static int ratMaze(char[][] a,int i,int j){
        if(checkBound(i,j)){
            return 0;
        }  
        if(a[i][j]=='|'){
            return 0;
        }
        if(i==n-1 && j==m-1 && a[i][j]=='*'){ 
            ct = ct + 1;
            return 1;
        } 
        
        return ratMaze(a,i,j+1) + ratMaze(a,i+1,j);
    }
    
    public static void main(String args[]) {
    
    char[][] a = new char[100][100]; 
    Scanner sc = new Scanner(System.in);
    
    n = sc.nextInt();
    m = sc.nextInt();
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            a[i][j] = sc.next().charAt(0); 
            
        } 
        sc.nextLine();
    }  
    
    int c = ratMaze(a,0,0);

    System.out.println(c);
    
    
    }
}
