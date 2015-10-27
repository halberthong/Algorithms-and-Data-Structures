import java.util.*;

public class Recursion {

    public List<List<Integer>> subsets (int[] nums) {
        /*
        Find all subsets of input array
        */
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        subsetsHelper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void subsetsHelper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public int minAdjustmentCost(int[] A, int target) {
        /*
         * Minimum Adjustment Cost
         * Given an integer array, adjust each integers so that the difference of
         * every adjcent integers are not greater than a given number target.
         *
         * If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
         *
         * You can assume each number in the array is a positive integer and not greater than 100
         * Example:
         * Given [1,4,2,3] and target=1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal. Return 2.
         */
        if (A == null || A.length == 0) {
            return 0;
        }
        int[][] D = new int[A.length][101];

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= 100; j++) {
                D[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    // First Element
                    D[i][j] = Math.abs(j - A[i]);
                } else {
                    for (int k = 1; k <= 100; k++) {
                        if (Math.abs(j - k) <= target) {
                            int curDiff = Math.abs(j - A[i]) + D[i - 1][k];
                            D[i][j] = Math.min(D[i][j], curDiff);
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, D[A.length - 1][i]);
        }
        return res;
    }
}
