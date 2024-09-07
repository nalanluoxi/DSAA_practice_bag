package org.example.dsaa.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyHashMapOpenAddress {

    private List<Pair> hashArr;
    // private List<Pair> hashArr;
    private Integer capacity;
    //哈希表容量
    private int size;
    //键值对数量
    private int extend;
    //扩容倍数
    private double load;
    //负载因子

    private Pair TOMBSTONE=new Pair(-1,"-1");

    public int getSize(){
        return size;
    }

    //哈希函数
    public int hashFun(int key) {
        int index = key % capacity;
        return index;
    }
    public MyHashMapOpenAddress() {
        size=0;
        capacity=2;
        extend=2;
        load=2.0/3.0;
        hashArr=new ArrayList<>(capacity);
        for (int i = 0; i <capacity ; i++) {
            hashArr.add(null);
        }
    }

    //负载因子
    public double Load(){
        return (double) size/capacity;
    }

    public void extend(){
        List<Pair> temp=hashArr;
        capacity*=extend;
        hashArr=new ArrayList<>(capacity);
        for (Integer i = 0; i < capacity; i++) {
            hashArr.add(null);
        }
        size=0;
        for (Pair pair:temp){
            if (pair!=null && pair!=TOMBSTONE){
                put(pair.key, pair.val);
            }
        }
    }

    public void put(int key,String val){
        if (Load()>load){
            extend();
        }
        int index = findindex(key);
        hashArr.set(index,new Pair(key,val));
        size++;
    }

    private int findindex(int key){
        int index=hashFun(key);
        while (hashArr.get(index)!=null){
            if (hashArr.get(index).key==key||hashArr.get(index)==TOMBSTONE){
                return index;
            }
            index=(index+1)%capacity;
        }
        return index;
    }

    public void printAll(){
        System.out.print("[");
        for (Pair pair: hashArr){
            if (pair==null){
                System.out.print(" null ,");
            } else if (pair==TOMBSTONE) {
                System.out.print(" TOMBSTONE ,");
            }else {
                System.out.print(" \" key:" + pair.key + " val:" + pair.val + " \" ,");
            }
        }
        System.out.println("]");
    }

}
