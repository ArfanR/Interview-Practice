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
}