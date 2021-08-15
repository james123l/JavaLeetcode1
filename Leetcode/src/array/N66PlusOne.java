package array;

public class N66PlusOne {
/*    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.*/
    /**
    * 这道题可以反向遍历数组 唯一需要注意的是进位问题
     * leetcode解法 ：
    * */
    public int[] plusOne(int[] digits) {
        // Case 1 - [4,3,5] --> [4,3,6]
        // Case 2 - [4,3,9] --> [4,4,0]
        // Case 3 - [9,9,9] --> [1,0,0,0]
        int n = digits.length - 1;
        for(int i=n ; i>=0 ; i--){
            //如果当前数字是0-8 不涉及进位
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            // 如果是9 直接设置为0
            digits[i] = 0;
        }

        int allNines[] = new int[n+2];
        // 在全是9的情况下需要进位 并且位数增长1 需要扩展新的数组长度+1 且数组仅有下标是0的位是1 其他都是0
        allNines[0] = 1;
        return allNines;
    }
}
