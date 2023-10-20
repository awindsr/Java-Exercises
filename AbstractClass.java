abstract class shape{
	public abstract void numberofSides();
}

class Rectangle extends Shape{
	public void numberofSides() {
		System.out.println("Rectangle has 4 sides");
	}
}

class Triangle extends Shape{
	public void numberofSides() {
		System.out.println("Triangle has 3 sides");
	}
}
class Hexagon extends Shape{
	public void numberofSides() {
		System.out.println("Hexagon has 6 sides");
	}
}

public class AbstractClass {
	public static void main(String [] args) {
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();
		Hexagon hexagon = new Hexagon();
		
		rectangle.numberofSides();
		triangle.numberofSides();
		hexagon.numberofSides();

	}
}



