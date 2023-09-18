package com.practice.dsa.basic;

public class LinkedList {

    Node head;

    public void traverse() {
        if(head != null) {
            Node cur= head;
            System.out.println();
            while(cur!= null){
                System.out.print(cur.data+"-->");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public void insertAtBeginning(int data) {
        Node x = new Node(data);
        if(head != null) x.next = head;
        head = x;
    }

    public void insertAtEnd(int data) {
        Node x = new Node(data);
        if(head == null) head = x;
        else {
            Node cur = head;
            while(cur.next != null) cur = cur.next;
            cur.next = x;
        }
    }

    public void insertInTheMiddle(int data, int x){
        Node y = new Node(data);
        if(head == null) head = y;
        else {
            Node cur = head;
            while(cur!= null) {
                if(cur.data == x){
                    Node next = cur.next;
                    cur.next = y;
                    y.next = next;
                }
                cur = cur.next;
            }
        }
    }

    public void deleteAtBeginning(){
        if (head != null) {
            Node cur = head;
            head = head.next;
            cur.next = null;
        }
    }

    public void deleteAtEnd() {
        if(head != null){
            if (head.next == null) head = null;
            else{
                Node cur = head;
                Node prev = null;
                while(cur.next!= null) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = null;
            }
        }
    }

    public void deleteInTheMiddle(int data){
        if(head != null){
            if(head.data == data) head = null;
            else{
                Node cur = head;
                Node prev= null;
                while(cur!= null && cur.data != data){
                    prev = cur;
                    cur = cur.next;
                }
                if(cur!= null && cur.data == data){
                    prev.next = cur.next;
                    cur.next = null;
                }
            }
        }
    }



    public class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
        sll.insertAtBeginning(1);
        sll.insertAtEnd(4);
        sll.insertInTheMiddle(2,1);
        sll.insertInTheMiddle(3,2);
        sll.insertAtEnd(5);
        sll.traverse();
        sll.insertAtEnd(8);
        sll.traverse();
        sll.deleteAtEnd();
        sll.traverse();
        sll.insertAtBeginning(8);
        sll.traverse();
        sll.deleteAtBeginning();
        sll.traverse();
        sll.insertInTheMiddle(8,3);
        sll.traverse();
        sll.deleteInTheMiddle(8);
        sll.traverse();

        //JAVA s inbuilt linked list
        // Creating object of the
        // class linked list
        java.util.LinkedList<String> ll = new java.util.LinkedList<String>();

         //Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");

        System.out.println(ll);
        System.out.println(ll.size());
        System.out.println(ll.peek());
        System.out.println(ll.peekFirst());
        System.out.println(ll.peekLast());

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
    }
}
