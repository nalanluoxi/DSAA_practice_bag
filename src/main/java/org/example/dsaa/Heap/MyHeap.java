package org.example.dsaa.Heap;

import java.util.ArrayList;
import java.util.List;

public class MyHeap {

    private ArrayList<Integer> maxHeap;


    public Boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    MyHeap(List<Integer> nums) {
        maxHeap = new ArrayList<>(nums);
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    MyHeap() {
        maxHeap = new ArrayList<>();
    }

    public int size() {
        return maxHeap.size();
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
        int aVal = maxHeap.get(a);
        int bVal = maxHeap.get(b);
        tem = aVal;
        maxHeap.set(a, bVal);
        maxHeap.set(b, tem);
    }

    /**
     * 从上到下堆化
     * @param i
     */
    private void siftDown(int i) {
        while (true) {
            int l = left(i), r = right(i), ma = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(ma)) {
                ma = l;
            }
            if (r < size() && maxHeap.get(r) > maxHeap.get(ma)) {
                ma = r;
            }
            if (ma == i) {
                break;
            }
            swap(i, ma);
            i = ma;
        }
    }

    /**
     * 返回堆顶
     * @return
     */
    public int peek() {
        return maxHeap.get(0);
    }

    /**
     * 添加
     * @param val
     */
    public void push(int val) {
        maxHeap.add(val);
    }

    /**
     * 从下向上堆化
     * @param i
     */
    private void sifUp(int i) {
        while (true) {
            int p = parent(i);
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p)) {
                break;
            }

            swap(i, p);
            i = p;
        }
    }

    /**
     * 出堆
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        swap(0, size() - 1);
        Integer remove = maxHeap.remove(size() - 1);

        siftDown(0);

        return remove;

    }

    public void printAll() {
        for (int i = 0; i < (size()); i++) {
            System.out.print(maxHeap.get(i) + " , ");
        }
    }

}
