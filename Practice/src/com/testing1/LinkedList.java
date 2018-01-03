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

    public void push(int data) {
        final LinkedNode startNode = new LinkedNode(data);
        startNode.next = this.head;
        this.head = startNode;
    }

    public void delete(int key) {

        LinkedNode temp = this.head, prev = null;

        if (temp != null && temp.data == key) {
            this.head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    public static void main(String[] args) {

        final LinkedList llist2 = new LinkedList();
        llist2.head = new LinkedNode(4);
        final LinkedNode second = new LinkedNode(5);
        final LinkedNode third = new LinkedNode(6);
        llist2.head.next = second;
        second.next = third;
        llist2.push(3);
        llist2.printList();
        // consider I want to delete 5
        llist2.delete(5);
        System.out.println(" ================================================ ");
        llist2.printList();

    }

}
