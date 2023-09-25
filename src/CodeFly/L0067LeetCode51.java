package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  N 皇后-LeetCode:51-代码随想录
 * 2023.09.25/18.55

 题目:按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

 n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 TIPS:
 自己思路想出来了但是，
 char【】【】数组的处理不会，判断是否合法的逻辑没有考虑完善，非常冗余。
 new String(char类型数组)--直接会变成字符串类型!!记住
 ToSring方法是方便打印观看的，有[]包裹。
 问题:1.数据的接受与处理非常不熟练  2.条件合法考虑不周到

 二维数组棋盘回溯，
 for循环控制列，递归回溯控制行。
*/

public class L0067LeetCode51 {
    public static void main(String[] args) {

    }
    //照着答案修改一下，又自己写了一下符合自己想法的代码。
    List<List<String>> res=new ArrayList();
    char[][] chess;
    public List<List<String>> solveNQueens(int n) {
        chess=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j]='.';
            }
        }
        backTrack(n,0);
        return res;
    }
    void backTrack(int n,int row){
        if(row==n){
            res.add(copy());
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(n,row,i)){
                chess[row][i]='Q';
                backTrack(n,row+1);
                chess[row][i]='.';
            }
        }
    }

    List<String> copy(){
        List<String> path=new ArrayList();
        for(int i=0;i<chess.length;i++){
            path.add(new String(chess[i]));
        }
        return path;
    }

    boolean isValid(int n,int row,int col){
        //这样只用判断当前行上部分的棋盘，因为回溯没进行到下面
        for(int i=0;i<row;i++){
            if(chess[i][col]=='Q') return false;
        }
        for(int x=row-1,y=col+1;x>=0&&y<chess.length;x--,y++){
            if(chess[x][y]=='Q') return false;
        }
        for(int x=row-1,y=col-1;x>=0&&y>=0;x--,y--){
            if(chess[x][y]=='Q') return false;
        }
        return true;
    }

}
