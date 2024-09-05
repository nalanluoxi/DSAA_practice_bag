package org.example.dsaa.MyListNote;

public class MyListNode {

    int size;


    ListNode head;

    public MyListNode() {
        size=0;
        head=new ListNode();
    }

    public void add(int val){
        add(size,val);
    }

    public void add(int index,int val){
        if (index<0){
            index=0;
        }
        if (index>size){
            return;
        }

        size++;
        ListNode now=head;

        for (int i = 0; i < index; i++) {
            now=now.next;
        }

        ListNode target=new ListNode(val);

        target.next=now.next;

        now.next=target;
    }

    public int getSize(){
        return size;
    }
    public Boolean delete(){
        return delete(size);
    }
    public Boolean delete(int index){
        if (index>size){
            return false;
        }

        ListNode now=head;
        for (int i = 0; i < index-1; i++) {
            now=now.next;
        }

        now.next=now.next.next;
        size--;
        return true;
    }

    public void printAll(){
        ListNode now=head.next;
        for (int i = 0; i < size; i++) {
            System.out.print(now.val+" => ");
            now=now.next;
        }
    }


}
