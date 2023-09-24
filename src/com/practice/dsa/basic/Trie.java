package com.practice.dsa.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private Node root;

    Trie() {
        root = new Node('/', false);
    }

    public void insert(String s) {
        if (s != null) {
            char data;
            boolean isEndOfString;
            Node x = root;
            int i = 0;
            while (x != null && i < s.length()) {
                data = s.charAt(i);
                isEndOfString = s.length() - 1 == i;
                Node y = x.map.get(data);
                if (y != null) {
                    y.isEndOfString = isEndOfString;
                } else {
                    y = new Node(data, isEndOfString);
                }
                x.map.put(data, y);
                x = y;
                i++;
            }
        }
    }

    public boolean search(String s) {
        if (s != null) {
            Node x = this.root.map.get(s.charAt(0));
            int i = 0;
            while (x != null) {
                if (i == s.length() - 1 && x.isEndOfString) return true;
                i++;
                x = x.map.get(s.charAt(i));
            }
        }
        return false;
    }

    private void display(StringBuilder s, List<String> res, Node x) {
        s.append(x.data);
        int index = s.length() - 1;
        if (x.isEndOfString) res.add(s.toString());
        for (Node y : x.map.values()) {
            display(s, res, y);
        }
        s.deleteCharAt(index);
    }

    public void display() {
        StringBuilder s = new StringBuilder();
        List<String> res = new ArrayList<>();
        Node x = this.root;
        display(s, res, x);
        System.out.println(res);
    }


    private static class Node {
        char data;
        Map<Character, Node> map;
        boolean isEndOfString;

        Node(char data, boolean isEndOfString) {
            this.data = data;
            this.isEndOfString = isEndOfString;
            map = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        Trie t = new Trie();
        t.insert(s);
        t.insert("hell");
        t.insert("hola");
        t.insert("bread");
        t.insert("organ");
        t.insert("fan");
        t.display();
        System.out.println(t.search("organ"));
        System.out.println(t.search("Hell"));
    }
}
