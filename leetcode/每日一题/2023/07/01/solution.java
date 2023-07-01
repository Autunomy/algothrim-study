//1. 两数之和
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Iterate over the array.
        for (int i = 0; i < nums.length; i++) {
            // Iterate over the rest of the array.
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum of the two values is equal to the target, return the indices.
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        // If no such pair is found, return null.
        return null;
    }
}