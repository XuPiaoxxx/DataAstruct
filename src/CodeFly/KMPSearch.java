package CodeFly;

public class KMPSearch {
    public static void main(String[] args) {
        int[] next=new int[4];
        getNext(next,"abab");
        int res= KmpSearch("abcdanmabcdabd","abcdabd",next);
        System.out.println(res);
    }

    //KMP�Լ�����(�ؼ���Ҫ�㶮-1�ĺ��壬��-1ʱ�Ĳ��������ǣ�ģʽ����0��Ŀ�괮ָ����һ���ַ�
    // ,ѧϰ���˱��˵ļ򵥴���д������Ϊ-1��Ϊ��-1-���Ļ��ڸ���������j++�Ĺ��̣�
    // ����д��һ��)
    public static int KmpSearch(String s,String pattern,int[] next){
        int j=0;
        int sLen=s.length();
        int pLen= pattern.length();
        for(int i=0;i<sLen;){
//            if(j==-1){
//                j=0;
//                i++;
//            }else if(s.charAt(i)==pattern.charAt(j)){
//                //�����һ���ַ��Ͳ�һ��������i�����ƶ���j����0
//                i++;
//                j++;
//            }else{
//                j=next[j];
//            }
            //next[0]Ϊ-1�����˽��������д��һ��
            if(j==-1||s.charAt(i)==s.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
            if(j==pLen) return i-j;
        }
        return -1;
    }

    //�������Լ����뷨��getNext(�Ż�ʧ�ܣ������-1��ѭ��ǰ���õ�)
    public static void getNext(int next[],String s){
        //��ʼ��
        int k=0;
        next[0]=0;
        for(int i=1;i<s.length();i++){
            //�����
            while(k>0&&s.charAt(k)!=s.charAt(i)){
                k=next[k-1];
            }
            if(s.charAt(k)==s.charAt(i)){
                k++;
            }
                next[i]=k;
        }
        for(int i=next.length-1;i>0;i--){
            next[i]=next[i-1];
        }
        next[0]=-1;
    }
    //�Ż���,��Ŀ�еı�׼��

    void GetNextval(String p, int next[])
    {
        int pLen = p.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]��ʾǰ׺��p[j]��ʾ��׺
            if (k == -1 || p.charAt(j) == p.charAt(k))
            {
                ++j;
                ++k;
                //��֮ǰnext�����󷨣��Ķ�������4��
                if (p.charAt(j) != p.charAt(k))
                    next[j] = k;   //֮ǰֻ����һ��
                else
                    //��Ϊ���ܳ���p[j] = p[ next[j ]]�����Ե�����ʱ��Ҫ�����ݹ飬k = next[k] = next[next[k]]
                    next[j] = next[k];
            }
            else
            {
                k = next[k];
            }
        }
    }
}
