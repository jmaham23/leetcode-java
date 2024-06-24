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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        else if(root == null){
            return false;
        }
        else if(match(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean match(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        else if(p == null && q != null){
            return false;
        }
        else if(p != null & q == null){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }
        else{
            return match(p.left, q.left) && match(p.right, q.right);
        }
    }
}