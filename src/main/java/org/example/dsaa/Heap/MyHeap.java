package org.example.dsaa.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyHeap {

    private ArrayList<Integer> maxHeap;


    private int size;

    MyHeap(List<Integer> nums){
        maxHeap=new ArrayList<>(nums);
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }

    private int parent(int i){
        return (i-1)/2;
    }



}
