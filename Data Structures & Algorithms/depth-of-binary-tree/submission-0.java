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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int countl = 0;
        int countr = 0;
        countl++;
        countr++;
        countl += maxDepth(root.left);
        countr += maxDepth(root.right);
        if(countl > countr){
            return countl;
        } else {
            return countr;
        }
        
    }
}
