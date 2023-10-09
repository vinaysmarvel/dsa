package com.practice.dsa.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {

    //O(N^2) Time Complexity,O(1) Space, in place, stable
    public void bubble(int[] a) {
        if (a != null && a.length != 0) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                boolean sorted = true;
                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j + 1];
                        a[j + 1] = a[j];
                        a[j] = temp;
                        sorted = false;
                    }
                }
                if (sorted) break;
            }
        }
    }

    //O(N^2) Time complexity, O(1) space, not stable, inplace.
    public void selection(int[] a) {
        if (a != null && a.length != 0) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (a[min] > a[j]) {
                        min = j;
                    }
                }
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    //O(N^2) time complexity, inplace, stable
    public void insertion(int[] a) {
        if (a != null && a.length != 0) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int j = i;
                int temp = a[j];
                while (j > 0 && a[j - 1] > temp) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = temp;
            }
        }
    }

    //O(N^2) time, not stable, in place, it is used when we know that elements are far apart for smaller lists and
    // as a part of preprocessing for advanced better algorithms like quick sort.
    public void shell(int[] a) {
        if (a != null && a.length != 0) {
            int n = a.length;
            for (int h = (n / 9) + 1; h > 0; h = (h / 3)) {
                //insertion sort
                for (int i = 0; i < n; i = i + h) {
                    int j = i;
                    int temp = a[j];
                    while (j > 0 && a[j - h] > temp) {
                        a[j] = a[j - h];
                        j = j - h;
                    }
                    a[j] = temp;
                }
            }
        }
    }

    //O(NlogN) Time , stable, not inplace: O(N) Space
    public void mergesort(int[] a) {
        int low = 0, high = a.length - 1;
        mergesort(a, low, high);
    }

    private void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, high);
        }
    }

    private void merge(int[] a, int low, int high) {
        if (low < high) {
            int[] temp = new int[high - low + 1];
            int mid = low + (high - low) / 2;
            int k = 0, i = 0, j = mid + 1;

            while (k < temp.length && i <= mid && j <= high) {
                if (a[i] < a[j]) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = a[j++];
                }
            }
            while (i <= mid) {
                temp[k++] = a[i++];
            }
            while (j <= high) {
                temp[k++] = a[j++];
            }
            for (i = low; i <= high; i++) {
                a[i] = temp[i];
            }
        }
    }

    //O(n^2) worst case O(NlogN) average and best case. inplace not stable.
    public void quicksort(int[] a) {
        int low = 0, high = a.length - 1;
        quicksort(a, low, high);
    }

    private void quicksort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quicksort(a, low, pivot - 1);
            quicksort(a, pivot + 1, high);
        }
    }

    private int partition(int[] a, int left, int right) {
        if (left < right) {
            int low = left, high = right ;
            int pivotItem = a[high+(low-high)/2];
            while (low < high) {
                while (low < high && a[low] < pivotItem) low++;
                while (low < high && a[high] >= pivotItem) high--;
                if (low < high) {
                    int temp = a[low];
                    a[low] = a[high];
                    a[high] = temp;
                }
            }
            a[low] = a[high];
            a[high] = pivotItem;
            return high;
        }
        return left;
    }

    //O(K) time complexity.. linear time.. O(K) space, not inplace, not stable
    public void counting(int[] a, int[] b, int k){
        int[] c = new int[k+1];
        //count the frequency and store them
        for (int j : a) {
            c[j]++;
        }
        //calculate how many elements before that so that we know the index of each in new array
        for(int i=1; i<k;i++) {
            c[i] = c[i]+c[i-1];
        }
        //put the value in correct index of output for each in input and decrement the count.
        for (int j : a) {
            b[c[j] - 1] = j;
            c[j]--;
        }
    }

    //Worst Case Complexity: O(n2), Best Case Complexity: O(n+k), Average Case Complexity: O(n)
    //Space O(N+k), not inplace, stable
    public void bucket(float[] a){
        int n = a.length;
        ArrayList<Float>[] bu = new ArrayList[n+1];
        for(int i=0;i<bu.length;i++){
            bu[i] = new ArrayList<>();
        }
        for (float v : a) {
            int index = (int) v * n;
            bu[index].add(v);
        }
        for(ArrayList<Float> b: bu){
            Collections.sort(b);
        }
        int index=0;
        for(int i=0;i<bu.length;i++){
            for(int j=0;j<bu[i].size();j++){
                a[index++]=bu[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 4};
        int[] b = new int[a.length];
        float[] c = {(float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,(float) 0.51 };
        Sorting s = new Sorting();
        //s.bubble(a);
        //s.selection(a);
        //s.insertion(a);
        //s.shell(a);
        //s.mergesort(a);
        //s.quicksort(a);
        s.counting(a,b,5);
        s.bucket(c);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}
