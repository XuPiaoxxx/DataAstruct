package CodeFly;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  ���ʲ��--LeetCode:139-��������¼
 * 2023.10.10/11.14

 ��Ŀ:����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣�����ж��Ƿ���������ֵ��г��ֵĵ���ƴ�ӳ� s ��
 ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�

��ȫ��������!!!!!!
 ת��˼·:
 s�ַ������ɱ�����ÿ��String�ַ���������Ʒ�����ܲ��ܰ���˳�������

 TIPS:

 �ϸ��ն�̬�滮5��������:
 1ȷ��dp���鼰��Ӧ�±�ĺ���--dp[j]-�ַ���s��0~j�����ܷ�����ӵ���Ʒ(�ַ���)��ɣ���Ӧ��dpֵΪtrue��false

 2������״̬ת�Ʒ���--����С�ķ����Ӳ����  if(�ַ���j~i�����Ƿ������ֵ����ҵ�&&ǰһ����dp[j]�Ƿ�Ϊtrue����) dp[i]=true;

 3ȷ��dp����ĳ�ʼ����ֵ--dp[0]��0���Ȳ�������Ŀ�Ķ��壬����Ϊ��״̬ת�Ʒ��̵�ʵ����Ҫ����Ϊtrue������Ĭ��Ϊfalse����������г���������Ϊtrue

 4ȷ������˳��--������Ҫ��֤�ֵ��п������Ҳ�п��ܳ�����ǰ�棬��������������������
 �ȱ�����Ʒʱ�򣬻�����ֵ��п�ǰ����Ʒ�����ں��棬��Ϊ��Ӧ��dp[j]Ҳ����ǰһ��������ַ�����û��������û����ֵΪtrue�����Ե�ǰdp[i]Ҳ���ܱ���ֵΪtrue
 ����������

 5��ӡdp����(û������oj����Ҫ�ж�dp�����Ƿ����Ԥ��) --����ν
 */

public class L00100LeetCode139 {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){//��ֹ�������ѭ������
            for(int j=0;j<i&&!dp[i];j++){//!dp[i]�������ǣ�ֻҪ�ҵ�j~iλ���ϵ��ַ�����set�У�dp[i]Ϊtrue������ֱ�ӽ��б�����һ��λ��
                if(set.contains(s.substring(j,i))&&dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }
    //���нⷨ
    //1.ֱ��ʹ��List��contains��������ʡ��set�ռ�
    //2.������Ӧ0~iλ�ôӺ���ǰ��������Ϊ�����棬s�ĳ��Ȼ�Զ�����ֵ����ַ����ĳ��ȣ����ԴӺ���ǰ�����ܼ�֦�˷ѵ�����
    //3.һ���ҵ�trueֱ��break����ֹ�������Դ�˷ѡ�
    public boolean wordBreak1(String s, List<String> wordDict) {
        //ת��Ϊ�Ƿ������ wordDict �еĴ���ϳ� s����ȫ��������
        //��˳�����ȫ�������⣬�ȱ���target���ٱ�������
        //dp[i]��ʾ���ַ�����ǰi���ַ��Ƿ�����ɱ����еĵ������
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        //��ʼ��d
        dp[0] = true;
        // ���ȷ��dp[j] ��true���� [j, i] ���������Ӵ��������ֵ����ôdp[i]һ����true����j < i ����
        // ���Ե��ƹ�ʽ�� if([j, i] ���������Ӵ��������ֵ��� && dp[j]��true) ��ô dp[i] = true��

        //�����1��ʼ��������Ϊsubstring���ұ�
        for(int i = 1; i <= len; i++){
            //���ű��������ǵ����ʳ��ȿ���ԶС��target���ȣ����ű���Ч�ʸ���
            for(int j = i - 1; j >= 0; j--){
                //���dp[j]Ϊfalse���Ѿ������������ˣ�������һ���Ƚ�
                if(dp[j] == false) continue;
                if(wordDict.contains(s.substring(j, i)) && dp[j]){
                    //���Ϊtrue����ض�Ϊtrue��ֱ��break
                    dp[i] = true;
                    break;
                }

            }

        }
        return dp[len];
    }

}
