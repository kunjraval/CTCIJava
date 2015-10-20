package ctci_chapter1;

/*
 * reverse a string in-place
 * 
 */

public class Sol2 {
	public static void main(String[] args) {
		String s = "abckdshf";
		char[] charStr = s.toCharArray();
		
		System.out.println("original string: " + new String(charStr));
		System.out.println("reversed string: " + new String(reverseStrInPlace(charStr)));
	}
	
	public static char[] reverseStrInPlace(char[] str) {
		int len = str.length;
		for(int i=0, j=len-1; i < len/2; i++, j--) {
			char c = str[i];
			str[i] = str[j];
			str[j] = c;
		}		
		return str;
	}
}
