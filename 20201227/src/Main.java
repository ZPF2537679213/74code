import java.util.Arrays;
import java.util.Scanner;
import java.lang.System;
public class Main {
    public static void main(String[]args){
   /*Scanner input=new Scanner(System.in);
   int n=input.nextInt();
        System.out.println(goSteps(n));*/
      //  mySort();
        //twoNum();
       // sumJC();
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        double m=max3(a+b,b,c)/(max3(a,b+c,c)+max3(a,b,b+c));
        int x=(int)(m*100);
        System.out.println(x/100+"."+x%100);
    }
    //题目描述
    //小乐乐上课需要走n阶台阶，因为他腿比较长，所以每次可以选择走一阶或者走两阶，那么他一共有多少种走法？
    //输入描述:
    //输入包含一个整数n (1 ≤ n ≤ 30)
    //输出描述:
    //输出一个整数，即小乐乐可以走的方法数。
    public static int goSteps(int n){
     if(n==0||n==1){
         return 1;
     }else{
         return goSteps(n-1)+goSteps(n-2);
     }
    }
    //题目描述
    //老师给了小乐乐一个正整数序列，要求小乐乐把这个序列去重后按从小到大排序。但是老师给出的序列太长了，小乐乐没办法耐心的去重并排序，请你帮助他。
    //输入描述:
    //第一行包含一个正整数n，表示老师给出的序列有n个数。接下来有n行，每行一个正整数k，为序列中每一个元素的值。(1 ≤ n ≤ 105，1 ≤ k ≤ n)
    //输出描述:
    //输出一行，为去重排序后的序列，每个数后面有一个空格。
    public static void mySort(){
       Scanner input=new Scanner(System.in);
       int n=input.nextInt();
       int[]num=new int[n];
       for(int i=0;i<n;++i){
           num[i]=input.nextInt();
       }
        Arrays.sort(num);
       for(int i=0,j=0;i<num.length;i=j){
           while(j<num.length&&num[i]==num[j]){
               j++;
           }
           System.out.print(num[i]+" ");
       }
    }
    //题目描述
    //小乐乐从老师口中听到了二段数这个名词，想更深入的了解二段数。
    //二段数是这样的正整数：恰好包含两种不同的十进制数字s和t，s不是0，并且s的所有出现均排列在所有的t的前面。例如，44444411是二段数（s是4，t是1）
    // ，41、10000000和5555556也是。但4444114和44444都不是二段数。
    //这时老师问小乐乐：给你一个任意的正整数n，你能求出比n大并且是n的倍数的最小二段数吗？请你帮助小乐乐解答这个问题。
    //输入描述:
    //多组输入，每组输入包含一个正整数n (1 ≤ n ≤ 99999)
    //题目保证测试数据总数不超过500组，当输入n=0时程序结束。
    //输出描述:
    //对于每组测试用例，输出正整数n，后面紧跟“: ”，输出答案并换行，即比n大且是n的倍数的最小二段数。
    public static void twoNum(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int n=input.nextInt();
            if(n==0){
                System.exit(0);
            }
            int s=0,t=-1;
            long i;
            int j;
            for(i=n*2;;i+=n){
                String str=String.valueOf(i);
               char[]c=str.toCharArray();
               s=c[0];
               for(j=0;j<c.length&&s!=0;++j){
                  if(s!=c[j]&&t==-1){
                      t=c[j];
                  }
                  if(t!=-1&&c[j]!=t){
                      break;
                  }
               }
               if(j==c.length&&t!=-1){
                   System.out.println(n+":"+i);
                   break;
               }
            }
        }
    }
    //题目描述
    //小乐乐想计算一下1!+2!+3!+...+n!。
    //输入描述:
    //一行，一个整数n。
    //输出描述:
    //一行，一个整数，表示1!+2!+3!+...+n!的结果。
    public static void sumJC(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int sum=0;
        for(int i=1;i<n+1;++i){
            int jc=1;
            for(int j=i;j>0;--j){
                jc*=j;
            }
            sum+=jc;
        }
        System.out.println(sum);
    }
    //题目描述
    //小乐乐学会了自定义函数，BoBo老师给他出了个问题，根据以下公式计算m的值。
    //其中 max3函数为计算三个数的最大值，如： max3(1, 2, 3) 返回结果为3。
    //输入描述:
    //一行，输入三个整数，用空格隔开，分别表示a, b, c。
    //输出描述:
    //一行，一个浮点数，小数点保留2位，为计算后m的值。
    public static double max3(int a,int b,int c){
        return Math.max(Math.max(a,b),c);
    }
}
