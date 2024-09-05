package org.example.dsaa.HashList;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}
