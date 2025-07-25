public class Exercise25_01 {
  public static void main(String[] args) {
    new Exercise25_01();
  }

  public Exercise25_01() {
    BinaryTree<String> tree = new BinaryTree<String>(); 
    System.out.print("The height of tree is " + tree.height());
    
    tree.insert("Red");
    System.out.print("\nThe height of tree is " + tree.height());

    tree.insert("Green");
    System.out.print("\nThe height of tree is " + tree.height());

    BinaryTree<String> tree1 = new BinaryTree<String>(new String[]
      {"Tom", "George", "Jean", "Jane", "Kevin", "Peter", "Susan", 
        "Jen", "Kim", "Michael", "Michelle"});
    System.out.print("\nThe breadth-first traversal for tree 1 is ");
    tree1.breadthFirstTraversal();
    System.out.print("\nThe height of tree 1 is " + tree1.height());

    BinaryTree<Integer> tree2 = 
      new BinaryTree<Integer>(new Integer[]{50, 45, 35, 48, 59, 51, 58});    
    System.out.print("\nThe breadth-first traversal for tree 2 is ");
    tree2.breadthFirstTraversal();
    System.out.print("\nThe height of tree 2 is " + tree2.height());   
  }

  public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    /** Create a default binary tree */
    public BinaryTree() {
    }

    /** Create a binary tree from an array of objects */
    public BinaryTree(E[] objects) {
      for (int i = 0; i < objects.length; i++)
        insert(objects[i]);
    }


    /**
     * Return the depth of this binary tree. Depth is the number of the nodes in
     * the longest path of the tree
     */
    public int height() {
      return height(root);
    }
    public int height(TreeNode<E> root) {
      if (root == null)
        return 0; 
      else
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /** 
     * Displays the nodes in breadth-first traversal 
     * Breadth-first traversal explores the tree level-by-level
     * Starting at the root, explore each child left to right
     * then their children left to right and so on
     */
    public void breadthFirstTraversal() {
      // Use this list to compile the traversal
      java.util.LinkedList<TreeNode<E>> queue = new java.util.LinkedList<TreeNode<E>>();
    if(root == null){
      System.out.println("Tree is empty");
      return; // Tree is empty
    }
      queue.add(root); // Start with the root

      while (!queue.isEmpty()) {
        TreeNode<E> current = queue.removeFirst(); // Get the current node
        System.out.print(current.element + " "); // Display the element

        // Enqueue the left child
        if (current.left != null) {
          queue.addLast(current.left);
        }

        // Enqueue the right child
        if (current.right != null) {
          queue.addLast(current.right);
        }
      }

    }

    /** Returns true if the element is in the tree */
    public boolean search(E e) {
      TreeNode<E> current = root; // Start from the root

      while (current != null) {
        if (e.compareTo(current.element) < 0) {
          current = current.left;
        } else if (e.compareTo(current.element) > 0) {
          current = current.right;
        } else
          // element matches current.element
          return true; // Element is found
      }

      return false;
    }

    /**
     * Insert element o into the binary tree Return true if the element is
     * inserted successfully
     */
    public boolean insert(E e) {
      if (root == null)
        root = createNewNode(e); // Create a new root
      else {
        // Locate the parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null)
          if (e.compareTo(current.element) < 0) {
            parent = current;
            current = current.left;
          } else if (e.compareTo(current.element) > 0) {
            parent = current;
            current = current.right;
          } else
            return false; // Duplicate node not inserted

        // Create the new node and attach it to the parent node
        if (e.compareTo(parent.element) < 0)
          parent.left = createNewNode(e);
        else
          parent.right = createNewNode(e);
      }

      size++;
      return true; // Element inserted
    }

    protected TreeNode<E> createNewNode(E e) {
      return new TreeNode<E>(e);
    }

    /** Inorder traversal from the root */
    public void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
      if (root == null)
        return;
      inorder(root.left);
      System.out.print(root.element + " ");
      inorder(root.right);
    }

    /** Postorder traversal from the root */
    public void postorder() {
      postorder(root);
    }

    /** Postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
      if (root == null)
        return;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.element + " ");
    }

    /** Preorder traversal from the root */
    public void preorder() {
      preorder(root);
    }

    /** Preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
      if (root == null)
        return;
      System.out.print(root.element + " ");
      preorder(root.left);
      preorder(root.right);
    }

    /** Inner class tree node */
    public class TreeNode<E extends Comparable<E>> {
      E element;

      TreeNode<E> left;

      TreeNode<E> right;

      public TreeNode(E e) {
        element = e;
      }
    }

    /** Get the number of nodes in the tree */
    public int getSize() {
      return size;
    }

    /** Returns the root of the tree */
    public TreeNode getRoot() {
      return root;
    }

    /** Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
      java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
      TreeNode<E> current = root; // Start from the root

      while (current != null) {
        list.add(current); // Add the node to the list
        if (e.compareTo(current.element) < 0) {
          current = current.left;
        } else if (e.compareTo(current.element) > 0) {
          current = current.right;
        } else
          break;
      }

      return list; // Return an array of nodes
    }

    /**
     * Delete an element from the binary tree. Return true if the element is
     * deleted successfully Return false if the element is not in the tree
     */
    public boolean delete(E e) {
      // Locate the node to be deleted and also locate its parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null) {
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        } else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        } else
          break; // Element is in the tree pointed by current
      }

      if (current == null)
        return false; // Element is not in the tree

      // Case 1: current has no left children
      if (current.left == null) {
        // Connect the parent with the right child of the current node
        if (parent == null) {
          root = current.right;
        } else {
          if (e.compareTo(parent.element) < 0)
            parent.left = current.right;
          else
            parent.right = current.right;
        }
      } else {
        // Case 2: The current node has a left child
        // Locate the rightmost node in the left subtree of
        // the current node and also its parent
        TreeNode<E> parentOfRightMost = current;
        TreeNode<E> rightMost = current.left;

        while (rightMost.right != null) {
          parentOfRightMost = rightMost;
          rightMost = rightMost.right; // Keep going to the right
        }

        // Replace the element in current by the element in rightMost
        current.element = rightMost.element;

        // Eliminate rightmost node
        if (parentOfRightMost.right == rightMost)
          parentOfRightMost.right = rightMost.left;
        else
          // Special case: parentOfRightMost == current
          parentOfRightMost.left = rightMost.left;
      }

      size--;
      return true; // Element inserted
    }

    /** Obtain an iterator. Use inorder. */
    public java.util.Iterator iterator() {
      return inorderIterator();
    }

    /** Obtain an inorder iterator */
    public java.util.Iterator inorderIterator() {
      return new InorderIterator();
    }

    // Inner class InorderIterator
    class InorderIterator implements java.util.Iterator {
      // Store the elements in a list
      private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

      private int current = 0; // Point to the current element in list

      public InorderIterator() {
        inorder(); // Traverse binary tree and store elements in list
      }

      /** Inorder traversal from the root */
      private void inorder() {
        inorder(root);
      }

      /** Inorder traversal from a subtree */
      private void inorder(TreeNode<E> root) {
        if (root == null)
          return;
        inorder(root.left);
        list.add(root.element);
        inorder(root.right);
      }

      /** Next element for traversing? */
      public boolean hasNext() {
        if (current < list.size())
          return true;

        return false;
      }

      /** Get the current element and move cursor to the next */
      public Object next() {
        return list.get(current++);
      }

      /** Remove the current element and refresh the list */
      public void remove() {
        delete(list.get(current)); // Delete the current element
        list.clear(); // Clear the list
        inorder(); // Rebuild the list
      }
    }

    /** Remove all elements from the tree */
    public void clear() {
      root = null;
      size = 0;
    }
  }

  public interface Tree<E extends Comparable<E>> {
    /** Return true if the element is in the tree */
    public boolean search(E e);

    /**
     * Insert element o into the binary tree Return true if the element is
     * inserted successfully
     */
    public boolean insert(E e);

    /**
     * Delete the specified element from the tree Return true if the element is
     * deleted successfully
     */
    public boolean delete(E e);

    /** Inorder traversal from the root */
    public void inorder();

    /** Postorder traversal from the root */
    public void postorder();

    /** Preorder traversal from the root */
    public void preorder();

    /** Get the number of nodes in the tree */
    public int getSize();

    /** Return true if the tree is empty */
    public boolean isEmpty();

    /** Return an iterator to traverse elements in the tree */
    public java.util.Iterator iterator();
  }

  public abstract class AbstractTree<E extends Comparable<E>> implements
      Tree<E> {
    /** Inorder traversal from the root */
    public void inorder() {
    }

    /** Postorder traversal from the root */
    public void postorder() {
    }

    /** Preorder traversal from the root */
    public void preorder() {
    }

    /** Return true if the tree is empty */
    public boolean isEmpty() {
      return getSize() == 0;
    }

    /** Return an iterator to traverse elements in the tree */
    public java.util.Iterator iterator() {
      return null;
    }
  }
}
