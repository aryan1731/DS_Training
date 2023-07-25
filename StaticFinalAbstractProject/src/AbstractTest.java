
public class AbstractTest {
	public static void main(String[] args) {
		
	}
}
abstract class GeometricalShape{
	abstract void draw();
	abstract void calcArea();
	abstract void calcPerimeter();
	
}

class Square extends GeometricalShape{
	int side;
	
	
	public Square(int side) {
		super();
		this.side = side;
	}
	
	
	void draw() {
		
	}
	
	public int getSide() {
		return side;
	}


	void calcArea() {
		float area =side*side;
		System.out.println("Square area : "+area);
		
	}
	void calcPerimeter() {
		float perimeter = 4*side;
		System.out.println("Square perimeter : " +perimeter);
	}
	
	

}

class Rectangle extends Square{
	int breadth;

	public Rectangle(int side, int breadth) {
		super(side);
		this.breadth = breadth;
	}
	
	void calcArea() {
		float area = getSide()*breadth;
		System.out.println("area of the rectangle ;" +area);
	}
	
	void calcPerimeter() {
		float perimeter = 2*(getSide() + breadth);
		System.out.println("Perimeter of Rectangle : "+perimeter);
	}
}