package com.practice.dsa.basic;

public class QuickFind {

    private int[] ar;

    //O(N) Space
    public QuickFind(int capacity) {
        ar = new int[capacity];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i;
        }
    }

    //O(1) time
    public boolean connected(int i, int j) {
        return ar[i] == ar[j];
    }

    //O(N) time
    public void union(int i, int j) {
        int rooti = ar[i];
        int rootj = ar[j];
        if (rooti != rootj) {
            for (int k = 0; k < ar.length; k++) {
                if (rooti == ar[k]) ar[k] = rootj;
            }
        }
    }

    public static void main(String[] args) {
        QuickFind uf = new QuickFind(10);
        uf.union(1,2);
        uf.union(5,6);
        uf.union(5,8);
        System.out.println(uf.connected(1,6));
        System.out.println(uf.connected(8,6));
    }

}
