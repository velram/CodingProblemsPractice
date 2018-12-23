package com.interviewbit.practice;

public class SpiralOrderMatrixTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] spiralMatrix = null;
		SpiralOrderMatrixGenerator spiralMatrixGenerator =new SpiralOrderMatrixGenerator();
		spiralMatrix = spiralMatrixGenerator.generateMatrix(4);
		spiralMatrixGenerator.displaySpiralMatrix(spiralMatrix);
	}

}

class SpiralOrderMatrixGenerator {

	 public int[][] generateMatrix(int inputNumber) {  
         int[][] spiralMatrix = new int[inputNumber][inputNumber];  
         int totalElementCount = inputNumber * inputNumber;   
         int topMostLeft = 0;   
         int bottomMostLeft = 0;  
         int topMostRight = inputNumber -1;  
         int bottomMostRight = inputNumber -1;  
         int row = 0;   
         int column = 0;   
         int direction = 1;   
         try {
         for(int loopIndex = 0; loopIndex < totalElementCount ; loopIndex++) {  
              System.out.println("\nDirection : "+direction + " loopIndex : "+loopIndex);  
              //Left to right   
              if(direction == 1) {  
                   /*System.out.println("\nInside direction 1 : ");  
                   System.out.println("row : " + row + " column : "+column + " topMostRight : "+topMostRight + " spiralMatrix[row][column] : "+spiralMatrix[row][column] + " loopIndex+1 "+(loopIndex+1));*/  
                   if(column < topMostRight) {  
                        if(spiralMatrix[row][column] == 0) {  
                             spiralMatrix[row][column++] = loopIndex+1;                                
                        }  
                        else {  
                             //System.out.println("Inside else");  
                             spiralMatrix[row][++column] = loopIndex+1;                                
                        }  
                        /*System.out.println("row : " + row + " column : "+column + " topMostRight : "+topMostRight);  
                        System.out.println("spiralMatrix[row][column++] :"+spiralMatrix[row][column]);*/  
                   }  
                   else if(column == topMostRight) {  
                        //System.out.println("row : " + row + " column : "+column + " topMostRight : "+topMostRight+" spiralMatrix[row][column++] :"+spiralMatrix[row][column]);  
                        topMostRight--;  
                        direction = 2;  
                        if(spiralMatrix[row][column] == 0) {  
                             spiralMatrix[row][column] = loopIndex+1;       
                        }  
                        else {  
                             //System.out.println("Inside line 55");  
                             spiralMatrix[++row][column] = loopIndex+1;  
                             //System.out.println("loopIndex+1 : "+ (loopIndex+1) + " spiralMatrix[row][column] : "+spiralMatrix[row][column]);  
                        }  
                   }  
              }  
              //Top to Bottom   
              else if(direction == 2) {  
                   System.out.println("row : "+row + " bottomMostRight : "+bottomMostRight);  
                   if(row < bottomMostRight) {
                	   if(spiralMatrix[row][column] == 0) {
                        spiralMatrix[row++][column] = loopIndex + 1;
                	   }
                	   else {
                		   spiralMatrix[++row][column] = loopIndex + 1;
                	   }
                   }  
                   else if(row == bottomMostRight) {
                	   System.out.println("");
                	   if(spiralMatrix[row][column] == 0) {
                		   spiralMatrix[row][column] = loopIndex+1;
                	   }
                        bottomMostRight--;  
                        direction = 3;  
                   }  
              }  
              //Right to left   
              else if(direction == 3) {  
                   System.out.println("column : "+column + " bottomMostLeft : "+bottomMostLeft);  
                   if(column > bottomMostLeft) {  
                        spiralMatrix[row][column--] = loopIndex + 1;  
                   }  
                   else if(column == bottomMostLeft) {  
                        spiralMatrix[row][column] = loopIndex+1;       
                        bottomMostLeft++;  
                        direction = 4;  
                   }  
              }  
              //Bottom to top  
              else if(direction == 4) {  
                   //System.out.println("row : "+ row + " topMostLeft: "+topMostLeft);  
                   if(row > topMostLeft) {  
                        spiralMatrix[row--][column] = loopIndex+1;  
                   }  
                   else if (row == topMostLeft) {  
                        topMostLeft++;  
                        column++;  
                        row++;  
                        direction = 1;  
                        //System.out.println("row : "+row + " column : "+column + " loopIndex : "+loopIndex);  
                        spiralMatrix[row][column] = loopIndex + 1;  
                        //System.out.println("row : " + row + " column : " + column + " spiralMatrix[row+1][matrix+1] is : "+spiralMatrix[row+1][column+1] + " spiralMatrix[row][column] "+spiralMatrix[row][column]);  
                   }  
              }
             // System.out.println("value at current index is : "+spiralMatrix[row][column]);
          }  
         }
         catch (Exception exceptionObj) {
        	 System.out.println("Exception while generating matrix : "+exceptionObj);
		}
         return spiralMatrix;  
    }  


	public void displaySpiralMatrix(int[][] pInputArray) {

		for(int row = 0; row < pInputArray.length ; row++) {
		  for(int column = 0 ; column < pInputArray[0].length ; column++) {
			  System.out.print(pInputArray[row][column] +" ");
		  }
		  System.out.println();
		}
	}
	
}