import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // KiKi();
        //FG();
        Age();
    }
    //题目描述
    //  问题：KiKi今年5岁了，已经能够认识100以内的非负整数，并且并且能够进行 100 以内的非负整数的加法计算。不过，BoBo老师发现KiKi在进行大于等于100的正整
    //  数的计算时，规则如下：
    //1.只保留该数的最后两位，例如：对KiKi来说1234等价于34；
    //2.如果计算结果大于等于 100， 那么KIKI也仅保留计算结果的最后两位，如果此两位中十位为0，则只保留个位。
    //例如：45+80 = 25
    //要求给定非负整数 a和 b，模拟KiKi的运算规则计算出 a+b 的值。
    //输入描述:
    //一行，输入两个非负整数a和b，用一个空格分隔。（0 <= a,b<= 231-1）。
    //输出描述:
    //针对每组输入，输出按照KiKi的运算规则计算出 a+b 的值。
    public static void KiKi(){
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        a%=100;
        b%=100;
        int sum=a+b;
       sum%=100;
       if(sum/10==0){
           sum%=10;
       }
        System.out.println(sum);
    }
    //题目描述
    //给定一个浮点数，要求得到该浮点数的个位数。
    //输入描述:
    //一行，包括一个浮点数。
    //输出描述:
    //一行，包含一个整数，为输入浮点数对应的个位数。
    public static void FG(){
        Scanner input=new Scanner(System.in);
        double x=input.nextDouble();
        System.out.println(String.format("%d",((int)x)%10));
    }
    //题目描述
    // 问题：一年约有3.156×107s，要求输入您的年龄，显示该年龄合多少秒。
    //输入描述:
    //一行，包括一个整数age(0<age<=200)。
    //输出描述:
    //一行，包含一个整数，输出年龄对应的秒数。
    public static void Age(){
        Scanner input=new Scanner(System.in);
        int age=input.nextInt();
        System.out.println((long)(age*3.156*(Math.pow(10,7))));
    }
}
