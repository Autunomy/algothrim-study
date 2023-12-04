1038. 从二叉搜索树到更大和树

```java
class Solution {
    private int s = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right); // 递归右子树
        s += node.val;
        node.val = s; // 此时 s 就是 >= node.val 的所有数之和
        dfs(node.left); // 递归左子树
    }
}
```