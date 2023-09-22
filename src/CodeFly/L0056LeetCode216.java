package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  ����ܺ� III-LeetCode:216-��������¼
 * 2023.09.22/21.14

 ��Ŀ:�ҳ��������֮��Ϊ n �� k ��������ϣ�����������������

 ֻʹ������1��9
 ÿ������ ���ʹ��һ��
 ���� ���п��ܵ���Ч��ϵ��б� �����б��ܰ�����ͬ��������Σ���Ͽ������κ�˳�򷵻ء�
 TIPS:
 ���ݱ�����������⣬���νṹ����һ��LinkedList�������β���ĵ�����������
 ���⻹���total�ܺͽ��л��ݵ���
 ����֦���������������������Ŀ��֦Ҷ


*/

public class L0056LeetCode216 {
    static List<List<Integer>> res=new ArrayList();
    static LinkedList<Integer> row=new LinkedList();
    static int total=0;
    public static void main(String[] args) {
        backTrack(3,7,1);
    }
    //δ���м�֦����
//    public static void backTrack(int k,int n,int start){
//        if(row.size()==k&&total==n){
//            res.add(new ArrayList(row));
//            return;
//        }
//        for(int i=start;i<=9;i++){
//            row.add(i);
//            total+=i;
//            backTrack(k,n,i+1);
//            total-=i;
//            row.removeLast();
//        }
//    }
    //1.����Ƚ��м�֦�����sum>n,��ֱ�ӷ��أ�������ô�Ӷ�����n
    //2.�Կ�Ƚ��м�֦�������������ĸ���������k����ֱ�ӷ��ؼ�֦��
    public static void backTrack(int k,int n,int start){
        if(row.size()==k&&total==n){
            res.add(new ArrayList(row));
            return;
        }
        //��ȼ�֦���������ķ�֧
        for(int i=start;i<=9-(k-row.size())+1;i++){
            row.add(i);
            total+=i;
            //��ȼ�֦���������ĵݹ�
            if(total>n){
                total-=i;
                row.removeLast();
                return;
            }
            backTrack(k,n,i+1);
            total-=i;
            row.removeLast();
        }
    }

}
