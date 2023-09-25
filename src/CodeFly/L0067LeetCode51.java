package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  N �ʺ�-LeetCode:51-��������¼
 * 2023.09.25/18.55

 ��Ŀ:���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�

 n �ʺ����� �о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������

 ����һ������ n ���������в�ͬ�� n �ʺ����� �Ľ��������

 ÿһ�ֽⷨ����һ����ͬ�� n �ʺ����� �����ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 TIPS:
 �Լ�˼·������˵��ǣ�
 char������������Ĵ����ᣬ�ж��Ƿ�Ϸ����߼�û�п������ƣ��ǳ����ࡣ
 new String(char��������)--ֱ�ӻ����ַ�������!!��ס
 ToSring�����Ƿ����ӡ�ۿ��ģ���[]������
 ����:1.���ݵĽ����봦��ǳ�������  2.�����Ϸ����ǲ��ܵ�

 ��ά�������̻��ݣ�
 forѭ�������У��ݹ���ݿ����С�
*/

public class L0067LeetCode51 {
    public static void main(String[] args) {

    }
    //���Ŵ��޸�һ�£����Լ�д��һ�·����Լ��뷨�Ĵ��롣
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
        //����ֻ���жϵ�ǰ���ϲ��ֵ����̣���Ϊ����û���е�����
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
