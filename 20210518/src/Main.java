/**
 * @author:飞哥
 * @date: 2021/5/18 21:50
 */
import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String[]ss=s.split(" ");
            System.out.println(ss.length);
            String a=ss[0];
            String b=ss[1];
            String c=ss[2];
            if(myequals(sum(a,b),c)&&myequals(sum(a,c),b)&&myequals(sum(b,c),a)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean myequals(String ab,String c){
        if(ab.length()>c.length()){
            return true;
        }
        if(ab.length()<c.length()){
            return false;
        }
        if(ab.equals(c)){
            return false;
        }
        for(int i=0;i<ab.length();++i){
            if(ab.charAt(i)>c.charAt(i)){
                return true;
            }
            if(ab.charAt(i)<c.charAt(i)){
                return false;
            }
        }
        return false;
    }
    public static String sum(String x,String y){
        while(x.length()<y.length()){
            x="0"+x;
        }
        while(x.length()>y.length()){
            y="0"+y;
        }
        String end="";
        int c=0;
        for(int i=x.length()-1;i>=0;--i){
            int xx=x.charAt(i)-'0';
            int yy=y.charAt(i)-'0';
            if(xx+yy<10){
                end=(xx+yy+c)+end;
                c=0;
            }else{
                end=((xx+yy+c)%10)+end;
                c=1;
            }
        }
        if(c==1){
            end="1"+end;
        }
        return end;
    }
}
/*
* 不利用+-*和/四则运算计算两个数的和*/
 class Solution {
    public int Add(int num1,int num2) {
        int a=num1;
        num1=num1^num2;
        num2=a&num2;
        if(num2==0){
            return num1;
        }
        return Add(num1,num2<<1);
    }
}