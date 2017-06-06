class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;
}

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


}