package ctci_chapter1;

/*
 * check a string if contains unique characters
 * solution 1
 * 
 */

public class Sol1_1 {

	public static void main(String[] args) {
		String s = "abcdefghi";
		System.out.println("contains unique chars? " + checkUniqueString(s));
	}

	public static boolean checkUniqueString(String str) {
		if(str.length() > 128)
			return false;
		
		boolean[] char_set = new boolean[128];
		
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
				
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
}
