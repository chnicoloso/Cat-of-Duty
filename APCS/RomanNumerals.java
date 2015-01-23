/* Ruijing Li
 * Period 3
 * 11/6/13
 * Time Spent: 35 minutes
 * When I first looked at the lab, I thought it would be extremely difficult
 * because of the rules and converting the numerals to numbers. However, I 
 * believed I had a solid psuedocode and when I actually coded it, the program was
 * a lot easier than I had expected. However, the bonus point seems to take a lot
 * more time, and although I have a strategy for it, it seems it may take too long
 * to implement.
 */


public class RomanNumerals {

    public RomanNumerals() {
    }
    
    public static int romanToArabic(String rom){
    	int result = 0;
    	
    	rom = rom.toUpperCase();
    	
    	for(int i = 0; i < rom.length(); i++){
    		if(i != 0 && convert(rom.charAt(i)) > convert(rom.charAt(i-1)))
    			result += convert(rom.charAt(i)) - convert(rom.charAt(i-1)) - convert(rom.charAt(i-1));
    		else	
    			result += convert(rom.charAt(i));
    	}
    	return result;
    }
    
    public static int convert(char c){
    	if(c == 'I')
    		return 1;
    	else if (c == 'V')
    		return 5;
    	else if(c == 'X')
    		return 10;
    	else if(c == 'L')
    		return 50;
    	else if(c == 'C')
    		return 100;
    	else if(c == 'D')
    		return 500;
    	else
    		return 1000;
    }    
}

class Driver{
	public static void main(String[] args){
		System.out.println("I is equal to " + RomanNumerals.romanToArabic("I"));
		System.out.println("IV is equal to " + RomanNumerals.romanToArabic("IV"));
		System.out.println("LXIII is equal to " + RomanNumerals.romanToArabic("LXIII"));
		System.out.println("LXIV is equal to " + RomanNumerals.romanToArabic("LXIV"));
		System.out.println("DCCXLV is equal to " + RomanNumerals.romanToArabic("DCCXLV"));
		System.out.println("MCMLXXIII is equal to " + RomanNumerals.romanToArabic("MCMLXXIII"));
		System.out.println("MMMDXCIII is equal to " + RomanNumerals.romanToArabic("MMMDXCIII"));
	}
}