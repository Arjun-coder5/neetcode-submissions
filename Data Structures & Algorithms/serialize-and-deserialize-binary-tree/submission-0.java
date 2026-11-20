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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs1(root,res);
        return String.join(",", res);
    }
    public void  dfs1(TreeNode root,List<String> res){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs1(root.left,res);
        dfs1(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
            String[] val = data.split(",");
            int[] i = {0};
           return  dfs2(val,i);
    }
    public TreeNode dfs2(String[] val,int[] i){
        if (val[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        node.left = dfs2(val, i);
        node.right = dfs2(val, i);
        return node;

    }
}
