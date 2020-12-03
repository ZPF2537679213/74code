import java.lang.String;
import java.util.Scanner;
public class Program {
    //于老师经常告诉我们“学习编程最好的办法就是上机实践，因为你要对计算机下指令，想让计算机帮你干活，就得多和计算机‘交流’，实践才能出真知。”
 /*public static void main(String[] args) {
     System.out.println("Practice makes perfect!");
 }*/
    //每个人都想成为大V (VIP：Very Important Person)，但要一点一点积累才行，先从小v做起。要求输出由小写字母v组成的大V。
    /*public static void main(String[] args) {
        System.out.println("v   v");
        System.out.println(" v v");
        System.out.println("  v");
    }*/
    //确定不同整型数据类型在内存中占多大（字节），输出不同整型数据类型在内存中占多大（字节）。
    /*public static void main(String[] args) {
        System.out.println("The size of short is 2 bytes.");
        System.out.println("The size of int is 4 bytes.");
        System.out.println("The size of long is 4 bytes.");
        System.out.println("The size of long long is 8 bytes.");
    }*/
    //KiKi学会了printf在屏幕输出信息，他想输出一架小飞机。请帮他编写程序输出这架小飞机。
    /*public static void main(String[] args) {
        System.out.println("     **     "+"\n");
        System.out.println("     **     "+"\n");
        System.out.println("************"+"\n");
        System.out.println("************"+"\n");
        System.out.println("    *  *    "+"\n");
        System.out.println("    *  *    "+"\n");
    }*/
    //十进制整数1234对应的八进制和十六进制（字母大写），用空格分开，并且要求，在八进制前显示前导0，在十六进制数前显示前导0X。
    /*public static void main(String[] args) {
        System.out.println("02322"+" "+"0X4D2");
    }*/
    //KiKi写了一个输出“Hello world!”的程序，BoBo老师告诉他printf函数有返回值，你能帮他写个程序输出printf(“Hello world!”)的返回值吗？
    /*public static void main(String[] args) {
        String str="Hello world!";
        System.out.println(str);
        System.out.println(str.length());
    }*/
    /*
输入描述:
学号以及3科成绩，学号和成绩之间用英文分号隔开，成绩之间用英文逗号隔开。
输出描述:
学号，3科成绩，输出格式详见输出样例。
 */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        char []str=new char[100];
        String s=input.next();
        str=s.toCharArray();
        System.out.print("The each subject score of  No. ");
        for(int i=0;i<str.length;++i){
            if(str[i]!=';'&&str[i]!=','){
                System.out.printf("%c",str[i]);
            }
           else if(str[i]==','){
               System.out.printf("%c ",str[i]);
           }else{
               System.out.printf(" is ");
            }
        }
        System.out.println(".");
    }
}