## 是否存在给定总和的路径

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
```java


## 返回给定总和的路径

```java
public class Solution {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * 找出二叉树中和为某一值的路径（必须从根节点到叶节点）
     *
     * @param root  二叉树的根结点
     * @param target 目标值
     * @return 结果list
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        findPath(root, target, new ArrayList<>());
        return res;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            findPath(root.left, target, list);
            findPath(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }
}
```