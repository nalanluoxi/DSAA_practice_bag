package org.example.dsaa.datastructure.linkedListdeque;

public class MyLinkedListDeque {

    private ListNode head;
    private ListNode tail;

    private int size;
    public MyLinkedListDeque() {
        head=tail=new ListNode();
        size=0;
    }
    public int getSize(){
        return size;
    }

    public Boolean isEmpty(){
        return size==0;
    }

    public void pushFirst(int val){
       push(true,val);
    }

    public void pushLash(int val){
      push(false,val);
    }

    private void push(Boolean isfirst,int val){
        ListNode newnode=new ListNode(val);
        if (this.isEmpty()){
            head=tail=newnode;
        } else if (isfirst) {
            newnode.next=head;
            head=newnode;
        }else {
            tail.next=newnode;
            tail=newnode;
        }
        size++;

    }

    public void popfirst(){
        pop(true);
    }

    public void poplast(){
        pop(false);
    }

    private void pop(Boolean isFirat){
        if (isFirat){
            if (head == null) throw new IllegalStateException("Deque is empty");
            head=head.next;
            if (head==null){
                tail=null;
            }
        }else {
            if (tail == null) throw new IllegalStateException("Deque is empty");
            if (head==tail){
                head=tail=null;
            }else {
                ListNode pretail=head;
                while (pretail.next!=tail){
                    pretail=pretail.next;
                }
                tail=pretail;
                tail.next=null;
            }
        }
        size--;
    }


    public void printAll(){
        ListNode p=head;
        System.out.print(p.val+"=> ");
        while (p.next!=null){
            p=p.next;
            System.out.print(p.val+"=> ");
        }
        System.out.println();
    }


}
