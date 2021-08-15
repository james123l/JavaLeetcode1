package array.simulation;

import java.util.ArrayList;
import java.util.List;

public class N54SpiralMatrix {
    //Given an m x n matrix, return all elements of the matrix in spiral order.

    //方式一 simulation 仿真 即利用一个数组 标记这个点是否去过
    //二维数组掌握的不好
    public List<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        //仿真数组 ！！！二维数组第一个参数是多少个一维数组 第二个是一个一维数组有多少元素 所以column是一维数组长度 Row是二维数组长度
        int C = matrix[0].length, R = matrix.length, r = 0, c = 0, nextr = 0, nextc = 0,dir = 0;
        boolean[][] map = new boolean[R][C];    //默认值是false
        //制定移动策略 移动策略是顺时针
        int[] dirC = {1,0,-1,0};    //行移动策略 比如一开始横向移动 一维数组就会自增1
        int[] dirR = {0,1,0,-1};    //列移动策略 比如纵向移动 二维数组就会自增1
        for (int i = 0; i < R*C; i++) { //遍历所有元素
            res.add(matrix[r][c]);
            map[r][c] = true;
            //寻找下一个访问坐标
            nextr = r + dirR[dir];
            nextc = c + dirC[dir];
            //不越界且下一个地方没去过 才可以访问
            if(nextc>=0&&nextc<C && nextr>=0&&nextr<R && !map[nextr][nextc]){
                r = nextr;  //更新下一次访问地址
                c = nextc;
            }else{
                dir = (dir+1)%4;    //因为已经访问过 所以更新方向
                r = r + dirR[dir];
                c = c + dirC[dir];
            }
        }
        return res;
    }

    //方式二 逐层递进 设定界限
    public List<Integer> spiralOrder2(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        //设定初始界限
        int rmin = 0, cmin = 0, rmax = matrix.length-1, cmax = matrix[0].length-1;
        //仅当rmin<=rmax 且cmin<=cmax的时候还有元素未添加 才进行添加
        while(rmin<=rmax && cmin<=cmax){
            for (int i = cmin; i <= cmax; i++) { res.add(matrix[rmin][i]); } //先添加这一层的上面的边
            for (int i = rmin+1; i <= rmax ; i++) { res.add(matrix[i][cmax]); } //先添加这一层的左边的边 因为第一个元素已经添加 所以跳过
            //仅当 rmin<rmax cmin<cmax时 需要添加下面和右面的边 因为不满足条件时没有这两条边
            if(rmin<rmax && cmin<cmax){
                for (int i = cmax-1; i > cmin; i--) { res.add(matrix[rmax][i]); }
                for (int i = rmax; i > rmin ; i--) { res.add(matrix[i][cmin]); }
            }
            //缩小范围
            rmin++;rmax--;cmax--;cmin++;
        }
        return res;
    }
}
