import java.util.Scanner;
import java.util.Stack;

/**
 * @author:飞哥
 * @date: 2021/6/3 18:09
 */
public class Main {
    public static void main(String[] args) {
        
    }
}
/**
 * 链接：https://www.nowcoder.com/questionTerminal/1a92fbc771a54feb9eb5bd9b3ff2d0a9
 * 来源：牛客网
 *
 * Emacs号称神的编辑器，它自带了一个计算器。与其他计算器不同，它是基于后缀表达式的，即运算符在操作数的后面。例如“2 3 +”等价于中缀表达式的“2 + 3”。
 * 请你实现一个后缀表达式的计算器。
 *
 * 输入描述:
 * 输入包含多组数据。
 *
 * 每组数据包括两行：第一行是一个正整数n (3≤n≤50)；紧接着第二行包含n个由数值和运算符组成的列表。
 *
 * “+-*\/”分别为加减乘除四则运算，其中除法为整除，即“5/3=1”。
 * **/
class Main2{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String m=sc.nextLine();
            int n=Integer.valueOf(m);
            String str=sc.nextLine();
            String[]math=str.split(" ");
            Stack<String>stack=new Stack<>();
            for(String x:math){
                if(x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/")){
                    int b=Integer.valueOf(stack.pop());
                    int a=Integer.valueOf(stack.pop());
                    if(x.equals("+")){
                        stack.push(a+b+"");
                    }else if(x.equals("-")){
                        stack.push(a-b+"");
                    }else if(x.equals("*")){
                        stack.push(a*b+"");
                    }else{
                        stack.push(a/b+"");
                    }
                }else{
                    stack.push(x);
                }
            }
            System.out.println(stack.pop());
        }
    }
}
/**
 * 链接：https://www.nowcoder.com/questionTerminal/a811535fed784ea492b63622c28c75c5
 * 来源：牛客网
 *
 * NowCoder最近爱上了五子棋，现在给你一个棋局，请你帮忙判断其中有没有五子连珠（超过五颗也算）。
 *
 * 输入描述:
 * 输入有多组数据，每组数据为一张20x20的棋盘。
 *
 * 其中黑子用“*”表示，白子用“+”表示，空白位置用“.”表示。
 *
 *
 * 输出描述:
 * 如果棋盘上存在五子连珠（无论哪种颜色的棋子），输入“Yes”，否则输出“No”。
 * 示例1
 * 输入
 * ....................
 * ....................
 * ....................
 * ....................
 * ......*.............
 * .......*............
 * ........*...........
 * ....++++.*..........
 * ..........*.........
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * .......*............
 * ......+*+++.........
 * .......*............
 * .......*............
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * ....................
 * 输出
 * Yes
 * No
 * **/
class Main3{
    public static int[][]index=new int[][]{{1,1},{1,0},{0,1}};
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String[]str=new String[20];
            for(int i=0;i<20;++i){
                str[i]=sc.next();
            }
            if(five(str)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean five(String[]str){
        for(int i=0;i<20;++i){
            for(int j=0;j<20;++j){
                char c=str[i].charAt(j);
                if(c=='*'||c=='+'){
                    for(int k=0;k<3;++k){
                        int x=i+index[k][0];
                        int y=j+index[k][1];
                        int count=1;
                        while(x<20&&y<20&&str[x].charAt(y)==c){
                            count++;
                            x+=index[k][0];
                            y+=index[k][1];
                            if(count==5){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}