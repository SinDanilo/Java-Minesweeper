package minesweeper;

public class CoordinateQueue {

    private static class CoordinateNode {
        int row;
        int col;
        CoordinateNode next;

        CoordinateNode(int row, int col) {
            this.row = row;
            this.col = col;
            this.next = null;
        }
    }

    private CoordinateNode head;
    private CoordinateNode tail;
    private int size;

    public CoordinateQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add element to queue
    public void push(int row, int col) {
        CoordinateNode Node = new CoordinateNode(row, col);

        if (tail == null) {
            head = Node;
            tail = Node;
        } else {
            tail.next = Node;
            tail = Node;
        }

        size++;
    }

    // Remove first element
    public int[] pop() {
        if (isEmpty()) {
            return null;
        }

        int[] coordinate = { head.row, head.col };

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;

        return coordinate;
    }

    // Returns first element
    public int[] peek() {
        if (isEmpty()) {
            return null;
        }

        return new int[] { head.row, head.col };
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
