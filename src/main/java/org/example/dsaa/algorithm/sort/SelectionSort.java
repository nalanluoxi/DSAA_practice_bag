package org.example.dsaa.algorithm.sort;

public class SelectionSort {
    public static void main(String[] args) {

        int[]nums={9,4,2,5,7,6,1,22,4,6};
        int[] select = select(nums);
        for (int i = 0; i < select.length; i++) {
            System.out.println(select[i]);
        }


    }
    public static int[] select(int []nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j]>nums[i]){
                    int tem=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tem;
                }
            }
        }
        return nums;

    }
}
