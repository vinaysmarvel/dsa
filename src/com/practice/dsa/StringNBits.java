package com.practice.dsa;

public class StringNBits {

    public static void problem(int n, int[] a){
        System.out.println("length: "+a.length+"size: "+n);
        if(n==a.length) {
            printArray(a);
        }
        else{
            a[n]=1;
            problem(n+1,a);
            a[n]=0;
            problem(n+1,a);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[3];
        problem(0,a);
    }

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
