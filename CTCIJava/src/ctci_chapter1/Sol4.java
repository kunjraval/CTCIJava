package ctci_chapter1;

/*
 * method to replace all spaces with string '%20'
 * 
 */
public class Sol4 {

	public static void main(String[] args) {
		String s = "Mr John Smith     ";
		char[] s_array = s.toCharArray();
		
		System.out.println("original string: " + s);
		
		String replacedStr = new String(replaceCharacters(s_array, 13));
		System.out.println("replaced string: " + replacedStr);
	}

	public static char[] replaceCharacters(char[] str, int orgLength) {
		int spaceCount=0, newLength;		
		for(int i = 0; i < orgLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = orgLength + spaceCount * 2;
		str[newLength] = '\0';
		
		for(int i = orgLength-1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[newLength-1] = '%';
				str[newLength-2] = '2';
				str[newLength-3] = '0';
				newLength = newLength - 3;
			}
			else {
				str[newLength-1] = str[i];
				newLength = newLength - 1;
			}			
		}
		return str;
	}
}
