//2490. 回环句
class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)){
            // System.out.println("123");
            return false;
        }

        for(int i=1;i<sentence.length();++i){
            if(sentence.charAt(i) == ' ' && sentence.charAt(i-1) != sentence.charAt(i+1)){
                // System.out.println(sentence.charAt(i-1) + " " + sentence.charAt(i+1));
                return false;
            }
        }
        return true;
    }
}