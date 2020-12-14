import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // HeBing();
       // course();
        KiKi();
    }
   //输入描述:
    //输入包含三行，
    //第一行包含两个正整数n, m（1 ≤ n,m ≤ 100），用空格分隔。n表示第二行第一个升序序列中数字的个数，m表示第三行第二个升序序列中数字的个数。
    //第二行包含n个整数（范围1~5000），用空格分隔。
    //第三行包含m个整数（范围1~5000），用空格分隔。
    //输出描述:
    //输出为一行，输出长度为n+m的升序序列，即长度为n的升序序列和长度为m的升序序列中的元素重新进行升序序列排列合并。
    public static void HeBing(){
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        int n=input.nextInt();
        int []num=new int[m+n];
        for(int i=0;i<m+n;++i){
            num[i]=input.nextInt();
        }
        Arrays.sort(num);
        for(int x:num){
            System.out.print(x+" ");
        }
        System.out.println();
        input.close();
    }
    //题目描述
    //输入一个班级5个学生各5科成绩，输出5个学生各5科成绩及总分。
    //输入描述:
    //五行，每行输入一个学生各5科成绩（浮点数表示，范围0.0~100.0），用空格分隔。
    //输出描述:
    //五行，按照输入顺序每行输出一个学生的5科成绩及总分（小数点保留1位），用空格分隔。
    public static void course(){
        Scanner input=new Scanner(System.in);
        double [][]cour=new double[5][6];
        for(int i=0;i<cour.length;++i){
            double sum=0.0;
            for(int j=0;j<5;++j){
             cour[i][j]=input.nextDouble();
             sum+=cour[i][j];
            }
            cour[i][5]=sum;
        }
        for(double[] x:cour){
           for(double m:x){
               System.out.printf("%.1f ",m);
           }
            System.out.println();
        }
        input.close();
    }
    //题目描述
    //KiKi得到了一个n行m列的矩阵，现在他想知道第x行第y列的值是多少，请你帮助他完成这个任务。
    //输入描述:
    //第一行包含两个数n和m，表示这个矩阵包含n行m列。从2到n+1行，每行输入m个整数（范围-231~231-1），用空格分隔，共输入n*m个数，表示矩阵中的元素。
    //接下来一行输入x和y，用空格分隔，表示KiKi想得到的元素的位置。(1≤x≤n≤10，1≤y≤m≤10)
    //输出描述:
    //一行，输出一个整数值，为KiKi想知道的值。
    public static void KiKi(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int [][]num=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                num[i][j]=input.nextInt();
            }
        }
        int x=input.nextInt();
        int y=input.nextInt();
        System.out.println(num[x-1][y-1]);
        input.close();
    }
}
