package drawing;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println(p1);

	Point p2 = new Point(5,10, true);
	System.out.println(p2);
	
	Line l1 = new Line(new Point(5,5), new Point(6,6), false);
	System.out.println(l1);
	
	Rectangle r1 = new Rectangle (new Point(5,5), 10, 20, false);
	System.out.println(r1);
	
	Circle c1 = new Circle (new Point(5,5), 10, false);
	System.out.println(c1);
	
	Donut d1 = new Donut (new Point(5,5), 10, 5, false);
	System.out.println(d1);
	}
}
