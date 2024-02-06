LCP 30. 魔塔游戏

```java
class Solution {
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int ans = 0;
        long hp = 1, delay = 0;
        for (int num : nums) {
            if (num < 0) {
                pq.offer(num);
            }
            hp += num;
            if (hp <= 0) {
                ++ans;
                int curr = pq.poll();
                delay += curr;
                hp -= curr;
            }
        }
        hp += delay;
        return hp <= 0 ? -1 : ans;
    }
}
```