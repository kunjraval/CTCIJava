package ctci_chapter1;

/*
 * check a string if contains unique characters
 * solution 2
 * 
 */

public class Sol1_2 {

	public static void main(String[] args) {
		String s = "abcdefghi";
		System.out.println("contains unique chars? " + checkUniqueString(s));
	}

	public static boolean checkUniqueString(String str) {		
		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i) - 'a';
			
			if((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		
		return true;
	}
}