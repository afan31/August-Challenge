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
    
  int count = 0;
  List<Integer> al = new ArrayList<>();
  public int pathSum(TreeNode root, int sum) {
      
      calcSum(root,sum);
      return count;
  }
  
  private void calcSum(TreeNode node, int sum){
      
      if (node == null){
          return;
      }
      al.add(node.val);
      calcSum(node.left, sum);
      calcSum(node.right, sum);
      
      int tempSum = 0;
      for (int i = al.size()-1; i >= 0; i--){
          tempSum += al.get(i);
          if (tempSum == sum){
              count++;
          }
      }
      al.remove(al.size()-1);
  }
}