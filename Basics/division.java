/*
 File : Sum.java
 Description : Java program to divide 2 numbers
 Author : Awindsr
 Version : 1.0
 Date : 19/09/2023
 */
import java.util.Scanner;  
public class division {
	public static void main(String[] args) {
		Scanner num1 = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int firstNum = num1.nextInt();
		
		Scanner num2 = new Scanner(System.in);
		System.out.print("Enter second number: ");
		int secondNum = num2.nextInt();
		
		int quotient = firstNum / secondNum;
		
		System.out.print(quotient);
	}
}
