import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class FileWriterDemo {
		public static void main(String args []) {
			char [] data = new char[60];
			FileReader input = null;
			FileWriter output = null;
			String value = "HI , my name is Awin";
			FileWriter info = null;
			try {
				info = new FileWriter("inputs.txt");
				info.write(value); 
				info.flush();
				info.close();
				input = new FileReader("inputs1.txt");
				int bytes = input.read(data);
				//System.out.println(data);
				input.close();
				output = new FileWriter("outputs1.txt");
				output.write(data,0,bytes);
				output.flush();
				output.close();				
			}
			catch(IOException io)
			{
				System.out.println("ERORR!!!!");
				io.printStackTrace();
			}
		}
}