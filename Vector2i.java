
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
	
	public void setX(int x){this.x=x;}
	public void setY(int y){this.y=y;}
	
	
	public boolean euqals(Object object)
	{
		if(!(object instanceof Vector2i))return false;
		Vector2i vec = (Vector2i) object;
		if(vec.getX() == this.getX() && vec.getY() == this.getY())return true;
		return false;
	}
	
	public int getX()
	{return x;}
	
	public int getY()
	{return y;}
	
	public Vector2i getXY()
	{
		return new Vector2i(x,y);
	}

	public void setX(double x){this.x=(int)x;}
	public void setY(double y){this.y=(int)y;}


}
