package org.example.dsaa.datastructure;


public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 45, 78, 66, 32, 5, 4, 56};
        quick(nums);
        System.out.print("{ ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("}");

    }

    public static void quick(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    public static int par(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[left] <= nums[j]) {
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

    public static void quicksort(int[]nums,int left,int right){
        if (left>=right){
            return;
        }
        int p = par(nums, left, right);
        quicksort(nums, left, p-1);
        quicksort(nums, p+1, right);

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
