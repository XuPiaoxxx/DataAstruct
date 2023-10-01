package CodeFly;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  根据身高重建队列-LeetCode:406-代码随想录
 * 2023.10.1/12.25

 题目:假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。 TIPS:
 TIPS:
 贪心，两个维度先分别排序，再想能不能在排序后的基础上解
 本题代码更多是java类的运用，需要认真磨炼
 LinkedList的add方法，插入指定位置
 自定义排序的细节

 */

public class L0079LeetCode406 {
    public static void main(String[] args) {
        int[][] temp=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(temp);
    }
    // TODO
    //
    // Comparator参数仅支持引用类型，而int并非引用类型。但是int[][]是引用类型
    // 把接受过来的int类型数组转换成Integer类型数组，就可以自定义排序了
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });

        LinkedList<int[]> que=new LinkedList();

        for(int[] i:people){
            que.add(i[1],i);
        }
        return que.toArray(new int[people.length][]);
    }
}
