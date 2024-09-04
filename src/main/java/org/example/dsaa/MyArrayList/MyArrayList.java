package org.example.dsaa.MyArrayList;

public class MyArrayList {

    private int[] arr;
    private int length;

    private int capacity;

    public MyArrayList() {
        this.length=10;
        arr=new int[10];
        capacity=0;
    }

    public boolean add(int value){
        if (capacity==length){
            arr=extend(arr);
        }
        arr[capacity++]=value;
        return true;
    }

    public boolean add(int index,int value){
        if (index>capacity+1){
            return false;
        }
        if (capacity==length){
            arr=extend(arr);
        }
        for (int i = (capacity-1); i >=index; i--) {
            arr[i+1]=arr[i];
        }
        arr[index]=value;
        capacity++;
        return true;
    }

    public boolean remove(int index){
        if (index<0||index>capacity){
            return false;
        }
        int [] brr=new int[capacity];
        for (int i = 0; i < capacity; i++) {
            brr[i]=arr[i];
        }
        int i=0;
        int j=0;
        while (j!=capacity){
           if (j==index){
               j++;
           }
           arr[i]=brr[j];
           i++;
           j++;
        }
        capacity--;
        return true;
    }

    public int getValue(int index){
        if (index<0||index>length){
            throw new RuntimeException();
        }
        return arr[index];
    }

    public void printall(){
        System.out.printf("[");
        for (int i = 0; i < capacity; i++) {
            System.out.print(arr[i]);
            if (i!=capacity-1){
                System.out.printf(" ");
            }
        }
        System.out.println("]");
    }

    public int[] extend(int [] arr){
        this.length=length*2;
        int[] newbrr=new int[this.length];
        for (int i = 0; i < capacity; i++) {
            newbrr[i]=arr[i];
        }
        return newbrr;
    }
}
