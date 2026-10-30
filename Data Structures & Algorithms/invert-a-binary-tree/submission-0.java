/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {
            }
 *     TreeNode(int val) {
        this.val = val; 
            }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = root;
        if(root == null){ //check if root is empty
            return null;
        }
            temp = root.left;//temporary hold rootleft
            root.left = root.right; // make root left into root right
            root.right = temp;//make rooit right to root left
           
            invertTree(root.left); 
            invertTree(root.right);
        
        return root;
    }
}
