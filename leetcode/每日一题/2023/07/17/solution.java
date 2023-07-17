//415.字符串相加
class Solution {
    public String addStrings(String num1, String num2) {
        List<Integer> list = new ArrayList<>();

        int ops = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;

        while(i >= 0 && j >= 0){
            int num = num1.charAt(i)-'0' + num2.charAt(j) - '0' + ops;
            list.add(num%10);
            ops = num/10;

            i--;
            j--;
        }

        while(i >= 0){
            int num = num1.charAt(i)-'0' +ops;
            list.add(num%10);
            ops = num / 10;
            i--;
        }
        while(j >= 0){
            int num = num2.charAt(j)-'0' +ops;
            list.add(num%10);
            ops = num / 10;
            j--;
        }

        if(ops!=0) list.add(ops);

        StringBuilder sb = new StringBuilder();
        for(int k=0;k<list.size();++k) sb.append(list.get(k));

        return sb.reverse().toString();
    }
}
