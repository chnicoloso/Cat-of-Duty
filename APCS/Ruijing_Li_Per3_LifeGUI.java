/* Ruijing Li
 * Period 3
 * 3/23/14
 * Time Spent: 6 hours
 * This lab took a realllly long time, mostly because I spent the first day fixing my open/ save program. Before
 * I thought I had it working but I neglected to use more testcases and therefore when it didn't work I had to 
 * make it work for a variety of special testcases. That limited my time a lot in finishing the Life Gui lab.
 * However, I got most of the life lab working. Since I believe my code is very inefficent from the beginning
 * but especially in the open and save, my life lab has a couple of bugs that I am unable to resolve with the time
 * I have. However, I believe I got all of the components working and my life gui does seem to be working most of the
 * time with a couple of bugs.
 */


import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.colorchooser.*;
import java.io.*;

public class Ruijing_Li_Per3_LifeGUI  {
	JButton clearButton, run;
	JRadioButton red, green, blue, choseColor;
	boolean Yred = true;
	boolean Ygreen, Yblue, Ywhite;
	boolean draw;
	MySketchPad pad;
	int myX, myY;
	ArrayList<Ruijing_Coordinate> grid = new ArrayList<Ruijing_Coordinate>();
	ArrayList<Ruijing_Coordinate> sort_grid = new ArrayList<Ruijing_Coordinate>();
	int count; 
	JColorChooser cc;
	Color newColor;
	JMenuItem openFile, saveFile, clearFile;
	JFileChooser fileChoose;
	int maxColor;
	int fileWidth, fileHeight, step;
	ArrayList<Integer> tempList = new ArrayList<Integer>();
	Color[][] colorArray = new Color[20][20];
	int generation = 0;
	Color[][] next = new Color[20][20];
	Color[][] temp = new Color[20][20];
	javax.swing.Timer time;
	JSlider slider;
	JRadioButton continous, single;
	boolean wipeOut, Ycontinous, Ysingle;
	JFrame window;
	
	public static void main(String[] args){
		Ruijing_Li_Per3_LifeGUI d = new Ruijing_Li_Per3_LifeGUI();
	}

    public Ruijing_Li_Per3_LifeGUI() {
    	// Build JFrame and GUI components
		window = new JFrame("Generation 0");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setBounds(200, 200, 500, 700);
		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		System.out.println(window.getBackground());
			  
		
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
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(10);
		
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
	  	clear.setMaximumSize(new Dimension(500, 100));
	  	clearButton = new JButton("CLEAR");
	  	run = new JButton("Run");
	  	clear.add(clearButton);
	  	clear.add(run);
	  	
	  	continous = new JRadioButton("continous mode");
	  	single = new JRadioButton("single-step mode");
	  	ButtonGroup group2 = new ButtonGroup();
	  	group2.add(continous);
	  	group2.add(single);
	  	JPanel modePanel = new JPanel();
	  	modePanel.add(continous);
	  	modePanel.add(single);
	  	
		// Create our custom MouseListener
		MyMouseListener m = new MyMouseListener();
  	
	  	// Register our JPanel to listen for events
	  	time = new javax.swing.Timer(1500, m);
	  	
	  	
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
	  	slider.addChangeListener(m);
	  	run.addActionListener(m);
	  	continous.addActionListener(m);
	  	single.addActionListener(m);
	  	
	  	window.add(panel);
	  	window.add(pad);
	  	window.add(buttonPanel);
	  	window.add(clear);
	  	window.add(modePanel);
	  	window.add(slider);
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
    			time.stop();
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
    			Yred = false;
    			Ygreen = false;
    			Yblue = false;
    			Ywhite = false;
				cc = new JColorChooser();
				newColor = cc.showDialog(null, "Awesome Color", Color.black);
    		}
    		
    		if(e.getSource() == openFile){
    			draw = false;
    			
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
	    			
	    			wipeOut = true;
	    			draw = true;
	    			
	    			pad.repaint();
    			}
    			
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
	   	
	   					sort_grid_list();
	   					
	   					step = 0;
	   
