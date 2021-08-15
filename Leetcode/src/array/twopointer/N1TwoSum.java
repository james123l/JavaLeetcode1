package array.twopointer;


import java.util.HashMap;

/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
* */
public class N1TwoSum {
    //leetcode 最优解法 是对双指针解法的优化
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if (len == 2) return new int[]{0, 1};
        //头尾指针 此时i < len/2 因为把数组用2个指针遍历 所以一个只需要遍历一半
        for (int i =0 , k = len-1; i < len/2 ; i++,k--) {
            if(nums[i]+nums[k] == target) return new int[]{i, k};
            //j<len-i 是因为尾部有k指针 所以这个遍历是一个头指针一个尾指针
            for (int j = i+1; j < k; j++) {
                int needed = target -nums[j];
                if (nums[i] == needed) return new int[]{i, j};
                if (nums[k] == needed) return new int[]{j, k};
            }
        }
        return new int[0];
    }
    //利用哈希表不重复的特性 省去一些遍历时间 速度较快 o(n)
    public int[] twoSumHashMap(int[] nums, int target) {
        int[] solution = new int[2];
        int diff;   //差值
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i = 0; i < nums.length;i++){
            //获取当前值所对应的差值
            diff = target - nums[i];
            //如果hashmap里面含有当前差值，则通过差值寻找到之前记录的对应下标
            if(hashMap.containsKey(diff)){
                solution[0]=hashMap.get(diff);
                solution[1]=i;
                break;
            }
            //如果没找到 把值和对应下标存入hashmap中
            hashMap.put(nums[i],i);
        }
        return solution;
    }
    //双指针问题 过多循环 暴力破解 效果最差 o(n^2)
    public int[] myTwoSumTwoPointer(int[] nums, int target) {
        //外层循环控制第一个指针
        int i , j ;
        for ( i =0 ; i < nums.length; i++) {
            //内层循环控制第二个指针
            for (j = i + 1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    int[] ints = {i,j};
                    return ints;
                }
            }
        }
        return null;
    }
}
