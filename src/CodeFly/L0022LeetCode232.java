package CodeFly;

import java.util.Stack;

/**
 * ��ջ��ʵ�ֶ���-LeetCode:232-��������¼
 * 2023.08.29/18.04

 ��Ŀ:�����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ�����֧�ֵ����в���
 ��push��pop��peek��empty����
*����:
 *
 * tips:
 * ��ջʵ�ֶ��еĹؼ��Ҿ�����˼ά��ת�䣬��ջ�ͳ�ջҪ�����������в���
 * push��ʱ��û���������ƣ�����ֱ�ӷŽ�StackIn����
 * pop��ʱ�򣬵�����StackOut��ջ���в����������Ϊ�գ������ջ���Ԫ�ػ�
 * ����StackOut�У����Ϊ���൱���ϴ�pop��������StackOut��Ԫ���Ѿ�ȫ����ջ��
 * ��ҪStackIn���Ԫ��ת�ƽ��в��䡣
 * �����Outջ��Ϊ�յ�����½�In���Ԫ�ص���Out��������������ж��һ�û������Ԫ��
 * ���ŵ��������еĺ�ߣ�����˳����󲻷������⡣

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
