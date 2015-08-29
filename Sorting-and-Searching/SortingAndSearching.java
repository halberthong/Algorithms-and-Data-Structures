import java.util.*;

public class SortingAndSearching {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null || B == null) return;
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(A[i] >= B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while(i >= 0) {
            A[index--] = A[i--];
        }
        while(j >= 0) {
            A[index--] = B[j--];
        }
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) return 0.0;
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    public int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        int A_mid = A_start + k / 2 - 1 < A.length ?
                    A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_mid = B_start + k / 2 - 1 < B.length ?
                    B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        if (A_mid < B_mid) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}
