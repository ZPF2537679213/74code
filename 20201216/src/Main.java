import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //KiKi();
        //Long();
        //equal();
        SJZ();
    }
    //题目描述
    //KiKi现在得到一个包含n*m个数的整数序列，现在他需要把这n*m个数按顺序规划成一个n行m列的矩阵并输出，请你帮他完成这个任务。
    //输入描述:
    //一行，输入两个整数n和m，用空格分隔，第二行包含n*m个整数（范围-231~231-1）。(1≤n≤10, 1≤m≤10)
    //输出描述:
    //输出规划后n行m列的矩阵，每个数的后面有一个空格。
    public static void KiKi(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[][]num=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                num[i][j]=input.nextInt();
            }
        }
        for(int[]arr:num){
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    //题目描述
    //KiKi想从n行m列的方阵队列中找到身高最高的人的位置，请你帮助他完成这个任务。
    //输入描述:
    //第一行包含两个整数n和m，表示这个方阵队列包含n行m列。从2到n+1行，每行输入m个整数（范围-231~231-1），用空格分隔，共输入n*m个数，表示方阵中的
    // 所有人的身高（保证输入身高都不相同）。(1≤x≤n≤10，1≤y≤m≤10)
    //输出描述:
    //一行，输出两个整数，用空格分隔，表示方阵中身高最高的人所在的行号和列号。
    public static void Long(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[][]num=new int[n][m];
        int max=num[0][0];
        int a=0,b=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                num[i][j]=input.nextInt();
                if(max<num[i][j]){
                    max=num[i][j];
                    a=i;
                    b=j;
                }
            }
        }
        System.out.println((a+1)+" "+(b+1));
    }
    //题目描述
    //KiKi得到了两个n行m列的矩阵，他想知道两个矩阵是否相等，请你回答他。(当两个矩阵对应数组元素都相等时两个矩阵相等)。
    //输入描述:
    //第一行包含两个整数n和m，表示两个矩阵包含n行m列，用空格分隔。
    //从2到n+1行，每行输入m个整数（范围-231~231-1），用空格分隔，共输入n*m个数，表示第一个矩阵中的元素。
    //从n+2行到2n+1，每行输入m个整数（范围-231~231-1），用空格分隔，共输入n*m个数，表示第二个矩阵中的元素。
    //1 < n,m < 10
    //输出描述:
    //一行，如果两个矩阵相等输出"Yes"并换行，否则输出"No"并换行。
    public static void equal(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int [][]num=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                num[i][j]=input.nextInt();
            }
        }
        String str="Yes";
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                int x=input.nextInt();
                if(x!=num[i][j]){
                    str="No";
                }
            }
        }
        System.out.println(str);
    }
    //题目描述
    //KiKi想知道一个n阶方矩是否为上三角矩阵，请帮他编程判定。上三角矩阵即主对角线以下的元素都为0的矩阵，主对角线为从矩阵的左上角至右下角的连线。
    //输入描述:
    //第一行包含一个整数n，表示一个方阵包含n行n列，用空格分隔。 (1≤n≤10)
    //从2到n+1行，每行输入n个整数（范围-231~231-1），用空格分隔，共输入n*n个数。
    //输出描述:
    //一行，如果输入方阵是上三角矩阵输出"YES"并换行，否则输出"NO"并换行。
    public static void SJZ(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[][]num=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
             num[i][j]=input.nextInt();
            }
        }
        String str="Yes";
        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(num[i][j]!=0){
                    str="No";
                }
            }
        }
        System.out.println(str);
    }
}
