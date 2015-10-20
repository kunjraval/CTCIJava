package ctci_chapter1;

/*
 * perform basic string compression using the counts of repeated characters
 * eg aabcccccaaa -> a2bc5a3
 * bad solution
 * 
 */
public class Sol5_1 {

	public static void main(String[] args) {
		String s = "aabcccccaaa";
		System.out.println("original string: " + s);
		System.out.println("compressed string: " + strCompression(s));
	}

	public static String strCompression(String str) {
		int len = str.length();
		int count=1;
		String result = "";
		char temp = str.charAt(0);
		
		for(int i=1; i<len; i++) {			
			if(temp == str.charAt(i)) {				
				count++;
				
			} else {
				result += temp + "" + count;
				System.out.println(result);
				temp = str.charAt(i);
				count=1;
			}			
		}
		return result + temp + "" + count;
	}
}
