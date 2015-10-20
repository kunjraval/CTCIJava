package ctci_chapter1;

/*
 * given 2 strings. check if one is a permutation of other
 * solution 2
 * 
 */

public class Sol3_2 {

	public static void main(String[] args) {
		String s1 = "grodrrrr";
		String s2 = "drrrrogr";
		
		System.out.println("if strings are permutation of each other? " + checkPermutations(s1, s2));
	}
	
	public static boolean checkPermutations(String s, String t) {
		int sLen=s.length();
		int tLen=t.length();
		
		if(sLen != tLen) 
			return false;
		
		int[] letters = new int[128];
		
		char[] s_array = s.toCharArray();
		for(char c : s_array) {
			letters[c]++;
		}
		
		for(int i=0; i<tLen; i++) {
			int val = t.charAt(i);
			if(--letters[val] < 0) {
				return false;
			}
		}
		
		return true;
	}

}
