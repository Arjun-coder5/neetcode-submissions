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
    int pIdx = 0;
    int iIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return soln(preorder,inorder,Integer.MAX_VALUE);
    }
    public TreeNode soln(int[] preorder,int[] inorder,int limit){
        if(pIdx>=preorder.length)return null;
        if(inorder[iIdx]==limit){
            iIdx++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pIdx++]);
        root.left = soln(preorder,inorder,root.val);
        root.right = soln(preorder,inorder,limit);
        return root;

    }
}
