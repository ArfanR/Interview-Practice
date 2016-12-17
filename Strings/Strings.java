import java.io.*;
import java.util.*;

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

	// Time complexity: O(n)
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

	// Time complexity: O(n)
	// Count white spaces and fill in new char array backward
	public static void replaceSpace(char[] str, int trueLength) {
		int spaces = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				spaces++;
			}
		}

		int newIndex = trueLength + spaces*2;
		if (trueLength < str.length) {
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

	// Time Complexity: O(n)
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

	// Time Complexity: O(n)
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

	public static void main(String[] args) {
		System.out.println(Strings.oneEdit("ple", "pale"));
		System.out.println(Strings.oneEdit("pales", "pale"));
		System.out.println(Strings.oneEdit("pale", "bale"));
		System.out.println(Strings.oneEdit("pale", "bae"));

	}

}