需要使用组合的算法,具体可以看[y中的题解](https://www.bilibili.com/video/BV1hN4y1X7ZB/?spm_id_from=top_right_bar_window_dynamic.content.click&vd_source=734e69f10219139821e38611a49c3e88)

```java
class Solution {
    int MOD = 1000000007;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        if(k > 26) return 0;
        int n = s.length();

        int[] cnt = new int[26];
        for(int i=0;i<n;++i){
            cnt[s.charAt(i) - 'a'] ++;
        }
        Arrays.sort(cnt);
        for (int min = 0, max = cnt.length - 1; min < max; min++, max--) {
            int temp = cnt[min];
            cnt[min] = cnt[max];
            cnt[max] = temp;
        }

        int left = k-1,right = k-1;

        while(left > 0 && cnt[left] == cnt[left - 1]) left --;
        while(right + 1 < 26 && cnt[right] == cnt[right + 1]) right ++;

        long res = 1;
        for(int i=0;i<k;++i) res = res * cnt[i] % MOD;

        return (int)(res * C(right - left + 1,k - left) % MOD);
    }

	long C(long a, long b) {
		long res = 1;
        for(long i = a,j = 1; j <= b ; i -- , j ++){
            res = res * i / j % MOD;
        }

        return res;
	}

}
```