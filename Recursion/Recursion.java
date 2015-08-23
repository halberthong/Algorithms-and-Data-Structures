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
        res.add(new ArrayList(list));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
