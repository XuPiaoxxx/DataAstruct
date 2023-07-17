public class day2 {

    //arr[L,R]范围上求最大值【递归加分治，查找最大值二分，L=R是终止条件】
    public static int process1(int[] arr,int L,int R){
        if(L==R){
            return arr[L];
        }
        int mid=L+((R-L)>>1);
        int maxLeft=process1(arr,L,mid);
        int maxRight=process1(arr,mid+1,R);
        return Math.max(maxLeft,maxRight);
    }

    //归并排序--->先左右各部分排序，再归并MergeSort
    public static void process2(int[] arr,int L,int R){
        if(L==R){
            return;
        }
        int mid=L+((R-L)>>1);
        process2(arr,L,mid);
        process2(arr,mid+1,R);
        merge1(arr,L,mid,R);
    }
    public static void merge1(int[] arr,int L,int M,int R){
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        while(p1<=M&&p2<=R){
            help[i++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=M){
            help[i++]=arr[p1++];
        }
        while(p2<=R){
            help[i++]=arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
    }
    //小和问题（改写归并排序）
    public static int process3(int[] arr,int l,int r){
        if(l==r){
            return 0;
        }
        int mid=l+((l-r)>>1);
        return process3(arr,1,mid)+process3(arr,mid+1,r)+merge2(arr,l,mid,r);
    }
    public static int merge2(int[] arr,int L,int M,int R){
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        int res=0;
        while(p1<=M&&p2<=R){
            res+=arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0;
            help[i++] = arr[p1] < arr[p2]?arr[p1++]:arr[p2++];//相等先拷贝右组
        }
        while(p1<=M){
            help[i++]=arr[p1++];
        }
        while(p2<=R){
            help[i++]=arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
        return res;
    }
    //快速排序
    //arr[L,R]排好序
    public static void quickSort(int[] arr,int L,int R){
        if(L<R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int[]p=partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }
    //这是一个处理arr[L,R]的函数，默认以arr[r]做划分，arr[r]->p  <p  ==p  >p
    //返回等于区域(左边界，右边界)，所以返回一个长度为2的数组res，res[0],res[1]
    public static int[] partition(int[] arr,int L,int R){
        int less=L-1;//<区的边界，向右动
        int more=R;//>区的边界，向左动
        while(L<more){//L表示当前数的位置，arr[R]->划分值
            if(arr[L]<arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        return new int[] {less+1,more};
    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[j]^arr[i];
        arr[i]=arr[i]^arr[j];
    }



    public static void main(String[] args) {

    }
}
