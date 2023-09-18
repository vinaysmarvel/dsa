package com.practice.dsa.basic;

import java.util.LinkedList;

public class Queue {
    LinkedList<Integer> ll = new LinkedList<>();
    public int size(){
        return ll.size();
    }
    public int dequeue(){
        return ll.removeFirst();
    }
     public void enqueue(int data){
        ll.addLast(data);
     }

     public int peek(){
        return ll.peek();
     }

     public boolean isEmpty(){
        return ll.isEmpty();
     }
     public void display(){
         System.out.println(ll.toString());
     }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.peek());
        q.display();
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        q.display();
        System.out.println(q.dequeue());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.peek()); // Null Pointer Exception
        q.display();
        System.out.println(q.dequeue());

        //JAVA's Queue interface has many implementations. LinkedList , PriorityQueue and ArrayDeque are prominent.
        java.util.Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.size();
        queue.isEmpty();
        queue.peek();
        queue.poll();
    }
}
