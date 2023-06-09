class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //count用于统计words中所有单词的最小字母出现次数，
        //大小设置为12是为了避免下面进行判定的时候出现越界而做的冗余处理
        int[] count = new int[12];
        for (String word:words)
            count[counts(word)]++;
        //计算后缀和，现在count[i]表示最小字母出现次数大于或等于i的单词总数。
        for (int i=9;i>=0;i--)
            count[i]+=count[i+1];
        //结果数组
        int[] result = new int[queries.length];
        //遍历queries中的每个字符串，利用前面计算得到的count数组，可以直接得到答案。
        for (int i=0;i<queries.length;i++)
            result[i]=count[counts(queries[i])+1];
        return result;
    }

    //counts方法用于统计字符串s中最小字母出现的次数
    private int counts(String s){
        char c = s.charAt(0);
        int count = 1;
        for (int i=1;i<s.length();i++){
            char temp = s.charAt(i);
            if (temp==c)
                count++;
            else if (temp<c){
                c=temp;
                count=1;
            }
        }
        return count;
    }
}
