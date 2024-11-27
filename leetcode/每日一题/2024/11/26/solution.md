3206. 交替组 I

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i] = colors[i];
        }
        arr[n] = colors[0];
        arr[n+1] = colors[1];
        int res = 0;
        int left = 0, right = 2;
        while(right < n + 2) {
            if (arr[left] != arr[left + 1] && arr[left + 1] != arr[right]) {
                res ++;
            }
            left ++;
            right ++;
        }

        return res;
    }
}
```