package org.example.dsaa.algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {

        int [ ]nums={9,22,4,5,7,8,6,4,5,8,8,33,41,5};
        int[] bubble = bubble(nums);
        for (int i = 0; i < bubble.length; i++) {
            System.out.print(bubble[i]+" ");
        }

    }

    public static int[] bubble(int[]nums){

        for (int j=nums.length-1;j>0;j--){
            for (int i = 0; i < j; i++) {
                if (nums[i]>nums[i+1]){
                    int tem=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=tem;
                }
            }
        }

        return nums;
    }
}
