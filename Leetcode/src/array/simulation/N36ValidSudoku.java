package array.simulation;

import java.util.HashSet;

public class N36ValidSudoku {
    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:
        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.*/



    //leetcode solution
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        // Use an array to record the status
        //标记行状态 二维数组 9行对应 原矩阵的9行 9列标记数字1-9出现的次数
        int[][] rows = new int[N][N];
        //标记列状态 二维数组 9行对应 原矩阵的9列 9列标记数字1-9出现的次数
        int[][] cols = new int[N][N];
        //标记box状态 二维数组 9行对应 原矩阵的9个3*3的方格 9列标记数字1-9出现的次数
        int[][] boxes = new int[N][N];
        //循环遍历矩阵内所有的元素
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                // 通过ascii码 找出这个字符对应的在二维数组中第二个参数对应的索引
                int pos = board[r][c] - '1';

                // Check the row 判断当前元素的数字在当前行是否出现过 因为出现过就会标记为1
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column 判断当前元素的数字在当前列是否出现过 因为出现过就会标记为1
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box 判断box (r / 3) * 3 注意计算机中4/3=1 所以这里把一列里的三个小矩阵作为行放入了二维数组第一个参数的索引
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }
        }
        return true;
    }



    //failed
    public boolean myIsValidSudoku(char[][] board) {
        return rowValidate(board)&&columnValidate(board)&&blockValidate(board);
    }
    public boolean rowValidate(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }else{
                    if(set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            if(set.isEmpty()) return false;
        }
        return true;
    }
    public boolean columnValidate(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[j][i]=='.'){
                    continue;
                }else{
                    if(set.contains(board[j][i])){
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
            if(set.isEmpty()) return false;
        }
        return true;
    }    
    public boolean blockValidate(char[][] board) {
        for (int i = 0; i < 9; i=i+3) {
            for (int j = 0; j < 9; j=i+3){
                HashSet<Character> set = new HashSet<>();
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3 ; l++) {
                        if(board[k][l]=='.'){
                            continue;
                        } else{
                            if(set.contains(board[k][l])){
                                return false;
                            }
                            set.add(board[k][l]);
                        }
                    }
                }
            }
        }
        return true;
    }
    
}
