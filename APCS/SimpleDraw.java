/* Ruijing Li
 * Period 3
 * 3/18/14
 * Time Spent: 6 hours
 * This lab was really hard, using not only guis, but 
 * 2d arrays made it challenging to draw on the grid.
 * Huge problems I had were creating the grid itself and 
 * storing the data into a 2d Array which would be kept even
 * after repaint was called. However, I soon realized it was 
 * easy to solve especially by using an arraylist with my
 * own class defined so I could easily store coordinates and
 * color. Implementing colorchooser was a bit harder than I
 * expected but I am pleased with the result.
 */
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.colorchooser.*;

public class SimpleDraw  {
	JButton clearButton;
	JRadioButton red, green, blue, choseColor;
	boolean Yred = true;
	boolean Ygreen, Yblue, Ywhite;
	boolean draw;
	MySketchPad pad;
	int myX, myY;
	ArrayList<Ruijing_Coordinate> grid = new ArrayList<Ruijing_Coordinate>();
	int count; 
	JColorChooser cc;
	Color newColor;
	
	public static void main(String[] args){
		SimpleDraw d = new SimpleDraw();
	}

    public SimpleDraw() {
    	// Build JFrame and GUI components
		JFrame window = new JFrame("My Awesome SimpleDraw");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setBounds(200, 200, 500, 600);
		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(50, 50));
	    pad = new MySketchPad();
	  	pad.setMaximumSize(new Dimension(402, 402));
	  	pad.setPreferredSize(new Dimension(402, 402));
	  	
	  	JPanel buttonPanel = new JPanel();
	  	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
	  	TitledBorder b = new TitledBorder("Drawing Color");
	  	buttonPanel.setBorder(b);
	  	red = new JRadioButton("Red", true);
	  	green = new JRadioButton("Green");
	  	blue = new JRadioButton("Blue");
	  	choseColor = new JRadioButton("Choose Color");
	  	ButtonGroup group = new ButtonGroup();
	  	group.add(red);
	  	group.add(green);
	  	group.add(blue);
	  	group.add(choseColor);
	  	buttonPanel.add(red);
	  	buttonPanel.add(green);
	  	buttonPanel.add(blue);
	  	buttonPanel.add(choseColor);

	  	buttonPanel.setPreferredSize(new Dimension(500, 100));
	  	
	  	JPanel clear = new JPanel();
	  	clear.setMaximumSize(new Dimension(100, 100));
	  	clearButton = new JButton("CLEAR");
	  	clear.add(clearButton);
	  	
		// Create our custom MouseListener
		MyMouseListener m = new MyMouseListener();
  	
	  	// Register our JPanel to listen for events
	  	// Parameter 'm' means MyMouseListener handles the MouseListener code
	  	pad.addMouseListener(m);
	  	pad.addMouseMotionListener(m);
	  	red.addActionListener(m);
	  	green.addActionListener(m);
	  	blue.addActionListener(m);
	  	choseColor.addActionListener(m);
	  	clearButton.addActionListener(m);
	  	
	  	window.add(panel);
	  	window.add(pad);
	  	window.add(buttonPanel);
	  	window.add(clear);
	  	window.setVisible(true);
	}
    
    private class MyMouseListener extends MouseAdapter implements ActionListener, ChangeListener{
    	public void mouseClicked(MouseEvent e) {
    		myX = e.getX()- e.getX()%20;
    		myY = e.getY()- e.getY()%20;
    		
    		if(e.getButton() == MouseEvent.BUTTON1){
    			draw = true;
    			Ywhite = false;
    		}
    		else if(e.getButton() == MouseEvent.BUTTON3){
    			Ywhite = true;
    		}
    		pad.repaint();
    	}
    	
    	public void mouseDragged(MouseEvent e){
    		myX = e.getX()- e.getX()%20;
    		myY = e.getY()- e.getY()%20;
    		if((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) == MouseEvent.BUTTON1_DOWN_MASK){
    			draw = true;
    			Ywhite = false;
    		}
    		else if((e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) == MouseEvent.BUTTON3_DOWN_MASK){
    			Ywhite = true;
    		}
    		pad.repaint();
    	}
    	
    	public void actionPerformed(ActionEvent e){
    		
    		if(e.getSource() == clearButton){
    			draw = false;
    			pad.repaint();	
    		}
    		
    		if(e.getSource() == red){
    			Yred = true;
    			Ygreen = false;
    			Yblue = false;
    			Ywhite = false;
    		}
    		else if(e.getSource() == green){
    			Yred = false;
    			Ygreen = true;
    			Yblue = false;
    			Ywhite = false;
    		}
    		else if(e.getSource() == blue){
    			Yred = false;
    			Ygreen = false;
    			Yblue = true;
    			Ywhite = false;
    		}
    		else if(e.getSource() == choseColor){
    			JFrame colorPanel = new JFrame("Color");
    			colorPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				colorPanel.setResizable(true);
				colorPanel.setBounds(700, 200, 600, 400);
				cc = new JColorChooser();
				colorPanel.add(cc);
	  			colorPanel.setVisible(true);
	  			cc.getSelectionModel().addChangeListener(this);
    		}
    	}
    	
    	public void stateChanged(ChangeEvent e){
    		if(e.getSource() == cc.getSelectionModel()){
    			Yred = false;
    			Ygreen = false;
    			Yblue = false;
    			Ywhite = false;
    			newColor = ((ColorSelectionModel)(e.getSource())).getSelectedColor();
    		}
    	}
    }
    
    private class MySketchPad extends JPanel{
    	public void paintComponent(Graphics g){
    		setBackground(Color.white);
    		super.paintComponent(g);
    		Graphics2D g2 = (Graphics2D)g;
    		
    		for(int i = 0; i < 20; i++){
    			for(int j = 0; j < 20; j++){
    				g2.drawRect(20*i, 20*j, 20, 20); 
    			}
    		}
  
    		if(draw){
    			count = 0;
    			while(grid.size() != count){
    				int x = grid.get(count).getX();
    				int y = grid.get(count).getY();
    				Color c = grid.get(count).getColor();
    				g2.setColor(c);
    				if(g2.getColor() == Color.white){
    					g2.setColor(Color.white);
						g2.fillRect(x, y, 20, 20);
    				}
    				else{
    					g2.fillRect(x, y, 20, 20);
    				}
    				
    				g2.setColor(Color.black);
					g2.drawRect(x, y, 20, 20);
    				count++;
    			}
    			
    			if(Yred){
					g2.setColor(Color.red);	
				}
				else if(Ygreen){
					g2.setColor(Color.green);
				}
				else if(Yblue){
					g2.setColor(Color.blue);
				}
				else{
					g2.setColor(newColor);
				}
    			
				if(Ywhite){
					g2.setColor(Color.white);
					g2.fillRect(myX, myY, 20, 20);
					
					grid.add(new Ruijing_Coordinate(myX, myY, g2.getColor()));		
				}else{
					g2.fillRect(myX, myY, 20, 20);
					grid.add(new Ruijing_Coordinate(myX, myY, g2.getColor()));	
				}
				
				g2.setColor(Color.black);
				g2.drawRect(myX, myY, 20, 20);
	    	}else
	    		grid.clear();		
    	}
    }
}

class Ruijing_Coordinate{
	int myX;
	int myY;
	Color myC;
	
	public Ruijing_Coordinate(int x, int y, Color c){
		myX = x;
		myY = y;
		myC = c;
	}
	
	public int getX(){
		return myX;
	}
	
	public int getY(){
		return myY;
	}
	
	public Color getColor(){
		return myC;
	}
}