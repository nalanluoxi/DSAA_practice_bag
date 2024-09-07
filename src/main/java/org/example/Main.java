package org.example;


import org.example.dsaa.HashMap.MyHashMapL;

public class Main {

    public static void main(String[] args) {


        System.out.println("========================================================");


      /*  MyHashMapOpenAddress mh=new MyHashMapOpenAddress();
        System.out.println(mh.getSize());
        mh.put(1,"111");
        mh.put(11,"111");
        mh.put(111,"111");
        mh.put(1111,"111");
        mh.put(11111,"111");

        mh.printAll();
        System.out.println(mh.getSize());*/

        System.out.println("========================================================");


        MyHashMapL ml = new MyHashMapL();

        ml.add(1, "1");//
        ml.add(2, "2");//
        ml.add(22, "22");//
        ml.add(222, "222");
        ml.add(1111, "1111");
//
        ml.add(11, "222");//
        ml.add(11113, "222");//
        ml.add(19, "222");//
        ml.add(1999, "222");//
        ml.add(188888, "222");//
        ml.add(18, "18");//

        ml.printAll();
        //System.out.println(ml.getSize());
        System.out.println(ml.get(1));
        System.out.println(ml.get(11));
        System.out.println(ml.get(18));
        System.out.println("========================================================");


    }
}
