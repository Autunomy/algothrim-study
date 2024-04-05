1026. 节点与其祖先之间的最大差值

```java
class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return res;
    }

    //[最大,最小]
    public int[] dfs(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return new int[]{root.val,root.val};
        int[] arr1 = dfs(root.left);
        int[] arr2 = dfs(root.right);
        if(arr1 == null) arr1 = arr2;
        if(arr2 == null) arr2 = arr1;
        int[] arr = new int[]{Math.max(arr1[0],arr2[0]),Math.min(arr1[1],arr2[1])};
        res = Math.max(res,Math.abs(root.val - arr[0]));
        res = Math.max(res,Math.abs(root.val - arr[1]));

        return new int[]{Math.max(root.val,arr[0]),Math.min(root.val,arr[1])};

    }
}
```