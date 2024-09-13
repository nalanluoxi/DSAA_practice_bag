package org.example.dsaa.datastructure.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

    private List<List<Pair>> hashArr;
    // private List<Pair> hashArr;
    private Integer HashArrCapacity;
    //哈希表容量
    private int size;
    //键值对数量
    private int extend;
    //扩容背书
    private double load;
    //负载因子

    //获取键值对数量
    public int getSize(){
        return size;
    }

    //哈希函数
    public int hashFun(int key) {
        int index = key % HashArrCapacity;
        return index;
    }

    //初始化
    public MyHashMap() {
        size=0;
        HashArrCapacity=10;
        extend=2;
        load=2.0/3.0;
        hashArr=new ArrayList<>(HashArrCapacity);
        for (int i = 0; i <HashArrCapacity ; i++) {
            hashArr.add(new ArrayList<>());
        }
    }
    //负载因子
    public double Load(){
        return (double) size/HashArrCapacity;
    }
    public void extendFun(){
        HashArrCapacity*=extend;
        List<List<Pair>> temparr=hashArr;
        hashArr=new ArrayList<>(HashArrCapacity);
        size=0;
        for (Integer i = 0; i < HashArrCapacity; i++) {
            hashArr.add(new ArrayList<>());
        }

        for (List<Pair> pairList:temparr){
            for(Pair pair:pairList){
                put(pair.key,pair.val);
            }
        }
    }

    public void put(int key,String val){
        if (Load()>load){
            extendFun();
        }

        int index=hashFun(key);
        List<Pair> pairList = hashArr.get(index);
        for (Pair pair:pairList){
            if (pair.key==key){
                pair.val=val;
                return;
            }
        }
        Pair pair=new Pair(key,val);
        pairList.add(pair);
        size++;
    }

    public void remove(int key){
        int index = hashFun(key);

        List<Pair> pairList = hashArr.get(index);
        for (Pair pair:pairList){
            if (pair.key==key){
                pairList.remove(pair);
                size--;
                break;
            }
        }
    }

    public String get(int key){
        int index = hashFun(key);
        List<Pair> pairList = hashArr.get(index);
        for (Pair pair:pairList){
            if (pair.key==key){
                return pair.val;
            }
        }
        return null;
    }
    public void printAll(){
        System.out.print("[");
        for (List<Pair> pairList:hashArr){
            for (Pair pair:pairList){
                System.out.print("\" key:"+pair.key+" val:"+pair.val+"\" , ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

}
