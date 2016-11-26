
public class Strings  {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;

		int[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			char_set[val]++;
			if (char_set[val] > 1) {
				return false;
			}
		}

		return true;
	}



	public static void main(String[] args) {
	
	}

}