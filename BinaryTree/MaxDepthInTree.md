## 二叉树的最大深度

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int nLeft = maxDepth(root.left);
        int nRight = maxDepth(root.right);
        return nLeft > nRight ? (nLeft+1) : (nRight+1);
    }
}
```java