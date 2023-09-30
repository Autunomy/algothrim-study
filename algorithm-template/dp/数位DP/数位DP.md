```java

/*
    s就是表示的是一个整数
    i表示第i位  我们从第i为开始填数字
    mask表示i前面已经填过的数字 一个整数的二进制可以表示一个集合 例如{1,3,4}可以使用[11010]表示 判断x是否存在的方法就是右移x位，如果为1就表示存在，为0表示不存在
    is_limit 表示当前位的数字大小是否受到限制 比如111，如果第一位写了1 那么第二位只能取0和1
    is_num 表示前面几位是否填写了除0之外的数字 因为如果一个数字为010，前导0需要省去
    返回值 返回s中没有重复数字的方案数 => 类似的根据这个返回值还可以求至少有一个重复数字的个数即使用n-减去当前函数的返回值
*/
public int f(String s,int i,int mask,boolean is_limit,boolean is_num){
    if(i >= s.length()){//如果每一位都已经填写完成
        return is_num?1:0;//如果前面已经有数字了 说明组成的数字不为0，那么当前方案就可以加入答案中
    }
    int res = 0;
    if(!is_num){//表示之前还没有填过数字，那么此时当前位也可以不填
        res = f(s,i+1,mask,false,false);
    }

    //当前位数字可以取到的上界 如果收到限制 那么只能取到原数字当前位的值 反之可以取到9
    int up = is_limit?(s.charAt(i)-'0'):9;
    //当前位数字的下界，如果已经填写过数字了，那么当前位可以从0开始 如果之前没有填过数字需要从1开始(因为前面的if已经把跳过当前位的情况统计过了)
    int down = is_num?0:1;
    for(int k=down;k<=up;++k){
        if(((mask >> k) & 1) == 0){ // 之前没有使用过当前数字
            //mask|(1<<d):这条语句就是将当前数字加入到集合中，位或就是有一个为1那么当前位就是1
            res += f(s,i + 1,mask|(1<<k),is_limit && k == up,true);
        }
    }
    return res;
}
```
视频讲解：https://www.bilibili.com/video/BV1rS4y1s721?share_source=copy_web 直接查看T4即可

 	

| 题目                                                         | 难度       | 题解                                                 |
| ------------------------------------------------------------ | ---------- | ---------------------------------------------------- |
| [数字 1 的个数](https://leetcode.cn/problems/number-of-digit-one/) | 困难       | [题解](http://www.autunomy.top/solution/content/183) |
| [面试题 17.06. 2出现的次数](https://leetcode.cn/problems/number-of-2s-in-range-lcci/) | 困难       | [题解](http://www.autunomy.top/solution/content/186) |
| [不含连续1的非负整数](https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/) | 困难       |                                                      |
| [最大为 N 的数字组合](https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/) | 困难(1990) |                                                      |
| [找到所有好字符串](https://leetcode.cn/problems/find-all-good-strings/) | 困难(2667) |                                                      |
| [至少有 1 位重复的数字](https://leetcode.cn/problems/numbers-with-repeated-digits/description/) | 困难       | [题解](http://www.autunomy.top/solution/content/182) |

