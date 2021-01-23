import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class Main {
    public static List<Character> func(String str1,String str2) {
        List <Character> arr=new ArrayList<>();
    for(int i=0;i<str1.length();++i){
        String str=str1.substring(i,i+1);
        if(str2.contains(str)){
         arr.add(str.charAt(0));
        }
    }
    return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        System.out.println(arr);
        Object o=new Integer(2);
        arr.remove(o);
        System.out.println(arr);
    }
}
class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows <= 0) return ret;
        //第一行的list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //把第一行的list放到ret当中
        ret.add(list);
        for(int i = 1;i < numRows;i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for(int j = 1 ;j < i;j++) {
                //确定的是当前行的每个元素  ==  上一行的当前列+上一行的前一列就是我当前需要添加的数字
                curRow.add(ret.get(i-1).get(j)+ret.get(i-1).get(j-1));
            }
            //手动在当前行的最后一个位置 添加一个1
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}
//栈的弹出压入序列(仅上传代码即可)。
class Solution2 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i=0,j=0;
        Stack <Integer> stack=new Stack<>();
        while(i<pushA.length){
            stack.push(pushA[i]);
            while(j<popA.length&&popA[j]==stack.peek()){
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.empty();
    }
}
//棒球比赛(仅上传代码即可)。
class Solution3 {
    public int calPoints(String[] ops) {
        if(ops.length==0){
            return -1;
        }
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<ops.length;++i){
            int x=0;
            if(ops[i].equals("D")){
                x=2*stack.peek();
            }else if(ops[i].equals("+")){
                int y=stack.pop();
                int m=stack.peek();
                stack.push(y);
                x=y+m;
            }else if(ops[i].equals("C")){
                stack.pop();
                continue;
            }else{
                x=Integer.valueOf(ops[i]);
            }
            stack.push(x);
        }
        int sum=0;
        while(stack.empty()!=true){
            sum+=stack.pop();
        }
        return sum;
    }
}
//比较含退格的字符串(仅上传代码即可)。
class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S==null&&T!=null||T==null&&S!=null){
            return false;
        }
        if(S==null&&T==null){
            return true;
        }
        Stack<Character> stack1=new Stack<>();
        for(int i=0;i<S.length();++i){
            if(S.charAt(i)=='#'&&stack1.empty()!=true){
                stack1.pop();
            }else{
                if(S.charAt(i)!='#'){
                    stack1.push(S.charAt(i));
                }
            }
        }
        Stack<Character> stack2=new Stack<>();
        for(int i=0;i<T.length();++i){
            if(T.charAt(i)=='#'&&stack2.empty()!=true){
                stack2.pop();
            }else{
                if(T.charAt(i)!='#'){
                    stack2.push(T.charAt(i));
                }
            }
        }
        while(stack1.empty()!=true&&stack2.empty()!=true){
            if(stack1.pop()!=stack2.pop()){
                return false;
            }
        }
        if(stack1.empty()&&stack2.empty()){
            return true;
        }else{
            return false;
        }
    }
}