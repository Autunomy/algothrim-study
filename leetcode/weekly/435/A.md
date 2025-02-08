```java
class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); ++ i) {
            arr[s.charAt(i)-'a'] ++;
        }


        Arrays.sort(arr);

        for(int i = 25; i >=0 ; i -- ){
            if (arr[i] % 2 == 1) {
                for(int j = 0; j < 26; ++ j) {
                    if(arr[j] != 0 && arr[j] % 2 == 0){
                        return arr[i] - arr[j];
                    }
                }
            }
        }

        return 0;

    }
}
```