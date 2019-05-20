import java.awt.Color;
import java.util.Random;


public class Entitys
{

	//int x,y;
	Vector2i pos;
	Vector2i target;
	int width =1;
	int height= 1;
	int ratio=50;
	Vector2i ScreenXY;
	
	float angle=90;
	double dx;
	double dy;
	int speed=10;
	float RADIANT = 0.017453f;
	Random rand = new Random();
	boolean colliding= false;
	boolean havetarget= true;
	Color c;
	
	boolean visible = true;
	
	
	public Entitys(Vector2i windowCoords)
	{
		pos.setX(rand.nextInt(windowCoords.getX()));
		pos.setY(rand.nextInt(windowCoords.getY()));
		speed = rand.nextInt(3)+2;
		ScreenXY.setX(windowCoords.getX());
		ScreenXY.setY(windowCoords.getY());
		c = Color.white;
	}
	

	public Color getcollidecolor(){ return new Color(255,0,0,255);}
	public Color getnormalcolor(){ return new Color(255,255,255,255);}
	
	
	
	public double getDistance(Vector2i target)
	{
		int dx = pos.getX() - target.getX();
		int dy = pos.getY() - target.getY();
		
		return Math.sqrt((dx*dx)+ (dy*dy));
	}
	
	
	
	public void setColor(Color _c)
	{
		this.c = _c;
	}
	
	public void update(Vector2i mousepos) {
		
		
		if(!havetarget)BehaveLikeSnowFlake();
		else BehaveFollowVector(mousepos);
		
		checkbounds();
		
	}
	
	
	//move funtkion machen also eine funktion bei der ich mir das gety scheisdreck spare
	public void BehaveFollowVector(Vector2i target)
	{
		
		
		if(pos.getX() < target.getX())pos.setX(pos.getX()+speed);
		if(pos.getX() > target.getX())pos.setX(pos.getX()-speed);

		if(pos.getX() < target.getY())pos.setY(pos.getY()+speed);
		if(pos.getY() > target.getY())pos.setY(pos.getY()-speed);
		
	}
	
	public void BehaveLikeSnowFlake()
	{
		if(!colliding){
			angle = rand.nextInt(105)+35;
			dx = Math.cos(angle*RADIANT) * speed; //bei 0 also nach rechts kommt hier cos =1 raus
			dy = Math.sin(angle*RADIANT) * speed; //hier kommt bei angle 0, also sin 0 = 0 raus deswegen nach rechts
			pos.setX(pos.getX()+dx);
			pos.setY(pos.getY()+dy);
			
			}
	}
	
	boolean iscolliding(){return colliding;}
	void setcollide(){colliding = true;}
	void setnotcollide(){colliding = false;}
	
	public void checkbounds() {
		
		if(pos.getX()>ScreenXY.getX() || pos.getX() <0 || pos.getY() > ScreenXY.getY())
		{
			pos.setX(rand.nextInt(ScreenXY.getX()));
			speed = rand.nextInt(3)+2;
			pos.setY( rand.nextInt(2)-1);
			
		}
	}
	
	//checks own collsion with target
	public boolean checkcollision(int x,int y, int width,int height){
		
		if (this.x < x + width &&
			this.x + this.width > x &&
			this.y < y + height &&
			this.height + this.y > y) {
		
			//System.out.println("collisjon :D");
			return true;
		}else return false;
	}

}
