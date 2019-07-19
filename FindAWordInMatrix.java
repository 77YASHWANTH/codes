/* i/p:
  3 4  
  l o n g
  c h a r 
  t y p e 
  
  grape  
  
  o/p:YES // because the word grape is available in matrix */
  

import java.util.*;

public class FindAWordInMatrix {
   static int n=0;
   static int m=0; 
   static String ans = "NO"; 
   
   public static boolean checkBound(int i,int j){
       if(i<0 || i>=n || j<0 || j>=m){
           return true;
       } 
       return false;
   }
   public static boolean findWord(int i,int j,int k,char[][] wordMatrix,String s){
       
       if(checkBound(i,j)){ 
           return false;
       } 
       
       if(wordMatrix[i][j] != s.charAt(k)){
           return false; 
       }
       if(k==s.length()-1){
           return true;
       } 
       
       return findWord(i+1,j,k+1,wordMatrix,s) || findWord(i-1,j,k+1,wordMatrix,s) 
       || findWord(i,j+1,k+1,wordMatrix,s) || findWord(i,j-1,k+1,wordMatrix,s)
       || findWord(i+1,j+1,k+1,wordMatrix,s) || findWord(i-1,j-1,k+1,wordMatrix,s)
       || findWord(i-1,j+1,k+1,wordMatrix,s) || findWord(i+1,j-1,k+1,wordMatrix,s);


   }
   
   
   public static void main(String args[]) {
       
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       m = sc.nextInt();
       char[][] wordMatrix = new char[n][m];
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               wordMatrix[i][j] = sc.next().charAt(0);
           }
       } 
       sc.nextLine();
       String s = sc.nextLine();
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(findWord(i,j,0,wordMatrix,s)){ 
                   ans = "YES"; 
                   break;
               }
           }
       }
       
       System.out.println(ans);
       
   }
}
