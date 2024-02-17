429. N 叉树的层序遍历

```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < cnt; ++i) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }

        return ans;
    }
}
```