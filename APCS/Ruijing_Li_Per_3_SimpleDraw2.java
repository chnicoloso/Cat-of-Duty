/* Ruijing Li
 * Period 3
 * 3/20/14
 * Time Spent: 4 hours
 * The file open and file save were actually pretty 
 * hard to implement. I tried a few people's testcases
 * and I believe my open works. However, I am not sure since I save a file
 * and it looks right but when I open it I find that the image is different,
 * so either my open or save does not work. I hardcoded the image to be exactly
 * 20 by 20.
 *
 *EDIT: FIXED SAVE AND OPEN, apparently got the x and y positions mixed up. Only problem 
 * is it can only save and open once before I have to rerun it and do it again. Still only works
 * for 20x20.
 */
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.colorchooser.*;
import java.io.*;

public class Ruijing_Li_Per_3_SimpleDraw2  {
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
	JMenuItem openFile, saveFile, clearFile;
	JFileChooser fileChoose;
	int maxColor;
	int fileWidth, fileHeight, step;
	ArrayList<Integer> tempList = new ArrayList<Integer>();
	Color[][] colorArray = new Color[20][20];
	
	public static void main(String[] args){
		Ruijing_Li_Per_3_SimpleDraw2 d = new Ruijing_Li_Per_3_SimpleDraw2();
	}

    public Ruijing_Li_Per_3_SimpleDraw2() {
    	// Build JFrame and GUI components
		JFrame window = new JFrame("My Awesome SimpleDraw");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setBounds(200, 200, 500, 650);
		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		openFile = new JMenuItem("Open", 'o');
		saveFile = new JMenuItem("Save", 's');
		
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		
		JMenu editMenu = new JMenu("Edit");
		clearFile = new JMenuItem("Clear", 'c');
		
		editMenu.add(clearFile);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		window.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(50, 50));
	    pad = new MySketchPad();
	  	pad.setMaximumSize(new Dimension(400, 400));
	  	pad.setPreferredSize(new Dimension(400, 400));
	  	
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
	  	openFile.addActionListener(m);
		saveFile.addActionListener(m);
	  	pad.addMouseListener(m);
	  	pad.addMouseMotionListener(m);
	  	red.addActionListener(m);
	  	green.addActionListener(m);
	  	blue.addActionListener(m);
	  	choseColor.addActionListener(m);
	  	clearButton.addActionListener(m);
	  	clearFile.addActionListener(m);
	  	
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
    		if(e.getSource() == clearButton || e.getSource() == clearFile){
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
    		
    		if(e.getSource() == openFile){
    			fileChoose = new JFileChooser();
    			if(fileChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	    			try{
	    				File f = fileChoose.getSelectedFile();
	    				String tempMax = "";
	    				String tempWidth = "";
	    				String tempHeight = "";
	    				String tempColor = "";
	    				Scanner in = new Scanner(f);
		    			String str = in.nextLine();
		    			if(str.equals("P3")){
		    				while(in.hasNext()){
		    					String line = in.nextLine();
		    					for(int i = 0; i < line.length(); i++){
		    						if(line.charAt(0) == '#'){
		    							break;
		    						}
		    						else if(line.length() == 3){
		    							tempMax += line.charAt(i); 
		    						}
		    						else if(line.length() == 5){
		    							if(i < 2)
		    								tempWidth += line.charAt(i);
		    							else if(i > 2)
		    								tempHeight += line.charAt(i);
		    						}else{
		    							if(Character.isLetterOrDigit(line.charAt(i)) ){
		    								tempColor += line.charAt(i);
		    							}
		    							else{
		    								if(tempColor.length() != 0)
		    									tempList.add(Integer.parseInt(tempColor));
		    								tempColor = "";
		    							}
		    						}	    								    						
		    					}
		    				}
		    			}
		    			maxColor = Integer.parseInt(tempMax);
		    			fileWidth = Integer.parseInt(tempWidth);
		    			fileHeight = Integer.parseInt(tempHeight);
						int numList = 0;
						
		    			for(int r = 0; r < fileWidth; r++){
		    				for(int c = 0; c < fileHeight; c++){
		    					Color colorTem = new Color(tempList.get(numList), tempList.get(numList+1), tempList.get(numList+2));
		    					numList += 3;
		    					colorArray[r][c] = colorTem;
		    				}
		    			}
		    			
	    			}catch(IOException i){
	    				i.getMessage();
	    			}
    			}
    			pad.repaint();
    		}
    		
    		if(e.getSource() == saveFile){
    			step = 0;
    			fileChoose = new JFileChooser();
    			if(fileChoose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
	    			try{
	    				FileWriter writer = new FileWriter(fileChoose.getSelectedFile());
	    				writer.write("P3\r\n");
	    				writer.write("20 20\r\n");
	    				writer.write(255 + "\r\n");
	   					
						for(int r = 0; r < 20; r++){
							for(int c = 0; c < 20; c++){
								if(grid.size() > 0 && grid.get(step).getX()/20 == c && grid.get(step).getY()/20 == r){
		    						writer.write(grid.get(step).getColor().getRed() + " ");
		    						writer.write(grid.get(step).getColor().getGreen() + " ");
		    						writer.write(grid.get(step).getColor().getBlue() + "   ");
		    						step++;
								}else
									writer.write("255 255 255   ");
	   						}
	   						writer.write("\r\n");
		   				}
	    					
						writer.close();
	    			}catch(IOException i){
	    				i.getMessage();
	    			}
    			}
    			pad.repaint();
    			
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
    				Color c = colorArray[i][j];
    				if(c == null){
    					c = Color.white;
    				}
    				g2.setColor(c);
    				g2.fillRect(20*j, 20*i, 20, 20);
    				g2.setColor(Color.black);
    				g2.drawRect(20*j, 20*i, 20, 20); 
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
	    	}else{
	    		for(int i = 0; i < 20; i++){
    				for(int j = 0; j < 20; j++){
    					colorArray[i][j] = null;
    				}
	    		}
	    		grid.clear();	
	    	}		
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