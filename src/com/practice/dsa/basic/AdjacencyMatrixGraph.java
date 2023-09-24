package com.practice.dsa.basic;

import java.util.Arrays;

public class AdjacencyMatrixGraph implements Graph {
    //Space: O(N^2)
    boolean[][] adjMat;

    public AdjacencyMatrixGraph(int vertexCount) {
        adjMat = new boolean[vertexCount][vertexCount];
    }

    //O(1) time
    public void addEdge(int i, int j) {
        if (i < adjMat.length && j < adjMat.length) {
            adjMat[i][j] = true;
            adjMat[j][i] = true;
        }
    }

    //O(1) time
    public void removeEdge(int i, int j) {
        if (i < adjMat.length && j < adjMat.length) {
            adjMat[i][j] = false;
            adjMat[j][i] = false;
        }
    }

    //O(1) time
    public boolean isEdgeExists(int i, int j) {
        if (i < adjMat.length && j < adjMat.length) {
            return adjMat[i][j];
        }
        return false;
    }

    //O(N^2) time
    public void display() {
        System.out.println(Arrays.deepToString(adjMat));
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.display();
        System.out.println(g.isEdgeExists(4, 2));
        g.removeEdge(0, 3);
        g.display();
        System.out.println(g.isEdgeExists(0, 3));
    }

}
