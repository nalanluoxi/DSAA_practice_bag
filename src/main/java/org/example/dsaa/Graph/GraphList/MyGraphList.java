package org.example.dsaa.Graph.GraphList;

import java.util.*;

public class MyGraphList {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public MyGraphList(Integer[][] edges) {
        this.adjList = new HashMap<>();
        for (Integer[] integers : edges) {
            addVertex(integers[0]);
            addVertex(integers[1]);
            addEdge(integers[0], integers[1]);
        }
    }

    public int size() {
        return adjList.size();
    }

    /**
     * 添加边
     *
     * @param val
     */
    public void addVertex(Integer val) {
        if (adjList.containsKey(val)) {
            return;
        }
        adjList.put(val, new ArrayList<>());
    }

    /**
     * 添加边
     *
     * @param i
     * @param j
     */
    public void addEdge(Integer i, Integer j) {
        if (!adjList.containsKey(i) || !adjList.containsKey(j) || i == j) {
            System.out.println("报错");
            return;
        }
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    /***
     * 删除节点
     * @param key
     */
    public void removeVertex(Integer key) {
        if (!adjList.containsKey(key)) {
            System.out.println("报错!");
            return;
        }
        adjList.remove(key);
        for (List<Integer> list : adjList.values()) {
            list.remove(key);
        }
    }


    /**
     * 删除边
     *
     * @param i
     * @param j
     */
    public void removeEdge(Integer i, Integer j) {
        if (!adjList.containsKey(i) || !adjList.containsKey(j) || i == j) {
            System.out.println("报错");
            return;
        }
        adjList.get(i).remove(j);
        adjList.get(j).remove(i);
    }


    public void printEdge() {
        System.out.println("==============================================");
        Set<Integer> integers = adjList.keySet();
        for (Integer key : integers) {
            List<Integer> list = adjList.get(key);
            System.out.print(key + " | ");
            for (Integer num : list) {
                System.out.print(" =>" + num);
            }
            System.out.println();
        }
        System.out.println("==============================================");
    }


    /**
     * 广度遍历
     * @param graph
     * @param startval
     * @return
     */
    public static List<Integer> graphBFSG(MyGraphList graph,Integer startval){
        List<Integer> res=new ArrayList<>();
        //遍历结果索引
        Queue<Integer> que=new LinkedList<>();
        //队列实现bfs
        Set<Integer> visited=new HashSet<>();
        //记录被遍历过的索引
        visited.add(startval);
        que.offer(startval);
        while (!que.isEmpty()){
            Integer vel = que.poll();
            res.add(vel);
            for (Integer adVet:graph.adjList.get(vel)){
                if (visited.contains(adVet)){
                    continue;
                }
                que.offer(adVet);
                visited.add(adVet);
            }
        }



        return res;
    }


    public static List<Integer> graphDFSS(MyGraphList graph,Integer start){
        List<Integer> res=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        dfs(graph,visited,res,start);
        return res;
    }

    public static void dfs(MyGraphList graph,Set<Integer> visited,List<Integer> res,Integer start){
        res.add(start);
        visited.add(start);
        for (Integer adjVal:graph.adjList.get(start)){
            if (visited.contains(adjVal)){
                continue;
            }
            dfs(graph,visited,res,adjVal);
        }

    }
}
