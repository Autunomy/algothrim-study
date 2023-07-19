//874. 模拟行走机器人
//直接按照题目要求进行模拟即可，有个小技巧就是使用一个哈希表存储所有的路障，这样可以在O(1)时间内判断当前位置是否是路障
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0,y=0;
        int dir = 0;//北
        Set<Integer> set = new HashSet<>();
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        for(int i=0;i<obstacles.length;++i){
            set.add(obstacles[i][0] * 60010 + obstacles[i][1]);
        }

        int res = 0;

        for(int i=0;i<commands.length;++i){
            if(commands[i] == -1){
                dir = (dir + 1) % 4;
            }else if(commands[i] == -2){
                dir = (dir == 0)?3:dir-1;
            }else{
                for(int j=1;j<=commands[i];++j){
                    if(set.contains((x+dx[dir]) * 60010 + (y+dy[dir]))){
                        break;
                    }
                    x += dx[dir];
                    y += dy[dir]; 
                    res = Math.max(res,x*x+y*y);   
                }
            }
        }

        return res;
    }
}