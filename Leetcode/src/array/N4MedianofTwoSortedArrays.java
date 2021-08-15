package array;


import java.util.Arrays;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).
public class N4MedianofTwoSortedArrays {
    /*
    * leetcode最快解决办法 分2情况
    *
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int count = 0, median = 0;
        int i=0, j=0;

        if ((m+n) % 2 == 0) {   //偶数个数的时候 只需要排序到总数和的一半和 前一个数 的和除以2
            int firstElement = 0;
            for (count = 1; count <= (m+n)/2 + 1; count++) {
                if (i < m && j < n) {
                    if (nums1[i] <= nums2[j])
                        median = nums1[i++];
                    else
                        median = nums2[j++];
                } else if (i == m) {
                    median = nums2[j++];
                } else if (j == n) {
                    median = nums1[i++];
                }
                if (count == (m+n)/2) {
                    firstElement = median;
                }
            }
            return (double)(firstElement + median) / 2;
        } else { //奇数个直接找到中间位
            for (count = 1; count <= (m+n)/2 + 1; count++) {
                if (i < m && j < n) {
                    if (nums1[i] <= nums2[j])
                        median = nums1[i++];
                    else
                        median = nums2[j++];
                } else if (i == m) {
                    median = nums2[j++];
                } else if (j == n) {
                    median = nums1[i++];
                }
            }
        }
        return median;
    }

    /*
    缺点： 进行过多的多余计算
    * 算法 先合并再求中间值
    * */
    public double myFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        //将所有元素都加入到新的array中
        int ptr1=0,ptr2=0;
        for (int i = 0; i < arr.length; i++) {
            int var1 = ptr1>=nums1.length?Integer.MAX_VALUE: nums1[ptr1];
            int var2 = ptr2>=nums2.length?Integer.MAX_VALUE: nums2[ptr2];
            if(var1 > var2){
                arr[i] = var2;
                ptr2++;
            }else{
                arr[i] = var1;
                ptr1++;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
        double res = arr.length % 2 == 0 ? ((double) arr[arr.length / 2 - 1] +(double) arr[arr.length / 2]) / 2 : arr[arr.length / 2 ];
        return res;
    }

    public static void main(String[] args) {
        N4MedianofTwoSortedArrays arrays = new N4MedianofTwoSortedArrays();
        int[] arr1={1,2} , arr2 = {3,4};
        System.out.println(arrays.findMedianSortedArrays(arr1, arr2));
    }
}
