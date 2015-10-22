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

	public boolean isSubstring(String needle, String haystack) {
		/*
		checks if needle is a substring of haystack
		O(N^2) time
		*/
		if(needle == null || haystack == null) {
			return false;
		}
		if(haystack.length() == 0) {
			return true;
		}
		for(int j = 0; ; j++) {
			for(int i = 0; ; i++) {
				if(i == needle.length()) return true;
				if(i + j == haystack.length()) return false;
				if(needle.charAt(i) != haystack.charAt(i + j)) break;
			}
		}
	}

	public boolean isRotation(String s, String t) {
		if(s == null || t == null || s.length() != t.length()) {
			return false;
		}
		String ss = s + s;
		return isSubstring(t, ss);
	}

	public void printReverseDiagonal(int[][] arr) {
		/*
		1 2 3
		4 5 6 ---> 1 -- 2 4 -- 3 5 7 -- 6 8 -- 9
		7 8 9

		1 2 3
		4 5 6 ---> 1 -- 2 4 -- 3 5 -- 6

		1 2
		3 4   ---> 1 -- 2 3 -- 4 5 -- 6
		5 6
		*/
		if (arr == null || arr.length == 0 || arr[0].length == 0) {
			return;
		}
		System.out.println();
		int i = 0;
		int j = 0;
		int row = arr.length;
		int col = arr[0].length;
		int count = 0;
		while (i + j < row + col - 1) {
			while (i >= 0 && j >= 0 && i < row && j < col) {
				System.out.print(arr[i][j] + " ");
				j--;
				i = count - j;
			}
			System.out.print("\n");
			count++;
			if (count < col) {
				j = count;
				i = count - j;
			} else {
				j = col - 1;
				i = count - j;
			}
		}
	}

	public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        while (str.charAt(i) == ' ') i++;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        long num = 0;
        while (i < str.length()) {
            char tmp = str.charAt(i);
            if (tmp > '9' || tmp < '0') {
				if (tmp == ' ') {
					break;
				}
                else {
					throw new IllegalArgumentException("Illegal Input!");
				}
            }
            num = num * 10 + (tmp - '0');
            if (flag * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (flag * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
		return (int)num * flag;
	}

	public int[] addTwoNumbers(int[] a1, int[] a2) {
		if (a1 == null || a2 == null) {
			return null;
		}
		int carry = 0;
		int i1 = a1.length - 1;
		int i2 = a2.length - 1;
		int[] res = new int[i1 > i2 ? i1 + 1 : i2 + 1];
		int j = res.length - 1;
		while (i1 >= 0 && i2 >= 0) {
			res[j] = (a1[i1] + a2[i2] + carry) % 10;
			carry = (a1[i1] + a2[i2] + carry) / 10;
			i1--;
			i2--;
			j--;
		}
		while (i1 >= 0) {
			res[j] = (a1[i1] + carry) % 10;
			carry = (a1[i1] + carry) / 10;
			i1--;
			j--;
		}
		while (i2 >= 0) {
			res[j] = (a2[i2] + carry) % 10;
			carry = (a2[i2] + carry) / 10;
			i2--;
			j--;
		}
		if (carry > 0) {
			int[] resNew = new int[res.length + 1];
			resNew[0] = carry;
			for (int i = 1; i < resNew.length; i++) {
				resNew[i] = res[i - 1];
			}
			return resNew;
		}
		return res;
	}

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				for (int j = nums.length - 1; j >= 0; j--) {
					if (nums[j] > nums[i]) {
						swap(nums, i, j);
						reverse(nums, i + 1, nums.length - 1);
						return;
					}
				}
			}
		}
		reverse(nums, 0, nums.length - 1);
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
