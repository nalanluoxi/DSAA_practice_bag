package org.example;


import org.example.dsaa.MyListNote.MyListNode;

public class Main {

    public static void main(String[] args) {


        System.out.println("========================================================");

        MyListNode node = new MyListNode();

        node.printAll();
        node.add(5);
        node.add(8);
        node.add(9);


        node.printAll();
        Boolean delete = node.delete(1);
        System.out.println(delete);

        node.printAll();


    }
}
