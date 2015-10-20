package ctci_chapter1;

/*
 * given 2 strings. check if one is a permutation of other
 * solution 1
 * 
 */

public class Sol3_1 {

	public static void main(String[] args) {
		String s1 = "god";
		String s2 = "dog";
		
		System.out.println("if strings are permutation of each other? " + checkPermutations(s1, s2));
	}
	
	public static boolean checkPermutations(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		return sort(s).equals(sort(t));
	}
	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

}
