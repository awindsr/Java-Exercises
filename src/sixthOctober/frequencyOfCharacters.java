/* File 	  : frequencyOfCharacters.java
 * Description: To check the frequency of String
 * Author	  : AwinDas R
 * Version	  : 1.0
 * Date		  : 29/09/2023
 */
  

package sixthOctober;

import java.util.Scanner;

public class frequencyOfCharacters {
	public static void main(String[] args)  
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String input=sc.nextLine();
		System.out.println("Enter the Character");
		char checkMe=sc.next().charAt(0);
		int charCount=checkFreq(input,checkMe);
		System.out.println("The number of occurences of given characters: "+ charCount);
	}
	static int checkFreq(String input, char checkMe)	{
		char[] charArray=input.toCharArray();
		int charCount=0;
		for(int i=0;i<input.length();i++)
		{
			if(charArray[i]==checkMe)   {
				charCount++;
			}
		}
		return charCount;
	}
}
