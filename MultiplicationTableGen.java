package ThreadingExercises;
import java.util.Scanner;

class MultiplicationTable {
    public synchronized void printTable(int multiplier) {
        for (int factor = 1; factor <=10; factor++) {
            System.out.println(multiplier + "x" + factor + "=" + multiplier * factor);
        }
    }
}

class TableThread extends Thread {
    MultiplicationTable multiplicationTable;
    Scanner scanner;
    int tableNumber;

    public TableThread(MultiplicationTable multiplicationTable, int tableNumber) {
        this.multiplicationTable = multiplicationTable;
        this.tableNumber = tableNumber;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        multiplicationTable.printTable(tableNumber);
    }
}

public class MultiplicationTableGen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the table you want to run by the first thread:");
        int number1 = scanner.nextInt();

        System.out.println("Enter the table you want to run by the second thread:");
        int number2 = scanner.nextInt();

        System.out.println("Enter the table you want to run by the third thread:");
        int number3 = scanner.nextInt();

        MultiplicationTable multiplicationTable = new MultiplicationTable();

        TableThread thread1 = new TableThread(multiplicationTable, number1);
        TableThread thread2 = new TableThread(multiplicationTable, number2);
        TableThread thread3 = new TableThread(multiplicationTable, number3);

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
