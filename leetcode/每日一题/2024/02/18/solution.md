589. N 叉树的前序遍历

```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        pre(root,res);

        return res;   
    }

    public void pre(Node root,List<Integer> res){
        if(root == null) return;

        res.add(root.val);
        for(Node x : root.children){
            pre(x,res);
        }
    }
}
```