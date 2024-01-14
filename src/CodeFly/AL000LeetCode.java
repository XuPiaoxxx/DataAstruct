package CodeFly;

import java.util.*;


public class AL000LeetCode {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
        System.out.println(" ´ò¶Ï×´Ì¬: {}" + t1.isInterrupted());// ´ò¶Ï×´Ì¬: {}false
    }
}

