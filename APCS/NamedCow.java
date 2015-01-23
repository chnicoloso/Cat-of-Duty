public class NamedCow extends Cow {
	private String myName;

    public NamedCow(String name) {
    	super();
    	myName = name;
    }
    
    public String getName(){
    	return myName;
    }
}