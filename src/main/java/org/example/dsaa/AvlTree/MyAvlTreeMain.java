package org.example.dsaa.AvlTree;

public class MyAvlTreeMain {
    public static void main(String[] args) {

        MyAvlTree mat = new MyAvlTree();

        mat.insert(1, 5);
        mat.insert(2, 9);
        mat.insert(9, 4);
        mat.insert(8, 777);
        System.out.println(mat.get(8).val);
        mat.remove(8);

        System.out.println(mat.get(8).val);

    }
}
