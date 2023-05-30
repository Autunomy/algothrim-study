class Solution {
    //答案
    List<TreeNode> res;
    //hash表存储所有的to_delete中的元素，方便快速查找
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        res = new ArrayList<>();
        for(int i=0;i<to_delete.length;++i){
            set.add(to_delete[i]);
        }

        dfs(root,null,-1);
        return res;
    }
    //root为当前节点，pre为父节点 pos为0代表左节点 1代表右节点
    void dfs(TreeNode root,TreeNode pre,int pos){
        if(root == null){
            return;
        }
        
        if(set.contains(root.val)){
            //当前节点需要删除
            if(pre != null){ // 如果不是根节点(父节点存在)，则需要将父节点的子指针也置为空
                if(pos == 0){
                    pre.left = null;
                }else{
                    pre.right = null;
                }
            }
            //子节点的父节点也就是当前节点被删除，所以pre穿null
            dfs(root.left,null,0);
            dfs(root.right,null,1);
        }else{
            //当前节点不删除
            if(pre == null){//只有是根节点才能加入答案中
                res.add(root);
            }
            dfs(root.left,root,0);
            dfs(root.right,root,1);
        }
    }
}