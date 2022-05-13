package Tree_Breadth_First_Search;

import java.util.*;

class LevelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {
    if (root == null)
      return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      // insert the children of current node in the queue
      if (currentNode.left != null)
        queue.offer(currentNode.left);
      if (currentNode.right != null)
        queue.offer(currentNode.right);

      // break if we have found the key
      if (currentNode.val == key)
        break;
    }

    return queue.peek();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
    if (result != null)
      System.out.println(result.val + " ");

    root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");

    result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
  }
}
