
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

public class malFunktion extends JLabel{

	Snowflake_Handler sh = new Snowflake_Handler();
	boolean paintsnow = true;
	boolean paintMouseRect = true;
	double faketimer=110;
		
	
	public malFunktion() {
			sh.init(800,650, 100);	
			this.setBackground(Color.black);
			
			
		
	}
	

	public void GiveMousePosSnowHandler(int x,int y)
	{
		sh.mouseposx = x;
		sh.mouseposy = y;
	}
	
 
	protected void paintComponent(Graphics g) {
		if(paintsnow)paint_snow2(g);
		
		if(paintMouseRect)paintMouseCollideRect(g);
		
		repaint();	
		
  	}
	
	void paintMouseCollideRect(Graphics g)
	{
		
		g.setColor(new Color(210,10,10,122));
		g.drawOval(sh.mouseposx, sh.mouseposy, 50, 50);
		
		
	}
	
	void paint_snow2(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, sh.screenx,sh.screeny);
		
		
		for (int i = 0; i < sh.schnee.size(); i++) {

			g.setColor(sh.schnee.get(i).c);
			
			
			
			if(sh.schnee.get(i).visible == true)
			{
			g.fillRect(sh.schnee.get(i).x, sh.schnee.get(i).y,
					sh.schnee.get(i).ratio, sh.schnee.get(i).ratio);
			}else 
			{
				
			}

		}
			
	}
	
	
	
	@Override
  	public Dimension getPreferredSize() {
  	    return new Dimension(790,650);
  	}
  	

}

