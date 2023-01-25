package net.paperdave.csi2130.structures.linkedList;

public class IntNode {
    private int data;
    private IntNode next;

    public IntNode(int data) {
        this.data = data;
        this.next = null;
    }

    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    // cool operations

    /**
     * Inserts a new node after this node. Returns the node.
     */
    public IntNode insertAfter(int data) {
        IntNode currentNext = this.getNext();
        IntNode newNode = new IntNode(data, currentNext);
        this.setNext(newNode);
        return newNode;
    }

    public void removeAfter() {
        IntNode currentNext = this.getNext();
        if (currentNext != null) {
            this.setNext(currentNext.getNext());
        }
    }

}
