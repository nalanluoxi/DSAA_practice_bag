package org.example.dsaa.Heap;

import java.util.ArrayList;
import java.util.List;

public class MyMinHeap {
    private ArrayList<Integer> minHeap;


    public Boolean isEmpty() {
        return minHeap.isEmpty();
    }

    MyMinHeap(List<Integer> nums) {
        minHeap = new ArrayList<>(nums);
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    MyMinHeap() {
        minHeap = new ArrayList<>();
    }

    public int size() {
        return minHeap.size();
    }

    //获取子节点索引
    private int left(int i) {
        return 2 * i + 1;
    }

    //获取右节点索引
    private int right(int i) {
        return 2 * i + 2;
    }

    //获取父节点索引
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int a, int b) {
        int tem;
        int aVal = minHeap.get(a);
        int bVal = minHeap.get(b);
        tem = aVal;
        minHeap.set(a, bVal);
        minHeap.set(b, tem);
    }
    /**
     * 返回堆顶
     *
     * @return
     */
    public int peek() {
        return minHeap.get(0);
    }

    /**
     * 添加
     *
     * @param val
     */
    public void push(int val) {
        minHeap.add(val);
        sifUp(size() - 1);
    }

    /**
     * 堆顶出堆
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        swap(0, size() - 1);
        Integer remove = minHeap.remove(size() - 1);

        siftDown(0);

        return remove;

    }

    public void printAll() {
        for (int i = 0; i < (size()); i++) {
            System.out.print(minHeap.get(i) + " , ");
        }
    }

    /**
     * 从下向上堆化
     *
     * @param i
     */
    private void sifUp(int i) {
        while (true) {
            int p = parent(i);
            if (p < 0 || minHeap.get(i) >= minHeap.get(p)) {
                break;
            }

            swap(i, p);
            i = p;
        }
    }

    /**
     * 从上到下堆化
     *
     * @param i
     */
    private void siftDown(int i) {
        while (true) {
            int l = left(i), r = right(i), ma = i;
            if (l < size() && minHeap.get(l) < minHeap.get(ma)) {
                ma = l;
            }
            if (r < size() && minHeap.get(r) < minHeap.get(ma)) {
                ma = r;
            }
            if (ma == i) {
                break;
            }
            swap(i, ma);
            i = ma;
        }
    }

    public static MyMinHeap topKHeap(int[] nums,int k){
        MyMinHeap mmhp=new MyMinHeap();
        for (int i = 0; i < k; i++) {
            mmhp.push(nums[i]);
        }

        for (int i = k ; i <nums.length;i++){
            if (nums[i]>mmhp.peek()){
                mmhp.pop();
                mmhp.push(nums[i]);
            }
        }

        return mmhp;
    }


}
