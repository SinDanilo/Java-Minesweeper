package Player;

public class LinkedList {
    private NodeMove head;
    private NodeMove tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(Move move) {
        NodeMove Node = new NodeMove(move);

        if (head == null) {
            head = Node;
            tail = Node;
        } else {
            tail.setNext(Node);
            tail = Node;
        }
    }

    public NodeMove getHead() {
        return head;
    }
}
