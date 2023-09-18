package com.practice.dsa;

import java.util.Arrays;

public class Heap {
    private int capacity;
    private int count;
    private int[] a;

    private Heap(int capacity){
        this.capacity = capacity;
        a = new int[this.capacity];
    }
    public Heap(int capacity, int[] a){
        this.capacity = capacity;
        this.a= new int[capacity];
        for(int i=0; i<a.length;i++){
            this.a[i] = a[i];
        }
        this.count = a.length;
    }

    public int getParent(int i){
        if(i<0 && i> this.count) return -1;
        else return a[(i-1)/2];
    }

    public int getLeftChild(int i){
        if(i<0 && 2*i+1> this.count) return -1;
        else return a[2*i+1];
    }

    public int getRightChild(int i){
        if(i<0 && 2*i+2 > this.count) return -1;
        else return a[2*i+2];
    }

    public void printHeap(){
        System.out.println("Heap: "+Arrays.toString(a));
    }

    public void percolateDown(int i){
        if(i<0 && i > this.count) return;
        else {
            while(i<this.count){
                int left = 2*i+1;
                int right = 2*i+2;
                int max = i;
                if(left > count && right > count) break;
                else {
                    if (left <= this.count && a[max] < a[left]) {
                        max = left;
                    }
                    if(right <= this.count && a[max] < a[right]) {
                        max = right;
                    }
                    if(max == i) break;
                    swap(a, max, i);
                    i=max;
                }
            }
        }
    }

    public void percolateUp(int i) {
        if (i < 0 && i > this.count) return;
        else {
            while (i > 0) {
                int parent = (i - 1) / 2;
                int max = i;
                if (a[max] > a[parent]) {
                    swap(a, max, parent);
                    i = parent;
                }
                if(max == i) break;
            }
        }
    }

    public void insert(int x){
        a[count] = x;
        percolateUp(count);
        count++;
    }

    public int deleteMax(){
        int res = a[0];
        swap(a, 0, count-1);
        percolateDown(0);
        count--;
        return res;
    }

    public int getMaximum(){
        return a[0];
    }

    public static void  buildHeap(int[] a, Heap h){
        System.arraycopy(a, 0, h.a, 0, a.length);
        h.count= a.length;
        for(int i=(a.length-1)/2; i>=0 ; i--){
            h.percolateDown(i);
        }
    }

    public static void heapSort(Heap h){
        for(int i= h.count; i>0;i--){
            h.deleteMax();
            System.out.println("h.count: "+h.count+", i:"+i);
            h.printHeap();
        }
    }

    private void swap(int[] a, int max, int i) {
        int temp = a[max];
        a[max] = a[i];
        a[i] = temp;
    }

    public static void main(String[] args){
        int a[] = new int[]{10,9,8,7,6,5,4,3,2,1};
        int b[] = new int[]{10,30,50,70,60,80,40,90,20,100};
        Heap h = new Heap(16,a);
        h.printHeap();
        h.deleteMax();
        h.printHeap();
        h.insert(10);
        h.printHeap();
        h.insert(11);
        h.printHeap();
        System.out.println("getMaximum:"+h.getMaximum());
        h = new Heap(16);
        buildHeap(b,h);
        h.printHeap();
        heapSort(h);
//        h.printHeap();
    }

}
