
public class Strings  {

	// Time complexity: O(n), where n is length of the string
	// Space complexity: O(1)
	// Check if character counts are no more than 1
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;
		
		int[] char_set = new int[128];
		for(int i = 0; i < str.length(); i++) {
			int val = (int) str.charAt(i);
			char_set[val]++;
			if (char_set[val] > 1) {
				return false;
			}
		}

		return true;
	}

	// Time complexity: O(n logn)
	// Sort both strings and check if they are equal
	public static boolean checkPermutation(String s1, String s2) { 
		String new_s1 = new String(java.util.Arrays.sort(s1.toCharArray()));
		String new_s2 = new String(java.util.Arrays.sort(s2.toCharArray()));
	
		if (new_s1.length() != new_s2.length()) {
			return false;
		}

		return (new_s1.equals(new_s2()));
	}

	// Time complexity: O(n)
	// Check if both strings have identical character counts
	public static boolean checkPermutation2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
	
		int[] char_set = new int[128];
		for (int i = 0; i < s1.length(); i++) {
			int val = (int) s1.charAt(i);
			char_set[val]++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			int val = (int) s2.charAt(i);
			char_set[val]--;
			if (char_set[val] < 0) {
				return false;
			}

		}

		return true;

	}

	// Time complexity: O(n)
	// Count white spaces and fill in new char array backward
	public static void replaceSpace(char[] str, int trueLength) {
		int spaces = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str[i] == ' ') {
				spaces++;
			}
		}

		int newIndex = trueLength + spaces*2;
		if (trueLength < str.length()) {
			str[trueLength] = '\0';
		}
		for (int i = newLength-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newIndex-1] = '0';
				str[newIndex-2] = '2';
				str[newIndex-3] = '%';
				newIndex -= 3;
			}
			else {
				str[newIndex-1] = str[i];
				newIndex--;
			}
		}
	}

	// Time Complexity: O(n)
	// Check if odd character counts are no more than 1
	public static boolean isPermutationofPalindrome(String str) {
		int countOdd = 0;
		int[] char_set = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

		for (char c : str.toCharArray()) {
			int val = getCharNumber(c);
			char_set[val]++;
			if (char_set[va] % 2 == 1) {
				countOdd++;
			}
			else {
				countOdd--;
			}
		}

		return (countOdd <= 1);

	}

	public static void main(String[] args) {
		System.out.println(Strings.isUniqueChars(""));
		System.out.println(Strings.isUniqueChars("abc"));
		System.out.println(Strings.isUniqueChars("abcc"));

		

	}

}