/* Ruijing Li
 * Period 3
 * 11/4/13
 * Time Spent: 20 minutes
 * It was nice to have a really good breather after all the labs we had done so far.
 * The concepts in this lab weren't as difficult to understand, although it greatly helped
 * that we went over inheritance in class. The coding was easy and almost felt like I was doing
 * the design a class lab back in the early lessons.
 */


public class RunPerson {

	public static void main(String[] args){
		Person bob = new Person("Coach Bob", 27, "M");
		System.out.println(bob);

		Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
		System.out.println(lynne);
		
		Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
		System.out.println(mrJava);
		
		CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123",
		                                         4.0, 1, "English");
		System.out.println(ima);
	}
}