package JavaThreadsDemo;
import java.util.Random;

class PrintOdd extends Thread {
    int num;

    PrintOdd(int num) {
        this.num = num;
    }

    public synchronized void run() {
    	System.out.println("Odd numbers between 1 and the generated number are:");
        for (int i = 1; i <= num; i += 2) {
            System.out.println(i);
        }
    }
}

class PrintEven extends Thread {
    int num;

    PrintEven(int num) {
        this.num = num;
    }

    public synchronized void run() {
    	System.out.println("Even numbers between 1 and the generated number are:");
        for (int i = 2; i <= num; i += 2) {
            System.out.println(i);
        }
    }
}

class Number extends Thread {
    Random rand = new Random();

    public void run() {
        for (int i = 1; i<=0; i++) {
            int randInt = rand.nextInt(100);
            System.out.println("Random integer generated is: " + randInt);

            if (randInt % 2 == 0) {
                PrintEven even = new PrintEven(randInt);
                even.start();
            } else {
                PrintOdd odd = new PrintOdd(randInt);
                odd.start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}

public class SyncDemoTwo {
    public static void main(String[] args) {
        Number n = new Number();
        n.start();
    }
}
