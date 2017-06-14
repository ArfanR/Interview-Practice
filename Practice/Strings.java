
// Find first nonrepeated character
public static Character firstNonrepeat(String str) {
	HashMap<Character, Integer> count = new HashMap<Character, Integer>();
	// build hash table
	for (int i = 0; i < str.length(); i++) {
		if (count.containsKey(str.charAt(i)) {
			count.put(str.charAt(i), count.get(str.charAt(i))+1);
		}
		else {
			count.put(str.charAt(i), 1);
		}
	}
	// check counts
	for (int i = 0; i < str.length(); i++) {
		if (count.get(str.charAt(i)) == 1) {
			return str.charAt(i);
		}
	}
	return null;
}

// Remove specified characters from string
public static String removeChars(String str, String remove) {
	HashSet<Character> removeSet = new HashSet<Character>();
	StringBuilder newString = new StringBuilder();

	for (int i = 0; i < remove.length(); i++) {
		if (!removeSet.contains(remove.charAt(i))) {
			removeSet.add(remove.charAt(i));
		}
	}

	for (char c : str.toCharArray()) {
		if (removeSet.contains(c)) {
			newString.append(new String(" "));
		}
		else {
			newString.append(Character.toString(c));
		}
	}

	return newString.toString();

}

// reverse characters in a string
public static void reverseString(char[] string, int start, int end) {
	while (start < end) {
		char temp = string[start];
		string[start] = string[end];
		string[end] = temp;
		start++;
		end--;
	}
}

// reverse a string word by word
public String reverseWords(String a) {
	if (a.length() == 0) {
		return a;
	}
	char[] string = a.toCharArray();
	reverseString(string, 0, string.length-1); // reverse entire string of words
	int start = 0;
	int end = 0;
	// reverse each word in place in reversed string
	while (end < string.length) {
		if (string[end] != ' ') {
			start = end;
			while (end < string.length && string[end] != ' ') {
				end++;
			}
			end--;
			reverseString(string, start, end);
		}
	}
}

// Check if character counts are no more than 1
public static boolean isUniqueChars(String str) {
	if (str.length() > 128)
		return false;

	int[] char_set = new int[128];
	// character count of string must be less than 2
	for(int i = 0; i < str.length(); i++) {
		int val = (int) str.charAt(i);
		char_set[val]++;
		if (char_set[val] > 1) {
			return false;
		}
	}

	return true;
}

// Check if both strings have identical character counts
public static boolean checkPermutation(String s1, String s2) {
	if (s1.length() != s2.length()) {
		return false;
	}
	// have a character count for first string
	int[] char_set = new int[128];
	for (int i = 0; i < s1.length(); i++) {
		int val = (int) s1.charAt(i);
		char_set[val]++;
	}
	// check if characters have same frequency in second string
	for (int i = 0; i < s2.length(); i++) {
		int val = (int) s2.charAt(i);
		char_set[val]--;
		if (char_set[val] < 0) {
			return false;
		}

	}

	return true;

}

// Count white spaces and fill in new char array backward
public static void replaceSpace(char[] str, int trueLength) {
	int spaces = 0;
	// count white spaces to calculate new length
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == ' ') {
			spaces++;
		}
	}
	// start at the end of the new array and update based on white spaces
	int newIndex = trueLength + spaces*2;
	if (trueLength < str.length()) {
		str[trueLength] = '\0';
	}
	for (int i = newIndex-1; i >= 0; i--) {
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

// Check if odd character counts are no more than 1
public static boolean isPermutationofPalindrome(String str) {
	int countOdd = 0;
	int[] char_set = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
	// keep track of odd character counts (less than or equal to one)
	for (char c : str.toCharArray()) {
		int val = Character.getNumericValue(c);
		char_set[val]++;
		if (char_set[val] % 2 == 1) {
			countOdd++;
		}
		else {
			countOdd--;
		}
	}

	return (countOdd <= 1);

}

// Check if strings are one or zero edits away: replacement, insertion or removal
public static boolean oneEdit(String s1, String s2) {
	if (s1.length() == s2.length()) {
		return oneEditReplace(s1, s2);
	}
	else if (s1.length()+1 == s2.length() || s1.length()-1 == s2.length()) {
		return oneEditInsert(s1, s2);
	}
	return false;
}

public static boolean oneEditInsert(String s1, String s2) {
	int index1 = 0;
	int index2 = 0;
	int edits = 0;
	// keep track of two indices and check for missing char
	while (index1 < s1.length() && index2 < s2.length()) {
		if (s1.charAt(index1) != s2.charAt(index2)) {
			edits++;
			if (s1.length() < s2.length()) {
				index2++;
			}
			else {
				index1++;
			}
		}
		else {
			index1++;
			index2++;
		}
	}

	return (edits <= 1);
}

public static boolean oneEditReplace(String s1, String s2) {
	int edits = 0;
	// check for unequal chars
	for (int i = 0; i < s1.length(); i++) {
		if (s1.charAt(i) != s2.charAt(i)) {
			edits++;
		}
	}

	return (edits <= 1);
}

// compress string with counts of repeated characters
public static String compress(String str) {
	StringBuilder newString = new StringBuilder();
	int countRepeats = 0;

	int i = 0;
	while (i < str.length()) {
		countRepeats++;
		if (str.charAt(i) != str.charAt(i+1)) {
			newString.append(str.charAt(i));
			newString.append(countRepeats);
			countRepeats = 0;
			i++;
		}
		i++;
	}

	return str.length() > newString.length() ? newString.toString() : str;
}

// set entire row and column to zero if element is zero
public static void zeroMatrix(int[][] matrix) {
	boolean rowHasZero = false;
	boolean colHazZero = false;

	// check if first row has a zero
	for (int i = 0; i < matrix[0].length; i++) {
		if (matrix[0][i] == 0) {
			rowHasZero = true;
			break;
		}
	}
	// check if first column has a zero
	for (int i = 0; i < matrix.length; i++) {
		if (matrix[i][0] == 0) {
			colHasZero = true;
			break;
		}
	}
	// check for zeros in the rest of the array
	for (int i = 1; i < matrix.length; i++) {
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[i][j] == 0) {
				matrix[i][0] = 0;;
				matrix[0][j] = 0;
			}
		}
	}
	// nullify rows based on values in first column
	for (int i = 1; i < matrix.length; i++) {
		if (matrix[i][0] == 0) {
			nullifyRow(matrix, i);
		}
	}
	// nullify columns based on values in first row
	for (int j = 1; j < matrix[0].length; j++) {
		if (matrix[0][j]) == 0) {
			nullifyColumn(matrix, j);
		}
	}

	if (rowHasZero) {
		nullifyRow(matrix, 0);
	}

	if (colHasZero) {
		nullifyCol(matrix, 0);
	}

}

// check if string is rotation of another
public static String isRotation(String s1, String s2) {
	if (s1.length == s2.length) {
		return isSubstring(s1, s2+s2);
	}
	return false;
}
