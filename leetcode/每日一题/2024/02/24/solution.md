2476. 二叉搜索树最近节点查询

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
    List<Integer> nums = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root);
        for(int i=0;i<queries.size();++i){
            int x = queries.get(i);
            List<Integer> temp = new ArrayList<>();
            int l=0,r=nums.size()-1;
            while(l < r){
                int mid = l + (r-l)/2;
                if(nums.get(mid)<x){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }
            if(nums.get(r) <= x){
                temp.add(nums.get(r));
            }else if(r > 0 && nums.get(r-1) <= x){
                temp.add(nums.get(r-1));
            }else{
                temp.add(-1);
            }
            if(nums.get(r) >= x){
                temp.add(nums.get(r));
            }else{
                temp.add(-1);
            }
            res.add(temp);
        }
        return res;
    }

    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }

}
```