package org.example;


import org.example.dsaa.HashMap.MyHashMap;

public class Main {

    public static void main(String[] args) {


        System.out.println("========================================================");

        MyHashMap myHashMap=new MyHashMap();
        myHashMap.put(99,"51235");
       myHashMap.put(123,"575");
       myHashMap.put(9999,"894");
       myHashMap.put(811,"123");
       myHashMap.put(99569456,"222");


       myHashMap.remove(888);
        String string = myHashMap.get(9999);
        System.out.println(string);
        myHashMap.printAll();

       // System.out.println(myHashMap.);

        System.out.println(99%100);
    }
}
