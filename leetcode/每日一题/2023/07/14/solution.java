//979. 在二叉树中分配硬币
//看灵神的题解即可
class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    //返回值 第一个值是节点数量 第二个值是硬币数量
    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int nodeNum = left[0] + right[0] + 1;
        int coinNum = left[1] + right[1] + root.val;

        res += Math.abs(nodeNum - coinNum);

        return new int[]{nodeNum,coinNum};
    }
}