						for(int r = 0; r < 20; r++){
							for(int c = 0; c < 20; c++){
								
								if((step < grid.size()) && (grid.size() > 0) && (grid.get(step).getX()/20 == c) && (grid.get(step).getY()/20 == r)){
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
    		
    		if(e.getSource() == single){
    			Ysingle = true;
    			Ycontinous = false;
    		}
    		
    		if(e.getSource() == continous){
    			Ycontinous = true;
    			Ysingle = false;
    		}
    		
    		//starting thing
    		if(e.getSource() == run){
    			int tempStep5 = 0;
    			for(int row = 0; row < 20; row++){
    				for(int col = 0; col < 20; col++){
    					if(tempStep5 < grid.size() && grid.get(tempStep5).getX()/20 == col && grid.get(tempStep5).getY()/20 == row){
    						
    						colorArray[row][col] = grid.get(tempStep5).getColor();
    						tempStep5++;
    					}
    				}
    			}
    			wipeOut = true;
	    		draw = true;
    			grid.clear();
    			
    			if(Ysingle){
    				time.stop();
	    			generation++;
	    			runLife(generation);
    			}
    			
    			if(Ycontinous){
    				if(!time.isRunning())
						time.start();
					else
						time.stop();
    			}
    			
    			
    			window.setTitle("Generation " + generation);
    			pad.repaint();
    		}
    		
    		if(e.getSource() == time){
    			int tempStep6 = 0;
    			for(int row = 0; row < 20; row++){
    				for(int col = 0; col < 20; col++){
    					if(tempStep6 < grid.size() && grid.get(tempStep6).getX()/20 == col && grid.get(tempStep6).getY()/20 == row){
    						colorArray[row][col] = grid.get(tempStep6).getColor();
    						tempStep6++;
    					}
    				}
    			}
    			
    			
    			System.out.println("TIMER NOPE");
    			generation++;
    			runLife(generation);
    			window.setTitle("Generation " + generation);
    			wipeOut = true;
	    		draw = true;
    			grid.clear();
    			pad.repaint();
    		
    		}
    	}
    	
    	public void stateChanged(ChangeEvent e){
    		if(e.getSource() == slider){
    			System.out.println(((JSlider)(e.getSource())).getValue());
    			time.stop();
    			time.setInitialDelay(30*((JSlider)(e.getSource())).getValue());
    			time.setDelay(30*((JSlider)(e.getSource())).getValue());
    			time.start();
    			
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
					int tempStep = 0;
                    boolean found = false;
                    for(int i = 0; i < grid.size(); i++){	   					
    					if ((myX == grid.get(tempStep).getX()) && (myY == grid.get(tempStep).getY()) && (g2.getColor().equals(grid.get(tempStep).getColor()))) {
                          found = true;
                          break;          	    
                        }
                        tempStep++;
                    }
                    if (found == false) {
					   g2.fillRect(myX, myY, 20, 20);
					   replace(myX, myY, g2.getColor());
                    }
				}else{
					/* check if we need to add g2 into grid object */
                    int tempStep = 0;
                    boolean found = false;
                    for(int i = 0; i < grid.size(); i++){	   					
    					if ((myX == grid.get(tempStep).getX()) && (myY == grid.get(tempStep).getY()) && (g2.getColor().equals(grid.get(tempStep).getColor()))) {
    					
                          found = true;
                          break;          	    
                        }
                        tempStep++;
                    }
                    if (found == false) {
                    	if(wipeOut){
    						wipeOut = false;
                    	}
    					else{
						   g2.fillRect(myX, myY, 20, 20);
						   //System.out.println("replace");
						   replace(myX, myY, g2.getColor());
    					}
                    }	
				}
				
				g2.setColor(Color.black);
				g2.drawRect(myX, myY, 20, 20);
	    	}else{
	    		//System.out.println("\nInitalize");
	    		for(int i = 0; i < 20; i++){
    				for(int j = 0; j < 20; j++){
    					colorArray[i][j] = null;
    				}
	    		}
	    		
	    		for(int i = 0; i < 20; i++){
	    			for(int j = 0; j < 20; j++){
	    				g2.setColor(Color.white);
						g2.fillRect(20*j, 20*i, 20, 20);
						g2.setColor(Color.black);
	    				g2.drawRect(20*j, 20*i, 20, 20); 
	    			}
	    		}
	    		
	    		grid.clear();	
	    	}
    	}
    	
    	private void replace(int x, int y, Color c){
    		int tempStep = 0;
    		for(int i = 0; i < grid.size(); i++){
    			
    			if ((x == grid.get(tempStep).getX()) && (y == grid.get(tempStep).getY())){
    				grid.remove(tempStep);
    				break;
    			}
    			tempStep++;
    			
    		}
    		grid.add(new Ruijing_Coordinate(x, y, c));
    	}	
    	
    }
    
