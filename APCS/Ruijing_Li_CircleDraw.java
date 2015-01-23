/* Ruijing Li
 * Period 3
 * 3/12/14
 * Time Spent: 4 hours
 * OMG FINALLY DONE. Hardest part of lab was making GUI look 
 * polished. Took forever using layout managers. The action
 * events and change events were pretty easy to comprehend. 
 * Fun lab, but really wished there was a faster way to make 
 * the GUI. Also it is not as polished as the youtube demo.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ruijing_Li_CircleDraw implements ActionListener, ChangeListener {
	JButton drawButton;
	JButton clearButton;
	JToggleButton thickLine;
	JRadioButton red, green, blue;
	JSlider slider;
	JTextField textName;
	JTextArea info;
	MyJPanel sketchpad;
	JLabel thick, color, radius, name;
	boolean draw = false;
	boolean Yred = true;
	boolean Ygreen, Yblue;
	int radiusValue;
	JPanel rightPanel;
    
    public static void main(String[] args) {
    	Ruijing_Li_CircleDraw r = new Ruijing_Li_CircleDraw();
    	r.createGUI();
	}
    
    public Ruijing_Li_CircleDraw() {
    }
    
    public void createGUI(){
    	// Create a basic Java window frame
		JFrame window = new JFrame("Awesome Circle Draw");

		// Decide what to do when the user closes the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the window size (see API)
		window.setBounds(200, 200, 800, 400);

		// Prevent users from resizing the window
		window.setResizable(true);
		
		// Create GUI components.
		thick = new JLabel("Line Thickness", SwingConstants.LEFT);
		thickLine = new JToggleButton("THIN");
		
		color = new JLabel("Line Color", SwingConstants.LEFT);
		red = new JRadioButton("Red", true);
		green = new JRadioButton("Green");
		blue = new JRadioButton("Blue");
		ButtonGroup group = new ButtonGroup();
		group.add(red);
      	group.add(green);
      	group.add(blue);
      	
      	radius = new JLabel("Radius", SwingConstants.LEFT);
      	slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(10);
		slider.setMaximum(100);
		slider.setMajorTickSpacing(20);	
		radiusValue = slider.getValue();
			
		drawButton = new JButton("Draw");
		clearButton = new JButton("Clear");
		
		thickLine.addActionListener(this);
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		drawButton.addActionListener(this);
		clearButton.addActionListener(this);
		slider.addChangeListener(this);
		
		name = new JLabel("Enter Your Name Here");
		textName = new JTextField("HappySparky");
		textName.setMaximumSize(new Dimension(100, 25));

		info = new JTextArea("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  red.getText() + " circle of\nradius "  + radiusValue, 10, 20);
			
		//Layouts
		//left
		JPanel thickPanel = new JPanel();
		thickPanel.add(thickLine);
		
		JPanel colorPanel = new JPanel();
		colorPanel.add(red);
		colorPanel.add(green);
		colorPanel.add(blue);
		
		JPanel radiusPanel = new JPanel();
		radiusPanel.add(slider);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(drawButton);
		buttonPanel.add(clearButton);
		
		JPanel optionsPane = new JPanel();
		optionsPane.setLayout(new BoxLayout(optionsPane, BoxLayout.Y_AXIS));
		optionsPane.add(thick);
		optionsPane.add(thickPanel);
		optionsPane.add(color);
		optionsPane.add(colorPanel);
		optionsPane.add(radius);
		optionsPane.add(radiusPanel);
		optionsPane.add(buttonPanel);
		
		//center
		sketchpad = new MyJPanel();
		
		//right
		rightPanel = new JPanel();
		JPanel miniPanel = new JPanel();
		miniPanel.add(info);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(name);
		rightPanel.add(textName);
		rightPanel.add(miniPanel);
		
		//padding
		JLabel pad = new JLabel("\n\n\n\n");
		JLabel pad2 = new JLabel("\n\n");
		JPanel padding = new JPanel();
		JPanel padding2 = new JPanel();
		padding.add(pad);
		padding2.add(pad2);
		
		window.getContentPane();
		window.add(padding, BorderLayout.PAGE_START);
		window.add(padding2, BorderLayout.PAGE_END);
		window.add(optionsPane, BorderLayout.LINE_START);
		window.add(sketchpad, BorderLayout.CENTER);
		window.add(rightPanel, BorderLayout.LINE_END);
		
		// Make the window visible
		window.setVisible(true);
    }
    
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == drawButton){
			draw = true;
			if(Yred)
				info.setText("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  red.getText() + " circle of\nradius "  + radiusValue);
			else if(Ygreen)
				info.setText("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  green.getText() + " circle of\nradius "  + radiusValue);
			else if(Yblue)
				info.setText("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  blue.getText() + " circle of\nradius "  + radiusValue);
				
			sketchpad.repaint();
		}
		else if (e.getSource() == clearButton){
			draw = false;
			sketchpad.repaint();
		}
		else if(e.getSource() == thickLine){
			if(thickLine.isSelected())
				thickLine.setText("THICK");
			else
				thickLine.setText("THIN");
				
			if(draw)
				sketchpad.repaint();
		}
		else if(e.getSource() == red){
			Yred = true;
			Ygreen = false;
			Yblue = false;
			if(draw)
				sketchpad.repaint();
		}
		else if(e.getSource() == green){
			Ygreen = true;
			Yblue = false;
			Yred = false;
			if(draw)
				sketchpad.repaint();
		}
		else if(e.getSource() == blue){
			Yblue = true;
			Yred = false;
			Ygreen = false;
			if(draw)
				sketchpad.repaint();
		}
	}
	
	public void stateChanged(ChangeEvent e){
		if(e.getSource() == slider){
			draw = true;
			radiusValue = ((JSlider)e.getSource()).getValue();
			if(Yred)
				info.setText("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  red.getText() + " circle of\nradius "  + radiusValue);
			else if(Ygreen)
				info.setText("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  green.getText() + " circle of\nradius "  + radiusValue);
			else if(Yblue)
				info.setText("Congratulations " + textName.getText() + "\n\nYou drew a " + thickLine.getText() + " " +  blue.getText() + " circle of\nradius "  + radiusValue);
				
			sketchpad.repaint();
		}
	}
    
    private class MyJPanel extends JPanel {
	
		public void paintComponent(Graphics g) {
			setBackground(Color.white);
			
			super.paintComponent(g);
			// Cast the Graphics object to a Graphics2D object,
	        // which has more powerful features, like stroke style
	     	Graphics2D g2 = (Graphics2D)g;
	
	        // Create a new Stroke style using a BasicStroke of width 3
			Stroke s = new BasicStroke(3);
	        
	        // Tell the Graphics2D object to use the new Stroke style
	        if(thickLine.isSelected())
				g2.setStroke(s);
			
			if(Yred){
				g2.setColor(Color.red);
			}
			if(Ygreen){
				g2.setColor(Color.green);
			}
			if(Yblue){
				g2.setColor(Color.blue);
			}
	        // Now you can draw whatever you want using
	        // the Graphics2D object
	        if(draw){
				g2.drawOval(getWidth()/2-radiusValue, getHeight()/2-radiusValue, radiusValue*2, radiusValue*2);
				draw = false;
	        }
		}
	}
}

