将偶数位上的所有字符都放在一起然后排序进行比较
将奇数位上的所有字符都放在一起然后排序进行比较
如果上面两个条件都成功，就是true，反之就是false

```java
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0;i<n;++i){
            arr1[i] = s1.charAt(i);
            arr2[i] = s2.charAt(i);
        }
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i=0;i<n;i+=2){
            list1.add(arr1[i]);
            list2.add(arr2[i]);
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        for(int i=0;i<list1.size();++i){
            if(list1.get(i) != list2.get(i)) return false;
        }

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for(int i=1;i<n;i+=2){
            list1.add(arr1[i]);
            list2.add(arr2[i]);
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for(int i=0;i<list1.size();++i){
            if(list1.get(i) != list2.get(i)) return false;
        }
        
        return true;
    }
}
```