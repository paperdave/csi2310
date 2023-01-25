package net.paperdave.csi2130.structures.linkedList;

public class IntLinkedList {
    IntNode head;

    public IntLinkedList() {
        head = null;
    }

    public void addToEnd(int data) {
        if (head == null) {
            head = new IntNode(data);
        } else {
            IntNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.insertAfter(data);
        }
    }

    public void addToFront(int data) {
        head = new IntNode(data, head);
    }

    public int get(int index) {
        IntNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void remove(int index) {
        IntNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        current.removeAfter();
    }

    public void set(int index, int data) {
        IntNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(data);
    }

    public void insertAt(int index, int data) {
        IntNode current = head;
        for (int j = 0; j < index - 1; j++) {
            current = current.getNext();
        }
        current.insertAfter(data);
    }

    public String toString() {
        String s = "";
        IntNode current = head;
        while (current != null) {
            s += current.getData() + " ";
            current = current.getNext();
        }
        return s;
    }
}
