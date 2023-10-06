/* File 	  : palindromeOrNot.java
 * Description: Matrix multiplication
 * Author	  : Awin Das R
 * Version	  : 1.0
 * Date		  : 29/09/2023
 */

package sixthOctober;

import java.util.Scanner;
public class MatrixMultiplication {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the row and col of First matrix: ");
		int ROW1 = input.nextInt();	
		int COL1 = input.nextInt();
		
		System.out.println("Enter the row and col of Second matrix: ");
		int ROW2 = input.nextInt();	
		int COL2 = input.nextInt();
		
		int [][] matrixOne = new int[ROW1][COL1];
		int [][] matrixTwo = new int[ROW2][COL2];
		int[][] resultMatrix = new int[ROW1][COL2];
		
		System.out.println("Enter elements of First matrix row wise: ");
		for(int i=0; i<ROW1; i++) {
			for(int j=0; j<COL1; j++) {
				matrixOne[i][j] = input.nextInt();
			}
		}
		System.out.println("Enter elements of second matrix row wise: ");
		for(int i=0; i<ROW2; i++) {
			for(int j=0; j<COL2; j++) {
				matrixTwo[i][j] = input.nextInt();
			}
		}
		
		if(COL1!=ROW2) {
			System.out.println("Matrix multiplication not possible since Column 1 and Row 2");
		}
		else {
			
			for(int i=0; i<ROW1; i++) {
				for(int j=0; j<COL2;j++) {
					
					for(int k=0;k<COL1; k++) {
						resultMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
					}
				}
			}
		}
		System.out.println("Result is:");
		for(int i=0; i<ROW1; i++) {
			for(int j=0; j<COL2; j++) {
				System.out.print(resultMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
