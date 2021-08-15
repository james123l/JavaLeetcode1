package array;

public class N48RotateImage {
    /*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.*/

    /*
     * leetcode解法的解题思路：把这个矩阵分成4块 2种情况
     * 1 行数是奇数 例如5 这个时候需顺时针调换四个矩阵 即2行3列的从0行1行的123列第一个矩阵 和 45 列 345行的矩阵顺时针调换 依次类推
     * 2 行数是偶数 如同奇数一样 不过这个时候矩阵是正方形
     * */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {    //控制小矩阵的列
            for (int j = 0; j < n / 2; j++) {       //控制小矩阵的行 然后依次调换每个位置的数值
                //四个角落分别是 顺时针 l是最大下标
                // [0][0]     [i][j]
                // [0][l]     [0+j][l-i]
                // [l][l]     [l-i][l-j]
                // [l][0]     [l-j][0+i]
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

}
