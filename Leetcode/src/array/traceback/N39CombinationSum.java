package array.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.*/
public class N39CombinationSum {
    //回溯算法 ： 这里因为可以重复使用数组内的元素 所以适合回溯算法不断遍历数组 暴力求解
    // lc 1ms算法 算法一样 编码习惯优化速度
    List<List<Integer>> result = new ArrayList<List<Integer>>();    //类的属性不需要传参
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0,0,new ArrayList<Integer>());
        return result;
    }

    public void helper(int[] candidates, int target,int startIndex,int sum,List<Integer> currList){
        if(sum==target){
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int j=startIndex;j<candidates.length;j++){
            if(sum+candidates[j]<=target){
                currList.add(candidates[j]);
                helper(candidates,target,j,(sum+candidates[j]),currList);
                currList.remove(currList.size()-1);
            }
        }
    }
    //*********************************  编码习惯： 产生了多余的变量 有更多的链表 链表使用不当 应该使用arraylist更加高效************
    public List<List<Integer>> combinationSumBackTracking(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);    //回溯算法需要排序吗
        backtrack(res, curr, 0, target, candidates, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curr, int sum, int target, int[] candidates, int index) {
        if (sum == target) {    //获取到结果并排除重复
            if (!res.contains(curr)) {
                res.add(new ArrayList(curr));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) { //如果sum超出target 说明没有可能进行下一步递归 可以直接return
                return;
            }
            curr.add(candidates[i]);
            sum = sum + candidates[i];
            backtrack(res, curr, sum, target, candidates, i);
            curr.remove(curr.size() - 1);
            sum = sum - candidates[i];
        }
    }
}
