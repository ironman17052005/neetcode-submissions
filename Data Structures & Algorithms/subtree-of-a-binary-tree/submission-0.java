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
        if(root == null || subRoot == null){ // check if these root are hitting null and if yes return false, it doesnt return false back to main tho
            return false;
        }
        //Need to tranveral the root till it it node value match the same value that subroot value is 
        
    if(isSameTree(root,subRoot)){//check if root and subroot is the same
        return true; 
    } else if(isSubtree(root.left,subRoot)){
          //if not then tranversal the root left and right
         return true;
    } else if (isSubtree(root.right,subRoot)){
        return true;
    }else{
        return false;
    }

    

        
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;//check if they both null rn and at the end
        }
        
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}
