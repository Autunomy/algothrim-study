//449. 序列化和反序列化二叉搜索树
public class Codec {
    public int cnt = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append('#');
            return sb.toString();
        }

        sb.append(root.val);
        sb.append(',');
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.charAt(0) == '#'){
            return null;
        }
        TreeNode root = pre_Traverse(data);
        return root;
    }

    //前序序列化 前序反序列化
    public TreeNode pre_Traverse(String data){
        if(cnt == data.length()){
            return null;
        }
        if(data.charAt(cnt) == '#'){
            cnt++;
            return null;
        }

        int val = 0;
        for(int i=0;i<5;++i){
            if(data.charAt(cnt) == ','){
                cnt++;
                break;
            }
            val = val*10+data.charAt(cnt)-'0';
            cnt++;
        }

        TreeNode node = new TreeNode(val);
        node.left = pre_Traverse(data);
        node.right = pre_Traverse(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;