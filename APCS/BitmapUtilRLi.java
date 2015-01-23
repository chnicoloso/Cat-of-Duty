import gpdraw.*;
import java.io.*;
import java.util.*;
import java.awt.*;

public class BitmapUtilRLi {
	byte tempMagicNum; //holds first char of magic #
	byte tempMagicNum2; //holds second char of magic #
	String magicNum; //the magic #
	int sizeHeader; //the size of the header
	short appTemp;
	short appTemp2;
	int offset;
	int sizeDIB;
	int width;
	int height;
	short numPlane;
	short numBits;
	int compression;
	int sizeArray;
	int horzRes;
	int vertRes;
	int numColors;
	int colorImp;
	int[][][] image;
	ArrayList<Character> list = new ArrayList<Character>();

    public BitmapUtilRLi() {
    }

    // loads a BMP file into memory
    public void loadBMP(String fileName){
    	try{
			FileInputStream f = new FileInputStream(fileName);
    		DataInputStream d = new DataInputStream(f);
    		tempMagicNum = d.readByte();
    		tempMagicNum2 = d.readByte();
    		magicNum = "" + (char)tempMagicNum + (char)tempMagicNum2;
    		sizeHeader = Integer.reverseBytes(d.readInt());
    		appTemp = Short.reverseBytes(d.readShort());
    		appTemp2 = Short.reverseBytes(d.readShort());
    		offset = Integer.reverseBytes(d.readInt());
    		sizeDIB = Integer.reverseBytes(d.readInt());
    		width = Integer.reverseBytes(d.readInt());
    		height = Integer.reverseBytes(d.readInt());
    		numPlane = Short.reverseBytes(d.readShort());
    		numBits = Short.reverseBytes(d.readShort());
    		compression = Integer.reverseBytes(d.readInt());
    		sizeArray = Integer.reverseBytes(d.readInt());
    		horzRes = Integer.reverseBytes(d.readInt());
    		vertRes = Integer.reverseBytes(d.readInt());
    		numColors = Integer.reverseBytes(d.readInt());
    		colorImp = Integer.reverseBytes(d.readInt());

    		//color array
    		image = new int[height][width][3];
    		for(int row = 0; row < height; row++){
    			for(int col = 0; col < width; col++){
    				for(int item = 2; item >= 0; item--){
    					image[row][col][item] = d.readUnsignedByte();
    				}
    			}
    			int temp = 0;
    			while(temp < width%4){
    				d.readByte();
    				temp++;
    			}
    		}
    	}catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }

