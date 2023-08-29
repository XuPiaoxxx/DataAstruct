package CodeFly;

import java.util.Stack;

/**
 * 用栈来实现队列-LeetCode:232-代码随想录
 * 2023.08.29/18.04

 题目:请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作
 （push、pop、peek、empty）：
*样例:
 *
 * tips:
 * 用栈实现队列的关键我觉得是思维的转变，入栈和出栈要单独来看进行操作
 * push的时候没有条件限制，可以直接放进StackIn里面
 * pop的时候，单独对StackOut出栈进行操作，如果不为空，则代表栈里的元素还
 * 存在StackOut中，如果为空相当于上次pop操作塞进StackOut的元素已经全部出栈，
 * 需要StackIn里的元素转移进行补充。
 * 如果在Out栈不为空的情况下将In里的元素导入Out，则会出现先入队列而且还没弹出的元素
 * 被放到后进入队列的后边，导致顺序错误不符合题意。

 *
*/

public class L0022LeetCode232 {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public L0022LeetCode232() {
        stackIn=new Stack();
        stackOut=new Stack();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        inToOut();
        return stackOut.pop();
    }

    public int peek() {
        inToOut();
        return stackOut.peek();
    }
    public void inToOut(){
        if(!stackOut.isEmpty()){
            return;
        }else{
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }

    public boolean empty() {
        return stackIn.isEmpty()&&stackOut.isEmpty();
    }
    public static void main(String[] args) {

    }

}
