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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null; // If root is null then return null
        }

        if(p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val ){//p smaller than root and q is bigger or p is bigger than q is smaller
            return root;// return root since mean they both have the same LCA, this get check every recursive
        } else if(p.val > root.val && q.val > root.val){
            //else if p and q is bigger then you move the right node of the right of the root and it check it p and q in the beging
            return lowestCommonAncestor(root.right,p,q);
            
        } else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
            //else if p and q is smaller then you move the left node of the left of the root and it check it p and q in the beging


        } else{//return the root
            return root;
        }
        
    }
}
