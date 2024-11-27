package org.example.dsaa.algorithm.sort;

public class RadixSort {
    public static void main(String[] args) {
        int []num={2024601,2024602,2023603,2024604,2000605};
        radixsort(num);
        System.out.print("{ ");
        for (int i : num) {
            System.out.print(i+" ");
        }
        System.out.println("}");
    }

    public static void radixsort(int[]nums){
        int min=Integer.MIN_VALUE;
        for (int num : nums) {
            if (num>min){
                min=num;
            }
        }

        for (int k = 1; k <=min; k*=10) {
            help(nums,k);
        }
    }

    private static void help(int[] nums, int k) {
        int len = nums.length;
        int[] count=new int[10];
        for (int i = 0; i < len; i++) {
            int temnum = getk(nums[i], k);
            count[temnum]++;
        }
        for (int i=1;i<10;i++){
            count[i]+=count[i-1];
        }

        int []res=new int[len];
        for (int i = len-1; i >=0; i--) {
            int getk = getk(nums[i], k);
            int j = count[getk] - 1;
            res[j]=nums[i];
            count[getk]--;
        }

        for (int i = 0; i < len; i++) {
            nums[i]=res[i];
        }
    }

    private static int getk(int nums,int k){
        return (nums/k)%10;
    }
}
