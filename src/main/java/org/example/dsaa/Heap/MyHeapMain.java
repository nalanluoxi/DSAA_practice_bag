package org.example.dsaa.Heap;

public class MyHeapMain {
    public static void main(String[] args) {

        MyHeap mh=new MyHeap();

        mh.push(9);
        mh.push(6);
        mh.push(7);
        mh.push(8);
        mh.push(1);
        mh.printAll();
        //System.out.println(mh.);
        System.out.println();
        System.out.println("=====================================");
        System.out.println(mh.peek());
        System.out.println(mh.peek());
        System.out.println(mh.peek());
        System.out.println(mh.peek());
        System.out.println(mh.peek());
        System.out.println(mh.peek());
        System.out.println("======================================");
        System.out.println(mh.pop());
        System.out.println(mh.pop());
        System.out.println(mh.pop());
        System.out.println(mh.pop());
        System.out.println(mh.pop());
     //   System.out.println(mh.pop());
     //   System.out.println(mh.pop());
    }
}
