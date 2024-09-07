package org.example;


import org.example.dsaa.Tree.MyTree;

public class Main {

    public static void main(String[] args) {


        System.out.println("========================================================");


        MyTree mt = new MyTree();
        mt.add(1, 1);
        mt.add(2, 1);
        mt.add(3, 9);
        mt.add(4, 1);
        mt.add(5, 99999);

        System.out.println("长度：" + mt.getSize());
        if (mt.get(3) != null) {
            System.out.println(mt.get(3).val);
        } else {
            System.out.println("不存在");
        }

        System.out.println("长度:" + mt.getSize());
        System.out.println("========================================================");


    }
}
