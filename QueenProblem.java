//Queen Problem:using BackTracking.

import java.util.*;
public class QueenProblem {
    static int n;
    public static void printBoard(int[][] QBoard){
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(QBoard[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    public static boolean canBePlaced(int[][] QBoard,int row,int col){
        
        int i,j;
        for(i=0;i<n;i++){
            if(QBoard[row][i]==1 || QBoard[i][col]==1){
                return false;
            }
        }
        for(i=row,j=col;i>=0 && j>=0;i--,j--){
            if(QBoard[i][j] == 1){
                return false;
            }
        } 
        
        for(i=row,j=col;i<n && j>=0;i++,j--){
            if(QBoard[i][j] == 1){
                return false;
            }
        }

        return true;
        
    }
    
    public static boolean solveQueen(int[][] QBoard,int col){
        
        if(col>=n){
            return true;
        } 
        for(int i=0;i<n;i++){
        if(canBePlaced(QBoard,i,col)){
            QBoard[i][col] = 1; 
                if(solveQueen(QBoard,col+1)){
                    return true;
                } 
                
                 QBoard[i][col] = 0; 
            }
            
        }  
        
        return false;
    }
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        int[][] QBoard = new int[n][n];
        if(solveQueen(QBoard,0)){
            printBoard(QBoard); 
        } 
        else{
            System.out.println("Queen Cannot Be Placed");
        }
        
    }
}
