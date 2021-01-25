import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();

    }
}
class MyStack {

    private Queue<Integer> qu1 = new LinkedList<>();

    private Queue<Integer> qu2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }
    /** Push element x onto stack. */
    public void push(int x) {
        //谁不为空入到哪个队列当中
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else{
            qu1.offer(x);//指定存放到了qu1
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        //每次出不为空的队列，出size-1个 到另外一个为空的队列，最后弹出剩余的那一个元素
        if(!qu1.isEmpty()) {
            int size =  qu1.size();
            for(int i = 0;i < size -1;i++) {
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }else {
            int size =  qu2.size();
            for(int i = 0;i < size -1;i++) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        //每次出不为空的队列，出size-1个 到另外一个为空的队列，最后弹出剩余的那一个元素
        if(!qu1.isEmpty()) {
            int size =  qu1.size();
            int cur = -1;
            for(int i = 0;i < size;i++) {
                cur = qu1.poll();
                qu2.offer(cur);
            }
            return cur;
        }else {
            int size =  qu2.size();
            int cur = -1;
            for(int i = 0;i < size;i++) {
                cur = qu2.poll();
                qu1.offer(cur);
            }
            return cur;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。
// 
//
//示例:
//
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
class MinStack {
    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(s1.empty()&&s2.empty()){
            s1.push(x);
            s2.push(x);
        }else{
            s1.push(x);
            if(s2.peek()>=x){
                s2.push(x);
            }
        }
    }

    public void pop() {
        if(s1.empty()&&s2.empty()){
            return;
        }else{
            int x=s1.pop();
            if(x==s2.peek()){
                s2.pop();
            }
        }
    }

    public int top() {
        if(s1.empty()){
            return -1;
        }
        return s1.peek();
    }

    public int getMin() {
        if(s2.empty()){
            return -1;
        }
        return s2.peek();
    }
}
