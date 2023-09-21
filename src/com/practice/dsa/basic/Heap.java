package com.practice.dsa.basic;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {
    private int capacity;
    private int[] arr;
    private int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.count = 0;
    }

    public int getSize() {
        return this.count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private int getMinimum() {
        return count == 0 ? -1 : arr[0];
    }

    private int getParent(int i) {
        if (count > 0 && i < count) return (i - 1) / 2;
        else return -1;
    }

    private int getLeftchild(int i) {
        if (count >= 0 && (2 * i + 1) < count) return (2 * i + 1);
        else return -1;
    }

    private int getRightchild(int i) {
        if (count >= 0 && (2 * i + 2) < count) return (2 * i + 2);
        else return -1;
    }

    private void percolateDown(int i) {
        if (this.count - 1 >= i && i >= 0) {
            int lc = getLeftchild(i);
            int rc = getRightchild(i);
            int lcv = lc == -1 ? Integer.MAX_VALUE : arr[lc];
            int rcv = rc == -1 ? Integer.MAX_VALUE : arr[rc];
            while (arr[i] > Math.min(lcv, rcv)) {
                int temp = arr[i];
                if (lcv < rcv) {
                    arr[i] = lcv;
                    arr[lc] = temp;
                    i = getLeftchild(i);
                } else {
                    arr[i] = rcv;
                    arr[rc] = temp;
                    i = getRightchild(i);
                }
                lc = getLeftchild(i);
                rc = getRightchild(i);
                lcv = lc == -1 ? Integer.MAX_VALUE : arr[lc];
                rcv = rc == -1 ? Integer.MAX_VALUE : arr[rc];
            }
        }
    }

    private void percolateUp(int i) {
        if (this.count - 1 >= i) {
            int x = getParent(i);
            while (arr[x] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
                i = x;
                x = getParent(i);
            }
        }
    }

    public int deleteMinimum() {
        if (this.count == 0) return -1;
        else {
            int data = arr[0];
            arr[0] = arr[this.count - 1];
            this.count--;
            percolateDown(0);
            return data;
        }
    }

    public void insert(int x) {
        arr[this.count++] = x;
        percolateUp(this.count - 1);
    }

    public void display() {
        System.out.println(Arrays.toString(this.arr));
    }

    public static void buildHeap(Heap h, int[] a) {
        if (h.capacity >= a.length) {
            h.arr = Arrays.copyOf(a, h.arr.length);
            h.count = a.length;
            for (int i = (h.count - 1) / 2; i >= 0; i--) {
                h.percolateDown(i);
            }
        }
    }

    public void heapSort() {
        int ct = this.count;
        for (int i = 0; i < ct; i++) {
            System.out.println(this.deleteMinimum());
        }
    }


    public static void main(String[] args) {
        Heap h = new Heap(10);
        System.out.println(h.isEmpty());
        h.insert(7);
        h.display();
        h.insert(1);
        h.insert(5);
        h.insert(3);
        h.insert(2);
        h.insert(6);
        h.display();
        System.out.println(h.getMinimum());
        System.out.println(h.deleteMinimum());
        h.display();
        System.out.println(h.getSize());
        System.out.println(h.isEmpty());

        int[] b = {10, 7, 9, 3, 5, 2, 6, 1, 4, 8};
        Heap h2 = new Heap(11);
        buildHeap(h2, b);
        h2.display();

        h2.heapSort();

        //JAVAs Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        pq.add(10);
        pq.add(2);
        pq.add(9);
        pq.add(4);
        pq.add(6);
        pq.add(5);
        pq.add(1);
        pq.add(3);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
