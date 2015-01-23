public class Item {
  private int myId;
  private int myInv;

  public Item(int id, int inv){
    myId = id;
    myInv = inv;
  }

  public int getId(){
  	return myId;
  }

  public int getInv(){
  	return myInv;
  }

  // Compares this item to another item based on id number. Returns
  // the difference between this item's id and the other item's id. A difference
  // of zero means the items' ids are equal in value.
  public int compareTo(Item other){ 
  	return this.getId() - other.getId();
  }

  // Compares this item to another item based on id number.
  public boolean equals(Item other){ 
  	if(this.getId() == other.getId())
  		return true;
  	else
  		return false;
  }

  // Overrides the default toString() of Object.
  // Returns a String representation of this object. It's up to you
  // exactly what this looks like.
  public String toString(){
  	return myId + " ";
  }
}

