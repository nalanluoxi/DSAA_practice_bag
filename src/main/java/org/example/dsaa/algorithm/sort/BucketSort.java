package org.example.dsaa.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        float[] fl={0.4F, 0.4F,0.46f,0.99f,0.14f};
        bucketSort(fl);
        for (Float f:fl){
            System.out.print(f+"  ");
        }

    }

    public static void bucketSort(float[] nums){
        int k=nums.length/2;

        List<List<Float>> list=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        for (float n:nums){
            int tem=(int) (n*k);
            list.get(tem).add(n);
        }

        for (List<Float> tem:list){
            Collections.sort(tem);
        }

        int i=0;
        for (List<Float> tem:list){
            for(Float n:tem){
                nums[i++]=n;
            }
        }

    }

    /* 桶排序 */
 /*  public static void bucketSort(float[] nums) {
        // 初始化 k = n/2 个桶，预期向每个桶分配 2 个元素
        int k = nums.length / 2;
        int cap=nums.length;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }
        // 1. 将数组元素分配到各个桶中
        for (float num : nums) {
            // 输入数据范围为 [0, 1)，使用 num * k 映射到索引范围 [0, k-1]
           // int i = (int) (num * k);
            int i = (int) ((num * k)%cap);
            // 将 num 添加进桶 i
            buckets.get(i).add(num);
        }
        // 2. 对各个桶执行排序
        for (List<Float> bucket : buckets) {
            // 使用内置排序函数，也可以替换成其他排序算法
            Collections.sort(bucket);
        }
        // 3. 遍历桶合并结果
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                nums[i++] = num;
            }
        }
    }*/
}
