package CodeFly;

import java.util.ArrayList;
import java.util.List;

/**
 *  解数独-LeetCode:37-代码随想录
 * 2023.09.26/12.10

 题目:编写一个程序，通过填充空格来解决数独问题。

 数独的解法需 遵循如下规则：

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 数独部分空格内已填入了数字，空白格用 '.' 表示。
 TIPS:
 解数独问题最大的不同是:
 是一个二维层次的回溯，一个回溯函数里包括两层递归分别遍历行和列，
 回溯函数控制的是当前行列位置取1-9这9种情况。
 所以是一个三个循环的回溯。
 1.通过传boolean类型，来确定是否能合法填满棋盘。
 2、合法的判断函数里，用row/3.col/3来确定小棋盘的编号，再分别乘3，确定小棋盘
 起始的位置
 3.如果遍历完棋盘，当前情况无冲突，则不断向上返回true，不处理剩下的情况。
 3.如果当前位置9个数都遍历完(9次回溯)，则没有正确答案，返回false，上层继续。
 回溯传入下一个值，直到回到第一个位置9个数遍历完成，总体返回false；

 挺难~

*/

public class L0068LeetCode37 {
    public static void main(String[] args) {
    }
    //照着答案修改一下，又自己写了一下符合自己想法的代码。
    public static void solveSudoku(char[][] board) {
        backTrack(board);
    }
    static boolean backTrack(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') continue;
                for(char q='1';q<='9';q++){
                    if(isValid(board,i,j,q)){
                        board[i][j]=q;
                        if(backTrack(board)) return true;
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    static boolean isValid(char[][] board,int row,int col,char num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num)return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num)return false;
        }
        int Row=(row/3)*3;
        int Col=(col/3)*3;
        for(int i=Row;i<Row+3;i++){
            for(int j=Col;j<Col+3;j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }

}
