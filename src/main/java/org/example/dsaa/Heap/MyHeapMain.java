package org.example.dsaa.Heap;

import java.util.Queue;

public class MyHeapMain {
    public static void main(String[] args) {

        // MyHeap mh=new MyHeap();

        // mh.push(9);
        // mh.push(6);
        // mh.push(7);
        // mh.push(8);
        // mh.push(1);
        // mh.printAll();
        //// //System.out.println(mh.);
        // System.out.println();
        //// System.out.println("=====================================");
        //// System.out.println(mh.peek());
        //// System.out.println(mh.peek());
        //// System.out.println(mh.peek());
        //// System.out.println(mh.peek());
        // System.out.println(mh.peek());
        // System.out.println(mh.peek());
        // System.out.println("======================================");
        // System.out.println(mh.pop());
        // System.out.println(mh.pop());
        // System.out.println(mh.pop());
        // System.out.println(mh.pop());
        // System.out.println(mh.pop());
        //   System.out.println(mh.pop());
        //   System.out.println(mh.pop());
        int[] num = {9, 8, 5, 11, 23, 46,872,101,54, 1111, 69, 58};

        MyMinHeap myMinHeap = MyMinHeap.topKHeap(num, 3);
        myMinHeap.printAll();

    }
}
