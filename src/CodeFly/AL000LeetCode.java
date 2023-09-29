package CodeFly;

/**
 * 最大二叉树-LeetCode:654-代码随想录
 * 2023.09.15/22.18

 题目:

 TIPS:
*/

public class AL000LeetCode {
    public static void main(String[] args) {
        canPlaceFlowers(new int[]{1,0,0,0,1},1);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res=0;
        if(flowerbed.length<3){
            for(int i:flowerbed){
                if(i==1) res++;
            }
            return res>0?false:true;
        }
        int pre=0,next=flowerbed[1];
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0&&pre==0&&next==0){
                res++;
                flowerbed[i]=1;
                pre=flowerbed[i];
                if(i==flowerbed.length-2){
                    next=0;
                }else{
                    next=flowerbed[i+2];
                }
            }else{
                pre=flowerbed[i];
                if(i==flowerbed.length-2){
                    next=0;
                }else{
                    next=flowerbed[i+2];
                }
            }
        }
        return res>=n?true:false;
    }
}
