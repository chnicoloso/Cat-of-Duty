/* Ruijing Li
 * Period 3
 * 2/6/14
 * Time Spent: 40 minutes
 * This lab was again easier than I expected it to be. The filereader 
 * class was extremely helpful and the only bug I ran into was easily 
 * fixed by initializing the empty strings. Other than that, helper 
 * functions were very useful in this lab!
 */

import java.io.*;
import java.util.*;
public class EncryptXOR {
	private String key;
	private String result = "";
	private String answer = "";

    public EncryptXOR() {
    }
    
    public void start(){
    	Scanner in = new Scanner(System.in);
    	System.out.println("Welcome to XOR Text File Encryptor!\n");
    	System.out.print("Enter a file to encrypt> ");
    	String file = in.next();
    	System.out.print("Enter a file to output> ");
    	String file2 = in.next();
    	System.out.print("Enter a private key> ");
    	key = in.next();
    	readFile(file);
    	outputFile(file2);
    }
    
    public void readFile(String fileName){
    	try{
	    	FileReader f = new FileReader(fileName);
	    	// while there are bytes to be read, repeat this process:
	    	while(f.ready()){
	            char[] bufferlist = new char[1024];
	            
	            int charsRead = f.read(bufferlist);
	            for(int i = 0; i < charsRead; i++){
	            	result += bufferlist[i];
	            }
	            // close the FileReader when you're done with it
	            f.close();
	    	}
    	}catch(IOException e){
    		System.out.println(e.getMessage());
    	}
        xorOp(result);
	}
	
	private void xorOp(String str){
		for(int i = 0; i < str.length(); i++){
			answer += (char)(str.charAt(i) ^ key.charAt(i%key.length())); 
		}
	}
	
	public void outputFile(String fileName){
		try{
			FileWriter out = new FileWriter(fileName);
			out.write(answer, 0, answer.length());
			out.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}

class Driver{
	public static void main(String[] args){
		EncryptXOR ex = new EncryptXOR();
		ex.start();
	}
}
     