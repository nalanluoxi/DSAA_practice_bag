package org.example.dsaa.Graph.GraphList;

public class GraphListMain {
    public static void main(String[] args) {

        Integer[][] nums = {{1, 2}, {1, 3}, {1, 5}, {1, 6}, {2, 3}};
        MyGraphList ml = new MyGraphList(nums);

        ml.printEdge();
        //ml.removeVertex(1);
        ml.removeEdge(1,2);
        ml.printEdge();
        ml.addVertex(9);
        ml.addVertex(8);
        ml.addVertex(7);
        ml.addEdge(1,9);
        ml.addEdge(8,9);
        ml.addEdge(7,9);


        ml.printEdge();


    }
}
