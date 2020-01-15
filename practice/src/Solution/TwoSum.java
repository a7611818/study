package Solution;

/**
 * 1. Two Sum
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    /**
     * 用hashMap，因为HashMap根据key找到value的期望时间为O(1)
     */
}