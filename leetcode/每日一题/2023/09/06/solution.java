//1123. 最深叶节点的最近公共祖先
class Solution {
    private TreeNode ans;
    private int maxDepth = -1; // 全局最大深度

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth); // 维护全局最大深度
            return depth;
        }
        int leftMaxDepth = dfs(node.left, depth + 1); // 获取左子树最深叶节点的深度
        int rightMaxDepth = dfs(node.right, depth + 1); // 获取右子树最深叶节点的深度
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth)
            ans = node;
        return Math.max(leftMaxDepth, rightMaxDepth); // 当前子树最深叶节点的深度
    }
}