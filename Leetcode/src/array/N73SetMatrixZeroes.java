package array;

import javax.swing.*;
import java.util.Arrays;

//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
//You must do it in place.
public class N73SetMatrixZeroes {
    /*
    * 解题思路： 使用第一行作为标志位 标志位是否含有0需要提前判断出来
    * */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;      //行数
        int n = matrix[0].length;   //列数
        int k = 0,l = 0;
        //判断第一行是否有0
        while(k<n && matrix[0][k]!=0) k++;
        while(l<m && matrix[l][0]!=0) l++;
        //从第二行开始逐个遍历进行标记
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[j][i]==0){
                    matrix[j][0] = 0;
                    matrix[0][i] = 0;
                }
            }
        }
//        for (int[] arr: matrix) {
//            System.out.println(Arrays.toString(arr));
//        }
        //行置零
        for(int i = 1; i < m ; i++){
            if(matrix[i][0] == 0){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //列置零
        for(int i = 1; i < n ; i++){
            if(matrix[0][i] == 0){
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if(k<n){
            //说明标志位即第一行有0 需要置0
            for (int i = 0 ; i < n ; i ++){
                matrix[0][i] = 0;
            }
        }
        if(l<m){
            //说明标志位即第一列有0 需要置0
            for (int i = 0 ; i < m ; i ++){
                matrix[i][0] = 0;
            }
        }
    }
}
