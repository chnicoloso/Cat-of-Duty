
public class Pig implements Animal {
	private String mySound;
	private String myType;

    public Pig() {
    	mySound = "oink";
    	myType = "pig";
    }
    
    public String getSound(){
    	return mySound;
    }
    
    public String getType(){
    	return myType;
    }
    
}