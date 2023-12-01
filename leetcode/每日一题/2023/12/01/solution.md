2661. 找出叠涂元素

```java
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] cntrow = new int[n];
        int[] cntcol = new int[m];
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        
        for(int i=0;i<m*n;++i){
            int[] temp = map.get(arr[i]);
            cntrow[temp[0]] ++;
            cntcol[temp[1]] ++;
            if(cntrow[temp[0]] == m || cntcol[temp[1]] == n) return i;
        }
        return n*m-1;
    }
}
```