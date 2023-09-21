package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ���-LeetCode:77-��������¼
 * 2023.09.21/21.57

 ��Ŀ:������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ�
 ����԰� �κ�˳�� ���ش𰸡�
 TIPS:
 ���ݱ�����������⣬���νṹ����һ��LinkedList�������β���ĵ�����������
 ����֦���������������������Ŀ��֦Ҷ


*/

public class L0055LeetCode77 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list=new LinkedList();
        List<List<Integer>> res=new ArrayList();
        backTrack(n,k,1,list,res);
        return res;

    }
    public void backTrack(int n,int k,int startindex,LinkedList<Integer> list,List<List<Integer>> res){
        if(list.size()==k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=startindex;i<=n-(k-list.size())+1;i++){
            list.add(i);
            backTrack(n,k,i+1,list,res);
            list.removeLast();
        }

    }

}
