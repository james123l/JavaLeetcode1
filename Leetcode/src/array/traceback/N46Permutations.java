package array.traceback;

import java.util.ArrayList;
import java.util.List;

//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class N46Permutations {
    //更高效算法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums != null && nums.length > 0) permute(nums,0,result);
        return result;
    }
    /*
    * 解题思路：通过各个位上的数组不断调换来实现
    * 回溯过程：    * dfs 会首先获得原数组 即depth不断增加 深度
    * 通过回溯和交换(可以不用多次验证和插入) 更改每个index所对应的数值
    * */
    private void permute(int[] nums, int depth, List<List<Integer>> result){
        if(depth == nums.length){
            List<Integer> ll = new ArrayList<>();
            for(int i: nums) ll.add(i);
            result.add(ll);
            return;
        }
        for(int i=depth; i < nums.length; i++){
            swap(nums,i,depth);
            permute(nums,depth+1,result);
            swap(nums,i,depth);
        }

    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //解题思路 回溯算法 DFS 改进方法是使用boolean数组做一个marker记录是否访问过这个数字
    public List<List<Integer>> permuteDFS(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res,new ArrayList<>(),nums,0);
        return res;
    }
    /**
     *
     * @param res 结果
     * @param curr  当前排列
     * @param nums
     * @param depth 当前所处的nums的索引
     */
    private void recursion( List<List<Integer>> res,ArrayList<Integer> curr,int[] nums,int depth){
        if(depth == nums.length){//已经添加过最后一位的时候 可以直接插入到curr中. 因为此处是一个引用类型 所以需要重新new一个list 否则curr会不断地插入删除导致res内都是空链表
            res.add(new ArrayList<>(curr));
        }else{      //此时尚未到达最后一位 需要循环遍历数组不断插入
            for (int i : nums) {
                if(curr.contains(i)) continue; //如果已经加入过 则直接跳过这个数字
                curr.add(i);
                recursion(res,curr,nums,depth+1);
                curr.remove(depth);//回溯
            }
        }
    }
}
