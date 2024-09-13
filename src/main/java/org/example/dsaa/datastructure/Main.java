package org.example.dsaa.datastructure;


import org.example.dsaa.datastructure.tree.MyTree;
import org.example.dsaa.datastructure.zhan.ListNode;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {

    }

    public static int length(ListNode n){
        ListNode p=n;
        int count=0;
        while (p.next!=null){
            p=p.next;
            count++;
        }
        return count;
    }
}
