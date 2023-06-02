class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] arr = new int[words.length];
        for(int i=0;i<arr.length;++i){
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length()-1))){
                arr[i] = 1;
            }
        }
        for(int i=1;i<arr.length;++i) arr[i] = arr[i-1] + arr[i];
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;++i){
            if(queries[i][0] == 0){
                res[i] = arr[queries[i][1]];
            }else{
                res[i] = arr[queries[i][1]] - arr[queries[i][0] - 1];
            }
        }
        return res;
    }
}