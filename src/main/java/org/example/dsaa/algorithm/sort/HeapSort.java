package org.example.dsaa.algorithm.sort;

public class HeapSort {

    public static void main(String[] args) {
        int [] nums={1,1,5,4,3,2};
        Heap(nums);
        for(int n:nums){
            System.out.print(n+"  ");
        }


    }
    private static int parent(int i) {
        return (i - 1) / 2;
    }

    public static void Heap(int[] nums){
        for (int i = parent(nums.length-1); i >=0 ; i--) {
            siftDown(nums,nums.length,i);
        }
        for (int i = nums.length-1; i >0 ; i--) {
            int tem=nums[0];
            nums[0]=nums[i];
            nums[i]=tem;
            siftDown(nums,i,0);
        }

    }

    public static void siftDown(int[] nums,int n,int i){
        while (true){
            int l=2*i+1;
            int r=2*i+2;
            int ma=i;
            if (l<n&&nums[l]>nums[ma]){
                ma=l;
            }
            if (r<n&&nums[r]>nums[ma]){
                ma=r;
            }
            if (ma==i){
                break;
            }
            int tem=nums[ma];
            nums[ma]=nums[i];
            nums[i]=tem;
            i=ma;
        }


    }


}
