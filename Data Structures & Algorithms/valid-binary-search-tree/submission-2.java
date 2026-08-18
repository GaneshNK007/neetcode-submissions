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
    List<Integer> l;
    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        l.add(root.val);
        dfs(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        l= new ArrayList<>();
        dfs(root);
        int s = l.size();
        for(int i=1;i<s;i++){
            if(l.get(i-1) >= l.get(i)){
                return false;
            }
        }

        return true;
    }
}
