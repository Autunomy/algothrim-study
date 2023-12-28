2735. 收集巧克力

```java
class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        // 找出 nums 中最小的元素，并用其为首元素构造一个新的数组
        int minIdx = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        int[] tmp = new int[n];
        for (int i = 0; i < n; ++i) {
            tmp[i] = nums[(minIdx + i) % n];
        }
        System.arraycopy(tmp, 0, nums, 0, n);

        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = n - 1;
        // 循环来看，右侧 nums[0] 是更小的元素，但不一定是第一个更小的元素，需要用单调栈计算得到
        for (int i = 0; i < n; ++i) {
            R[i] = n - i - 1;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        for (int i = 1; i < n; ++i) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                R[stack.peek()] = i - stack.peek() - 1;
                stack.pop();
            }
            L[i] = i - stack.peek() - 1;
            stack.push(i);
        }

        long[] F = new long[n];

        // 进行操作需要的成本
        diffTwice(F, 0, n - 1, x, 0);

        for (int i = 0; i < n; ++i) {
            int minv = Math.min(L[i], R[i]);
            int maxv = Math.max(L[i], R[i]);
            // 第一种情况，窗口数量 k+1，总和 nums[i] * k + nums[i]
            diffTwice(F, 0, minv, nums[i], nums[i]);
            // 第二种情况，窗口数量 minv+1，总和 0 * k + nums[i] * (minv + 1)
            diffTwice(F, minv + 1, maxv, 0, (long) nums[i] * (minv + 1));
            // 第三种情况，窗口数量 L[i]+R[i]-k+1，总和 -nums[i] * k + nums[i] * (L[i] + R[i] + 1)
            diffTwice(F, maxv + 1, L[i] + R[i], -nums[i], (long) nums[i] * (L[i] + R[i] + 1));
        }

        // 计算两次前缀和
        for (int i = 0; i < 2; ++i) {
            long[] G = new long[n];
            G[0] = F[0];
            for (int j = 1; j < n; ++j) {
                G[j] = G[j - 1] + F[j];
            }
            System.arraycopy(G, 0, F, 0, n);
        }

        long minimum = Long.MAX_VALUE;
        for (long num : F) {
            minimum = Math.min(minimum, num);
        }
        return minimum;
    }

    // 辅助函数，一次差分，将 F[l..r] 都增加 d
    public void diffOnce(long[] F, int l, int r, long d) {
        if (l > r) {
            return;
        }
        int n = F.length;
        if (l < n) {
            F[l] += d;
        }
        if (r + 1 < n) {
            F[r + 1] -= d;
        }
    }

    
    // 辅助函数，二次差分，将 F[l..r] 增加 ki + b，i 是下标
    public void diffTwice(long[] F, int l, int r, long k, long b) {
        if (l > r) {
            return;
        }
        diffOnce(F, l, l, k * l + b);
        diffOnce(F, l + 1, r, k);
        diffOnce(F, r + 1, r + 1, -(k * r + b));
    }
}
```