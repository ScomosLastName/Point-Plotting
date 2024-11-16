package pointPlotting;

public class Point {
	double x; // x-coordinate of the point
	double y; // y-coordinate of the point
	
	public Point(double x, double y) { // Constructor for Point class, runs on initialization
		this.x = x; // Set the x-coordinate of the point
		this.y = y; // Set the y-coordinate of the point
	}
	
	public double getX() {
		return x; // Return the x-coordinate of the point
	}
	
	public double getY() {
		return y; // Return the y-coordinate of the point
	}
}
