package array;


import java.util.ArrayList;

/*
* Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
 */
public class N57InsertInterval {
    /*leetcode的解题思路 分析一切可能性  如果：
    遍历中当前的interval 最小值大于要插入interval最大值 此时应该向result链表直接把新的interval插入到数组中
    遍历中当前的interval 最大值小于要插入interval的最小值 此时应向result链表插入当前遍历到的interval
    遍历中当前的interval 如果两个interval存在了包含关系 那么此时最小值应该取两个interval index=0 的两个数最小值 最大值取index=1的两个值的最大值
    最后转换list为二维数组

    总结： 应该考虑一切情况 用列表列出！！！ 不能想的太复杂

    需要更迭的唯一情况 只需要更迭当前数组而不是全部数组
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> solution = new ArrayList<int[]>();
        for(int[] arr: intervals){
            //情况1：当newInterval的最大值小于当前arr最小值 可以直接插入newInterval
            if(newInterval[1]<arr[0]){
                solution.add(newInterval);
                // 保证所有数据都可以插入到solution
                newInterval = arr;
            }//情况2：当newInterval的最小值大于当前arr最大值 可以直接插入arr
            else if(newInterval[0]>arr[1]){
                solution.add(arr);
            }//情况3：当两个数组存在交集 最小值应该改为当前两个数组最小值里面的最小值 最大值改为两个数组最大值的最大值
            else{
                newInterval[0] = Math.min(newInterval[0],arr[0]);
                newInterval[1] = Math.max(newInterval[1],arr[1]);
            }
        }
        solution.add(newInterval);
        return solution.toArray(new int[solution.size()][]);
    }
}
