package org.example.dsaa.algorithm.search;

public class BinarySearchMain {
    public static void main(String[] args) {
        System.out.println("=========================================================");
        int[] nums = {1, 2,  4, 5, 6, 6, 6, 6, 7, 8, 9, 10};
        // System.out.println(binarySearch(nums, 6));

        System.out.println(binarySearchInsertionSimple(nums, 3));
        System.out.println("=========================================================");
    }

    /**
     * 左右闭区间二分查找
     *
     * @param nums
     * @param target
     */
    public static int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //Arrays.sort(nums);
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }


        return -1;
    }

    /**
     * 有重复元素二分查找插入点索引  左边界
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchInsertionSimple(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        //return l < nums.length ? l : -1;
        return l;
    }


}
