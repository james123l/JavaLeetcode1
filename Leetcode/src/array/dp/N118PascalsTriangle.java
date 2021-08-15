package array.dp;

import java.util.ArrayList;
import java.util.List;

public class N118PascalsTriangle {

    /*
     Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]*/

    /**
     * 自己的结题过程 ：递归或循环，递归效率太低，最好使用单次循环。 每一行的数据会被下一行利用，所以考虑动规
     * 第n行有n个数字
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        //杨辉三角的第一行第一列永远是1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        //应该从第二行算起
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> pre = triangle.get(i-1);
            curr.add(1);
            // 为什么j<i ：假设是第三行 此事应该通过循环计算一次 i = 2， j = 1  只会计算一次。
            for (int j = 1; j < i; j++) {
                int val =  pre.get(j-1)+pre.get(j);
                curr.add(val);
            }
            curr.add(1);
            triangle.add(curr) ;
        }
        return triangle;
    }

    public static void main(String[] args) {
        N118PascalsTriangle n1188321PascalsTriangle = new N118PascalsTriangle();
    }
}
