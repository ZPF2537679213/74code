
import java.util.Scanner;
import java.lang.Math;
public class ZuYe {
    public static void main(String[]args){
      Scanner input=new  Scanner(System.in);
      /*int []num={1,1,2,2,3,4,4,5,5};
        System.out.println(NSer(num,9));*/
        /*int x=input.nextInt();
        System.out.println(FBNQ(x));*/
        /*int x=input.nextInt();
        System.out.println(FacSum(x));*/
        /*int x=input.nextInt();
        System.out.println(JC(x));*/
        //JO();
        /*System.out.println("Max="+Max1(8.2, 8.6, 5));
        System.out.println("Max="+Max1(8,10));
        System.out.println("Max="+Max1(9.5,9.8));*/
        /*System.out.println("Sum="+Sum(8,10));
        System.out.println("Sum="+Sum(9.5,9.8,1.5));*/
        /*System.out.println(QW(5));*/
       // HNT(3,'A','B','C');
       /*System.out.println( FBNQ2(5));*/
        /*System.out.println(SuM(123));*/
        /*Show(123);*/
        /*System.out.println(He(10));*/
        System.out.println(JC2(10));
    }
    //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
    public static int NSer(int []num,int n){
      int sum=0;
        for(int i=0;i<n;++i){
          sum^=num[i];
      }
        return sum;
    }
    //求斐波那契数列的第n项。(迭代实现)
    public static int FBNQ(int n){
        int n1=1,n2=1,n3=1;
        for(int i=3;i<=n;++i){
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        return n3;
    }
    //求1！+2！+3！+4！+........+n!的和
    public static int FacSum(int n){
        int sum=0;
        for(int i=1;i<=n;++i){
          int f=1;
          for(int j=1;j<=i;++j){
              f*=j;
          }
          sum+=f;
        }
        return sum;
    }
    //求 N 的阶乘 。
    public static int JC(int n){
        if(n==1){
            return 1;
        }
        return n*JC(n-1);
    }
    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    public static void JO(){
     int []num={1,2,3,4,5,6,7,2,3,4};
     int i,j;
     for(i=0;i<num.length;++i){
         if(num[i]%2==0){
         for(j=i+1;j<num.length;++j){
             if(num[j]%2!=0){
                 num[i]=num[i]^num[j];
                 num[j]=num[i]^num[j];
                 num[i]=num[i]^num[j];
                 break;
             }
         }
         if(j==num.length){
            break;
         }
         }
     }
     for(int x:num){
         System.out.print(x+" ");
     }
    }
    //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
    //​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static int Max2(int a,int b){
        return Math.max(a,b);
    }
    public static int Max3(int a,int b,int c){
      return Math.max(Max2(a,b),c);
    }
    //在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
    public static int Max1(int a,int b){
        return Math.max(a,b);
    }
    public static double Max1(double x,double y){
        return Math.max(x,y);
    }
    public static double Max1(double a,double b,int x){
        return Math.max(Max1(a,b),x);
    }
    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static int Sum(int x,int y){
        return x+y;
    }
    public static double Sum(double a,double b,double c){
        return a+b+c;
    }
    //青蛙跳台阶问题
    public static int QW(int T){
        if(T==0||T==1){
            return 1;
        }else{
            return QW(T-1)+QW(T-2);
        }
    }
    //递归求解汉诺塔问题
    public static void Print(char A,char B){
        System.out.print(A+"->"+B+" ");
    }
    public static void HNT(int T,char A,char B,char C){
        if(T==1){
            Print(A,C);
            return;
        }
        HNT(T-1,A,C,B);
        Print(A,C);
        HNT(T-1,B,A,C);
    }
    //递归求斐波那契数列的第 N 项
    public static int FBNQ2(int n){
        if(n==1||n==2){
            return 1;
        }
        return FBNQ2(n-1)+FBNQ2(n-2);
    }
    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static int SuM(int x){
        if(x==0){
            return 0;
        }
        return x%10+SuM(x/10);
    }
    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void Show(int x){
        if(x==0){
            return;
        }
        Show(x/10);
        System.out.print(x%10+" ");
    }
    //递归求 1 + 2 + 3 + ... + 10
    public static int He(int n){
        if(n==1){
            return 1;
        }
        return n+He(n-1);
    }
    //递归求 N 的阶乘
    public static int JC2(int n){
        if(n==1){
            return 1;
        }
        return n*JC2(n-1);
    }
}
