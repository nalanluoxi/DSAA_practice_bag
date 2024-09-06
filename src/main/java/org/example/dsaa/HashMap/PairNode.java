package org.example.dsaa.HashMap;

public class PairNode {
    int key;
    String val;
    PairNode next;

    PairNode pre;

    public PairNode(int key,String val) {
        this.key=key;
        this.val=val;
        next=pre=null;
    }

    public PairNode() {
    }
}
