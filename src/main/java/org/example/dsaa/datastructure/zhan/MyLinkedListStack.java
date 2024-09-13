package org.example.dsaa.datastructure.zhan;


public class MyLinkedListStack {
    private ListNode head;
    private ListNode tail;

    private int size;

    public MyLinkedListStack() {
        this.head =new ListNode() ;
        tail=head;
        size=0;
    }

    public void push(int val){
        ListNode newnode=new ListNode(val);
        tail.next=newnode;
        tail=tail.next;
        this.size++;
    }

    public int getSize(){
        return this.size;
    }

    public int peek(){
        return tail.val;
    }

    public int pop(){
        int peek = peek();
        ListNode point=head;
        for (int i = 0; i < size-1; i++) {
            point=point.next;
        }
        point.next=null;
        tail=point;
        size--;
        return peek;
    }

    public Boolean isEmpty(){
        if (head.next==null){
            return true;
        }else {
            return false;
        }
    }

    public void printAll(){
        ListNode point=head;
        while (point.next!=null){
            point=point.next;
            System.out.print(point.val+"=> ");
        }
    }
}
