605. 种花问题
先将原数组前后分别扩大一个元素，标记为0，代表是边界，然后从中间开始遍历，要是前中后都为0表示中间可以种花，就将中间置为1并且给答案+1，最后将能种的数量与n的大小进行比较
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        int[] arr = new int[flowerbed.length + 2];
        for(int i=1;i<=flowerbed.length;++i){
            arr[i] = flowerbed[i - 1];
        }

        for(int i=1;i<=flowerbed.length;++i){
            if(arr[i-1] == 0 && arr[i] == 0 && arr[i+1] == 0){
                arr[i] = 1;
                res ++;
            }
        }
        return res >= n;
    }
}
```