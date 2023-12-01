package JavaThreadsDemo;

import java.util.Random;

class PrintNumbers implements Runnable {
    int num;
    String type;

    PrintNumbers(int num, String type) {
        this.num = num;
        this.type = type;
    }

    public void run() {
        System.out.println(type + " numbers between 1 and the generated number are:");
        for (int i = type.equals("Odd") ? 1 : 2; i <= num; i += 2) {
            System.out.println(i);
        }
    }
}

class Numberone extends Thread {
    Random rand = new Random();

    public void run() {
        for (int i = 1; i <= 10; i++) { // Generate 10 random numbers
            int randInt = rand.nextInt(100);
            System.out.println("Random integer generated is: " + randInt);

            Runnable printTask = (randInt % 2 == 0)
                    ? new PrintNumbers(randInt, "Even")
                    : new PrintNumbers(randInt, "Odd");

            new Thread(printTask).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}

public class OddEvenRunnable {
    public static void main(String[] args) {
        Numberone n = new Numberone();
        n.start();
    }
}
