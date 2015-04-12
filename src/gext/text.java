package gext;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class text extends JFrame{
	
	public int pX;
	public int pY;
	
	public text(Color c, x xclose) {
		super("I am a text");
		
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
            
            public void mouseReleased(MouseEvent me) {
            	int rX = getLocation().x;//me.getX();
            	int rY = getLocation().y;//me.getY();
            	
            	if ( rX <= 150 && rY <= 150 ) {
            		dispose();
            	}
            	
            	xclose.setVisible(false);
            }
            
        });
		
		addMouseMotionListener(new MouseAdapter(){
			 public void mouseDragged(MouseEvent me)
	            {
	                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
	                xclose.setVisible(true);
	            }
		});
		
		
		setLayout(new GridBagLayout());
		JTextArea txtArea = new JTextArea(5, 50);
		txtArea.setBackground(Color.white);
		txtArea.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		txtArea.setLineWrap(true);
		
		//txtArea.setOpaque(true);
		
		//JPanel P1 = new JPanel();
		//P1.add(txtArea);
		//P1.setPreferredSize(new Dimension(5, 50));
		
		add(txtArea);		
		setUndecorated(true);
        
		
		setSize(200,200);
        //setOpacity(0.7f);
        setBackground(new Color(c.getRed(),c.getGreen(),c.getBlue(),180));
        
        setLocation(800,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //pack();
		
	}
	

}
