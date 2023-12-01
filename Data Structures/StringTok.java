import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTok {
	public static void main(String [] args) {
		Scanner sc  =  new Scanner(System.in);
		String numbers; 
		System.out.println("Enter numbers: ");
		numbers = sc.nextLine();
		
		StringTokenizer tokenizer = new StringTokenizer(numbers);
		int integer;
		int sum = 0;
		
		System.out.println("The integers are: ");
		while(tokenizer.hasMoreElements()) {
			integer = Integer.parseInt(tokenizer.nextToken());
			System.out.println(integer);
			sum+=integer;
		}
		System.out.println("The sum of integers are: "+ sum);
		
	}
}
