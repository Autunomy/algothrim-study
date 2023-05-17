//将其都转化为分钟，然后判断即可
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int l1 = Integer.valueOf(event1[0].substring(0,2)) * 60 + Integer.valueOf(event1[0].substring(3));
        int r1 = Integer.valueOf(event1[1].substring(0,2)) * 60 + Integer.valueOf(event1[1].substring(3));
        int l2 = Integer.valueOf(event2[0].substring(0,2)) * 60 + Integer.valueOf(event2[0].substring(3));
        int r2 = Integer.valueOf(event2[1].substring(0,2)) * 60 + Integer.valueOf(event2[1].substring(3));
        return (l1 >= l2 && l1 <= r2) || (r1 <= r2 && r1 >= l2) || (l2 >= l1 && l2 <= r1) || (r2 >= l1 && r2 <= r1);
    }
}