
//SUDOKU - Solve By Using Backtracking 

import java.util.*;
public class Sudoku {
    
    static int n = 9;
	
	//To check Board isFull. 
    public static boolean isFull(int[][] sudoku) {
	    //Traverse Full Board.
		for(int i=0;i<n;i++) {
			for(int j =0;j<n;j++) {
				if(sudoku[i][j] == 0) {
					return false;
				}
			}
		} 
		return true;
	}
	
	//To Check Possible Numbers Can be Place in that Position
    public static HashMap<Integer,Integer> PossibleEntries(int[][] sudoku,int row,int col){
        
        
        //HashMap Used For Saving The Number And Its Possiblities.
        LinkedHashMap<Integer,Integer> possiblities = new LinkedHashMap<Integer,Integer>();
        
        int rowLimit,colLimit;
    
        //Update All The Number In The possiblities
        for(int i=1;i<10;i++){
            possiblities.put(i,0);
        } 
        
        //If The Number Is In That Same Row Update possiblities
        for(int i = 0;i<9;i++){
            possiblities.put(sudoku[row][i],1);
        }
        
        //If The Number Is In That Same Coloumn Update possiblities
        for(int i = 0;i<9;i++){
            possiblities.put(sudoku[i][col],1);
        }
        
        //Setting 3*3 grid To Check Number Is Already Present. 
        //RowLimt
        if(row>=0 && row<3){
            rowLimit = 3;
        } 
        else if(row>=3 && row<6){
             rowLimit = 6;
        }
        else{
             rowLimit = 9;
        } 
        
        //ColLimit
        if(col>=0 && col<3){
            colLimit = 3;
        } 
        else if(col>=3 && col<6){
             colLimit = 6;
        }
        else{
             colLimit = 9;
        }

        //TraverseThroughGrid.
        for(int i = rowLimit - 3;i<rowLimit;i++) {
        	for(int j=colLimit - 3;j<colLimit;j++) {
        		possiblities.put(sudoku[i][j],1);
        	}
        }
    
    
    return possiblities;
        
    }
    
    //Solving Sudoku
    public static void solve(int[][] sudoku){
        
        int i,j,row=0,col=0;
        boolean vacant = false;
        HashMap<Integer,Integer> possiblities = new HashMap<Integer,Integer>();
        
        //If Full Print And Terminate 
        if(isFull(sudoku)){
            printSudoku(sudoku);
            return;
        }  
        
        //Finding The VacantPositon And The Saving Tht Position In row and col and break.
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(sudoku[i][j] == 0){
                    row = i;
                    col = j;
                    vacant = true;
                    break;
                }
            }  
            if(vacant){
                break;
            }
        }    
        
        //Getting the Possibilities ,
        possiblities = PossibleEntries(sudoku,row,col);
        
        //If Numer Key Value Is 0 Then It is Considered To be One Possibility And Recursively Calling Again Solve 
        for(int x = 1;x<10;x++){
            
            if(possiblities.get(x)==0){
                sudoku[row][col] = x;
                solve(sudoku);
            }
        }
        
        //Key Logic Of This Program,If There Is No Possibility Exist Then Again It is Intialized To 0 
        //And Go Back In The Previous Recursion And Iterate To Next Number And Again Recursively Call.
        sudoku[row][col] = 0;
    }
    
    public static void printSudoku(int[][] sudoku) {
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			System.out.print(sudoku[i][j]+" ");
    		} 
    		System.out.println();
    	}
    }
    
    
    public static void main(String args[]) {
      
     Scanner sc =new Scanner(System.in);
  
     int[][] sudoku = new int[9][9];   
  
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
             sudoku[i][j] = sc.nextInt();
         }
     } 
     
     solve(sudoku);
      
      
     
    }
}
