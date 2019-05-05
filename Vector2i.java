
public class Vector2i {

	
	private int x,y;
	
	public Vector2i() {
		// TODO Auto-generated constructor stub
	set(0,0);
	}
	
	public Vector2i(Vector2i vector)
	{
		set(vector.x,vector.y);
	}
	

	public Vector2i(int x, int y)
	{
		set(x,y);
	}
	
	public boolean equals(Vector2i lhs, Vector2i rhs)
	{
		if(lhs.getX() == rhs.getX() && lhs.getX() == rhs.getY())return true;
		
		return false;
	}


	public void set(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
	
	public int getX()
	{return x;}
	
	public int getY()
	{return y;}
	
	public Vector2i getXY()
	{
		return new Vector2i(x,y);
	}


}
