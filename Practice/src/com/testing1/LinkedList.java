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

    public void printList() {

        Node n = this.head;
        while (n != null) {
            System.out.println(n.data + " ");
            n = n.next;
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

        llist.printList();
    }
}