    // displays the BMP centered in a SketchPad
	public void drawBMP(){
		SketchPad s = new SketchPad(500,500, 0);
		DrawingTool pen = new DrawingTool(s);
		pen.up();
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Color c = new Color(image[y][x][0], image[y][x][1], image[y][x][2]);
				pen.up();
				pen.move(x-width/2,y-height/2);
				pen.setDirection(0);
				pen.setColor(c);
				pen.down();

				pen.forward(0);
				pen.up();
				pen.forward(1);
			}
		}
		pen.up();
	}

	// displays the BMP centered at (x, y)
	public void drawBMP(int x, int y){
		SketchPad s = new SketchPad(500,500, 0);
		DrawingTool pen = new DrawingTool(s);
		pen.up();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				Color c = new Color(image[i][j][0], image[i][j][1], image[i][j][2]);
				pen.up();
				pen.move(j-width/2+x, i-height/2+y);
				pen.setDirection(0);
				pen.setColor(c);
				pen.down();
				pen.forward(0);
				pen.up();
				pen.forward(1);
			}
		}
		pen.up();
	}

	// displays the BMP header info in console
	public void printBMPHeader(){
		System.out.println("Magic Number: " + magicNum);
    	System.out.println("size of BMP File: " + sizeHeader);
    	System.out.println("Application Specific Bytes: " + appTemp);
    	System.out.println("Application Specifc Bytes: " + appTemp2);
    	System.out.println("Offset: " + offset);
    	System.out.println("Bytes in DIB Header: " + sizeDIB);
    	System.out.println("Width of Image: " + width);
    	System.out.println("Height of Image: " + height);
    	System.out.println("Number of Planes: " + numPlane);
    	System.out.println("Bits per Pixel: " + numBits);
    	System.out.println("Pixel Array Compression: " + compression);
    	System.out.println("Size of raw Data: " + sizeArray);
    	System.out.println("Horizontal Resolution: " + horzRes);
    	System.out.println("Vertical Resolution: " + vertRes);
    	System.out.println("Colors in the Palette: " + numColors);
    	System.out.println("Important Colors: " + colorImp);
	}

	// Loads a text file and inserts it into the current BMP object
	// Precondition: loadBMP(bmpFileName) has already been called
	public void encodeBMP(String txtFileName){
		try{
			Scanner in = new Scanner(new File(txtFileName));
			while(in.hasNext()){
				String str = in.next();
				for(int i = 0; i < str.length(); i++){
					char c = str.charAt(i);
					
					String temp = Integer.toBinaryString((int)c);
					String zeros = "";
					if(temp.length() != 8){
						for(int n = 0; n < 8-temp.length(); n++){
							zeros += "0";
						}
					}
					String binary = zeros + temp;
					for(int j = 0; j < binary.length(); j++){
						list.add(binary.charAt(j));
					}	
				}
			}
			list.add((char)0);
			encrypt();
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

	private void encrypt(){
		int i = 0;
		for(int row = height-1; row >= 0; row--){
			for(int col = 0; col < width; col++){
				for(int item = 0; item < 3; item++){
					if(i < list.size() && list.get(i) == '1' && image[row][col][item] % 2 == 0)
						image[row][col][item] += 1;
					else if(i < list.size() && list.get(i) == '0' && image[row][col][item] % 2 == 1)
						image[row][col][item] -= 1;
						
					i++;
				}
			}
		}
	}

	// Extracts a message hidden in a BMP file and saves it into txtFileName
	// Precondition: loadBMP(bmpFileName) has already been called
	public void extractMessage(String txtFileName){
		boolean brk = false;
		String str = "";
		String result = "";
		char ctemp = 1;
		for(int row = height-1; row >= 0; row--){
			for(int col = 0; col < width; col++){
				for(int item = 0; item < 3; item++){
			
					if(image[row][col][item] % 2 == 0){
						str += 0;
					}
					else{
						str += 1;
					}

					if(str.length() == 8){
						ctemp = (char)Integer.parseInt(str, 2);
						str = "";
						if(ctemp == (char)0){
							brk = true;
							break;
						}
						result += ctemp;
					}
				}
				if(brk){
					break;
				}
			}
			if(brk){
				break;
			}
		}
		try{
			FileWriter fw = new FileWriter(txtFileName);
			fw.write(result, 0, result.length());
			fw.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	// Saves a BMP image to disk in Windows V3 format
	public void saveBMP(String bmpFileName){
		try{
		
			// Create a new stream of data from a file
			FileOutputStream fOutStream = new FileOutputStream(bmpFileName);
		
			// Pass the stream to DataOutputStream to write to disk
			DataOutputStream dOut = new DataOutputStream(fOutStream);
			
			dOut.writeByte(tempMagicNum);
			dOut.writeByte(tempMagicNum2);
			dOut.writeInt(Integer.reverseBytes(sizeHeader));
			dOut.writeShort(Short.reverseBytes(appTemp));
			dOut.writeShort(Short.reverseBytes(appTemp2));
			dOut.writeInt(Integer.reverseBytes(offset));
			dOut.writeInt(Integer.reverseBytes(sizeDIB));
			dOut.writeInt(Integer.reverseBytes(width));
			dOut.writeInt(Integer.reverseBytes(height));
			dOut.writeShort(Short.reverseBytes(numPlane));
			dOut.writeShort(Short.reverseBytes(numBits));
			dOut.writeInt(Integer.reverseBytes(compression));
			dOut.writeInt(Integer.reverseBytes(sizeArray));
			dOut.writeInt(Integer.reverseBytes(horzRes));
			dOut.writeInt(Integer.reverseBytes(vertRes));
			dOut.writeInt(Integer.reverseBytes(numColors));
			dOut.writeInt(Integer.reverseBytes(colorImp));
			
			for(int row = 0; row < height; row++){
				for(int col = 0; col < width; col++){
					for(int item = 2; item >= 0; item--){
						 dOut.writeByte(image[row][col][item]);
					}
				}
				int temp = 0;
				while(temp < width%4){
					dOut.writeByte(0);
					temp++;
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
/*
class DriverRLi{
	  public static void main(String[] args){
    	BitmapUtilRLi r = new BitmapUtilRLi();
    	r.loadBMP("lol_cat.bmp");
    	r.encodeBMP("encode_text.txt");
    	r.extractMessage("RLi_output.txt");
    	//r.printBMPHeader();
    	//r.drawBMP();
    	//r.drawBMP(100,0);
    	r.saveBMP("cat_save.bmp");
    }
}*/