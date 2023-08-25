//1448.统计二叉树中好节点的数目
class Solution {
    int goodNum = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return goodNum;
        }
        dfs(root, root.val);
        return goodNum;
    }

    public void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            goodNum++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}