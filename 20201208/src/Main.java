import java.util.Scanner;
public class Main {
    public static void main(String[]args){
       // Show();
        //ZF();
        //SJ();
        //DSJ();
       // FSJ();
        //JZT();
        DJZT();
    }
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的线段图案。
    //输入描述:
    //多组输入，一个整数（1~100），表示线段长度，即“*”的数量。
    //输出描述:
    //针对每行输入，输出占一行，用“*”组成的对应长度的线段。
    public static void Show(){
        Scanner input=new Scanner(System.in);
        String []str=new String[1000];
        int i=0,j=0;
        while(input.hasNextInt()){
            int x=input.nextInt();
            char[]arr=new char[100];
            for(i=0;i<x;++i){
                arr[i]='*';
            }
           str[j]=String.valueOf(arr);
            j++;
        }
        for(i=0;i<j;++i){
            System.out.println(str[i]);
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的正方形图案。
    //输入描述:
    //多组输入，一个整数（1~20），表示正方形的长度，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用“*”组成的对应边长的正方形，每个“*”后面有一个空格。
    public static void ZF(){
        Scanner input=new Scanner(System.in);
        int i,j;
        while(input.hasNextInt()){
            int x=input.nextInt();
            char[][]arr=new char[20][20];
           for(i=0;i<x;++i){
               for(j=0;j<x;++j){
                   arr[i][j]='*';
               }
           }
            for(i=0;i<x;++i){
                for(j=0;j<x;++j){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的直角三角形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示直角三角形直角边的长度，即“*”的数量，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用“*”组成的对应长度的直角三角形，每个“*”后面有一个空格。
    public static void SJ(){
        Scanner input=new Scanner(System.in);
        int i,j;
        while(input.hasNextInt()){
            int x=input.nextInt();
            char[][]arr=new char[20][20];
            for(i=0;i<x;++i){
                for(j=0;j<=i;++j){
                    arr[i][j]='*';
                }
            }
            for(i=0;i<x;++i){
                for(j=0;j<=i;++j){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的翻转直角三角形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示翻转直角三角形直角边的长度，即“*”的数量，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用“*”组成的对应长度的翻转直角三角形，每个“*”后面有一个空格。
    public static void DSJ(){
        Scanner input=new Scanner(System.in);
        int i,j;
        while(input.hasNextInt()){
            int x=input.nextInt();
            char[][]arr=new char[20][20];
            for(i=0;i<x;++i){
                for(j=0;j<x-i;++j){
                    arr[i][j]='*';
                }
            }
            for(i=0;i<x;++i){
                for(j=0;j<x-i;++j){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
        input.close();
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的带空格直角三角形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示直角三角形直角边的长度，即“*”的数量，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用“*”组成的对应长度的直角三角形，每个“*”后面有一个空格。
    public static void FSJ(){
        Scanner input=new Scanner(System.in);
        int i,j;
        while(input.hasNextInt()){
            int x=input.nextInt();
            char[][]arr=new char[20][20];
            for(i=0;i<x;++i){
                for(int k=0;k<x-i-1;++k){
                    arr[i][k]=' ';
                }
                for(j=x-i-1;j<x;++j){
                    arr[i][j]='*';
                }
            }
            for(i=0;i<x;++i){
                for(j=0;j<x;++j){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
        input.close();
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的金字塔图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示金字塔边的长度，即“*”的数量，，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用“*”组成的金字塔，每个“*”后面有一个空格。
    public static void JZT(){
        Scanner input=new Scanner(System.in);
        int i,j;
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(i=0;i<x;++i){
                for(int k=0;k<x-i-1;++k){
                    System.out.print(" ");
                }
                for(j=0;j<=i;++j){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        input.close();
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的翻转金字塔图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示翻转金字塔边的长度，即“*”的数量，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用“*”组成的金字塔，每个“*”后面有一个空格。
    public static void DJZT(){
        Scanner input=new Scanner(System.in);
        int i,j;
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(i=x-1;i>=0;--i){
                for(int k=0;k<x-i-1;++k){
                    System.out.print(" ");
                }
                for(j=0;j<=i;++j){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        input.close();
    }
}
