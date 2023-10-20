/*
 File : Sum.java
 Description : Java program to subtract 2 numbers
 Author : Awindsr
 Version : 1.0
 Date : 19/09/2023
 */
import java.util.Scanner;

public class multiplication {
	public static void main(String[] args) {
//		int firstNum =10, secondNum = 60;
//		
//		int product = firstNum * secondNum;
//		System.out.print(product);
		
		Scanner num1 = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int firstNum = num1.nextInt();
		
		Scanner num2 = new Scanner(System.in);
		System.out.print("Enter Second number: ");
		int secondNum = num2.nextInt();
		
		int product = firstNum * secondNum;
		System.out.print(product);
	}

}
