import java.util.Scanner;
public class Main {
    //输入一个字符，用它构造一个三角形金字塔。
    /*public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    String s=input.next();
   for(int i=1;i<=5;++i){
       for(int j=1;j<=5-i;++j){
           System.out.print(" ");
       }
       for(int k=1;k<=i;++k){
           System.out.print(s+" ");
       }
       System.out.println();
   }
   input.close();
    }*/
    //BoBo教KiKi字符常量或字符变量表示的字符在内存中以ASCII码形式存储。BoBo出了一个问题给KiKi，转换以下ASCII码为对应字符并输出他们。
    //73, 32, 99, 97, 110, 32, 100, 111, 32, 105, 116 , 33
    /*public static void main(String[] args) {
        int[]num=new int[]{73, 32, 99, 97, 110, 32, 100, 111, 32, 105, 116 , 33};
        for(int i=0;i<num.length;++i){
            System.out.print((char)num[i]);
        }
    }*/
    //输入一个人的出生日期（包括年月日），将该生日中的年、月、日分别输出。
    //输入描述:
    //输入只有一行，出生日期，包括年月日，年月日之间的数字没有分隔符。
    //输出描述:
    //三行，第一行为出生年份，第二行为出生月份，第三行为出生日期。输出时如果月份或天数为1位数，需要在1位数前面补0。
    //输入
    //20130225
    //输出
    //year=2013
    //month=02
    //date=25
   /* public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      String birth=input.next();
      char[]bir=birth.toCharArray();
      int i=0;
      System.out.print("year=");
      for(;i<4;++i){
          System.out.print(bir[i]);
      }
      System.out.println();
        System.out.print("month=");
        for(;i<6;++i){
            System.out.print(bir[i]);
        }
        System.out.println();
        System.out.print("date=");
        for(;i<8;++i){
            System.out.print(bir[i]);
        }
        System.out.println();
        input.close();
      }*/
    /*public static void main(String[] args) {
num(123);
    }
    public static void num(int n){
        if(n==0) {
            return;
        }
        else{
           num(n/10);
            System.out.print(n%10+" ");
        }
    }*/
    //输入两个整数，范围-231~231-1，交换两个数并输出。
    //输入描述:
    //输入只有一行，按照格式输入两个整数，范围，中间用“,”分隔。
    //输出描述:
    //把两个整数按格式输出，中间用“,”分隔。
    //输入
    //a=1,b=2
    //输出
    //a=2,b=1
   /*/ public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.next();
        char a=str.charAt(2);
        char b=str.charAt(6);
        char p=a;
        a=b;
        b=p;
        System.out.println("a="+a+","+"b="+b);
    }*/
    /*public static void main(String[] args) {
        System.out.println(JC(10));
    }
    public static int JC(int n){
        if(n==1){
            return 1;
        }else{
            return n*JC(n-1);
        }
    }*/
    //BoBo教KiKi字符常量或字符变量表示的字符在内存中以ASCII码形式存储。BoBo出了一个问题给KiKi，输入一个字符，输出该字符相应的ASCII码。
    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.next();
        char c=str.charAt(0);
        System.out.println((int)c);
    }*/
    //请计算表达式“(-8+22)×a-10+c÷2”，其中，a = 40，c = 212。
    //
    //输入描述:
    //无。
    //输出描述:
    //(-8+22)×a-10+c÷2计算之后的结果，为一个整数。
    public static void main(String[] args) {
        System.out.printf("%d\n",(-8+22)*40-10+212/2);
    }
}
