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
    int count =0;
    public void dfs(TreeNode root,int min){
        if(root==null) return;

        if(root.val >= min){
            count++;
        }
        
        min = Math.max(min,root.val);

        dfs(root.left,min);
        dfs(root.right,min);
        
    }
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
}
