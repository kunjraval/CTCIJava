package ctci_chapter1;

/*
 * perform basic string compression using the counts of repeated characters
 * eg aabcccccaaa -> a2bc5a3
 * better solution
 * 
 */
public class Sol5_2 {

	public static void main(String[] args) {
		//String s = "aabccdeeaa";
		String s = "aabcccccaaa";
		System.out.println("original string: " + s);
		System.out.println("compressed string: " + strCompression(s));
	}

	public static String strCompression(String s) {
		int size = countCompression(s);
		if(size >= s.length()) {
			return s;
		}
		
		int len = s.length();
		int count=1;
		StringBuffer myStr = new StringBuffer();		
		char temp = s.charAt(0);
		
		for(int i=1; i<len; i++) {
			if(temp == s.charAt(i)) {
				count++;
			} else {
				myStr.append(temp);
				myStr.append(count);
				temp = s.charAt(i);				
				count=1;
			}
		}
		myStr.append(temp);
		myStr.append(count);
		return myStr.toString();
	}
	
	public static int countCompression(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		int count=1;
		int size=0;
		int len = str.length();
		char temp = str.charAt(0);
		
		for(int i=1; i<len; i++) {
			if(temp == str.charAt(i)) {
				count++;
			} else {
				temp = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count=1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}