package org.example.dsaa.algorithm.sort;

public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = {9, 55, 4, 2, 8, 6, 7, 3, 1, 545, 55, 9, 7, 6, 4, 15};
        int[] insert = insert(nums);
        for (int i = 0; i < insert.length; i++) {
            System.out.print(insert[i] + " ");
        }

    }

    public static int[] insert(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int base = num[i];
            int j = i - 1;
            while (j >= 0 && base < num[j]) {
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = base;
        }
        return num;
    }


}
