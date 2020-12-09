import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //KZ();
        KSJ();
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的“空心”正方形图案。
    //输入描述:
    //多组输入，一个整数（3~20），表示输出的行数，也表示组成正方形边的“*”的数量。
    //输出描述:
    //针对每行输入，输出用“*”组成的“空心”正方形，每个“*”后面有一个空格。
    public static void KZ(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
          for(int i=1;i<=x;++i){
              if(i==1||i==x){
                  for(int j=1;j<=x;++j){
                      System.out.print("* ");
                  }
                  System.out.println();
              }else{
                  for(int j=1;j<=x;++j){
                      if(j==1||j==x){
                          System.out.print("* ");
                      }else{
                          System.out.print("  ");
                      }
                  }
                  System.out.println();
              }
          }
        }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的“空心”三角形图案。
    //输入描述:
    //多组输入，一个整数（3~20），表示输出的行数，也表示组成三角形边的“*”的数量。
    //输出描述:
    //针对每行输入，输出用“*”组成的“空心”三角形，每个“*”后面有一个空格。
    public static void KSJ(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(int i=1;i<=x;++i){
                if (i != x) {
            for(int j=1;j<=x;++j) {
                    if (i == j || j == 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                    System.out.println();
            }else{
                    for(int j=1;j<=x;++j){
                        System.out.print("* ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
