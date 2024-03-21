2671. 频率跟踪器

```java
class FrequencyTracker {
    Map<Integer,Integer> map = new HashMap<>();
    int[] cnt = new int[200010];
    public FrequencyTracker() {
        
    }
    
    public void add(int number) {
        if(map.get(cnt[number]) != null && map.get(cnt[number]) >= 1) map.put(cnt[number],map.get(cnt[number])-1);
        cnt[number] ++;
        map.put(cnt[number],map.getOrDefault(cnt[number],0) + 1);
    }
    
    public void deleteOne(int number) {
        if(cnt[number] > 0){
            map.put(cnt[number],map.get(cnt[number])-1);
            cnt[number] --;
            map.put(cnt[number],map.getOrDefault(cnt[number],0) + 1);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        if(map.get(frequency) != null && map.get(frequency) > 0) return true;
        return false;
    }
}
```