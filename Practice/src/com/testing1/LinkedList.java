package com.testing1;

public class LinkedList {

    LinkedNode head;

    public void printList() {
        LinkedNode n = this.head;
        while (n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {

        final LinkedList llist2 = new LinkedList();
        llist2.head = new LinkedNode(4);
        final LinkedNode second = new LinkedNode(5);
        final LinkedNode third = new LinkedNode(6);

        llist2.head.next = second;
        second.next = third;

        llist2.printList();

    }

}
