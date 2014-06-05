package homework2Kruskals;

import java.lang.Math;

/**
 * KruskalSolver.java
 * 
 * @author Miles
 * @version 6/1/14
 */
public class KruskalsSolver {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public double computeDistance (Point a, Point b) {
		double part1 = 0;
		part1 = ((a.getXCoordinate() - b.getXCoordinate())*(a.getXCoordinate() - b.getXCoordinate())) + ((a.getYCoordinate() - b.getYCoordinate())*(a.getYCoordinate() - b.getYCoordinate()));
		return sqrt(part1);
	}
}
