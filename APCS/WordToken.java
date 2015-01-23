// Helper Class Created by Ruijing Li Period 3

public class WordToken {
	private String myStr;
    private int myCount;
    
    public WordToken(String str, int count) {
    	myStr = str;
    	myCount = count;
    }
    
    public int getCount(){
  		return myCount;
    }
    
    public String getToken(){
    	return myStr;
    }
    
   	public int compareTo(WordToken other){
   		return this.getCount() - other.getCount();
   	}

	public boolean equals(WordToken other){
		if(this.getToken().equals(other.getToken()))
			return true;
		else
			return false;
	}     
    
    public String toString(){
    	return myStr;
    }
    
    public void addFrequency(){
    	myCount++;
    }
}