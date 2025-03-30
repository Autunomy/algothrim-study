2116. 判断一个括号字符串是否有效

详细题解：https://leetcode.cn/problems/check-if-a-parentheses-string-can-be-valid/solutions/1178043/zheng-fan-liang-ci-bian-li-by-endlessche-z8ac/?envType=daily-question&envId=2025-03-23
重点如下
1. 将可修改的字符看为?
2. 不需要存储所有的取值，只需要维护左右区间的端点
```java
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0) return false;

        int left = 0, right = 0;

        for(int i = 0; i < s.length(); ++ i) {
            if(locked.charAt(i) == '1') {
                // 不能变
                int x = s.charAt(i) == '(' ? 1 : -1;

                left += x;
                right += x;
                
                // 代表到现在为止没有任何办法可以凑成一个合法的括号字符串，直接返回false
                if(right < 0) return false;
            } else {
                // 左区间表示最小值，则当前值改为右括号可以让最小值最小
                left --;

                // 同理右区间是最大值，当前值改为左括号可以让最大值最大
                right ++;
            }

            // 左区间小于0，但是右区间一定大于0时，需要舍弃掉负数，改为最小的正数
            if(left < 0) {
                left = 1;
            }
        }

        return left == 0;
    }
}
```
重点需要解释一下为什么left<0的时候设置为1不是0
首先通过灵神题解中的例子1，全部都为?的场景下进行模拟，如图所示，每当出现负数的时候一定是-1，并且会有一个与之对应的一定会有一个1在取值范围内。 -1是由0变过去的，那么只有在0遇到?和右括号的时候会变为-1。
1. ？的场景下，既可以将0变为-1，也可以将0变为1，所以需要选择1做为最小值，因为-1是不合法的字符串
2. 右括号的场景下，如果前面没有出现过?，则左右区间一定相等，在前面的判断中就已经跳出循环了，如果前面出现过?，那么取值范围一定是以2为间隔进行跳跃，-1+2=1，所以1也一定存在。
