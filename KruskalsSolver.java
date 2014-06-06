package homework2Kruskals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		
		//mark the current point so it can be reset after the test for file content in the while
		//loop below.
		input.mark(1);
		
		//while there is still content to be read in the input file
		while (input.readLine() != null) {
			
			//reset the marker to point to the beginning of the file.
			input.reset();
			
			//Scan the first line of the test case into a variable representing the number of points
			//in the test case.
			int numOfPoints = 0;
			numOfPoints = Integer.parseInt(input.readLine());
			
			//System.out.println(numOfPoints);
			
			DisjointSet points = new DisjointSet(numOfPoints);
			
			int i;
			//loop through each line of the current test case and fill the DisjointSet's array of
			//points.
			for (i = 0; i < numOfPoints; i++) {
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
			
			double edgeWeightNeeded = 0;
			//While some points are part of different sets, run findBestEdge weight and add that to
			//the edgeWeightNeeded variable. Once all points are part of the same set, the 
			//edgeWeightNeeded variable is complete and the answer to the problem has found.
			while (allPointsConnected(points, numOfPoints) == false) {
				edgeWeightNeeded = edgeWeightNeeded + findBestEdgeWeight(points, numOfPoints);
			}
			
			System.out.println(edgeWeightNeeded);
			//input.mark(1);
			
			try {
				input.mark(1); //mark the start of the next test case.
			} catch (Exception e) {
				
			}
			
		}
		
	}

	
	public static boolean allPointsConnected (DisjointSet points, int numOfPoints) {
		int setTest = -1; //used to test to see whether all points are part of the same set.
		int shareASet = 0; //represents the amount of points that share a set.
		boolean allPointsConnected = false;
		
		//loop through each points checking to see if the points shares the same point as
		//the previous tested. If so
		for (int i = 0; i < numOfPoints; i++) {
			//If the first point is being looked at
			if (setTest == -1) {
				setTest = points.find(points.getPointAtIndex(i));
				shareASet++;
			} else {
				//if the point being looked at shares the same set as previously examined point.
				//increment shareASet.
				if (setTest == points.find(points.getPointAtIndex(i)))
					shareASet++;
			}
		}
		
		if (shareASet == numOfPoints)
			allPointsConnected = true;
		
		return allPointsConnected;
	}
	
	public static double findBestEdgeWeight (DisjointSet points, int numOfPoints) {
		boolean setsJoined = false;
		int edgeStart = -1;
		int edgeEnd = -1;
		double bestEdgeWeight = -1;
		for (int i = 0; i < numOfPoints; i++) {
			for (int j = 0; j < numOfPoints; j++) {
				
				//If comparing two different points or if the set that point i belongs to is different than
				//the set that point j belongs to (CYCLE DETECTION: if the two points are part of the same set,
				//don't bother checking the edge between them, as it would create a cycle)
				if (i != j && points.find(points.getPointAtIndex(i)) != points.find(points.getPointAtIndex(j))) {
					//if no edges have been compared yet or the new edge has a greater weight than
					//the old edge, set bestEdgeWeight equal to the new edge. (EDGE SORTING)
					if (bestEdgeWeight == -1 || bestEdgeWeight > computeDistance(points.getPointAtIndex(i), points.getPointAtIndex(j))) {
						bestEdgeWeight = computeDistance(points.getPointAtIndex(i), points.getPointAtIndex(j));
						edgeStart = i;
						edgeEnd = j;
					} 
				}
				
			}
		}
		
		setsJoined = points.union(points.getPointAtIndex(edgeStart), points.getPointAtIndex(edgeEnd));
		return bestEdgeWeight;
	}
	
	public static double computeDistance (Point a, Point b) {
		double part1 = 0;
		part1 = ((a.getXCoordinate() - b.getXCoordinate())*(a.getXCoordinate() - b.getXCoordinate())) + ((a.getYCoordinate() - b.getYCoordinate())*(a.getYCoordinate() - b.getYCoordinate()));
		return Math.sqrt(part1);
	}
	
}