    private void sort_grid_list() {
		    int minY = 20;
		    int minX = 20;
		    int index = 0;
			Color color = Color.white;
		
			//System.out.println("Before Sort");
//			for(int i = 0; i < grid.size(); i++){
//				System.out.println(grid.get(i).getX() + " " + grid.get(i).getY() + " " + grid.get(i).getColor());
//			}
		
		    while (grid.size() > 0) {
		       minY = 400;
		       minX = 400;
		       index = 0;
		
		      for(int i = 0; i < grid.size(); i++) {
		        /* find the mini Y */
		        if (minY >= grid.get(i).getY()) {
		            if (minY > grid.get(i).getY()) {
			            minY = grid.get(i).getY();
			            minX = grid.get(i).getX();
			            color = grid.get(i).getColor();
			            index = i;
		            }else{ /* minY equal */
	                   if (minX > grid.get(i).getX()) {
			               minX = grid.get(i).getX();
			               color = grid.get(i).getColor();
			               index = i;
	                   }
		             }   
		          }
		       } /* end of for */
		
		      /* remove minY & minX from grid */
		      grid.remove(index);
		      /* add into a new sorted array list */
		      sort_grid.add(new Ruijing_Coordinate(minX, minY, color));
		
		    }  /* end of while */
		
			for(int i = 0; i < sort_grid.size(); i++){
				grid.add(sort_grid.get(i));
			}
			//System.out.println("After Sort");
		    /* print the sort_grid to verify if it is a correct sort list */
//		    for(int i = 0; i < grid.size(); i++){
//				System.out.println(grid.get(i).getX() + " " + grid.get(i).getY() + " " + grid.get(i).getColor());
//			}
	}
    //This is logic
    public void runLife(int numGenerations) {
		for(int i = 1; i <= numGenerations; i++){
			int count = 0;
			for(int row = 0; row < colorArray.length; row++){
				for(int col = 0; col < colorArray[0].length; col++){
					count = checkNeighbors(row, col);
//					if(count != 0){
//						System.out.println("Count is " + count);
//						System.out.println(row + " " + col);
//						System.out.println("COlor is " + colorArray[row][col]);
//					}
					
					if(count == 2 || count == 3){
						if(colorArray[row][col] != null && !colorArray[row][col].equals(Color.white)){
							next[row][col] = colorArray[row][col];
							//System.out.println("Good");
						}
					}
					if(colorArray[row][col] == null || colorArray[row][col].equals(Color.white)){
						if(count == 3){
							if(Yred)
								next[row][col] = Color.red;
							else if(Ygreen)
								next[row][col] = Color.green;
							else if(Yblue)
								next[row][col] = Color.blue;
							else if(Ywhite)
								next[row][col] = Color.white;
							else
								next[row][col] = newColor;
							//System.out.println("Job");
						}
					}
				}
			}
			//System.out.println(Arrays.deepToString(next));
			nextGeneration();
		}
	}
	
   
    //This helper method will check if that current spot is in bounds
	private boolean isLegal(int x, int y){
		if(x < 0 || x >= colorArray.length || y < 0 || y >= colorArray.length)
			return false;
		else 
			return true;
	}
						
    private int checkNeighbors(int x, int y){
    	int counter = 0;
    	counter += getNeighbor(x-1, y);
    	counter += getNeighbor(x-1, y-1);
    	counter += getNeighbor(x-1, y+1);
    	counter += getNeighbor(x+1, y);
    	counter += getNeighbor(x+1, y-1);
    	counter += getNeighbor(x+1, y+1);
    	counter += getNeighbor(x, y-1);
    	counter += getNeighbor(x, y+1);
    	return counter;
    }
    
    private int getNeighbor(int x, int y){
    	if(isLegal(x, y)){
    		if((colorArray[x][y] != null) && (!colorArray[x][y].equals(Color.white))){
//  				System.out.println(x + " " + y);
//  				System.out.println("COlor is " + colorArray[x][y]);
    			return 1;
    		}
    	}

    	return 0;
    }
    
    // Advances Life forward one generation
	public void nextGeneration() {
		for(int row = 0; row < next.length; row++){
			for(int col = 0; col < next[0].length; col++){
				colorArray[row][col] = next[row][col];
				next[row][col] = temp[row][col];
			}
		}
//		System.out.println("\n");
//		System.out.println(Arrays.deepToString(colorArray));
		//generation++;
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