package array;

public class N53MaximumSubarray {
    /*
    * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
        A subarray is a contiguous part of an array.
    * */
    /*
    * 解题思路：需要一次遍历解决 需要记录下标 当前面的和为负数的时候 从新开始计算 当前面的和是正数 下标开始计入
    * */

    public int maxSubArray(int[] nums) {
        int max = 0, globalMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max += nums[i];
            globalMax = Math.max(max,globalMax);
            if(max<0) max = 0;
        }
        return globalMax;
    }

}
