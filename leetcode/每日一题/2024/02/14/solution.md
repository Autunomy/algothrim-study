102. 二叉树的层序遍历

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode[] queue = new TreeNode[2010];
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;
        
        int head = 0;
        int tail = 0;
        queue[tail++] = root;
        while(head < tail){
            List<Integer> list = new ArrayList<>();
            int count = tail - head;
            while(count > 0){
                TreeNode temp = queue[head++];
                count--;
                if(temp != null){
                    list.add(temp.val);
                    if(temp.left != null){
                        queue[tail++]=temp.left;
                    }
                    if(temp.right != null){
                        queue[tail++]=temp.right;
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
```