package com.practice.dsa.basic;

import java.util.HashMap;
import java.util.Map;

public class StringMatching {

    //Time: O(N*M) space:O(1)
    public static int bruteforce(String t, String p) {
        if (t == null || p == null || t.length() < p.length()) return -1;
        else {
            int n = t.length();
            int m = p.length();
            for (int i = 0; i < n - m + 1; i++) {
                int j = 0;
                while (j < m && t.charAt(i + j) == p.charAt(j)) {
                    j++;
                }
                if (j == m) return i;
            }
            return -1;
        }
    }

    //O(M+N) average time and O(M*N) worst case . O(1) space, This version works only with integers as of now.
    public static int rabinkarp(String t, String p) {
        if (t != null && p != null && t.length() >= p.length()) {
            int ht = hash(t, 0, p.length() - 1);
            int pt = hash(p, 0, p.length() - 1);
            for (int i = p.length(); i <= t.length() - 1; i++) {
                if (ht == pt) {
                    int j = 0;
                    while (j < p.length() && p.charAt(j) == t.charAt(i - p.length() + j)) {
                        j++;
                    }
                    if (j == p.length()) return i;
                } else {
                    int value = t.charAt(i - p.length()) - '0';
                    ht = t.charAt(i) - '0' + 10 * ht - (int) (value * Math.pow(10, p.length()));
                }
            }
        }
        return -1;
    }

    private static int hash(String s, int j, int k) {
        int h = 0;
        if (s != null) {
            for (int i = j; i <= k; i++) {
                h = s.charAt(i) - '0' + 10 * h;
            }
        }
        return h;
    }

    //O(N+M) time complexity O(M) Space. suited for binary string matching
    public static int kmp(String t, String p) {
        int[] lps = computeLps(p);
        int i = 0, j = 0, m = p.length(), n = t.length();
        while (i < n) {
            if (t.charAt(i) == p.charAt(j)) {
                if (j == m - 1) return i - j;
                i++;
                j++;
            } else {
                if (j > 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private static int[] computeLps(String p) {
        int i = 1, j = 0, m = p.length();
        int[] f = new int[m];
        while (i < m) {
            if (p.charAt(i) == p.charAt(j)) {
                f[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = f[j - 1];
                } else {
                    f[i] = 0;
                    i++;
                }
            }
        }
        return f;
    }

    //O(NM) worst time , O(M) Space.. suited for large alphabet relative to the length of the pattern.
    public static int boyermoore(String t, String p) {
        if (t != null && p != null && t.length() >= p.length()) {
            int n = t.length(), m = p.length();
            Map<Character, Integer> map = computeBadMatchTable(p);
            for (int i = m - 1; i < n; ) {
                int j = 0;
                for (int k=m-1; j < m && t.charAt(i-j) == p.charAt(k);) {
                    j++;
                    k--;
                }
                if (j == m) return i-j+1;
                i = i+ map.getOrDefault(t.charAt(i), m);
            }
        }
        return -1;
    }

    public static Map<Character, Integer> computeBadMatchTable(String p) {
        Map<Character, Integer> map = new HashMap<>();
        int m = p.length();
        for (int i = 0; i < m; i++) {
            int newValue = Math.max(1, m - i - 1);
            map.put(p.charAt(i), newValue);
        }
        return map;
    }


    public static void main(String[] args) {
        String t = "welcome";
        String p = "come";
        System.out.println(StringMatching.bruteforce(t, p));
        System.out.println(StringMatching.rabinkarp(t, p));
        System.out.println(StringMatching.kmp(t, p));
        System.out.println(StringMatching.boyermoore(t, p));
    }
}
