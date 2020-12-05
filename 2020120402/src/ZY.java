import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
public class ZY {
    public static void main(String[] args) {
        //System.out.println(Nine());
        //RunNian();
        //ShowSS();
        //System.out.println(SuShu());
       // Age();
        //ShowX();
        //CN();
       // WN();
        //Sum();
        /*System.out.println("请输入一个整数：");
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        System.out.println(TO(x));
        input.close();*/
        //MGYS();
        //TX();
        //PassWord();
       /* System.out.println("请输入一个整数：");
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        Num(x);
        System.out.println();*/
        //ShowNine();
    }
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static int Nine(){
        int n=0;
        for(int i=1;i<101;++i){
            int m=i;
            while(m!=0){
                if(m%10==9){
                    n++;
                }
                m/=10;
            }
        }
        return n;
    }
    //输出 1000 - 2000 之间所有的闰年
    public static void RunNian(){
        int i=1000;
        while(i<=2000){
            if((i%400==0)||(i%4==0&&i%100!=0)){
                System.out.println(i);
            }
            i++;
        }
    }
    //打印 1 - 100 之间所有的素数
    public static void ShowSS(){
        for(int i=1;i<=100;++i){
            int flag=1;
            for(int j=2;j<=Math.sqrt((double)i);++j){
                if(i%j==0){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                System.out.println(i);
            }
        }
    }
    //给定一个数字，判定一个数字是否是素数
    public static boolean SuShu(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        for(int i=2;i<=Math.sqrt((double)n);++i){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    //根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
    public static void Age(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        if(n<=18){
            System.out.println("少年");
        }else if(n>=19&&n<=28){
            System.out.println("青年");
        }else if(n>=29&&n<=55){
            System.out.println("中年");
        }else{
            System.out.println("老年");
        }
    }
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的X形图案。
    //输入描述:
    //多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
    //输出描述:
    //针对每行输入，输出用“*”组成的X形图案。
    //
    //示例1
    //输入
    //5
    //输出
    //*   *
    // * *
    //  *
    // * *
    //*   *
    //示例2
    //输入
    //6
    //输出
    //*    *
    // *  *
    //  **
    //  **
    // *  *
    //*    *
    public static void ShowX(){
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        char[][]X=new char[20][20];
        for(int i=0;i<x;++i) {
            for (int j = 0; j < x; ++j) {
                if (i == j || (i + j == x - 1)) {
                    X[i][j] = '*';
                } else {
                    X[i][j] = ' ';
                }
                System.out.print(X[i][j]);
            }
            System.out.println();
        }
    }
    //完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
    public static void CN() {
        Random rand=new Random();
        Scanner input=new Scanner(System.in);
        int x=rand.nextInt(100)+1;
        int n;
        while(true){
            System.out.print("请输入你猜测的数字：");
            n=input.nextInt();
          if(n>x){
              System.out.println("猜大了");
          } else if(n<x){
              System.out.println("猜小了");
          }else{
              System.out.println("恭喜你猜对了");
              break;
          }
        }
        input.close();
    }
    //求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，如；153＝1＋5＋3?，则153是一个“水仙花数“。）
    public static void WN(){
        for(int i=0;i<1000;++i){
            int n=i;
            int sum=0;
           while(n!=0){
               sum+=Math.pow(n%10,3);
               n/=10;
           }
           if(sum==i){
               System.out.print(i+" ");
           }
        }
        System.out.println();
    }
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
    public static void Sum(){
        double sum=0;
        double m=1;
        for(int i=1;i<101;++i){
            sum+=m/i;
            m=-m;
        }
        System.out.println(sum);
    }
    //求两个正整数的最大公约数
    public static void MGYS(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入两个正整数：");
        int x=input.nextInt();
        int y=input.nextInt();
        if(x<y){
        x=x^y;
        y=x^y;
        x=x^y;
            }
        while(x%y!=0){
           x=y;
           y=x/y;
        }
        System.out.println(y);
    }
    //求一个整数，在内存当中存储时，二进制1的个数。
    public static int TO(int x){
       int num=0;
       while(x!=0){
           num++;
           x=x&(x-1);
       }
       return num;
    }
    //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
    public static void TX(){
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        int []num=new int[32];
        for(int i=0;i<32;i++){
           num[i]=x&1;
           x=x>>1;
        }
        System.out.print("奇数位:");
        for(int i=1;i<32;i=i+2){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        System.out.print("偶数位:");
        for(int i=0;i<32;i=i+2){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
    //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
    public static void PassWord(){
        int num=3;
        Scanner input=new Scanner(System.in);
        System.out.print("请输入初始密码：");
        String pass=input.nextLine();
        while(num!=0){
            System.out.print("请输入验证密码:");
            String user=input.nextLine();
            if(user.equals(pass)){
                System.out.println("登陆成功");
                break;
            }else{
                System.out.println("密码错误");
                num--;
            }
        }
        input.close();
    }
    //输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
    public static void Num(int x){
        if(x!=0){
            Num(x/10);
            System.out.print(x%10+" ");
        }
    }
    //输出n*n的乘法口诀表，n由用户输入。
    public static void ShowNine(){
        System.out.print("请输入你要打印的乘法口诀范围：");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        for(int i=1;i<=n;++i){
            for(int j=1;j<=i;++j){
                System.out.print(i+"x"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
