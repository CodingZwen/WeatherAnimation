
import java.awt.Color;


import java.util.Random;


public class Snowflake  {

	int x,y;
	int width =1;
	int height= 1;
	int ratio=5;
	int screenx, screeny;
	float angle=90;
	double dx;
	double dy;
	double speed=10;
	float RADIANT = 0.017453f;
	Random rand = new Random();
	boolean colliding= false;
	boolean havetarget= true;
	Color c;
	Vector2i target;
	boolean visible = true;
	
	
	public Color getcollidecolor(){ return new Color(255,0,0,255);}
	public Color getnormalcolor(){ return new Color(255,255,255,255);}
	
	public Snowflake(int screenwidth, int screenheight) {
		
		x = rand.nextInt(screenwidth);
		speed = rand.nextInt(3)+2;
		y = rand.nextInt(screenheight);
		screenx=screenwidth;
		screeny=screenheight;
		c = Color.white;
	}
	
	public double getDistance(int targetx, int targety)
	{
		int dx = x - targetx;
		int dy = y - targety;
		
		return Math.sqrt((dx*dx)+ (dy*dy));
	}
	
	public double getDistanceInt(int targetx, int targety)
	{
		int dx = x - targetx;
		int dy = y - targety;
		
		return Math.sqrt((dx*dx)+ (dy*dy));
	}
	
	public void setColor(Color _c)
	{
		c = _c;
	}
	
	public void update(Vector2i mousepos) {
		
		
		if(!havetarget)BehaveLikeSnowFlake();
		else BehaveFollowVector(mousepos);
		
		checkbounds();
		
	}
	
	public void BehaveFollowVector(Vector2i target)
	{
		
		
		if(x < target.getX())x+=speed;
		if(x > target.getX())x-=speed;

		if(y < target.getY())y+=speed;
		if(y > target.getY())y-=speed;
		
	}
	
	public void BehaveLikeSnowFlake()
	{
		if(!colliding){
			angle = rand.nextInt(105)+35;
			dx = Math.cos(angle*RADIANT) * speed; //bei 0 also nach rechts kommt hier cos =1 raus
			dy = Math.sin(angle*RADIANT) * speed; //hier kommt bei angle 0, also sin 0 = 0 raus deswegen nach rechts
			x += dx;
			y += dy;
			
			}
	}
	
	boolean iscolliding(){return colliding;}
	void setcollide(){colliding = true;}
	void setnotcollide(){colliding = false;}
	
	public void checkbounds() {
		
		if(x>screenx || x<0 || y > screeny)
		{
			x = rand.nextInt(screenx);
			speed = rand.nextInt(3)+2;
			y = rand.nextInt(2)-1;
			
		}
	}
	
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
