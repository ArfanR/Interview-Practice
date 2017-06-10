
public class Trees {

    enum State {
        Visited, Visiting, Unvisited;
    }
    // determine if there is a route between two nodes
    // Breadth First Search
    public static boolean isRoute(Graph g, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
            u.State = State.Unvisited;
        }
        q.add(start);
        start.State = State.Visiting;
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        }
                        else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
            }
            u.state = State.Visited;
        }

        return false;
    }

    // create minimal BST from sorted array
    public static TreeNode createMinimalBST(int arr[]) {
        return createMinimalBST(arr, 0, arr.length-1);
    }

    public static TreeNode createMinimalBST(int arr[], int start, int end) {
        if (start == end) {
            return new TreeNode(arr[start]);
        }
        else {
            int mid = (start+end) / 2;
            TreeNode n = new TreeNode(arr[mid]);
            n.left = createMinimalBST(arr, start, mid-1);
            n.right = createMinimalBST(arr, mid+1, start);
            return n;
        }
    }

    // make linked list of each depth in binary tree
    public static HashTable<Integer, LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        HashTable<Integer, LinkedList<TreeNode>> result = new HashTable<Integer, LinkedList<TreeNode>>();

        LinkedList<TreeNode> q = new LinkedList<TreeNode();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            result.put(level, q);
            LinkedList<TreeNode> parent = q;
            q = new LinkedList<TreeNode>();
            for (TreeNode n : parent) {
                if (parent != null) {
                    q.add(n.left);
                    q.add(n.right);
                }
            }
            level++;
        }

        return result;
    }

    public static int GetHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // check is binary tree is balanced
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // check if tree is a BST
    public static boolean isBinarySearchTree(TreeNode node) {
        return IsBetween(node, null, null);
    }

    public static boolean IsBetween(TreeNode node, int min, int max) {
        if (node == null) return true;

        if (node.data > min && node.data < max &&
            IsBetween(node.left, min, node.data) &&
            IsBetween(node.right, node.data, max))
            return true;
        else {
            return false;
        }
    }

    // get min node
    public static TreeNode minNode(TreeNode n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }

    // find in order successor to a node
    public static TreeNode inOrderSuccessor(TreeNode n) {
        if (n == null) return null;

        // min node of right subtree
        if (n.right != null) {
            return minNode(n.right);
        }
        // find deepest ancestor where value is in left subtree
        else {
            TreeNode ancestor = n;
            TreeNode sucessor = ancestor.parent;
            while (sucessor != null & successor.left != null) {
                ancestor = successor;
                successor = succesor.parent;
            }
            return successor;
        }
    }

    // searches for existing node in binary tree
    public static boolean search(TreeNode node, TreeNode root) {
        if (node == null) {
            return false;
        }
        else if (node == root) {
            return true;
        }
        else {
            return search(node.left, root) || search(node.right, root);
        }
    }

    // find lowest common ancestor in binary tree
    public static boolean findLowestCommonAncestor(TreeNode node1, TreeNode node2, TreeNode root) {
        if (root == null || node1 == root || node2 == root) {
            return root;
        }
        if (!search(node1, root) || !search(node2, root)) {
            return null;
        }

        return ancestorHelper(node1, node2, root);
    }

    public static TreeNode ancestorHelper(TreeNode node1, TreeNode node2, TreeNode root) {
        boolean node1onLeft = search(node1, root.left);
        boolean node2onLeft = search(node2, root.left);

        if (node1onLeft && search(node2, root.right)) {
            return root;
        }
        else if (search(node1, root.right) && node2onLeft) {
            return root;
        }

        TreeNode newSide = node1onLeft ? root.left : root.right;
        return ancestorHelper(node1, node2, newSide);
    }

}



