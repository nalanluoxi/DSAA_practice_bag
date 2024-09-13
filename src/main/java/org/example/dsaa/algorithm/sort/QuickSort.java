package org.example.dsaa.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {


        int[] nums = {9,8,7,6,5,4,3,2,1,0};
        int r = nums.length;
        quick(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }


    public static void quick(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int partition = partition(nums, left, right);
        quick(nums, left, partition - 1);
        quick(nums, partition + 1, right);

        //  return nums;
    }
}
