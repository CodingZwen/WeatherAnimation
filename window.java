import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;



public class window extends JFrame implements ActionListener, MouseListener, MouseMotionListener {


	JPanel MalPanel ;
	JPanel ButtonUndTextPanel;
	JSplitPane splitPane;
	JTextField tf ;
	JButton button ;
	malFunktion mf;
	boolean clicked = false;
	
	public window() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 MalPanel = new JPanel();
		 ButtonUndTextPanel = new JPanel();
		 splitPane = new JSplitPane();
		 tf = new JTextField();
		// tf.addKeyListener(l);
		 button = new JButton("send");
		 mf = new malFunktion();
	    	MalPanel.add(mf);
	    	MalPanel.addMouseListener(this);
	    	MalPanel.addMouseMotionListener(this);
		
		this.setVisible(true);
		
		
		
		setPreferredSize(new Dimension(800,600));
		getContentPane().setLayout(new GridLayout()); 
		getContentPane().add(splitPane);  
		setVisible(true);
		
		
		//die splitpanels bekommen die top und bottom panels
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
	    splitPane.setDividerLocation(500);                    // the initial position of the divider is 200 (our window is 400 pixels high)
	    splitPane.setTopComponent(MalPanel);                  // at the top we want our "topPanel"
	    splitPane.setBottomComponent(ButtonUndTextPanel);   
	    
	   ButtonUndTextPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
	   ButtonUndTextPanel.setLayout(new BoxLayout(ButtonUndTextPanel, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally

	   ButtonUndTextPanel.add(tf);        // left will be the textField
	   ButtonUndTextPanel.add(button); 
	   
	   button.addActionListener(this);
	   
	   pack();
	
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		if(e.getSource() == this.button){
			
			String s = new String();
			s = tf.getText();
			System.out.println(s);
			
			if(s.contains("machschnee")) {
				mf.paintsnow=true;
			}
			
			
			if(s.contains("sommer")) {
				mf.paintsnow=false;
		
			}
			
	          
        }
		
		
		
		
	}
	

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//mf.sh.mouseposx = e.getX();
		//mf.sh.mouseposy = e.getY();
		
		clicked = true;
		System.out.println("mausgeklickt");
	
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		clicked = false;
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(clicked)
		{
		mf.sh.mouseposx = e.getX();
		mf.sh.mouseposy = e.getY();
		}
		
	}




	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}


