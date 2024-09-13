package org.example.dsaa.datastructure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
     *
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
     *
     * @return
     */
    public int peek() {
        return maxHeap.get(0);
    }

    /**
     * 添加
     *
     * @param val
     */
    public void push(int val) {
        maxHeap.add(val);
        sifUp(size() - 1);
    }

    /**
     * 从下向上堆化
     *
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
     * 堆顶出堆
     *
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

  /*  public static MyHeap topkHeap(int[] nums,int k){
        MyHeap topK= new MyHeap();

        for (int i = 0; i < k; i++) {
            topK.push(nums[i]);
        }

        for (int i =k;i<nums.length;i++){
            if (nums[i]>topK.peek()){
                topK.pop();
                topK.push(nums[i]);
            }
        }
        return topK;

    }
*/

    public static Queue<Integer> topKHeap(int[] nums, int k) {
        // 初始化小顶堆
        Queue<Integer> heap = new PriorityQueue<Integer>();
        // 将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        // 从第 k+1 个元素开始，保持堆的长度为 k
        for (int i = k; i < nums.length; i++) {
            // 若当前元素大于堆顶元素，则将堆顶元素出堆、当前元素入堆
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap;
    }
}
