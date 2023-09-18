package com.practice.dsa;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Combinations {

    public void problem() {

        PriorityQueue <String> res= new PriorityQueue<>();
        res.add("A");
        res.add("B");
        res.add("C");
        while(res.peek().length() <3) {
            String s = res.poll();
            System.out.println("s: "+s);
            String s1;
            if(!s.contains("A")) {
                s1 = s+"A";
                res.add(s1);
            }
            if(!s.contains("B")) {
                s1 = s+"B";
                res.add(s1);
            }
            if(!s.contains("C")) {
                s1 = s+"C";
                res.add(s1);
            }
            System.out.println("res.toArray().toString(): "+res.toArray().toString());
        }
        for(String b:res){
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.problem();;
    }
}
