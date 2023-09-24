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

    public static void main(String[] args) {
        SetGraph g = new SetGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.display();
        System.out.println(g.isEdgeExists(1, 0));
        g.removeEdge(0, 3);
        g.display();
        System.out.println(g.isEdgeExists(0, 3));
    }
}
