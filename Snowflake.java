
import java.awt.Color;


import java.util.Random;


public class Snowflake  {

	int x,y;
	int width =1;
	int height= 1;
	int ratio;
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
	public enum KiStates  { HAVETARGET,SNOWLIKE,INPUT}
	KiStates modi = KiStates.INPUT;

	
	
	
	public Color getcollidecolor(){ return new Color(255,0,0,255);}
	public Color getnormalcolor(){ return new Color(255,255,255,255);}
	
	public Snowflake(int screenwidth, int screenheight, int ratio) {
		
		this.ratio = ratio;
		x = rand.nextInt(screenwidth);
		speed = rand.nextInt(3)+2;
		y = rand.nextInt(screenheight);
		screenx=screenwidth;
		screeny=screenheight;
		c = Color.white;
	}
	
	public void changeKi(int KI)
	{
		if(KI>2)return;
		
		
		switch(KI)
		{
		case 0 : modi = KiStates.HAVETARGET;break;
		case 1 : modi = KiStates.SNOWLIKE;break;
		case 2 : modi = KiStates.INPUT;break;
		
		
		
		}
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
		this.c = _c;
	}
	
	public void update(Vector2i mousepos) {
		
		
		switch(modi)
		{
		case HAVETARGET : BehaveFollowVector(mousepos);break;
		case SNOWLIKE : BehaveLikeSnowFlake();break;
		case INPUT : break;
		default:break;
		
		}
		
	
		
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
		
		
			angle = rand.nextInt(105)+35;
			dx = Math.cos(angle*RADIANT) * speed; //bei 0 also nach rechts kommt hier cos =1 raus
			dy = Math.sin(angle*RADIANT) * speed; //hier kommt bei angle 0, also sin 0 = 0 raus deswegen nach rechts
			x += dx;
			y += dy;
	
			
			
	}
	
	void moveRight()
	{
		x+=speed;
	}

	void moveLeft()
	{
		x-=speed;
	}
	
	
	void moveUp()
	{
		y-=speed;
		
	}
	
	void moveDown()
	{
		y+=speed;
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
	
	//checks own collsion with target
	public boolean checkcollision(int x, int y, int width, int height)
	{

		boolean collide = false;

		if (this.x <= x + width && this.x + this.width >= x && this.x>= x
				&& this.y <= y + height && this.height + this.y >= y)
		{
			collide = true;
			// System.out.println("collisjon :D");

		} else if (this.x+this.height <= x + width && this.x + this.width >= x
				&& this.y <= y + height && this.height + this.y >= y)
		{
			collide = true;
		}
		
		
		return collide;

	}

}




/*
 * 
 * boolean collide = false;
		
		if (this.x <= x + width &&
			this.x + this.width >= x &&
			this.y <= y + height &&
			this.height + this.y >= y) {
		
			//System.out.println("collisjon :D");
			return true;
		}else return false;
 * */
