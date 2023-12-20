package CodeFly;

import java.util.*;


public class AL000LeetCode {

    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
        });
        t1.start();
//        t1.join();//不等待线程执行结束，输出的10
        System.out.println(r);
    }
}

