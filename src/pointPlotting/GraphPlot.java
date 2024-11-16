package pointPlotting;
import java.awt.*;
import java.util.ArrayList;

public class GraphPlot {
	ArrayList<Point> points;
	int x,y,width,height;
	Color colour, frameColour;
	int windowHeight;
	int windowWidth;
	
	public GraphPlot(ArrayList<Point> points, int x, int y, int height, int width, Color colour, Color frameColour) {
		// Constructor for LineGraph class
		this.points = points; // Assign the list of data points
		this.x = x; // Set the x-coordinate of the graph
		this.y = y; // Set the y-coordinate of the graph
		this.width = width; // Set the width of the graph
		this.height = height; // Set the height of the graph
		this.colour = colour; // Set the color of the graph
		this.frameColour = frameColour; // Set the color of the graph's frame
	}
	
	public void graphPoints(Graphics g) {
		g.setColor(colour); // Set Point Color
		
		double xFactorDilation = (double) width / (getDomainMaximum();
		double yFactorDilation = (double) height / getRangeMaximum();
		
		for (int i = 0; i < points.size(); i++) {
			g.fillOval(
					(int) Math.round(points.get(i).getX() * xFactorDilation) + ((windowWidth - width) / 2),
					(int) (windowHeight/2 - (points.get(i).getY() * yFactorDilation + ((windowHeight - height) / 2))) + 8, 5, 5);
		}
	}
	
	public void setColour(Color colour, Color frameColour) {
		this.colour = colour; // Set the color of the graph
		this.frameColour = frameColour; // Set the color of the graph's frame
	}
	
	public void drawAxis(Graphics g) {
		g.setColor(frameColour); // Set the color for drawing the graph's frame
		
		// Draw the vertical axis
		g.drawLine(x + (width/2), y, x + (width/2), y + height);
		
		// Draw the horizontal axis
		g.drawLine(x, y + height/2, x + width, y + height/2);
	}
	
	public void updateArray(ArrayList<Point> destArray) {
		this.points = destArray; // Update the data points array
	}
	
	public void updateSize(int width, int height) {
		this.width = width; // Update the width of the graph
		this.height = height; // Update the height of the graph
	}
	
	public void updateWindowSize(int width, int height) {
		windowWidth = width; // Update the width of the window
		windowHeight = height; // Update the height of the window
	}
	
	public void reset(Point yIntercept) {
		this.points.clear(); // Clear the data points list
		this.points.add(yIntercept); // Add the specified y-intercept point to the list
	}
	
	public double getRangeMaximum() {
		double max = points.get(0).getY(); // Initialize the maximum value with the y-value of the first point
		
		// Iterate over the points list to find the maximum y-value
		for (int i = 0; i < points.size() - 1; i++) {
			if (points.get(i).getY() > max) {
				max = points.get(i).getY();
			}
		}
		return max; // Return the maximum y-value
	}
	
	public double getDomainMaximum() {
		double max = points.get(0).getX(); // Initialize the maximum value with the x-value of the first point
		
		// Iterate over the points list to find the maximum x-value
		for (int i = 0; i < points.size() - 1; i++) {
			if (points.get(i).getX() > max) {
				max = points.get(i).getX();
			}
		}
		return max; // Return the maximum x-value
	}
	
	public double 
}
