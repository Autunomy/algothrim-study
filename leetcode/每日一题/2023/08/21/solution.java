//2337.移动片段得到字符串
class Solution {
    public boolean canChange(String start, String target) {
        //1.判断在没有_的情况下两个字符串是否相等
        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();
        for(int i=0;i<start.length();++i){
            if(start.charAt(i) != '_') sbs.append(start.charAt(i));
            if(target.charAt(i) != '_') sbt.append(target.charAt(i));
        }
        if(!sbs.toString().equals(sbt.toString())) return false;

        int cntleft = 0;
        int cntright = 0;

        //2.判断移动能否形成target  判断方式就是cntleft必须是小于等于0的，如果不是小于等于0则说明在start的L右边存在一个L不能够被形成
        for(int i=0;i<start.length();++i){
            if(start.charAt(i) == 'L') cntleft ++;
            if(target.charAt(i) == 'L') cntleft --;
            if(cntleft > 0) return false;
        }

        for(int i=start.length()-1;i>=0;--i){
            if(start.charAt(i) == 'R') cntright ++;
            if(target.charAt(i) == 'R') cntright --;
            if(cntright > 0) return false;
        }

        return true;
    }
}