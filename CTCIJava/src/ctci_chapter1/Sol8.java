package ctci_chapter1;

/*
 * given 2 strings - s1 & s2. check if s2 is a rotation of s1
 * 
 */
public class Sol8 {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		int len = s1.length();
		if(len != s2.length() || len <= 0) {
			System.out.println("if s2 is a rotation of s1? " + false);
			
		} else {
			s2 = s2+s2;
			System.out.println("if s2 is a rotation of s1? " + isSubstring(s1, s2));
		}		
	}
	
	public static boolean isSubstring(String s, String t) {		
		return t.contains(s);
	}
}
