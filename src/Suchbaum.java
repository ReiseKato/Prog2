import javax.management.InstanceAlreadyExistsException;

public class Suchbaum <T extends Comparable<T>>{
    Baum root;

    class Baum {
        T data;
        Baum left;
        Baum right;

        public Baum(T content) {
            data = content;
            left = null;
            right = null;
        }
    }

    public Suchbaum() {
        root = null;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public Baum insertRecursive(Baum currentNode, T data) throws InstanceAlreadyExistsException {
        if (currentNode == null) {
            return new Baum(data);
        }

        if (currentNode.data.compareTo(data) > 0) {
            currentNode.left = insertRecursive(currentNode.left, data);
        } else if(currentNode.data.compareTo(data) < 0) {
            currentNode.right = insertRecursive(currentNode.right, data);
        } else {
            throw new InstanceAlreadyExistsException(data + " schon vorhanden");
        }
        return currentNode;
    }

    public void insert(T data) {
        try {
            root = insertRecursive(root, data);
        } catch (InstanceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean contains(T data) {
        try {
            root = insertRecursive(root, data);
        } catch (InstanceAlreadyExistsException e) {
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

    public void preorder(Baum currentNode) {
        if (currentNode == null) {
            return;
        } else {
            System.out.println(currentNode.data);
            preorder(currentNode.left);
            preorder(currentNode.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    public void postorder(Baum currentNode) {
        if (currentNode == null) {
            return;
        } else {
            postorder(currentNode.left);
            postorder(currentNode.right);
            System.out.println(currentNode.data);
        }
    }

    public void postorder() {
        postorder(root);
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

    public int hoehe() {
        return depthRecursive(root);
    }

    public void horizontalOrderByLevel(Baum currentNode, int level) {
        if (currentNode == null) {
            return;
        }
        if (level == 1) {
            System.out.println(currentNode.data);
        } else if (level > 1) {
            horizontalOrderByLevel(currentNode.left, level - 1);
            horizontalOrderByLevel(currentNode.right, level - 1);
        }
    }

    public void horizontalOrder() {
        System.out.println("Horizontal Order:");
        int depth = this.hoehe();
        for (int i = 1; i <= depth; i++) {
            horizontalOrderByLevel(root, i);
        }
    }

    public void inorder(Baum currentNode) {
        if (currentNode == null) {
            return;
        } else {
            inorder(currentNode.left);
            System.out.println(currentNode.data);
            inorder(currentNode.right);
        }
    }

    public void inorder() {
        inorder(root);
    }
}
