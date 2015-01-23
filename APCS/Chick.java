import java.util.*;
public class Chick implements Animal {
	private String mySecSound;
	private String mySound;
	private String myType;
	private Random r;

    public Chick() {
    	mySound = "cluck";
    	myType = "chick";
    }
    
    public Chick(int flag) {
    	if(flag == 2)
    		mySecSound = "cheep";
    		
    	mySound = "cluck";
    	myType = "chick";
    	r = new Random();
    }
    
    public String getSound(){
    	if(mySecSound != null){
    		if(r.nextInt(2) == 0)
    			return mySound;
    		else
    			return mySecSound;
    	}
    	else
    		return mySound;
    }
    
    public String getType(){
    	return myType;
    }
    
}