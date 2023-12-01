/*
 File : Sum.java
 Description : Java program to add 2 numbers
 Author : Awindsr
 Version : 1.0
 Date : 19/09/2023
 */
import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
//		int num1 = 10, num2 = 20;
//		int sum = num1 + num2;
//		System.out.print(sum);
		
		Scanner num1 = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int firstNum = num1.nextInt();
		
		Scanner num2 = new Scanner(System.in);
		System.out.print("Enter second number: ");
		int secondNum = num2.nextInt();
		
		int sum = firstNum + secondNum;
		System.out.print(sum);
		
		
		
	}
}
