import javax.management.InstanceAlreadyExistsException;
import java.util.NoSuchElementException;

public class IntSuchbaum {
    Baum root;
    DynArray transversalFolge = new DynArray();
    class Baum {
        Integer data;
        Baum left;
        Baum right;

        Baum(Integer content) {
            data = content;
            left = null;
            right = null;
        }
    }

    public IntSuchbaum() {
        root = null;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

//    public Baum remove(Baum currentNode, Integer i) {
//        if (currentNode == null) {
//            return currentNode;
//        }
//        if (i < currentNode.data) {
//            root.left = remove(currentNode.left, i);
//        } else if (i > currentNode.data) {
//            root.right = remove(currentNode.right, i);
//        } else {
//
//            if (currentNode.left == null) {
//                return currentNode.right;
//            } else if (currentNode.right == null) {
//                return currentNode.left;
//            }
//
//            currentNode.data = inOrderSuccessor(root.right);
//            root.right = remove(root.right, (int) root.data);
//        }
//
//        return currentNode;
//    }
//
//    public static int inOrderSuccessor(Baum root) {
//        int minimum = (int) root.data;
//        while (root.left != null) {
//            minimum = (int) root.left.data;
//            root = root.left;
//        }
//        return minimum;
//    }
//
//    public void remove(Integer i) {
//        if (!this.contains(i)) {
//            throw new NoSuchElementException();
//        } else {
//            this.remove(root, i);
//        }
//    }

    public Baum insertRecursive(Baum currentNode, Integer i) throws InstanceAlreadyExistsException {
        if (currentNode == null) {
            return new Baum(i);
        }

        if (i < currentNode.data) {
            currentNode.left = insertRecursive(currentNode.left, i);
        } else if (i > currentNode.data) {
            currentNode.right = insertRecursive(currentNode.right, i);
        } else {
            throw new InstanceAlreadyExistsException(i + " already exists");
        }
        return currentNode;
    }

    public void insert(Integer i) {
        try {
            root = insertRecursive(root, i);
        }
        catch (InstanceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean contains(Integer i) {
        try {
            root = insertRecursive(root, i);
        }
        catch (InstanceAlreadyExistsException e) {
            //System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public String toStringRecursive(Baum currentNode) {
        String tree = "";
        boolean left = false;
        boolean right = false;
        tree += currentNode.data;
        if (currentNode.left != null) {
            tree = toStringRecursive(currentNode.left) + ")" + tree;
            left = true;
        }
        if (currentNode.right != null) {
            tree = tree + "(" + toStringRecursive(currentNode.right);
            right = true;
        }

        if (right == true) {
            tree += ")";
        }
        if (left == true) {
            tree = "(" + tree;
        }
        return tree;
    }

    public String toString() {
        String sTree = "";
        if (this.isEmpty()) {
            return "";
        } else {
            sTree = "(" + toStringRecursive(root) + ")";
            return sTree;
        }
    }

    public int depthRecursive(Baum currentNode) {
        if (currentNode == null) {
            return 0;
        } else {
            int leftDepth = depthRecursive(currentNode.left);
            int rightDepth = depthRecursive(currentNode.right);

            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }

    public int hoehe() {
        return depthRecursive(root);
    }

    public int sizeRecursive(Baum currentNode) {
        if (currentNode == null) {
            return 0;
        } else {
            return sizeRecursive(currentNode.left) + 1 + sizeRecursive(currentNode.right);
        }
    }

    public int size() {
        return sizeRecursive(root);
    }

    //Tree Traversals
    public void preorder(Baum node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    /*
    public int[] createArray() {
        int arr[] = new int[this.size()];
        return arr;
    }

     */

    public void preorderWithArray(Baum node) {
        //int arr[] = createArray();
        if (node == null) {
            return;
        } else {
            transversalFolge.addlast(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void preorder() {
        System.out.println("Preorder:");
        preorder(root);
    }

    public void inorder(Baum node) {
        if (node == null) {
            return;
        } else {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public void inorder() {
        System.out.println("Inorder:");
        inorder(root);
    }

    public void postorder(Baum node) {
        if (node == null) {
            return;
        } else {
            inorder(node.left);
            inorder(node.right);
            System.out.println(node.data);
        }
    }

    public void postorder() {
        System.out.println("Postorder:");
        postorder(root);
    }

    public void horizontalOrderByLevel(Baum node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.println(node.data);
        } else if (level > 1) {
            horizontalOrderByLevel(node.left, level - 1);
            horizontalOrderByLevel(node.right, level - 1);
        }
    }

    public void horizontalOrder() {
        System.out.println("Horizontal Order:");
        int depth = this.hoehe();
        for (int i = 1; i <= depth; i++) {
            horizontalOrderByLevel(root, i);
        }
    }
}
