package gext;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class x extends JFrame {

	public x () {
		super("I am a circle");
		
		addComponentListener(new ComponentAdapter() {
            // Give the window an elliptical shape.
            // If the window is resized, the shape is recalculated here.
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
            }
        });
		//Image i =  new Image();
		try {
			URL hi = this.getClass().getResource("/can.png");
			///Users/katherine/Documents/workspace-e/test/can.png"
			final Image i = ImageIO.read(hi);
			// /
			Image newimg = i.getScaledInstance(100 , 100,  java.awt.Image.SCALE_SMOOTH ) ;
			ImageIcon first= new ImageIcon( newimg );
			
			setContentPane(new JLabel(first));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		//ImageIcon first = new ImageIcon("/Users/katherine/Documents/workspace-e/test/can.png");
		//Image i = first.getImage();
		//Image newimg = i.getScaledInstance(100 , 100,  java.awt.Image.SCALE_SMOOTH ) ;
		//first= new ImageIcon( newimg );
		//setContentPane(new JLabel(first));
		
		
		setUndecorated(true);
        setSize(100,100);
        //setForeground(Color.blue);
        setOpacity(0.9f);
        
        
        setLocation(50,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(false);
		
	}
	
}
