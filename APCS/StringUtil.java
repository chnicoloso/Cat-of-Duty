
public class StringUtil {

    public static void main(String[] args){
    	System.out.println("Palindrome");
    	System.out.println(StringMethods.isPalindrome("radar"));
    	System.out.println(StringMethods.isPalindrome("J"));
    	System.out.println(StringMethods.isPalindrome("Lewd did I live, & evil I did dwel."));
    	System.out.println(StringMethods.isPalindrome("I like Java"));
    	System.out.println(StringMethods.isPalindrome("Straw? No, too stupid a fad, I put soot on warts."));
    	
    	System.out.println("\nshorthand");
    	System.out.println(StringMethods.shorthand("A truck"));
    	System.out.println(StringMethods.shorthand("Me AND YOU forever!"));
    	System.out.println(StringMethods.shorthand("To Bill and Ted: Are you going to be EXCELLENT to towtrucks too???"));
    	System.out.println(StringMethods.shorthand("Look, here's a 3.14159 I made for you! And? How's it taste?"));
    }
}