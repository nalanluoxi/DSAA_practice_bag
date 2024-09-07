package org.example.dsaa.HashMap;

public class MyHashMapL {

    private PairNode[] hashArr;
    //哈希表

    private int capcity;
    //总容量

    private int size;
    //键值对数

    private int extend;
    //扩容倍数

    private  final double load=2.0/3.0;
    //扩容因子

    public int getSize() {
        return size;
    }

    public double getLoad() {
        return (double) size / capcity;
    }

    public MyHashMapL() {
        capcity = 4;
        hashArr = new PairNode[capcity];
        size = 0;
        extend = 2;
        for (int i = 0; i < capcity; i++) {
            hashArr[i] = null;
        }
    }

    public int hashFun(int key) {
        int index = key % capcity;
        return index;
    }

    public void extendFun() {
        capcity *= extend;
        PairNode[] tembrr = hashArr;
        hashArr = new PairNode[capcity];
        size = 0;
        for (PairNode pair : tembrr) {
            while (pair != null) {
                add(pair.key, pair.val);
                pair = pair.next;
            }
        }
    }

    public void add(int key, String val) {
        if (getLoad() > load)
            extendFun();
        int index = hashFun(key);
        PairNode point = hashArr[index];
        if (point == null) {
            hashArr[index] = new PairNode(key,val);
        } else {
            while (true) {
                if (point.next == null) {
                    PairNode tem = new PairNode(key, val);
                    point.next = tem;
                    tem.pre = point;
                    break;
                }
                point = point.next;
            }
        }
        size++;
    }

    public String get(int key) {
        int index = hashFun(key);
        PairNode p = hashArr[index];
        if (p == null) {
            return null;
        } else {
            while (p!= null) {
                if (p.key == key) {
                    return p.val;
                }
                p = p.next;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hashFun(key);
        PairNode point= hashArr[index];
        if (point.next == null) {
            hashArr[index] = null;

        } else {
            if (point.key == key) {
                hashArr[index] = point.next;
                return;
            }
            while (point.next != null) {
                if (point.key == key) {
                    point.pre = point.next;
                    if (point.next!=null){
                        point.next.pre=point.pre;
                    }
                    break;
                }
                point = point.next;
            }
        }
        size--;
    }

    public void printAll() {
        System.out.print("[ ");
        int count = 0;
        for (PairNode pairNode : hashArr) {
            PairNode p = pairNode;
            while (p != null) {
                System.out.print(" \"key:" + p.key + " val:" + p.val + "\" , ");
                count++;
                p = p.next;

            }
        }
        System.out.println("]");
        System.out.println("容器容量capcity：" + capcity);
        System.out.println("键值对数size：" + count);
    }


}
