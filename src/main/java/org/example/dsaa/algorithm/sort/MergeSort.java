package org.example.dsaa.algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {


    }

    public static void merge(int[] nums, int left, int right) {

        int mid=left+(right+left)/2;



    }

    public static void mergehelp(int[] nums, int left, int mid, int right) {
        int[] temnums = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i < mid && j < right) {
            if (nums[i] < nums[j]) {
                temnums[k++] = nums[i++];
            } else {
                temnums[k++] = nums[j++];
            }
        }

        while (i < mid) {
            temnums[k++] = nums[i];
        }
        while (j < right) {
            temnums[k++] = nums[j];
        }

        for (int l = 0; l < temnums.length; l++) {
            nums[left+l]=temnums[l];
        }

    }


}
