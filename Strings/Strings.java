
public class Strings  {

	// Time complexity: O(n), where n is length of the string
	// Space complexity: O(1)
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;
		// character counts no more than 1
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
	public static boolean checkPermutation(String s1, String s2) {
		// sort both strings 
		String new_s1 = new String(java.util.Arrays.sort(s1.toCharArray()));
		String new_s2 = new String(java.util.Arrays.sort(s2.toCharArray()));
		// check if sorted strings are equal
		if (new_s1.length() != new_s2.length()) {
			return false;
		}
		return (new_s1.equals(new_s2()));
	}

	// Time complexity: O(n)
	public static boolean checkPermutation2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		// fill up character counts for first string
		int[] char_set = new int[128];
		for (int i = 0; i < s1.length(); i++) {
			int val = (int) s1.charAt(i);
			char_set[val]++;
		}
		// check for identical character count in second string
		for (int i = 0; i < s2.length(); i++) {
			int val = (int) s2.charAt(i);
			char_set[val]--;
			if (char_set[val] < 0) {
				return false;
			}

		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(Strings.isUniqueChars("abcdef"));
		System.out.println(Strings.isUniqueChars("aabbccddeeff"));
	}

}