
public class Node extends Vector2i {

	Vector2i coords;
	public Node parent;
	public double fCost, gCost, hCost;
	
	public Node(Vector2i coords, Node parent, double gCost, double hCost) {
		// TODO Auto-generated constructor stub
		this.coords = coords;
		this.parent = parent;
		this.gCost = gCost;
		this.hCost = hCost;
		this.fCost = this.gCost + this.hCost;
		
		
	}
	
	public boolean equals(Vector2i obj)
	{
		if(coords.getX() == obj.getX() && coords.getX() == obj.getY())return true;
		
		return false;
	}

	
	public Node()
	{}

}
