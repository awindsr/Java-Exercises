package sixthOctober;

import java.util.Scanner;

public class diagonalMatrix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the row and col of matrix: ");
		int ROW1 = input.nextInt();	
		int COL1 = input.nextInt();
		
		int [][] matrixOne = new int[ROW1][COL1];
		if(ROW1==COL1) {
			System.out.println("Enter elements of  matrix row wise: ");
			for(int i=0; i<ROW1; i++) {
				for(int j=0; j<COL1; j++) {
					matrixOne[i][j] = input.nextInt();
				}
			}
		}
		else {
			System.out.println("Error: Matrix defined is not a square matrix");
		}
		for(int i=0; i<ROW1; i++) {
			for(int j=0; j<COL1; j++) {
				if(i==j || j == (COL1-i-1)) {
					matrixOne[i][j]=0;
				}
			}
		}
		for(int i=0; i<ROW1; i++) {
			for(int j=0; j<COL1; j++) {
				System.out.print(matrixOne[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
