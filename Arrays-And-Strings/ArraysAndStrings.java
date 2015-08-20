import java.util.*;

public class ArraysAndStrings {

	public void HelloWorld() {
		System.out.println("Hello World");
	}

	public boolean noDuplocateString1(String s) {
		if(s == null) {
			return true;
		}
		boolean[] dups = new boolean[256];
		for(int i = 0; i < s.length(); i++) {
			int cur = s.charAt(i);
			if(dups[cur]) return false;
			dups[cur] = true;
		}
		return true;
	}

	public boolean noDuplocateString2(String str) {
		/*
		Works if s only contains alphabetic characters ('a'~'z')
		Use bit manipulation
		*/
		if(str == null) {
			return true;
		}
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int dev = (str.charAt(i) - 'a');
			if((checker & (1 << dev)) > 0) {
				return false;
			}
			checker |= (1 << dev);
		}
		return true;
	}

	public String reverseString(String str) {
		if(str == null) {
			return null;
		}
		StringBuilder res = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--) {
			res.append(str.charAt(i));
		}
		return res.toString();
	}

	public String removeDuplicates(String str) {
		//O(N) time O(1) space
		if(str == null) {
			return null;
		}
		char[] chs = str.toCharArray();
		if(chs.length < 2) {
			return str;
		}
		boolean[] dups = new boolean[256];
		dups[chs[0]] = true;
		int tail = 1;
		for(int i = 1; i < chs.length; i++) {
			if(!dups[chs[i]]) {
				chs[tail] = chs[i];
				tail++;
				dups[chs[i]] = true;
			}
		}
		return new String(chs).substring(0, tail);
	}

	public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[256];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            counts[t.charAt(i)]--;
        }
        for(int j = 0; j < counts.length; j++) {
            if(counts[j] != 0) return false;
        }
        return true;
	}

	public int[][] rotateMatrix(int[][] matrix) {
		/*
		Input: N * N matrix
		Rotate the matrix clockwise by 90 degrees
		*/
		if(matrix == null) {
			return null;
		}
		int n = matrix.length;
		for(int i = 0; i < n / 2; i++) {
			for(int j = i; j < n - 1 - i; j++) {
				int top = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = top;
			}
		}
		return matrix;
	}

	public int[][] setZeros(int[][] matrix) {
		/*
		Input: M * N matrix
		if an element in an MxN matrix is 0, its entire row and column is set to 0.
		*/
		if(matrix == null) {
			return null;
		}
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	public boolean isSubstring(String s1, String s2) {
		/*
		checks if s1 is a substring of s2
		*/
		if(s1 == null || s2 == null) {
			return false;
		}
		if(s2.length() == 0) {
			return true;
		}
		for(int j = 0; ; j++) {
			for(int i = 0; ; i++) {
				if(i == s1.length()) return true;
				if(i + j == s2.length()) return false;
				if(s1.charAt(i) != s2.charAt(i + j)) break;
			}
		}
	}

	// public boolean isRotation(String s, String t) {
	// 	if(s == null || t == null || s.length() != t.length()) {
	// 		return false;
	// 	}
	//
	// }
}
