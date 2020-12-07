import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        //JY();
        //JFC();
        //yearDay();
        //JSQ();
    }
    //KiKi最近学习了信号与系统课程，这门课里有一个非常有趣的函数，单位阶跃函数，其中一种定义方式为：
    //题目有多组输入数据，每一行输入一个t(-1000<t<1000)表示函数的时域t。
    //输出描述:
    //输出函数的值并换行。
    public static void JY(){
        Scanner input=new Scanner(System.in);
        double []num=new double[1000];
        int i=0;
        while(input.hasNextDouble()){
           double t=input.nextDouble();
           if(t>0){
           num[i]=1;
           }else if(t==0){
               num[i]=0.5;
           }else{
               num[i]=0;
           }
           i++;
        }
        for(int j=0;j<i;++j){
            if(num[j]==1.0){
            System.out.println((int)num[j]);
        }else if(num[j]==0.0){
                System.out.println((int)num[j]);
            }else{
                System.out.println(num[j]);
            }
        }
        input.close();
    }
    //从键盘输入a, b, c的值，编程计算并输出一元二次方程ax2 + bx + c = 0的根，当a = 0时，输出“Not quadratic equation”，当a ≠ 0时，根据
    // △ = b2 - 4*a*c的三种情况计算并输出方程的根。
    //输入描述:
    //多组输入，一行，包含三个浮点数a, b, c，以一个空格分隔，表示一元二次方程ax2 + bx + c = 0的系数。
    //输出描述:
    //针对每组输入，输出一行，输出一元二次方程ax2 + bx +c = 0的根的情况。
    //  如果a = 0，输出“Not quadratic equation”；
    //  如果a ≠  0，分三种情况：
    //△ = 0，则两个实根相等，输出形式为：x1=x2=...。
    //△  > 0，则两个实根不等，输出形式为：x1=...;x2=...，其中x1  <=  x2。
    //△  < 0，则有两个虚根，则输出：x1=实部-虚部i;x2=实部+虚部i，即x1的虚部系数小于等于x2的虚部系数，实部为0时不可省略。实部= -b / (2*a),虚
    // 部= sqrt(-△ ) / (2*a)
    //所有实数部分要求精确到小数点后2位，数字、符号之间没有空格。
    public static void JFC() {
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()) {
            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();
            double d = Math.pow(b, 2) - 4 * a * c;
            if (a == 0) {
                System.out.println("Not quadratic equation");
            } else {
                if (d == 0) {
                    System.out.println("x1=x2=" + (String.format("%.2f", (-b) / (2 * a))));
                } else if (d > 0) {
                    System.out.println("x1=" + (String.format("%.2f", (-b) / (2 * a) - (Math.sqrt(d) / (2 * a)))) + ";" + "x2=" + (String.format("%.2f", (-b) / (2 * a) + (Math.sqrt(d) / (2 * a)))));
                } else {
                    double x = (-b) / (2 * a);
                    double y = Math.sqrt(d) / (2 * a);
                    System.out.println("x1=" + String.format("%.2f", x) + "-" + y + "i" + ";" + "x2=" + String.format("%.2f", x) + "+" + y + "i");
                }
            }
        }
        input.close();
    }
    //KiKi想获得某年某月有多少天，请帮他编程实现。输入年份和月份，计算这一年这个月有多少天。
    public static void yearDay(){
    Scanner input=new Scanner(System.in);
    while(input.hasNextInt()){
        int year=input.nextInt();
        int month=input.nextInt();
        if(month==2){
         if(year%400==0||year%4==0&&year%100!=0){
             System.out.println(29);
         }else{
             System.out.println(28);
         }
        }else{
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                System.out.println(31);
            }else{
                System.out.println(30);
            }
        }
    }
    input.close();
    }
    //KiKi实现一个简单计算器，实现两个数的“加减乘除”运算，用户从键盘输入算式“操作数1运算符操作数2”，计算并输出表达式的值，如果输入的运算符号不包括在
    //（+、-、*、/）范围内，输出“Invalid operation!”。当运算符为除法运算，即“/”时。如果操作数2等于0.0，则输出“Wrong!Division by zero!”
    public static void JSQ(){
        Scanner input=new Scanner(System.in);
        String []s=new String[1000];
        int i=0;
        while(input.hasNextDouble()){
          double x=input.nextDouble();
          String str=input.next();
          double y=input.nextDouble();
          if(str.equals("+")){
              System.out.printf("%.4f+%.4f=%.4f\n",x,y,x+y);
          }else if(str.equals("-")){
              System.out.printf("%.4f-%.4f=%.4f\n",x,y,x-y);
          }else if(str.equals("/")){
              if(y!=0.0){
              System.out.printf("%.4f/%.4f=%.4f\n",x,y,x/y);
          }else{
                  System.out.println("Wrong!Division by zero!\n");
              }
          }else if(str.equals("*")){
              System.out.printf("%.4f*%.4f=%.4f\n",x,y,x*y);
          }else{
              System.out.println("Invalid operation!\n");
          }
        }
        input.close();
    }
    }
