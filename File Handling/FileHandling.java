import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {
        char[] data = new char[50];
        FileReader input = null;
        FileWriter output = null;
        try {
            input = new FileReader("output.txt");
            int bytes = input.read(data);
            System.out.println("output.txt");
            System.out.println(data);
            input.close();
            output = new FileWriter("newoutput.txt");
            output.write(data, 0, bytes);
            System.out.println("newoutput.txt");
            System.out.println(data);
            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}