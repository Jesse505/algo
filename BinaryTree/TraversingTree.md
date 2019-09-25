## 二叉树遍历

### 前序遍历

中 -> 左 -> 右

```java
    /**
     * 前序遍历——递归
     * @author Jesse
     */
    public void preOrder(TreeNode node){
        if(node == null){
            return;
        }else{
            System.out.print(node.getData());
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }


    /**
     * 前序遍历——非递归
     * 1、首先申请一个新的栈，记为stack；
     * 2、将头结点head压入stack中；
     * 3、每次从stack中弹出栈顶节点，记为cur，然后打印cur值，如果cur右孩子不为空，则将右孩子压入栈中；      * 4、如果cur的左孩子不为空，将其压入stack中；
     * 5、重复步骤3，直到stack为空.
     */
    public void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            //出栈和进栈
            TreeNode cur = stack.pop();//弹出根结点
            System.out.print(cur.getData());
            if(cur.rightChild!=null){
                stack.push(cur.rightChild);
            }
            if(cur.leftChild!=null){
                stack.push(cur.leftChild);
            }
        }
    }
```



### 中序遍历

左 -> 中 -> 右

```java
    /**
     * 中序遍历——递归
     * @author Jesse
     */
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }else{
          	inOrder(node.leftChild);
            System.out.print(node.getData());
            inOrder(node.rightChild);
        }
    }

		/**
     * 中序遍历——非递归
     * @author Jesse
     */
		public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
              	//找到最左边的结点
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.getData());
                cur = cur.right;
            }
        }
        return res;
    }
```



### 后序遍历

左 -> 右 -> 根

```java
    /**
     * 后序遍历——递归
     * @author Jesse
     */
    public void posOrder(TreeNode node){
        if(node == null){
            return;
        }else{
          	posOrder(node.leftChild);
            posOrder(node.rightChild);
          	System.out.print(node.getData());
        }
    }


public void PosOrder(TreeNode<char> treeNode)
{
    if (treeNode == null)
    {
        return;
    }

    Stack<TreeNode<char>> stack1 = new Stack<TreeNode<char>>();
    Stack<TreeNode<char>> stack2 = new Stack<TreeNode<char>>();

    stack1.Push(treeNode);
    while (!stack1.isEmpty())
    {
        TreeNode<char> cur = stack1.Pop();
        if (cur.LChild != null)
        {
            stack1.Push(cur.LChild);
        }
        if (cur.RChild != null)
        {
            stack1.Push(cur.RChild);
        }
        stack2.Push(cur);
    }

    while (!stack2.isEmpty())
    {
        TreeNode<char> node = stack2.Pop();
        Console.WriteLine(node.Data); ;
    }
}
```



### 层序遍历

```java
/**
	*1、首先申请一个新的队列，记为queue；
  *2、将头结点head压入queue中；
  *3、每次从queue中出队，记为node，然后打印node值，如果node左孩子不为空，则将左孩子入队；如果node的右				孩子不为空，则将右孩子入队；
	*4、重复步骤3，直到queue为空。
	*/
public static void LevelOrder(TreeNode<char> treeNode)
{
    if(treeNode == null)
    {
         return;
    }
    Queue<TreeNode<char>> queue = new Queue<TreeNode<char>>();
    queue.Enqueue(treeNode);

    while (queue.Any())
    {
        TreeNode<char> node = queue.Dequeue();
        Console.Write(node.Data);

        if (node.Left != null)
        {
            queue.Enqueue(node.Left);
        }

        if (node.Right != null)
        {
            queue.Enqueue(node.Right);
        }
    }
}
```

