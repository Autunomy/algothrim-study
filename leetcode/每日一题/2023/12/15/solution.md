2415. 反转二叉树的奇数层

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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        if(root.left == null || root.right == null) return root;
        
        TreeNode[] queue = new TreeNode[1 << 14 + 1];
        
        int head = 0,tail = 0;
        queue[tail ++] = root.left;
        queue[tail ++] = root.right;
        boolean flag = true;
        while(head < tail){
            int n = tail - head;
            List<TreeNode> node = new ArrayList<>();
            List<Integer> v = new ArrayList<>();
            
            while(n > 0){
                TreeNode temp = queue[head ++];
                node.add(temp);
                v.add(temp.val);
                
                if(temp.left != null) {
                    queue[tail ++] = temp.left;
                    queue[tail ++] = temp.right;
                }
                n--;
               
            }
            System.out.println(n);
            if(flag){
                for(int i=0,j=v.size()-1;i<v.size();++i,--j){
                    node.get(i).val = v.get(j);
                }
            }
            flag = !flag;
        }
        return root;

    }
}
```