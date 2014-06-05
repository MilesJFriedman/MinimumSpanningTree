package homework2Kruskals;


/**
 * KruskalSolver.java
 * 
 * @author Miles
 * @version 6/1/14
 */
public class DisjointSet {

	private Point[] sets;
	
	public DisjointSet (int size) {
		this.sets = new Point[size];
	}//constructor
	
	
	/**
	 * union method:
	 * @param a the first Point to be compared
	 * @param b the second Point to be compared
	 * @return a true false value returning true if the points have been successfully 
	 * 		   joined in a set or false if the two points are already part of the same set.
	 */
	public boolean union (Point a, Point b) {
		boolean pointsJoined = false;
		
		//if the points are already part of the same set, they can't be joined. Otherwise, check
		//to see which points SetNumber is smaller as the smaller points SetNumber is the parent
		//point in the set (and influences the set name).
		if (a.getSetNumber() == b.getSetNumber())
			pointsJoined = false;
		else if (a.getSetNumber() < b.getSetNumber()) {
			b.changeSetNumber(a.getSetNumber());
			pointsJoined = true;
		} else if (a.getSetNumber() > b.getSetNumber()) {
			a.changeSetNumber(b.getSetNumber());
			pointsJoined = true;
		}
			
		return pointsJoined;
	}
	
	public int find (Point a) {
		return a.getSetNumber();
	}
	
	public void insert (Point a, int i) {
		this.sets[i] = a;
	}
	
	public Point getPointAtIndex (int i) {
		return this.sets[i];
	}
	
}

