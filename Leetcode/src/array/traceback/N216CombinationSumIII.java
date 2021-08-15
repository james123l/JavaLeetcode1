package array.traceback;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
* */
public class N216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        combinationSum3(res,new ArrayList<Integer>(), k,n,1);
        return res;
    }
    /*
    * n 剩余需要增加的数字
    * k 剩余层数
    */
    private void combinationSum3( List<List<Integer>> res, List<Integer> curr,int k, int n, int start){
        //仅剩下一层的时候 如果 n>start 说明可以添加 否则不可以
        if(k==1){
            if(n>=start&& n <10){
                curr.add(n);
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
            return;
        }
        for (int i = start; i <Math.max(n+1,10) ; i++) {
            curr.add(i);
            combinationSum3(res,curr,k-1,n-i,i+1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        N216CombinationSumIII iii = new N216CombinationSumIII();
        System.out.println(iii.combinationSum3(2, 18));
    }

}
