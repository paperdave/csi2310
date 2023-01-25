package net.paperdave.csi2130.structures.linkedList;

import net.paperdave.csi2130.runner.Example;

import java.time.LocalDate;

public class LinkedListExample extends Example {
    public LinkedListExample() {
        this.setName("Linked List");
        this.setDescription("linked list demo");
        this.setCreatedDate(LocalDate.of(2023, 1, 23));
    }
    @Override
    public void run() {
        IntLinkedList list = new IntLinkedList();
        list.addToFront(1);
        list.addToEnd(2);
        list.addToFront(3);
        list.addToEnd(4);

        System.out.println(list);

        list.remove(3);

        System.out.println(list);

        list.insertAt(2, 5);

        System.out.println(list);
    }
}
