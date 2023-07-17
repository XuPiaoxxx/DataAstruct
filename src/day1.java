public class day1 {

    //选择排序
    public static void selectionSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                minIndex=arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void BubbleSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int e=arr.length-1;e>0;e--){
            for(int i=0;i<e;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    }
                }
            }
    }
    //一数组，两个出现奇数次
    public static void OddTimesNum(int[] arr){
        int eor=0;
        for(int i=0;i<arr.length;i++){
            eor^=arr[i];
        }
        int rightOne=eor&(~eor+1);
        int onlyOne=0;
        for(int cur:arr){
            if((cur&rightOne)==0){
                onlyOne ^=cur;
            }
        }
        System.out.println(onlyOne);
        System.out.println((onlyOne^eor));
    }
    //插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j+1);
            }
        }
    }


    //交换arr数组中，i和j的位置
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

    public static void main(String[] args) {
        int[] arr={11,22,33,11,22,33,45,45,45,23};
        OddTimesNum(arr);

    }
}
