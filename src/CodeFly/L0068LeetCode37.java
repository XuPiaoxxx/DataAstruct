package CodeFly;

import java.util.ArrayList;
import java.util.List;

/**
 *  ������-LeetCode:37-��������¼
 * 2023.09.26/12.10

 ��Ŀ:��дһ������ͨ�����ո�������������⡣

 �����Ľⷨ�� ��ѭ���¹���

 ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�����ο�ʾ��ͼ��
 �������ֿո��������������֣��հ׸��� '.' ��ʾ��
 TIPS:
 �������������Ĳ�ͬ��:
 ��һ����ά��εĻ��ݣ�һ�����ݺ������������ݹ�ֱ�����к��У�
 ���ݺ������Ƶ��ǵ�ǰ����λ��ȡ1-9��9�������
 ������һ������ѭ���Ļ��ݡ�
 1.ͨ����boolean���ͣ���ȷ���Ƿ��ܺϷ��������̡�
 2���Ϸ����жϺ������row/3.col/3��ȷ��С���̵ı�ţ��ٷֱ��3��ȷ��С����
 ��ʼ��λ��
 3.������������̣���ǰ����޳�ͻ���򲻶����Ϸ���true��������ʣ�µ������
 3.�����ǰλ��9������������(9�λ���)����û����ȷ�𰸣�����false���ϲ������
 ���ݴ�����һ��ֵ��ֱ���ص���һ��λ��9����������ɣ����巵��false��

 ͦ��~

*/

public class L0068LeetCode37 {
    public static void main(String[] args) {
    }
    //���Ŵ��޸�һ�£����Լ�д��һ�·����Լ��뷨�Ĵ��롣
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
