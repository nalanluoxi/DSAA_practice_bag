package org.example.dsaa.datastructure.graph.GraphMatrix;

import java.util.ArrayList;
import java.util.List;

public class MyGraphMatrix {

    private List<Integer> vertices;
    //顶点值集合
    private List<List<Integer>> adjMat;
    //边集合，关系集合


    //构造方法
    public MyGraphMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        for (int val : vertices) {
            addVertex(val);
        }
        for (int[] e : edges) {
            addEdgeByValue(e[0], e[1]);
        }
    }

    /**
     * 查询值对应的索引
     * @param val
     * @return
     */
    public int getIndex(int val){
        for (int i=0;i<size();i++){
            Integer temver = vertices.get(i);
            if (temver==val){
                return i;
            }
        }
        return -1;
    }

    public void addEdgeByValue(int i,int j){
        addEdgeByIndex(getIndex(i),getIndex(j));
    }

    public void removeEdgeBuValue(int i ,int j){
        removeEdgeByIndex(getIndex(i),getIndex(j));
    }
    public int size() {
        return vertices.size();
    }

    /**
     * 添加新顶点
     *
     * @param val
     */
    public void addVertex(int val) {

        List<Integer> newRow = new ArrayList<>(size());
        for (int i = 0; i < size(); i++) {
            newRow.add(0);

        }
        adjMat.add(newRow);
        for (List<Integer> row : adjMat) {
            row.add(0);
        }
        vertices.add(val);
    }

    /* 添加顶点 */
  /*  public void addVertex(int val) {*/
  /*      int n = size();*/
  /*      // 向顶点列表中添加新顶点的值*/
  /*      vertices.add(val);*/
  /*      // 在邻接矩阵中添加一行*/
  /*      List<Integer> newRow = new ArrayList<>(n);*/
  /*      for (int j = 0; j < n; j++) {*/
  /*          newRow.add(0);*/
  /*      }*/
  /*      adjMat.add(newRow);*/
  /*      // 在邻接矩阵中添加一列*/
  /*      for (List<Integer> row : adjMat) {*/
  /*          row.add(0);*/
  /*      }*/
  /*  }*/

    /**
     * 通过索引添加边
     * @param i
     * @param j
     */
    public void addEdgeByIndex(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size()) {
            throw new IndexOutOfBoundsException();
        }

        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    /**
     * 通过索引删除边
     *
     * @param i
     * @param j
     */
    public void removeEdgeByIndex(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size()) {
            throw new IndexOutOfBoundsException();
        }

        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);

    }


    public void removeVertex(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        vertices.remove(index);
        adjMat.remove(index);
        for (List<Integer> row : adjMat) {
            row.remove(index);
        }
    }

    public void printEdge() {
        System.out.println("=================================");
        System.out.print("   ");
        for (int i : vertices) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i =0;i< adjMat.size();i++) {
            List<Integer> row = adjMat.get(i);
            Integer ro = vertices.get(i);
            System.out.print(ro+" |");
            for (int tem : row) {
                System.out.print(" " + tem + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }


}
