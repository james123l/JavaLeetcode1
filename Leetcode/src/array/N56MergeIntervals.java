package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
*  and return an array of the non-overlapping intervals that cover all the intervals in the input.
* */
public class N56MergeIntervals {
    //leetcode 0ms最快解法 这个算法没采用排序所以取出的数组需要不断和前面的数组对比
    public int[][] merge(int[][] intervals) {   //循环遍历 把所有interval加入到solution即原数组中
        int intervalCount = 1;  //最少有一个interval 所以基准数为1
        for(int i = 0; i < intervals.length;i++){   //遍历所有数组
            int[] interval = intervals[i];  //当前数组
            int solutionRemain = 0;    //因为没有排序 所以每次solution的个数都要重新计算
            for(int j = 0;j<intervalCount;j++){
                int[] candidate = intervals[j];
                if(candidate[1]<interval[0]){
                    //如果当前数组最小值比已经加入solution的某个interval最大值还要大 那么已经加入solution的这个interval就不需要动 并且更新已经存在的solution内部的interval的数量
                    solutionRemain++;
                }else if(interval[1]<candidate[0]){
                    //如果当前数组最大值比已经加入solution的某个interval最小值还要小 那么需要把这个当前interval数组存入这个位置并且把更大的interval取出 并且增加一个solution内部interval数值
                    intervals[solutionRemain++] = interval;
                    // intervals[solutionRemain++]的原因是 如果一直无交集 remain=j 如果有且替换过 remain<j 此时remain是计数器 如果放在j上会导致其在solution外
                    interval = candidate;
                }else{
                    //当两个数组有交集的时候 需要合并 此时solution内的总数并不会改变 而是把两个合并为一个
                    if(candidate[0]<interval[0])  interval[0] = candidate[0];   //更新interval的原因是interval会进入下一次内循环 candidate不能 interval是外部变量
                    if(candidate[1]>interval[1])  interval[1] = candidate[1];
                }
            }
            //因为在循环开始的时候重新计数 所以此时如果想加入一个数组作为solution solution的数量会++， 不自增的情况在上面已经写了
            intervals[solutionRemain++] = interval;
            //更新count方便下一次循环
            intervalCount = solutionRemain;
        }
        //拷贝到新的数组作为返回值
        int result[][] = new int[intervalCount][];
//        Arrays.stream(result).forEach((e,i)-> e=intervals[i]);
        for(int i = 0; i<result.length;i++){
            result[i] = intervals[i];
        }
        return result;
    }


    //***********************************************  我的算法  *****************************************************
    //采用57题的策略 导致效率低下 需要先sort一遍数组 让数组有序 才能从最小的开始 否则会有重复覆盖的区间被插入到solution
    //后面采取了优化策略
    public int[][] myMerge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->
            Integer.compare(a[0],b[0]));
        List<int[]> solution = new ArrayList<int[]>();
        int[] temp = intervals[0];
        //遍历所有数组 因为第一个数组已经储存在 curr 不需要遍历
        for(int i = 1; i < intervals.length;i++){
            int[] curr = intervals[i];
            //情况1 temp最大值小于当前数组的最小值 solution可以直接插入temp
            if(temp[1]<curr[0]){
                solution.add(temp);
                temp = curr;
            }
            //情况2 temp最小值大于当前数组最大值 solution可以直接插入当前数组curr
            else if(temp[0]>curr[1]){
                solution.add(curr);
            }
            //情况3 temp和当前数组的范围有交叠 此时应该取最小值为两个数组最小值的最小值 最大值为两个数组最大值的最大值
            else{
                temp[0] = Math.min(temp[0],curr[0]);
                temp[1] = Math.max(temp[1],curr[1]);
            }
        }
        solution.add(temp);
        return solution.toArray(new int[solution.size()][]);
    }
    //简化算法 因为已经排序过了 所以i数组的[0] 必然是从小到大排列 所以此处无需再次排列了 只要比较[1] 即可
    public int[][] myMergeSimpled(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> solution = new LinkedList<>();
        for (int[] curr : intervals) {
            //当上一个数组的最大值小于当前数组最小值 说明没有交集 可以直接加入
            if (solution.isEmpty() || solution.getLast()[1] < curr[0]) {
                solution.add(curr);
            } else {
                //当上一个数组的最大值大于当前数组最小值 说明有交集 需要把上一个数组的最大值 取为curr和上个数组[1]的最大值
                int temp = solution.getLast()[1];
                solution.getLast()[1] = Math.max(temp, curr[1]);
            }
        }
        return solution.toArray(new int[solution.size()][]);
    }
    //*************************************************************************************************************
}
