package org.example;


import org.example.dsaa.HashMap.MyHashMap;
import org.example.dsaa.HashMap.MyHashMapL;

public class Main {

    public static void main(String[] args) {


        System.out.println("========================================================");

        MyHashMapL myHashMapL=new MyHashMapL();

        myHashMapL.add(1,"sdadasdsa");
        myHashMapL.add(9999,"sdadasdsa");
        myHashMapL.add(9,"sdadasdsa");
        myHashMapL.add(999,"sdadasdsa");
        myHashMapL.add(99,"sdadasdsa");
        myHashMapL.add(999999999,"sdadasdsa");

        System.out.println(myHashMapL.get(999));
        myHashMapL.printAll();

        System.out.println("========================================================");
    }
}
