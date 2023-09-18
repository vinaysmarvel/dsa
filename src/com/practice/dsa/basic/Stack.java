package com.practice.dsa.basic;

import java.util.LinkedList;

public class Stack {

    LinkedList<Integer> ll = new LinkedList<>();
    public int size(){
        return ll.size();
    }
    public int peek(){
        return ll.peek();
    }

    public int pop(){
        return ll.removeFirst();
    }

    public void push(int i){
        ll.push(i);
    }
    public boolean isEmpty(){
        return ll.isEmpty();
    }

    public void display(){
        System.out.println(ll.toString());
    }

    public static void main(String[] args) {
        Stack s  = new Stack();
        s.push(1);
        s.display();
        s.push(2);
        s.display();
        System.out.println(s.peek());
        System.out.println(s.pop());
        s.display();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.pop());
        s.display();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        System.out.println(s.pop());// No such Element exception thrown
    }
}
