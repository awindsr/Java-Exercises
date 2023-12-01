/*
 File : Sum.java
 Description : Java program to subtract 2 numbers
 Author : Awindsr
 Version : 1.0
 Date : 19/09/2023
 */
import java.util.Scanner;
public class Subtraction {

	public static void main(String[] args) {
//		int firstNum = 30, secondNum = 20;
//		
//		int difference = firstNum - secondNum;
//		System.out.print(difference);
		
		Scanner num1 = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int firstNum = num1.nextInt();
		
		Scanner num2 = new Scanner(System.in);
		System.out.print("Enter Second Number: ");
		int secondNum = num2.nextInt();
		
		int difference = firstNum -  secondNum;
		System.out.print(difference);
		
		
		
		

	}

}
