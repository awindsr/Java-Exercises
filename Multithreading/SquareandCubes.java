package ThreadingExercises;

import java.util.Random;

class Square {
	 public static void calculateSquare(int number) {
	        int square = number * number;
	        System.out.println("Square: " + square);
	    }
}

class Cube {
	 public static void calculateCube(int number) {
	        int cube = number * number;
	        System.out.println("Cube: " + cube);
	    }
}


class Number extends Thread {
    Random rand = new Random();

    public void run() {
        for (int i = 0; i<=10; i++) {
            int randInt = rand.nextInt(100);
            System.out.println("Random integer generated is: " + randInt);
            
            if (randInt % 2 == 0) {
                Square.calculateSquare(randInt);
            } else {
                Cube.calculateCube(randInt);
            }
         

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}


public class SquareandCubes {

	public static void main(String[] args) {
		 Number numberThread = new Number();
	     numberThread.start();
	}
}
