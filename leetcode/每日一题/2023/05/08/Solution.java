/*
题目：1263. 推箱子
原题链接：https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/description/

基本思路是使用BFS求推动次数。注意：这里并不是人走的步数，而是箱子被推动的次数，也就是说计算的是
箱子移动的步数
有两个物体在移动,那就使用两个bfs来求。为了防止重复计算，使用一个st数组记录人在[i,j]并且箱子在
[k,z]这个状态是否被搜过
推动次数更新的规则是：人走到了和箱子的同一个位置时，箱子可以被推动一次。

*/
class Solution {
    public int minPushBox(char[][] grid) {
        int px=0,py=0,bx=0,by=0,tx=0,ty=0;
        int n = grid.length;
        int m = grid[0].length;

        //找人、箱子，终点的初始位置
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j] == 'S'){
                    px = i;
                    py = j;
                }

                if(grid[i][j] == 'B'){
                    bx = i;
                    by = j;
                }

                if(grid[i][j] == 'T'){
                    tx = i;
                    ty = j;
                }
            }
        }

        //移动量
        int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //st[i][j][k][z]表示人在[i,j]箱子在[k,z]这个状态是否被经过
        boolean[][][][] st = new boolean[n][m][n][m];
        //数组中的元素依次为 人的横纵坐标 箱子的横纵坐标 当前箱子推动的次数 堆按照箱子的推动次数排序 是小根堆
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[4] - o2[4]);
        q.add(new int[]{px,py,bx,by,0});

        while(!q.isEmpty()){
            int len = q.size();
            
            while(len -- > 0){
                int[] arr = q.poll();

                if(grid[arr[2]][arr[3]] == 'T'){
                    return arr[4];
                }

                for(int[] p : pos){
                    int newpx = arr[0] + p[0];
                    int newpy = arr[1] + p[1];
                    int newbx = arr[2];
                    int newby = arr[3];
                    int step = arr[4];
                    //如果人走到箱子上了 那么箱子就可以向前走一步 方向一定和人移动的方向相同
                    if(newpx == newbx && newpy == newby){
                        newbx += p[0];
                        newby += p[1];
                        step ++;
                    }
                    //判断移动是否合法
                    if(newpx < 0 || newpx >= n || newpy < 0 || newpy >= m || newbx < 0 || newbx >= n || 
                        newby < 0 || newby >= m || grid[newpx][newpy] == '#' || grid[newbx][newby] == '#')
                        continue;

                    //判断是否已经处理过了当前状态
                    if(!st[newpx][newpy][newbx][newby]){
                        st[newpx][newpy][newbx][newby] = true;
                        q.offer(new int[]{newpx,newpy,newbx,newby,step});
                    }
                }
            }
        }
        return -1;
    }
}