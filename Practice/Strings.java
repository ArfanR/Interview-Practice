
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
	reverseString(string, 0, string.length-1);
	int start = 0;
	int end = 0;
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
     m
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

// check if string is rotation of another
public static String isRotation(String s1, String s2) {
	if (s1.length == s2.length) {
		return isSubstring(s1, s2+s2);
	}
	return false;
}
