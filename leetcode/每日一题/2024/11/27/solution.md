3208. 交替组 II

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int n = colors.length;
        // 成环将最后一个元素做为k个连续的瓷砖的开始，则还需要在数据末尾增加k - 1个元素，这样减少一些特殊逻辑
        int[] arr = new int[n + k - 1];
        
        // 填充元素
        for(int i = 0 ; i < n; ++i) {
            arr[i] = colors[i];
        }
        for(int i = n; i < n + k - 1; ++ i) {
            arr[i] = colors[i-n];
        }
        
        // 双指针
        int left = 0, right = 0;
        while(right < n + k - 1) {
            // right不是起始点且相邻的前面的瓷砖与当前瓷砖颜色相同
            if(right != 0 && arr[right] == arr[right-1]) {
                // 此时只要包含这两块瓷砖的组都不满足条件 则将窗口放置在右边瓷砖部分，跳过这两块相同的瓷砖
                left = right;
                right ++;
                continue;
            }
            // 滑动窗口的瓷砖数量恰好是k个
            if(right - left == k - 1) {
                res ++;
                // 继续向后滑动
                right ++;
                left ++;
            } else if(right - left > k - 1) {
                // 多于k个
                left ++;
            } else {
                // 少于k个
                right ++;
            }
        }

        return res;
    }
}
```