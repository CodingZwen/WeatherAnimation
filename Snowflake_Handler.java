import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class Snowflake_Handler extends Node {
Timer move;

	ArrayList<Snowflake> schnee;
	int screenx;
	int screeny;
	
	int mouseposx=0;
	int mouseposy=0;
	
	
	float snowlevel = 10.0f;
	float faktor = 1.1f;
	
	
	
	private Comparator<Node> nodeSorter = new Comparator<Node>() {
		public int compare(Node lhs, Node rhs) {
		if(lhs.fCost < rhs.fCost)return +1;
		if(lhs.fCost > rhs.fCost)return -1;
		
		
			return 0;
		}
	};
	
	
	public Snowflake_Handler() {

		schnee = new ArrayList<Snowflake>();
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				for (int i = 0; i < schnee.size(); i++) {
					
					if(schnee.get(i).checkcollision(0,300,800,(int)snowlevel)){
						schnee.get(i).setcollide();
						snowlevel -=faktor;
						
						
						if(!schnee.get(i).iscolliding())pop();
						
					}
					
					if(schnee.get(i).checkcollision(mouseposx,mouseposy,50,50)){
						//System.out.print("Collision Mit Mauszeiger\n");
						schnee.get(i).setColor(Color.red);
					}else 
					{
						schnee.get(i).setColor(Color.WHITE);
					}
					
					//
					Point location = MouseInfo.getPointerInfo().getLocation();
					schnee.get(i).update(new Vector2i(location.x,location.y));
					collide();
				}

			}

		}, 0, 50);

	}
	
	void init(int screenwidth,int screenheight,int count) {
		
		screenx = screenwidth;
		screeny= screenheight;
		
		for(int i =0;i < count;i++){
			
			Snowflake sf = new Snowflake(screenwidth,screenheight);
			schnee.add(sf);
		}
		
	}
	
	public void pop(){
		
		Snowflake sf = new Snowflake(screenx,screeny);
		schnee.add(sf);
	}
	
	public void collide()
	{
		for (int i = 0; i < schnee.size(); i++) {
			
			for (int j = i+1; j < schnee.size(); j++) {
				
				if(schnee.get(i).checkcollision(schnee.get(j).x, schnee.get(j).y, 5,5) )
				{
					schnee.get(i).setColor(Color.green);
					schnee.get(j).setColor(Color.magenta);
				}
			}
		}
		
	}
	
	private double getDistance(Vector2i start, Vector2i goal)
	{
		double dx = start.getX() - goal.getX();
		double dy = start.getY() - goal.getY();
		
		return Math.sqrt(dx*dx+dy*dy);
	}
	
	private boolean vecInList(List<Node> list, Vector2i vector)
	{
		for(Node n : list)
		{
			if(n.coords.equals(vector)) return true;
		}
		
		return false;
		
	}
	
	public List<Node> findPath(Vector2i start, Vector2i goal)
	{
		List<Node> openList = new ArrayList<Node>();
		List<Node> closedList = new ArrayList<Node>();
		
		Node current = new Node(start,null,0,getDistance(start,goal));
		openList.add(current);
		
		while(openList.size()>0 )
		{
			Collections.sort(openList, nodeSorter);
			current = openList.get(0);
			
			
			if(current.equals(goal))
			{
				//finish
				List<Node> path = new ArrayList<Node>();
				while(current.parent != null)
				{
					path.add(current);
					current = current.parent;
					
				}
				
				openList.clear();
				closedList.clear();
				return path;
			}
			
			openList.remove(current);
			closedList.add(current);
			
			for(int i =0;i < 9;i++){
				if(i ==4)continue;
				int x = current.getX();
				int y = current.getY();
				int xi = (i % 3)-1; //geht der reihe nach die nachbarn ab
				int yi = (i / 3)-1;
				
				Vector2i at = new Vector2i(x+xi,y+yi); //nachbar von current
				//hier maybe testen ob collide bzw. ob tile an obstacle oder
				//bei array out of bounds
				double gCost = current.gCost + getDistance(current.coords,at);
				double hCost = getDistance(at,goal);
				
				Node node = new Node(at,current,gCost,hCost);
				//wenn node in liste
				if(vecInList(closedList,at) && gCost >= node.gCost)continue;
				//wenn es nicht in der open list ist, f�gen wir es hinzu
				if(!vecInList(openList,at) || gCost < current.gCost)openList.add(node);
				
				
				
			}
			
		}
		
		
		closedList.clear();
		return null;
		
	}
	

}
