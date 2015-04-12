package gext;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class circle extends JFrame{
	
	public int pX;
	public int pY;
	
	public circle(int x, int y) {
		super("I am a circle");
		
		addComponentListener(new ComponentAdapter() {
            // Give the window an elliptical shape.
            // If the window is resized, the shape is recalculated here.
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
            }
        });
		
		addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                // Get x,y and store them
                pX=me.getX();
                pY=me.getY();
            }
        });
		
		addMouseMotionListener(new MouseAdapter(){
			 public void mouseDragged(MouseEvent me)
	            {
	                // Set the location
	                // get the current location x-co-ordinate and then get
	                // the current drag x co-ordinate, add them and subtract most recent
	                // mouse pressed x co-ordinate
	                // do same for y co-ordinate
	                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
	            }
		});
		
		//String path = "fox_y.jpg";
		
		ImageIcon first = new ImageIcon("fox_y.jpg");
		Image img = first.getImage() ;  
		Image newimg = img.getScaledInstance(300 , 300,  java.awt.Image.SCALE_SMOOTH ) ;
		first = new ImageIcon( newimg );
		
		setContentPane(new JLabel(first));
		
		setUndecorated(true);
        setSize(300,300);
        //setForeground(Color.blue);
        setOpacity(0.7f);
        
        
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}

}
