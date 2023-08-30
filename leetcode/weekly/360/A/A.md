```java
/*
贪心：全部选择向左或向右，求两种方案的最大值即可
*/
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;

        for(int i=0;i<moves.length();++i){
            if(moves.charAt(i) == 'L') {
                left --;
                right --;
            }else if(moves.charAt(i) == 'R'){
                left ++;
                right ++;
            }else{
                left --;
                right ++;
            }
        }

        //abs是求绝对值，将其都转换为正数然后去最大值
        return Math.max(Math.abs(left),Math.abs(right));
    }
}
```