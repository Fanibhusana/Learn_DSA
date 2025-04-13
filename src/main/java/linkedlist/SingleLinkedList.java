package linkedlist;

public class SingleLinkedList {

    // node creation
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // head node
    private Node head;

    //Print
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    //length
    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Search
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    //Insert at Head
    public void insertHead(int data) {
        Node node = new Node(data);
        node.next = head;// store the head data to the new node next
        head = node;// store the new node in the head
    }

    //Insert at Tail
    public void insertTail(int data) {
        Node node = new Node(data);
        if (head == null) { // Handle empty list
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next; // Find the last node
        }
        current.next = node;
    }

    //Insert at Position
    public void insert(int data, int position) {
        if (position < 1 || position > length() + 1) System.out.println("enter a valid position");
        else {
            if (position == 1) insertHead(data);
            else {
                Node node = new Node(data);
                Node previous = head;
                int count = 1; // Start from 1 to match position indexing
                while (count < position - 1) { // Stop at the node before the insertion point
                    previous = previous.next;
                    count++;
                }
                node.next = previous.next;
                previous.next = node;
            }
        }
    }

    //Delete at Head
    public void deleteHead() {
        if (head != null) {
            head = head.next;
        }
    }

    //Delete at Tail
    public void deleteTail() {
        if (head == null) {
            return; // List is empty
        }
        if (head.next == null) {
            head = null; // List has only one node
            return;
        }
        Node previous = head;
        while (previous.next.next != null) { // Traverse to the second last node
            previous = previous.next;
        }
        previous.next = null; // Remove the last node
    }

    //Delete at Position
    public void delete(int position) {
        if (head == null) {
            return; // List is empty
        }
        if (position < 1 || position > length()) System.out.println("enter a valid position");
        else {
            if (position == 1) deleteHead();
            else {
                Node previous = head;
                int count = 1; // Start from 1 to match position indexing
                while (count < position - 1) {
                    previous = previous.next;
                    count++;
                }
                previous.next = previous.next.next;
            }
        }
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return; // List is empty
        }
        if (head.data == value) { // If the value is in the head node
            head = head.next;
            return;
        }
        Node previous = null;
        Node current = head;

        while (current != null && current.data != value) { // Traverse to find the node
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value is not present");
            return;
        }
        previous.next = current.next; // Remove the node
    }

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        // implement all the methods

    }

}

