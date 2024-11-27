package org.example.dsaa.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

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
      //  int[] num = {9, 8, 5, 11, 23, 46,872,101,54, 1111, 69, 58};

        int [] nums={1,1,5,4,3,2};
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        MyHeap my=new MyHeap(list);
        my.printAll();

    }
}
