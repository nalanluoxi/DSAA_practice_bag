package org.example.dsaa.Graph.GraphMatrix;

public class GraphMatrixMain {
    public static void main(String[] args) {
        int[] ver = {1, 3, 4, 9};
        int[][] edg = {{1, 3}, {1, 9}};
        MyGraphMatrix mg = new MyGraphMatrix(ver, edg);
        mg.printEdge();

        mg.addVertex(8);
        mg.addEdgeByValue(3, 4);


        mg.printEdge();
        mg.removeEdgeBuValue(3, 4);

        mg.printEdge();

    }
}
