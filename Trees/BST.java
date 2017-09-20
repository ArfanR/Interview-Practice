
public class BST {

    public int data;
    public BST left, right;

    public BST(int data, BST left, BST right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BST insert(BST node, int value) {
        BST newNode = new BST(value, null, null);
        if (node == null) {
            node = newNode;
            return node;
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        }
        else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public bool search(BST node, int value) {
        if (node == null) {
            return false;
        }

        if (value < node.data) {
            search(node.left, value);
        }
        else if (value > node.data) {
            search(node.right, value);
        }
        else {
            return true;
        }
    }

    public int getHeight(BST node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), GetHeight(node.right));
    }

    public int getMin(BST node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null) {
            return node.data;
        }
        return getMin(node.left);
    }

    public int getMax(BST node) {
        if (node == null) {
            return -1;
        }
        if (node.right == null) {
            return node.data;
        }
        return getMax(node.right);
    }



}



