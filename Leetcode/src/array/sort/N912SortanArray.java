package array.sort;

import java.util.Arrays;

//Given an array of integers nums, sort the array in ascending order.
// 快速排序 堆排序 merge排序 redix排序需要重点掌握
public class N912SortanArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0, nums.length-1);
        return nums;
    }
    private void quickSort(int[] nums , int start , int end){
        //当区间重叠的时候 不再进行
        if(start>= end){
            return;
        }

        int pivotVal = nums[(start + end) / 2], i = start, j = end;
        while(i<j){
            //把中轴左边所有的大于中轴元素和中轴右边所有小于中轴的元素调换位置
            //找到中轴左边的大于中轴元素
            while(nums[i]<pivotVal){
                i++;
            }
            //找到中轴右边的小于中轴元素
            while(nums[j]>pivotVal){
                j--;
            }
            if(i>=j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            if(nums[i] == pivotVal) j--;
            if(nums[j] == pivotVal) i ++;
        }
        if(i == j){
            i++;
            j--;
        }
        if(start<i) quickSort(nums,start,j);
        if(j<end) quickSort(nums,i,end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4,0,7,4,9,-5,-1,0,-7,-1};
        N912SortanArray array = new N912SortanArray();
        System.out.println(Arrays.toString(array.sortArray(arr)));
    }
}
