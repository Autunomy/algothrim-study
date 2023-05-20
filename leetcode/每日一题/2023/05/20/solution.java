/*
    思路：从叶子结点向上遍历每个子树，每次都判断当前是否能形成二叉搜索树，能形成就更新答案
    不能形成就返回一个标志，表示再向上的所有子树都不能构成一个二叉搜索树
*/

class Solution {
    int res = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    //返回值为有3个元素的数组 a[0]表示子树的最大和 如果为Integer.MIN_VALUE表示子树不是一个
    //二叉搜索树,a[1]表示是当前子树的最小值，a[2]表示当前子树的最大值
    int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE};

        int[] a = dfs(root.left);
        int[] b = dfs(root.right);

        if(a[0] == Integer.MIN_VALUE) return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(b[0] == Integer.MIN_VALUE) return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE};

        if(root.val <= a[2] || root.val >= b[1]) return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE};

        int x = a[0] + b[0] + root.val;
        res = Math.max(res,x);

        int min = Math.min(a[1],b[1]);
        min = Math.min(root.val,min);
        int max = Math.max(a[2],b[2]);
        max = Math.max(root.val,max);
        
        return new int[]{x,min,max};
    }
}