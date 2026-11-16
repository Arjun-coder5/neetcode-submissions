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
    public int goodNodes(TreeNode root) {
        int count = 0;
          return   countGoodNode(root,count,Integer.MIN_VALUE);
    }
    public int countGoodNode(TreeNode root,int count,int max){
        if(root==null)return 0;
        if(root.val>=max){
            count++;
        }   
        max = Math.max(max,root.val);
      count +=  countGoodNode(root.right,0,max);
         count +=  countGoodNode(root.left,0,max);
        return count;
    }
}
