import java.lang.Math;
import java.util.Scanner;
public class HuaWei{
    public static void main(String[] args) {
       /* Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        System.out.println(a/b+" "+a%b);
        input.close();*/
        /*Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Show(n);*/
        //BMI();
        //SanJiao();
        //Area();
        //BtoL();
        //CF();
        Milk();
    }
    //题目描述
    //将一个四位数，反向输出
    //输入描述:
    //一行，输入一个整数n（1000 <= n <= 9999）。
    //输出描述:
    //针对每组输入，反向输出对应四位数。
    //输入
    //1234
    //输出
    //4321
    public static void Show(int n){
      if(n!=0){
          System.out.print(n%10);
          Show(n/10);
      }
    }
    //问题：计算BMI指数（身体质量指数）。BMI指数（即身体质量指数，简称体质指数又称体重，英文为Body Mass Index，简称BMI），是用体重公斤数除以身高
    //米数平方得出的数字，是目前国际上常用的衡量人体胖瘦程度以及是否健康的一个标准。主要用于统计用途，当我们需要比较及分析一个人的体重对于不同高度的人
    //所带来的健康影响时，BMI值是一个中立而可靠的指标。
    //输入描述:
    //一行，两个整数，分别表示体重（公斤），身高（厘米），中间用一个空格分隔。
    //输出描述:
    //一行，BMI指数（保留两位小数）。
    public static void BMI(){
        Scanner input=new Scanner(System.in);
        int Wide=input.nextInt();
        int Long=input.nextInt();
        double x=Wide/(Math.pow(Long/100.0,2.0));
        System.out.println(String.format("%.2f",x));
        input.close();
    }
    //根据给出的三角形3条边a, b, c（0 < a, b, c < 100,000），计算三角形的周长和面积。
    //输入描述:
    //一行，三角形3条边（能构成三角形），中间用一个空格隔开。
    //输出描述:
    //一行，三角形周长和面积（保留两位小数），中间用一个空格隔开，输出具体格式详见输出样例。
    //输入
    //3 3 3
    //输出
    //circumference=9.00 area=3.90
    public static void SanJiao(){
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        double cir=(double)(a+b+c);
        double area=(double)Math.sqrt(((cir/2.0)*(cir/2.0-a)*(cir/2.0-b)*(cir/2.0-c)));
        System.out.println("circumference="+String.format("%.2f",cir)+" "+"area="+String.format("%.2f",area));
    }
    //题目描述
    //给定一个球体的半径，计算其体积。其中球体体积公式为 V = 4/3*πr3，其中 π= 3.1415926。
    //输入描述:
    //一行，用浮点数表示的球体的半径。
    //输出描述:
    //一行，球体的体积，小数点后保留3位。
    //示例1
    //输入
    //3.0
    //输出
    //113.097
    public static void Area(){
        Scanner input=new Scanner(System.in);
        double r=input.nextDouble();
        double pi=3.1415926;
        double v=(4.0/3.0)*pi*Math.pow(r,3);
        System.out.println(String.format("%.3f",v));
    }
    //题目描述
    //实现字母的大小写转换。多组输入输出。
    //输入描述:
    //多组输入，每一行输入大写字母。
    //输出描述:
    //针对每组输入输出对应的小写字母。
    //输入
    //A
    //B
    //输出
    //a
    //b
    public static void BtoL(){
        Scanner input=new Scanner(System.in);
        char[]word=new char[1000];
        int i=0;
        while(input.hasNext()){
        String str=input.next();
        word[i]=str.charAt(0);
        i++;
        }
        for(int j=0;j<i;++j){
            System.out.println((char)(word[j]+32));
        }
    }
    //题目描述
    //不使用累计乘法的基础上，通过移位运算（<<）实现2的n次方的计算。
    //输入描述:
    //多组输入，每一行输入整数n（0 <= n < 31）。
    //输出描述:
    //针对每组输入输出对应的2的n次方的结果。
    //示例1
    //输入
    //2
    //10
    //输出
    //4
    //1024
    public static void CF(){
        Scanner input=new Scanner(System.in);
        long[]L=new long[1000];
        int i=0;
        while(input.hasNextInt()){
            int a=input.nextInt();
            L[i]=2<<(a-1);
            i++;
        }
        for(int j=0;j<i;++j){
            System.out.println(L[j]);
        }
    }
    //题目描述
    //BoBo买了一箱酸奶，里面有n盒未打开的酸奶，KiKi喜欢喝酸奶，第一时间发现了酸奶。KiKi每h分钟能喝光一盒酸奶，并且KiKi在喝光一盒酸奶之前不会喝另
    // 一个，那么经过m分钟后还有多少盒未打开的酸奶？
    //输入描述:
    //多组输入，每组输入仅一行，包括n，h和m（均为整数）。输入数据保证m <= n * h。
    //输出描述:
    //针对每组输入，输出也仅一行，剩下的未打开的酸奶盒数。
    //输入
    //8 5 16
    //输出
    //4
    public static void Milk(){
        Scanner input=new Scanner(System.in);
        int[]milk=new int[1000];
        int i=0;
        while(input.hasNextInt()){
            int n=input.nextInt();
            int h=input.nextInt();
            int m=input.nextInt();
            if(m%h==0){
            milk[i]=n-m/h;
            }else{
                milk[i]=n-m/h-1;
            }
            i++;
        }
       for(int j=0;j<i;++j){
           System.out.println(milk[j]);
       }
    }
}