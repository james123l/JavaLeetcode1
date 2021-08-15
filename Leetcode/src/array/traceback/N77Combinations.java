package array.traceback;

import java.util.ArrayList;
import java.util.List;

/*
* Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.
* 通过回溯算法进行解决 因为此时是有序的数组 可以直接排除重复
* */
public class N77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n,k,res,new ArrayList<>(),1);
        return res;
    }

    private void backtrack(int n ,int k,List<List<Integer>> res,List<Integer> curr ,int start) {
        if(k == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(n,k-1,res,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
