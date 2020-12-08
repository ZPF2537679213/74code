import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // LX();
       // K();
       // GJ();
      //  FXG();
       // ZXX();
        X();
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的菱形图案。
    //输入描述:
    //多组输入，一个整数（2~20）。
    //输出描述:
    //针对每行输入，输出用“*”组成的菱形，每个“*”后面有一个空格。
    public static void LX(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(int i=1;i<=x+1;++i){
              for(int j=1;j<=x-i+1;++j){
                  System.out.print(" ");
              }
              for(int j=1;j<=i;++j){
                  System.out.print("* ");
              }
                System.out.println();
            }
            for(int i=x;i>=1;--i){
                for(int j=x-i+1;j>=1;--j){
                    System.out.print(" ");
                }
                for(int j=i;j>=1;--j){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的K形图案。
    //输入描述:
    //多组输入，一个整数（2~20）。
    //输出描述:
    //针对每行输入，输出用“*”组成的K形，每个“*”后面有一个空格。
    public static void K(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(int i=1;i<x+2;++i){
                for(int j=1;j<=x-i+2;++j){
                    System.out.print("* ");
                }
                for(int j=1;j<=i;++j){
                    System.out.print(" ");
                }
                System.out.println();
            }
            for(int i=x;i>=1;--i){
                for(int j=x-i+2;j>=1;--j){
                    System.out.print("* ");
                }
                for(int j=i;j>=1;--j){
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的箭形图案。
    //输入描述:
    //多组输入，一个整数（2~20）。
    //输出描述:
    //针对每行输入，输出用“*”组成的箭形。
    public static void GJ(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(int i=1;i<=x+1;++i){
                for(int j=1;j<=2*(x-i+1);++j){
                    System.out.print(" ");
                }
                for(int j=1;j<=i;++j){
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int i=x;i>=1;--i){
                for(int j=(x-i+1)*2;j>=1;--j){
                    System.out.print(" ");
                }
                for(int j=i;j>=1;--j){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的反斜线形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示输出的行数，也表示组成反斜线的“*”的数量。
    //输出描述:
    //针对每行输入，输出用“*”组成的反斜线。
    public static void FXG(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
           for(int i=1;i<=x;++i){
               for(int j=1;j<=i;++j){
                   if(i==j){
                       System.out.println("*");
                   }else{
                       System.out.print(" ");
                   }
               }
           }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的正斜线形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示输出的行数，也表示组成正斜线的“*”的数量。
    //输出描述:
    //针对每行输入，输出用“*”组成的正斜线。
    public static void ZXX(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(int i=1;i<=x;++i){
                for(int j=1;j<=x;++j){
                    if(i+j==x+1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的X形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
    //输出描述:
    //针对每行输入，输出用“*”组成的X形图案。
    public static void X(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
          int x=input.nextInt();
          char[][]arr=new char[20][20];
          for(int i=0;i<x;++i){
              for(int j=0;j<x;++j){
                  if(i==j||i+j==x-1){
                   arr[i][j]='*';
                  }else{
                      arr[i][j]=' ';
                  }
              }
              for(int j=0;j<x;++j){
                  System.out.print(arr[i][j]);
              }
              System.out.println();
          }
        }
    }
}
