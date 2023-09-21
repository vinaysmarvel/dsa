package com.practice.dsa.basic;

import java.util.Arrays;

public class Heap {
    private int capacity;
    private int[] arr;
    private int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.count =0;
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
        if (count >= 0 && (2 * i + 1) / 2 < count) return (2 * i + 1) / 2;
        else return -1;
    }

    private int getRightchild(int i) {
        if (count >= 0 && (2 * i + 2) / 2 < count) return (2 * i + 2) / 2;
        else return -1;
    }

    private void percolateDown(int i) {
        if(this.count -1 >= i && i>=0) {
            int lc = getLeftchild(i);
            int rc = getRightchild(i);
            int lcv =  lc== -1?Integer.MAX_VALUE:arr[lc];
            int rcv =  rc== -1?Integer.MAX_VALUE:arr[rc];
            while(arr[i]>Math.min(lcv,rcv)) {
                int temp  = arr[i];
                if(lcv < rcv ){
                    arr[i] = lcv;
                    arr[lc]= temp;
                    i=getLeftchild(i);
                }
                else{
                    arr[i] = rcv;
                    arr[rc]= temp;
                    i=getRightchild(i);
                }
                lc = getLeftchild(i);
                rc = getRightchild(i);
                lcv =  lc== -1?Integer.MAX_VALUE:arr[lc];
                rcv =  rc== -1?Integer.MAX_VALUE:arr[rc];
            }

        }
    }

    private void percolateUp(int i) {
        if(this.count-1 >= i) {
            int x = getParent(i);
            while(arr[x] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x]= temp;
                i=x;
                x=getParent(i);
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

    public void display(){
        System.out.println(Arrays.toString(this.arr));
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
    }
}
