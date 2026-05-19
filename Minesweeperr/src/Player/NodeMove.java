package Player;

public class NodeMove {
    private final Move move;
    private NodeMove next;

    public NodeMove(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public NodeMove getNext() {
        return next;
    }

    public void setNext(NodeMove next) {
        this.next = next;
    }
}