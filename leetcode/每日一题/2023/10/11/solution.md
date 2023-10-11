2512. 奖励最顶尖的 K 名学生

```java
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        for(int i=0;i<positive_feedback.length;++i) s1.add(positive_feedback[i]);
        for(int i=0;i<negative_feedback.length;++i) s2.add(negative_feedback[i]);
        int[] s = new int[student_id.length];
        for(int i=0;i<report.length;++i){
            String[] temp = report[i].split(" ");
            for(int j=0;j<temp.length;++j){
                // System.out.println(temp[i]);
                if(s1.contains(temp[j])){
                    s[i] += 3;
                }
                if(s2.contains(temp[j])){
                    s[i] -= 1;
                }
            }
        }
        //双关键字排序
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<student_id.length;++i){
            map.put(student_id[i],s[i]);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer>e1,Map.Entry<Integer,Integer>e2){
                int re = e2.getValue().compareTo(e1.getValue());
                if(re!=0){return re;}
                else{return e1.getKey().compareTo(e2.getKey());}
            }
        });
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;++i){
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
```