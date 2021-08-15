package array.greddy;


/*
* You are given an integer array nums. You are initially positioned at the array's first index,
* and each element in the array represents your maximum jump length at that position.
* Return true if you can reach the last index, or false otherwise.
* 解题思路 最大跳跃长度需要动态规划 如果index是n 那么当前步骤需要动态记录 步长是0-num[n]的所有可能
*   贪心算法 每次都计算最大长度 如果不能超过num.length-1才回退
* */
public class N55JumpGame {
    public boolean canJump(int[] nums) {
        int reach = 0;  //初始化可以reach的下标为0
        // i <= reach 当当前的下标不能被reach的时候退出循环
        //不断确定最大的可及范围来确定是否可以达到length-1
        for (int i = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach,i+nums[i]);
            if(reach >= nums.length-1) return true;
        }
        return false;
    }
}
