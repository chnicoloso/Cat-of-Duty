/* Ruijing Li 
 * Period 3
 * 3/13/14
 * Time Spent: 5 Hours
 * So long, wish GUIs did not take this long, wish I had 
 * more than one day to finish, sigh. Mouse event was pretty easy; however, 
 * LAYOUT MANAGERS ARE FRUSTRATING, in getting the position I want a component 
 * to be in.
 */

// import libraries
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class ClassworkGUI implements MouseListener {
	MySketchPad pad;
	boolean drawCircle, drawSq;
	int myX, myY;
	int sizeValue;
	JSlider slider;

	public static void main(String[] args) {
		ClassworkGUI gui = new ClassworkGUI();
		gui.createGUI();
	}

	public void createGUI() {
		// Create a basic Java window frame
		JFrame window = new JFrame("My Window Title");

		// Decide what to do when the user closes the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Get the screen dimensions
		int screenWidth = (int)(window.getToolkit().getScreenSize().getWidth());
		int screenHeight = (int)(window.getToolkit().getScreenSize().getHeight());
		// Our window size
		int frameWidth = 800;
		int frameHeight = 600;
		// Centers the JFrame, regardless of screen resolution
		window.setBounds(screenWidth/2 - frameWidth/2, screenHeight/2 - frameHeight/2, frameWidth, frameHeight);

		// Decide whether to allow users to resize the window
		window.setResizable(true);

		// Define the overall layout
		window.getContentPane().setLayout(new GridLayout(1, 3));
		// Create GUI components
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 225, 225));
		BevelBorder leftBorder = new BevelBorder(BevelBorder.LOWERED);
		leftPanel.setBorder(leftBorder);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel topLeft = new JPanel();
		topLeft.setMinimumSize(new Dimension(200, 150));
		topLeft.setPreferredSize(new Dimension(200, 150));
		topLeft.setMaximumSize(new Dimension(200, 150));
		topLeft.setBackground(Color.white);
		topLeft.setBorder(new LineBorder(Color.gray, 5, true));
		leftPanel.add(topLeft);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(null);
		JButton button1 = new JButton("Click me");
		JButton button2 = new JButton("Hit click...");
		JButton button3 = new JButton("STOP!!");
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		leftPanel.add(buttonPanel);
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new BorderLayout());
		sliderPanel.setBackground(null);
		slider = new JSlider(SwingConstants.VERTICAL);
		slider.setBackground(null);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(2);
		sliderPanel.add(slider);
		leftPanel.add(sliderPanel);

		//center
		JPanel middlePanel = new JPanel();
		Dimension size = middlePanel.getPreferredSize();
		middlePanel.setBackground(new Color(225, 255, 225));
//		EtchedBorder middleBorder = new EtchedBorder(EtchedBorder.RAISED);
//		middlePanel.setBorder(middleBorder);

		JPanel center = new JPanel();
		center.setMinimumSize(new Dimension(200, 300));
		center.setPreferredSize(new Dimension(200, 300));
		center.setMaximumSize(new Dimension(200, 300));
		center.setBackground(new Color(255, 250, 205));
		//center.setBorder(new TitledBorder("Blackboard"));
		
		middlePanel.add(center);

		//right
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBackground(new Color(225, 225, 255));
		EtchedBorder rightBorder = new EtchedBorder(EtchedBorder.LOWERED);
		rightPanel.setBorder(rightBorder);
		
		pad = new MySketchPad();
		rightPanel.add(pad);

		// Add GUI components to JFrame (window)
		window.add(leftPanel);
		window.add(middlePanel);
		window.add(rightPanel);
		
		
		// Make the window visible
		window.setVisible(true);
		
		//listeners
		rightPanel.addMouseListener(this);
	}
	
	//events
	public void mouseClicked(MouseEvent e){
		myX = e.getX();
		myY = e.getY();
		sizeValue = slider.getValue();
		if(e.getButton() == 1){
			drawCircle = true;
			drawSq = false;
		}
		else if(e.getButton() == 3){
			drawSq = true;
			drawCircle = false;
		}
		else{
			drawSq = false;
			drawCircle = false;
		}
		pad.repaint();
	}

	public void mouseEntered(MouseEvent e){
		System.out.println("Mouse Entered");
	}

	public void	mouseExited(MouseEvent e){
		System.out.println("Mouse Exited");
	}

	public void	mousePressed(MouseEvent e){
		System.out.println("Mouse Pressed");
	}

	public void	mouseReleased(MouseEvent e){
		System.out.println("Mouse Released");
	}

	private class MySketchPad extends JPanel{
		public void paintComponent(Graphics g) {

			// Set the background color to white (do this yourself)
			setBackground(null);
			// Ask our parent to paint itself
			super.paintComponent(g);
	
			// Next, cast the Graphics parameter back into what
			// it really is - a more powerful Graphics2D object.
			// Or, if you want, you can leave it as a Graphics
			// and only use Graphics class methods.
			Graphics2D g2 = (Graphics2D)g;
	
			// Finally, draw stuff
			if(drawCircle)
				g2.drawOval(myX-sizeValue/2, myY-sizeValue/2, sizeValue, sizeValue);
			else if(drawSq)
				g2.drawRect(myX-sizeValue/2, myY-sizeValue/2, sizeValue, sizeValue);
		}	
	} 
}