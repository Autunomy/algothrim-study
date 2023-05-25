class Solution {
    public String oddString(String[] words) {
        for(int i=0;i<words.length;++i){
            int cnt = 0;
            for(int j=0;j<words.length;++j){
                if(words[i].length() != words[j].length()) cnt++;
                else{
                    for(int k=1;k<words[i].length();++k){
                        if((words[i].charAt(k)-words[i].charAt(k-1)) != words[j].charAt(k)-words[j].charAt(k-1)) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            if(cnt > 1) return words[i];
        }
        return "";
    }
}