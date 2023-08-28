package CodeFly;

public class KMPSearch {
    public static void main(String[] args) {
        int[] next=new int[4];
        getNext(next,"abab");
        int res= KmpSearch("abcdanmabcdabd","abcdabd",next);
        System.out.println(res);
    }

    //KMP自己理解的(关键是要搞懂-1的含义，当-1时的操作步骤是，模式串归0，目标串指向下一个字符
    // ,学习到了别人的简单代码写法，因为-1是为了-1-》的环节更方便融入j++的过程，
    // 可以写在一起)
    public static int KmpSearch(String s,String pattern,int[] next){
        int j=0;
        int sLen=s.length();
        int pLen= pattern.length();
        for(int i=0;i<sLen;){
//            if(j==-1){
//                j=0;
//                i++;
//            }else if(s.charAt(i)==pattern.charAt(j)){
//                //代表第一个字符就不一样。所以i向下移动，j归于0
//                i++;
//                j++;
//            }else{
//                j=next[j];
//            }
            //next[0]为-1方便了将两种情况写在一起。
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

    //符合我自己的想法的getNext(优化失败，讲解的-1是循环前设置的)
    public static void getNext(int next[],String s){
        //初始化
        int k=0;
        next[0]=0;
        for(int i=1;i<s.length();i++){
            //不相等
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
    //优化后,心目中的标准答案

    void GetNextval(String p, int next[])
    {
        int pLen = p.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p.charAt(j) == p.charAt(k))
            {
                ++j;
                ++k;
                //较之前next数组求法，改动在下面4行
                if (p.charAt(j) != p.charAt(k))
                    next[j] = k;   //之前只有这一行
                else
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
            }
            else
            {
                k = next[k];
            }
        }
    }
}
