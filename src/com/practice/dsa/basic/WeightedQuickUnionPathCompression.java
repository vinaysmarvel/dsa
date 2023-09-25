package com.practice.dsa.basic;

public class WeightedQuickUnionPathCompression {

    int[] ar;
    int[] size;

    //O(N)
    public WeightedQuickUnionPathCompression(int capacity) {
        ar = new int[capacity];
        size = new int[capacity];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i;
            size[i] = 1;
        }
    }
    //Log*N.. for all practical purposes , amortized time O(1)
    public int root(int i) {
        while (ar[i] != i) {
            ar[i] = ar[ar[i]];
            i = ar[i];
        }
        return i;
    }

    //Log*N for all practical purposes , amortized time O(1)
    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }


    //Log*N for all practical purposes , amortized time O(1)
    public void union(int i, int j) {
        int rooti = root(i);
        int rootj = root(j);
        if (rooti != rootj) {
            if (size[rooti] > size[rootj]) {
                ar[rootj] = i;
                size[rooti] = size[rootj] + size[rooti];
            } else {
                ar[rooti] = j;
                size[rootj] = size[rooti] + size[rootj];
            }
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionPathCompression uf = new WeightedQuickUnionPathCompression(10);
        uf.union(1,2);
        uf.union(5,6);
        uf.union(5,8);
        System.out.println(uf.connected(1,6));
        System.out.println(uf.connected(8,6));
    }
}
