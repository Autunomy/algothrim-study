1457. 二叉树中的伪回文路径

```java
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int mask) {
        if (root == null) {
            return 0;
        }
        mask ^= 1 << root.val; // 修改 root.val 出现次数的奇偶性
        if (root.left == root.right) { // root 是叶子节点
            return (mask & (mask - 1)) == 0 ? 1 : 0;
        }
        return dfs(root.left, mask) + dfs(root.right, mask);
    }
}
```