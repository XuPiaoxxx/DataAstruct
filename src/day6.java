import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day6 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.val=value;
            left=null;
            right=null;
        }
    }

    //递归先序遍历
    public static void preOrderRecur(TreeNode head){
        if(head==null){
            return;
        }
        System.out.println(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //非递归先序遍历
    public static void preOrderUnRecur(TreeNode head){
        if(head==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(head);
        while(!stack.isEmpty()){
            head=stack.pop();
            System.out.println(head.val);
            if(head.right!=null){
                stack.push(head.right);
            }
            if(head.left!=null){
                stack.push(head.left);
            }
        }
    }
    //非递归后序遍历
    public static void posOrderUnRecur(TreeNode head){
        if(head==null){
            return;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(head);
        while(stack1!=null){
            head=stack1.pop();
            stack2.push(head);
            if(head.left!=null){
                stack1.push(head.left);
            }
            if(head.right!=null){
                stack1.push(head.right);
            }
            while(stack2!=null){
                System.out.print(stack2.pop()+" ");
            }
        }
    }
    //中序遍历非递归
    public static void inOrderUnRecur(TreeNode head){
        if(head==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head);
                head=head.left;
            }else {
                head=stack.pop();
                System.out.println(head);
                head=head.right;
            }
        }
    }
    //求二叉树的最大宽度
    public static int BinaryWidth(TreeNode head){
        if(head==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode,Integer> levelMap=new HashMap<>();
        levelMap.put(head,1);
        int curLevel=1;
        int curLevelNodes=0;
        int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            head=queue.poll();
            int curNodeLevel=levelMap.get(head);
            if(curNodeLevel==curLevel){
                curLevelNodes++;
            }else{
                max=Math.max(curLevelNodes,max);
                curLevelNodes=1;
            }
            if(head.left!=null){
                levelMap.put(head.left,curLevel+1);
                queue.add(head.left);
            }
            if(head.right!=null){
                levelMap.put(head.right,curLevel+1);
                queue.add(head.right);
            }
        }
        max=Math.max(max,curLevelNodes);
        return max;
    }

    public static void main(String[] args) {

    }
}
