package com.testing1;

class LinkedList {

    Node head;

    static class Node {

        final int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }

    }

    public static void main(String args[]) {

        System.out.println(" Program on Linked List ");
        final LinkedList llist = new LinkedList();

        llist.head = new Node(1);
        final Node second = new Node(2);
        final Node third = new Node(3);

        llist.head.next = second;
        second.next = third;

        System.out.println(" Printing the Linked List " + llist.head.data + " Second " + llist.head.next.data
                + " Third " + llist.head.next.next.data);
    }
}
