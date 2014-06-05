package homework2Kruskals;


/**
 * KruskalSolver.java
 * 
 * @author Miles
 * @version 6/1/14
 */
public class Point {
	
	private int pointNumber;
	private int xCoordinate;
	private int yCoordinate;
	
	public Point (int pointNumber, int x, int y) {
		this.pointNumber = pointNumber;
		this.xCoordinate = x;
		this.yCoordinate = y;
	}

	public int getPointNumber () {
		return this.pointNumber;
	}
	
	public int getXCoordinate () {
		return this.xCoordinate;
	}
	
	public int getYCoordinate () {
		return this.yCoordinate;
	}
}
