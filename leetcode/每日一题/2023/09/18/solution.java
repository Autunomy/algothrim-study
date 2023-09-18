//337. 打家劫舍 III
class Solution {
    public int rob(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0],arr[1]);
    }
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int tou = root.val;
        int notTou = 0;
        int[] arr1 = dfs(root.left);
        int[] arr2 = dfs(root.right);

        tou += arr1[1] + arr2[1];
        notTou = Math.max(notTou,arr1[0]+arr2[0]);
        notTou = Math.max(notTou,arr1[1]+arr2[0]);
        notTou = Math.max(notTou,arr1[0]+arr2[1]);
        notTou = Math.max(notTou,arr1[1]+arr2[1]);

        return new int[]{tou,notTou};
    }

}