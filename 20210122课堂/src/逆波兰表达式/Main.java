package 逆波兰表达式;
import  java.util.Stack;
public class Main {
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<tokens.length;++i){
            if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
                int x=Integer.valueOf(tokens[i]);
                stack.push(x);
            }else{
                int a=stack.pop();
                int b=stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(b+a);
                }else if(tokens[i].equals("-")){
                    stack.push(b-a);
                }else if(tokens[i].equals("*")){
                    stack.push(b*a);
                }else{
                    stack.push(b/a);
                }
            }
        }
        return stack.pop();
    }
}