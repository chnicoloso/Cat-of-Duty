/* Ruijing Li
 * 2/13/14
 * Period 3
 * Time Spent: 2 days
 * I have mixed feelings about this lab. For some parts of the lab, like reading the
 * color pixel array data and taking care of padding, it was excruciating hard.
 * For other parts, like drawing the bitmap or reading the bmp file format, it was surprisingly easy.
 * I am glad that we had time in class to work on this because the time spent in class really helped me solve
 * any problems I had with my code. I tested all the testcases, and they seem to be working,
 * although for the small bmps they seem to look incredibly similar.
 */
import gpdraw.*;
import java.io.*;
import java.util.*;
import java.awt.*;

public class BitmapReaderRLiPer3 {
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

    public BitmapReaderRLiPer3() {
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
}
/*
class DriverRuijingLiPer3{
	  public static void main(String[] args){
    	BitmapReaderRLiPer3 r = new BitmapReaderRLiPer3();
    	//r.loadBMP("2x2.bmp");
    	//r.loadBMP("3x2.bmp");
    	//r.loadBMP("4x2.bmp");
    	//r.loadBMP("5x2.bmp");
    	r.loadBMP("lol_cat.bmp");
    	//r.loadBMP("bitmap_size_test_1.bmp");
    	//r.loadBMP("bitmap_size_test_2.bmp");
    	//r.loadBMP("bitmap_size_test_3.bmp");
    	//r.loadBMP("bitmap_size_test_4.bmp");
    	//r.loadBMP("masterpiece.bmp");
    	r.printBMPHeader();
    	r.drawBMP();
    	//r.drawBMP(100,0);
    }
}*/