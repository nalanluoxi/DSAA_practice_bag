package org.example.dsaa.HashMap;

public class MyHashMapL {

    private PairNode [] hashArr;
    //哈希表

    private int capcity;
    //总容量

    private int size;
    //键值对数

    private int extend;
    //扩容倍数

    private double load;
    //扩容因子

    public int getSize(){
        return size;
    }

    public double getLoad(){
        return (double) size/capcity;
    }

    public MyHashMapL() {
        capcity=10;
        hashArr=new PairNode[10];
        size=0;
        extend=2;
        load=2.0/3.0;
        for (int i = 0; i < 10; i++) {
            hashArr[i]=null;
        }
    }

    public int hashFun(int key){
        int index=key%capcity;
        return index;
    }

    public void extendFun(){
        capcity*=load;
        PairNode []newbrr=new PairNode[capcity];
        for (int i = 0; i < size; i++) {
            newbrr[i]=hashArr[i];
        }
        hashArr=newbrr;
    }

    public void add(int key,String val){
        if (getLoad()>load){
            extendFun();
        }
        int index = hashFun(key);
        PairNode tem=new PairNode(key,val);
        PairNode target = hashArr[index];
        if (target==null){
            hashArr[index]=tem;
        }else {
            PairNode point=target;
            while (true){
                if (point.next==null){
                    point.next=tem;
                    tem.pre=point;
                    break;
                }
                point=point.next;
            }
        }
        size++;
    }

    public String get(int key){
        int index = hashFun(key);
        PairNode pairNode = hashArr[index];
        if (pairNode==null){
            return null;
        }else {
            PairNode p=pairNode;
            while (p!=null){
                if (p.key==key){
                    return p.val;
                }
                p=p.next;
            }
        }
        return null;
    }

    public void remove(int key){
        int index = hashFun(key);
        PairNode pairNode = hashArr[index];

        if (pairNode.next==null){
            hashArr[index]=null;
            size--;
            return;
        }else {
            PairNode point=pairNode;
            if (point.key==key){
                hashArr[index]=point.next;
                return;
            }
            while (point.next!=null){
                if (point.key==key){
                    point.pre=point.next;
                    size--;
                    break;
                }
                point= point.next;
            }
        }

    }

    public void printAll(){
        System.out.print("[ ");
        for (PairNode pairNode:hashArr){
            PairNode p=pairNode;
            while (p!=null){
                System.out.print(" \"key:"+p.key+" val:"+p.val+"\" , ");
                p=p.next;
            }
        }
        System.out.println("]");
    }


}
