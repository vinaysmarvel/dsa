package com.practice.dsa.basic;

import java.util.*;

public class SetGraph implements Graph {
    Map<Integer, Set<Integer>> edgeMapSet;

    //O(V+E) space
    public SetGraph(int vertexCount) {
        edgeMapSet = new HashMap<>();
        for (int i = 0; i < vertexCount; i++) {
            edgeMapSet.put(i, new HashSet<>());
        }
    }

    //O(1) time
    @Override
    public void addEdge(int i, int j) {
        edgeMapSet.get(i).add(j);
        edgeMapSet.get(j).add(i);
    }

    //O(1) time
    @Override
    public void removeEdge(int i, int j) {
        edgeMapSet.get(i).remove(j);
        edgeMapSet.get(j).remove(i);
    }

    //O(1) time
    @Override
    public boolean isEdgeExists(int i, int j) {
        return edgeMapSet.get(i).contains(j);
    }

    //O(V+E) time
    @Override
    public void display() {
        int i = 0;
        for (Set s : edgeMapSet.values()) {
            System.out.print(i++ + " : " + Arrays.toString(s.toArray()));
            System.out.println();
        }
    }

    //O(V+E) time O(V+E) space
    public void dfs(int i) {
        Set<Integer> vs = new HashSet<>();
        java.util.Stack<Integer> s = new java.util.Stack<>();
        s.push(i);
        while (!s.isEmpty()) {
            int x = s.pop();
            System.out.println(x);
            vs.add(x);
            for (Integer y : edgeMapSet.get(x)) {
                if (y != null && !s.contains(y) && !vs.contains(y)) {
                    s.push(y);
                }
            }
        }
    }

    //O(V+E) time O(V+E) space
    public void bfs(int i) {
        Set<Integer> vs = new HashSet<>();
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.println(x);
            vs.add(x);
            for (Integer y : edgeMapSet.get(x)) {
                if (y != null && !q.contains(y) && !vs.contains(y)) {
                    q.offer(y);
                }
            }
        }
    }
    //Question: is BFS or DFS better? : It depends on the problem nature.

    public static void main(String[] args) {
        SetGraph g = new SetGraph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.display();
        System.out.println(g.isEdgeExists(1, 0));
        g.removeEdge(6, 4);
        g.display();
        System.out.println(g.isEdgeExists(6, 4));
        g.dfs(0);
        System.out.println("BFS:");
        g.bfs(0);
    }
}
