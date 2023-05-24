/*
思路：DFS遍历整个二叉树，在遍历过程中保存当前节点的子节点，以及当前节点的概率
如果遍历到了target,还需要判断是否是叶子结点或者t为0
*/
class Solution {
    boolean[] st;
    Map<Integer,List<Integer>> map;
    double res = 0.0;
    public double frogPosition(int n, int[][] edges, int t, int target) {

        if(edges == null || edges.length == 0){
            return 1.0;
        }
        map = new HashMap<>();

        for(int i=0;i<edges.length;++i){
            if(map.get(edges[i][0]) == null){
                map.put(edges[i][0],new ArrayList<>());
            }
            if(map.get(edges[i][1]) == null){
                map.put(edges[i][1],new ArrayList<>());
            }

            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        st = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        list.add(1);
        dfs(list,1.0,target,t);

        return res;
    }   

    void dfs(List<Integer> list,double lastG,int target,int t){
        //为空直接返回
        if(list.size() == 0) return;
        //时间用完了也直接返回
        if(t < 0) return;
        for(int i : list){
            st[i] = true;
            //计算当前节点的概率
            double gv = 1.0 / list.size() * lastG;
            //找到了target
            if(i == target){
                boolean flag = true;
                //判断是不是叶子结点
                for(int j : map.get(i)){
                    if(!st[j]){
                        flag = false;
                        break;
                    }
                }

                if(flag || t == 0)
                    res = gv;
                else res = 0.0;
                return;
            }
            //继续遍历下一层(每个节点的所有子节点为一组)
            List<Integer> temp = new ArrayList<>();
            for(int j : map.get(i)){
                if(!st[j]){
                    st[j] = true;
                    temp.add(j);
                }
            }
            dfs(temp,gv,target,t-1);
        }
    }
}