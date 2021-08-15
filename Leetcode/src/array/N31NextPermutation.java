package array;

import java.util.Arrays;

public class N31NextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
    The replacement must be in place and use only constant extra memory.
    */


    /**
     * leetcode 最快算法
     * 算法一样 编码方式不同 效率差别很大
     * ！！！！！ 不多创建函数 不多进行循环嵌套 提升效率
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        //找到顶点 从后往前
        for(;i>=0;i--){
            if(i==0||nums[i]>nums[i-1]) { break; }
        }
        //定义第一个开始递减的下标 并判断是否为0
        int firstIdx= Math.max(0,i-1);
        //从后向前遍历 直到遇到刚好大于第一个递减元素的数字并进行替换
        for(int j= nums.length-1;j>firstIdx;j--){
            if(nums[j]>nums[firstIdx]){
                int temp= nums[j];
                nums[j]=nums[firstIdx];
                nums[firstIdx]=temp;
                break;
            }
        }
        int start= i;
        int end= nums.length-1;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    /***************************************************************************************************************
    字典顺序排序 就是sort的排序 所以会把一个数组分成2部分 第一部分（可能无序）和第二部分（降序）
     在当前数组所有排列组合从小到大排序后 找到当前排序的下一个
    分2种情况：
    1. 有下一个更大的组合     所以应该是尽可能缩小更改范围 即从后往前更改
    2. 没有下一个更大的组合    应该返回最小的 所以应该先判断当前是否是最大
    例：145632 下一个数字是146235
     算法解析： 此时应该把顶点及其右边 最小的大于i的数字和i进行更换 并且reversei右边的所有数字以保证最小
        更换后是 146532  i指向145632的5 j指向6 此时j从右往左遍历到顶点直到遇到第一个大于nums[i]的数值 并和i进行交换
        交换后顶点及其右边需要全部reverse 从最大数值变为最小
     */
    //自己的解法 6%
    public void MyNextPermutation(int[] nums) {
        if(nums.length==1) return;
        int i = nums.length-2 , j = nums.length-1,k = -1;
        while(i>=0){
            //寻找从后往前单调递增
            if(nums[i]>=nums[j]){
                i--; j--;
                continue;
            }else{
                //发现递减 i指向了递减后的第一个数
                k = nums.length-1;
                while(k>=j){
                    if(nums[k]<=nums[i]){
                        k--;
                    }else{
                        System.out.println("swap");
                        int temp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = temp;
                        reverse(nums,j,nums.length-1);
                        System.out.println("in  break");
                        break;
                    }
                }
                System.out.println("out break");
                break;
            }
        }
        //如果已经是最大值 需要把数组reverse得到最小值排列
        if(k == -1) reverse(nums,0,nums.length-1);
    }
    public void reverse(int[] nums,int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }

    public static void main(String[] args) {
        N31NextPermutation permutation = new N31NextPermutation();
        int[] nums = new int[]{5,1,1};
        permutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
