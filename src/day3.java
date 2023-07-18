import java.util.PriorityQueue;

public class day3 {


    //大根堆构建
    public static void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    //取出大根堆的最大值，并不改变大根堆的特性.heapify堆化
    public static void heapify(int[] arr,int index,int heapSize){
        int left=index*2+1;//左孩子的下标
        while(left<heapSize){//下方还有孩子，因为左孩子下标肯定小于右孩子下摆，所以判断左孩子即判断有没有孩子
            //两个孩子中，谁的值大就把下标给largest
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            //父和孩子之间，谁的值大，谁把下标给largest
            largest=arr[largest]>arr[index]?largest:index;
            if(largest==index){
                break;
            }
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }
    //堆排序的coding
    public static void heapSort(int[] arr){
        if(arr==null&&arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize=arr.length;
        swap(arr,0,--heapSize);
        while(heapSize>0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    //比较器
    //public static class IdAscendingComparator implements Comparable<>


    //桶排序（基数排序）
    public static void radixSort(int[] arr,int L,int R,int digit){
        final int radix=10;
        int i=0,j=0;
        //有多少数准备多少个辅助空间
        int[] bucket=new int[R-L+1];
        //有多少位就进出几次
        for(int d=1;d<=digit;d++){
            //10个空间
            //count[0]当前位(d位)是0的数字有多少个
            //count[1]当前位(d位)是(0和1)的数字有多少个
            //count[2]当前位(d位)是(0,1,2)的数字有多少个
            //count[i]当前位(d位)是(0~i)的数字有多少个
            int[] count=new int[radix];
            for(i=L;i<=R;i++){
               // j=getDigit(arr[i],d);
                count[j]++;
            }
            for(i=1;i<radix;i++){
                count[i]=count[i]+count[i-1];
            }
            for(i=R;i>=L;i--){
              //  j=getDigit(arr[i],d);
                bucket[count[j]-1]=arr[i];
                count[j]--;
            }
            for(i=L,j=0;i<=R;i++,j++){
                arr[i]=bucket[j];
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[j]^arr[i];
        arr[i]=arr[i]^arr[j];
    }

    public static void main(String[] args) {

        //优先队列，本质就是小根堆
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
        heap.add(8);
        heap.add(2);
        heap.add(6);
        heap.add(10);
        heap.add(9);
        heap.add(1);
        heap.add(0);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
