1962. 移除石子使总数最小

```java
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int pile : piles) {
            pq.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            int pile = pq.poll();
            pile -= pile / 2;
            pq.offer(pile);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
```