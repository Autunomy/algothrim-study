//722.删除注释
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();

        boolean isleft = false;
        
        String str = "";
        for(int i=0;i<source.length;++i){
            str += source[i] + "\n";
        }

        for(int i=0;i<str.length();){
            if(str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i+1) == '/'){
                int j = i + 2;
                while(str.charAt(j) != '\n') j++;
                str = str.substring(0,i) + "\n" + str.substring(j + 1);
            }else if(str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i+1) == '*'){
                int j = i + 2;
                while(!(str.charAt(j) == '*' && str.charAt(j+1) == '/')) j++;
                str = str.substring(0,i) + str.substring(j + 2);
            }else i++;
            System.out.println(str);
        }

        String[] arr = str.split("\n");
        for(int i=0;i<arr.length;++i){
            if(arr[i].length() != 0)
                res.add(arr[i]);
        }

        return res;
    }   
}