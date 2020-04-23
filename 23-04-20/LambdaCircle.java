interface Circle {
	double area(double r);
}

public class LambdaCircle {
	public static void main(String[] args) {

		Circle circle=(double r)-> (Math.PI*r*r);
		
		System.out.println("Area of Circle = "+circle.area(5));
	}
}