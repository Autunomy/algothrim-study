2641. 二叉树的堂兄弟节点 II

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
    public TreeNode replaceValueInTree(TreeNode root) {
        LinkedList<TreeNode[]> q = new LinkedList<>();
        root.val = 0;
        if(root.left != null) q.add(new TreeNode[]{root,root.left});
        if(root.right != null) q.add(new TreeNode[]{root,root.right});
        
        
        
        while(q.size() > 0){
            int n = q.size();
            int sum = 0;
            for(int i=0;i<n;++i){
                sum += (q.get(i)[1]).val;
            }
            for(int i=0;i<n;){
                TreeNode[] temp1 = q.poll();
                TreeNode[] temp2 = null;
                i++;
                if(i < n && q.peek()[0] == temp1[0]){
                    temp2 = q.poll();
                    i++;
                }
                int a = temp1[1].val;
                temp1[1].val = sum - a;
                
                if(temp1[1].left != null) q.offer(new TreeNode[]{temp1[1],temp1[1].left});
                if(temp1[1].right != null) q.offer(new TreeNode[]{temp1[1],temp1[1].right});
                if(temp2 != null){
                    temp1[1].val -= temp2[1].val;
                    temp2[1].val = sum - a - temp2[1].val;
                    if(temp2[1].left != null) q.offer(new TreeNode[]{temp2[1],temp2[1].left});
                    if(temp2[1].right != null) q.offer(new TreeNode[]{temp2[1],temp2[1].right});
                }
            }
        }
        return root;
    }
}
```