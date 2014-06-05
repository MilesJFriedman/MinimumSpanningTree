package homework2Kruskals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * KruskalSolver.java
 * 
 * @author Miles
 * @version 6/1/14
 */
public class KruskalsSolver {

	
	public static void main(String[] args) throws Exception {
		//Create a new buffered reader for the input file.
		BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Miles\\workspace\\COP3503 - Computer Science II\\src\\homework2Kruskals\\input.txt"));
		
		//Scan the first line of the test case into a variable representing the number of points
		//in the test case.
		int numOfPoints = 0;
		numOfPoints = Integer.parseInt(input.readLine());
		
		//System.out.println(numOfPoints);
		
		DisjointSet points = new DisjointSet(numOfPoints);
		
		//loop through each line of the current test case and fill the DisjointSet's array of
		//points.
		for (int i = 0; i < numOfPoints; i++) {
			//read in the next line of the input file as a string
			String line = input.readLine();
			//parse the string using the split function
			String[] tokens = line.split(" ");
			
			//Create a new point based on the scanned in information and add that point to the
			//DisjointSet's set array.
			Point p = new Point(i, Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			points.insert(p, i);
			
			//System.out.println(points.getPointAtIndex(i).getSetNumber());
			//System.out.println(p.getSetNumber());
		}
		
		
		
	}

	
	/*public double findBestEdgeWeight (DisjointSet points, int numOfPoints) {
		for (int i = 0; i < numOfPoints; i++) {
			for (int j = 0; j < numOfPoints; j++) {
				//Only find the edge weight between different points
				if (i != j) {
					
				}
			}
		}
	}*/
	
	public double computeDistance (Point a, Point b) {
		double part1 = 0;
		part1 = ((a.getXCoordinate() - b.getXCoordinate())*(a.getXCoordinate() - b.getXCoordinate())) + ((a.getYCoordinate() - b.getYCoordinate())*(a.getYCoordinate() - b.getYCoordinate()));
		return Math.sqrt(part1);
	}
}
