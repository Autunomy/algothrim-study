2251. 花期内花的数目
```java
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        var starts = new int[n];
        var ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < people.length; i++) {
            people[i] = lowerBound(starts, people[i] + 1) - lowerBound(ends, people[i]);
        }
        return people;
    }

    // 返回 >= x 的第一个数的下标
    // 如果不存在（所有元素都小于 x），则返回 nums.length
    private int lowerBound(int[] nums, int x) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < x
            // nums[right] >= x
            int mid = left + (right - left) / 2;
            if (nums[mid] < x) {
                left = mid; // 区间缩小为 (mid, right)
            } else {
                right = mid; // 区间缩小为 (left, mid)
            }
        }
        return right; // 根据循环不变量，此时 right 就是满足 nums[right] >= x 的最小值
    }
}
```