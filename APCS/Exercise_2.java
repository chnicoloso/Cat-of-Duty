/* Ruijing Li
 * Period 3
 * 3/6/14
 * Time Spent: 5 hours
 * I actually had a rough time with this lab, spending
 * so many hours on it. Mostly my drawing skills were 
 * already rough, but I was confused at the new material
 * we had to use. Later on, the graphics method became easier 
 * to use, but it was a challenge creating all these shapes.
 * All in all, I had a rough start getting into graphics 
 * and GUIS. 
 */

// import libraries
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Exercise_2 {

	public static void main(String[] args) {

		// Create a basic Java window frame
		JFrame window = new JFrame("My Window Title");

		// Decide what to do when the user closes the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the window size (see API)
		window.setBounds(200, 200, 640, 480);

		// Prevent users from resizing the window
		window.setResizable(false);

		// Create GUI components.
		// For us, create a custom JPanel to draw on.
		MySketchPad panel = new MySketchPad();

		// Add GUI components to the JFrame (window)
		window.add(panel);

		// Make the window visible
		window.setVisible(true);
	}
}

/*
   A JPanel is like a SketchPad in the sense that you can
   draw on it.  It's more powerful though, because it has
   more capabilities than a SketchPad, such as the ability
   to add buttons and GUI elements.  And you can add
   JPanels to JPanels.
*/
class MySketchPad extends JPanel {

	public void paintComponent(Graphics g) {

		// Set the background color to white (do this yourself)
		setBackground(Color.white);

		// Ask our parent to paint itself
		super.paintComponent(g);

		// Next, cast the Graphics parameter back into what
		// it really is - a more powerful Graphics2D object.
		// Or, if you want, you can leave it as a Graphics
		// and only use Graphics class methods.
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth();
		int h = getHeight();
		
		// Finally, draw stuff
		//Problem a
		int rw = w/6;
		int rh = h/6;
		int or = rh*3/4; 
		g.drawOval(w/12 + rw/4, h/8 - or, or, or);
		g.drawRect(w/12, h/8, rw, rh);
		
		//Problem b
		g.setColor(Color.black);
		g.fillRoundRect(w/3, h/12, w/6, w/6, w/8, w/8);
		g.setColor(Color.white);
		g.fillOval(w/3, h/12, w/12, w/12);
		g.fillOval(w/3 + w/12, h/12, w/12, w/12);
		g.fillOval(w/3, h/12 + w/12, w/12, w/12);
		g.fillOval(w/3 + w/12, h/12 + w/12, w/12, w/12);
		
	
		//Problem c
		int[] xlist = {w/2+w/12, w/2 + w/6, w/2 + w/4, w/2 + w/6};
		int[] ylist = {h/4, h/4 - h/9, h/4, h/4 + h/9};
		g.setColor(Color.black);
		g.fillPolygon(xlist, ylist, 4);
		
		//Problem d
		g.drawOval(w/24, h/2, w/15, w/15);
		g.drawOval(w/24 + w/100, h/2 + w/100, 3*w/60, 3*w/60);
		g.drawOval(w/6, h/2, w/15, w/15);
		g.drawOval(w/6 + w/100, h/2 + w/100, 3*w/60, 3*w/60);
		g.drawLine(w/24+w/30, h/2, w/6+w/30, h/2);
		g.drawLine(w/24+w/30, h/2+w/15, w/6+w/30, h/2 + w/15);
		
		//Problem e
		int deltaY = h/2;
		g.drawOval(w/2, deltaY, w/24, w/24);
		deltaY += w/56;
		for(int i = 0; i < 4; i++){
			
			if(i %2 == 0){
				g.drawOval(w/2-3*w/24/6- w/108, deltaY, w/24, w/24);
			}else{
				g.drawOval(w/2+3*w/24/6 + w/108, deltaY, w/24, w/24);
				deltaY += w/24-w/56+w/108;
			}
			
		}
		g.setFont(new Font("Serif", Font.BOLD, 15));
		g.drawOval(w/2, deltaY-w/20, w/24, w/24);
		g.drawOval(w/2, deltaY-w/56, w/24, w/24);
		g.drawString("Sunshines", w/2-3*w/24/6- w/96, deltaY+w/16);
		
		
		//Problem f
		int diameter = w/6;
		g.drawOval(3*w/4, h/2, diameter, diameter);
		int jdiameter = (int)(0.75*diameter);
		g.fillOval(3*w/4 + diameter/2-jdiameter/2, h/2 + diameter/2-jdiameter/2, jdiameter, jdiameter);
		g.setColor(Color.white);
		g.setFont(new Font("SansSerif", Font.PLAIN, 75));
		g.drawString("J", 3*w/4 + diameter-jdiameter, h/2 + diameter-jdiameter/3);
	
		//Problem g
		g.setColor(Color.black);
		g.drawArc(w/12, h*3/4, w/6, w/6, 90, 270);
		g.drawLine(w/6, h*3/4, w/6, h*3/4 + w/12);
		g.drawLine(w/6, h*3/4 + w/12, w/6+w/12, h*3/4 + w/12);
		
		//Problem h
		g.drawOval(w/2, h*3/4, w/6, w/6);
		g.drawOval(w/2 + w/24, h*3/4 + w/24, w/48, w/48);
		g.drawOval(w/2 + w/12 + w/48, h*3/4 + w/24, w/48, w/48);
		g.drawArc(w/2 + w/12-w/30, h*3/4 + w/12 +w/36, w/14, w/56, 180, 180);
	}
}