package array.simulation;


import java.util.Arrays;
import java.util.function.Consumer;

//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
public class N59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        //限界 每次进行一周循环 n都会减2 直到n=0的时候结束
        //
        //
        int val = 1;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            //横行
            for (int j = i; j < n-i ; j++) {
                res[i][j]=val++;
            }
            //竖行 第一个元素已经设置过了
            for (int j = i+1; j < n-i ; j++) {
                res[j][n-i-1]=val++;
            }
            //横行 最后一个元素已经设置过了
            for (int j = n-i-2 ; j >=i ; j--) {
                res[n-i-1][j]=val++;
            }
            //竖行 第一个元素和最后一个已经设置过了
            for (int j =n-i-2 ; j >=i+1 ; j--) {
                res[j][i]=val++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(new N59SpiralMatrixII().generateMatrix(5)).forEach(new Consumer<int[]>() {
            @Override
            public void accept(int[] ints) {
                Arrays.stream(ints).forEach(System.out::print);
                System.out.println();
            }
        });
    }
}
