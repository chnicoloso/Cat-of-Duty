/**
 * @(#)Teacher.java
 *
 *
 * @author 
 * @version 1.00 2013/11/4
 */


public class Teacher extends Person {
	private String mySubject;
	private double mySalary;

    public Teacher(String name, int age, String gender, String subject, double salary) {
    	super(name, age, gender);
    	mySubject = subject;
    	mySalary = salary;
    }
   
    public String getSubject(){
    	return mySubject;
    }
    
    public double getSalaray(){
    	return mySalary;
    }
    
    public void setSubject(String subject){
    	mySubject = subject;
    }
    
    public void setSalary(double salary){
    	mySalary = salary;
    }
    
    public String toString(){
    	return super.toString() + ", subject: " + mySubject + ", salary: " + mySalary;
    }
    
}