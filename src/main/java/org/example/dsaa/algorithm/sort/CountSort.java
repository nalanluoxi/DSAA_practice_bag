package org.example.dsaa.algorithm.sort;

public class CountSort {
    public static void main(String[] args) {
        int [ ]nums={5,8,4,4,4,64,15,15,15,15,15,34,325,4};
        counting(nums);
        for (int n:nums){
            System.out.print(n+"  ");
        }
    }


    public static void counting(int[]nums){
        int m=0;
        for ( int n: nums){
            m=Math.max(m,n);
        }

        int [] count=new int[m+1];

        for ( int n: nums){
            count[n]++;
        }

        for (int i = 0; i < m; i++) {
            count[i+1]+=count[i];
        }

        int l = nums.length;
        int [] res=new int[l];

        for (int i =l-1;i>=0;i--){
            int num=nums[i];
            res[count[num]-1]=num;
            count[num]--;
        }

        for (int i = 0; i < l; i++) {
            nums[i]=res[i];
        }


    }

    /* 计数排序 */
// 完整实现，可排序对象，并且是稳定排序
    public  static void counting1(int[] nums) {
        // 1. 统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        // 2. 统计各数字的出现次数
        // counter[num] 代表 num 的出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }
        // 3. 求 counter 的前缀和，将“出现次数”转换为“尾索引”
        // 即 counter[num]-1 是 num 在 res 中最后一次出现的索引
        for (int i = 0; i < m; i++) {
            counter[i + 1] += counter[i];
        }
        // 4. 倒序遍历 nums ，将各元素填入结果数组 res
        // 初始化数组 res 用于记录结果
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            res[counter[num] - 1] = num; // 将 num 放置到对应索引处
            counter[num]--; // 令前缀和自减 1 ，得到下次放置 num 的索引
        }
        // 使用结果数组 res 覆盖原数组 nums
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}
