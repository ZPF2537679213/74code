import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //KiKi();
        //yangHui();
        jZQ();
    }
    //题目描述
    //KiKi有一个矩阵，他想知道经过k次行变换或列变换后得到的矩阵。请编程帮他解答。
    //输入描述:
    //第一行包含两个整数n和m，表示一个矩阵包含n行m列，用空格分隔。 (1≤n≤10,1≤m≤10)
    //从2到n+1行，每行输入m个整数（范围-231~231-1），用空格分隔，共输入n*m个数，表示第一个矩阵中的元素。
    //接下来一行输入k，表示要执行k次操作（1≤k≤5）。接下来有k行，每行包括一个字符t和两个数a和b，中间用空格格分隔，t代表需要执行的操作，当t为字符'r'
    // 时代表进行行变换，当t为字符'c'时代表进行列变换，a和b为需要互换的行或列（1≤a≤b≤n≤10，1≤a≤b≤m≤10）。
    //输出描述:
    //输出n行m列，为矩阵交换后的结果。每个数后面有一个空格。
    public static void KiKi(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[][]num=new int [n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                num[i][j]=input.nextInt();
            }
        }
        int k=input.nextInt();
        for(int i=0;i<k;++i){
          String str=input.next();
          char t=str.charAt(0);
          int a=input.nextInt();
          int b=input.nextInt();
          if(t=='r'){
              int[]nu=num[a-1];
              num[a-1]=num[b-1];
              num[b-1]=nu;
          }else if(t=='c'){
              for(int j=0;j<n;++j){
                int nu=num[j][a-1];
                num[j][a-1]=num[j][b-1];
                num[j][b-1]=nu;
              }
          }
        }
        for(int[]nu:num){
            for(int x:nu){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    //题目描述
    //KiKi知道什么叫杨辉三角之后对杨辉三角产生了浓厚的兴趣，他想知道杨辉三角的前n行，请编程帮他解答。杨辉三角，本质上是二项式(a+b)的n次方展开后各项
    //的系数排成的三角形。其性质包括：每行的端点数为1， 一个数也为1；每个数等于它左上方和上方的两数之和。
    //输入描述:
    //第一行包含一个整数数n。 (1≤n≤30)
    //输出描述:
    //包含n行，为杨辉三角的前n行，每个数输出域宽为5。
    public static void yangHui(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[][]num=new int [n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<=i;++j){
                if(i==j||j==0){
                num[i][j]=1;
                }else{
                    num[i][j]=num[i-1][j-1]+num[i-1][j];
                }
                System.out.printf("%5d",num[i][j]);
            }
            System.out.println();
        }
    }
    //题目描述
    //KiKi和BoBo玩 “井”字棋。也就是在九宫格中，只要任意行、列，或者任意对角线上面出现三个连续相同的棋子，就能获胜。请根据棋盘状态，判断当前输赢。
    //输入描述:
    //三行三列的字符元素，代表棋盘状态，字符元素用空格分开，代表当前棋盘，其中元素为K代表KiKi玩家的棋子，为O表示没有棋子，为B代表BoBo玩家的棋子。
    //输出描述:
    //如果KiKi获胜，输出“KiKi wins!”；
    //如果BoBo获胜，输出“BoBo wins!”；
    //如果没有获胜，输出“No winner!”。
    public static void jZQ(){
        Scanner input=new Scanner(System.in);
        char[][]q=new char[3][3];
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                String str=input.next();
                q[i][j]=str.charAt(0);
            }
        }
     for(int i=0;i<3;++i){
         if(q[i][0]==q[i][1]&&q[i][1]==q[i][2]){
             if(q[i][0]=='K'){
                 System.out.println("KiKi wins!");
                 break;
             }else if(q[i][0]=='B'){
                 System.out.println("BoBo wins!");
                 break;
             }else{
                 System.out.println("No winner!");
                 break;
             }
         }
     }
     for(int i=0;i<3;++i){
      if(q[0][i]==q[1][i]&&q[1][i]==q[2][i]){
          if(q[0][i]=='K'){
              System.out.println("KiKi wins!");
              break;
          }else if(q[0][i]=='B'){
              System.out.println("BoBo wins!");
              break;
          }else{
              System.out.println("No winner!");
              break;
          }
      }
     }
     if((q[0][0]==q[1][1]&&q[1][1]==q[2][2])||(q[0][2]==q[1][1]&&q[1][1]==q[2][0])){
         if(q[1][1]=='K'){
             System.out.println("KiKi wins!");
         }else if(q[1][1]=='B'){
             System.out.println("BoBo wins!");
         }else{
             System.out.println("No winner!");
         }
     }
    }
}
