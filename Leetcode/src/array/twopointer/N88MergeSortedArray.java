package array.twopointer;


/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
           the number of elements in nums1 and nums2 respectively.Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
           and the last n elements are set to 0 and should be ignored. nums2 has a length of n.*/
public class N88MergeSortedArray {
    /*
    * 因为num1 长度是m+n 后面都是空的 所以想到双指针
    * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m-1,ptr2 = n-1, ptr = m+n-1; //分别定义指向num1 num2 还有整个num1数组的三个指针 都指向数组尾
        //当且仅当两个指针都没有越过数组头的时候 即还有元素没有执行插入
        while(ptr>=0){
            //如果一个数组执行插入完毕 就设定为最小值 这样可以让下一个数组执行插入操作
            int val1 = ptr1>=0? nums1[ptr1]:Integer.MIN_VALUE;
            int val2 = ptr2>=0? nums2[ptr2]:Integer.MIN_VALUE;
            if(val1 > val2){
                nums1[ptr--] = val1;
                ptr1--;
            }else{
                nums1[ptr--] = val2;
                ptr2--;
            }
        }
    }
}
