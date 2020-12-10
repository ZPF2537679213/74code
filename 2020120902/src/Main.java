import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
//NY();
        //HTTP();
        //SZSJ();
        //PJCJ();
        //XL();
        SZ();
    }
    //题目描述
    //新年到来，输出信息迎接新年。
    //输入描述:
    //输出描述:
    //Happy New Year*2019*
    public static void NY(){
        System.out.println("Happy New Year*2019*");
    }
    //题目描述
    //从键盘输入5个人的身高（米），求他们的平均身高（米）。
    // 输入描述:
    //一行，连续输入5个身高（范围0.00~2.00），用空格分隔。
    public static void PJSG(){
        Scanner input=new Scanner(System.in);
        double x;
        double sum=0;
        for(int i=1;i<6;++i){
            x=input.nextDouble();
            sum+=x;
        }
        System.out.println(String.format("%.2f",sum/5.0));
    }
    //题目描述
    //KiKi访问网站，得到HTTP状态码，但他不知道什么含义，BoBo老师告诉他常见HTTP状态码：200（OK，请求已成功），202（Accepted，服务器已接受请求，但尚未处理。）
    // 400（Bad Request，请求参数有误），403（Forbidden，被禁止），404（Not Found，请求失败），500（Internal Server Error，服务器内部错误），
    // 502（Bad Gateway，错误网关）。
    //输入描述:
    //多组输入，一行，一个整数（100~600），表示HTTP状态码。
    //输出描述:
    //针对每组输入的HTTP状态，输出该状态码对应的含义，具体对应如下：
    //200-OK
    //202-Accepted
    //400-Bad Request
    //403-Forbidden
    //404-Not Found
    //500-Internal Server Error
    //502-Bad Gateway
    public static void HTTP(){
      Scanner input=new Scanner(System.in);
      while(input.hasNextInt()){
          int x=input.nextInt();
          switch(x){
              case 200:System.out.println("OK");break;
              case 202: System.out.println("Accepted");break;
              case 400: System.out.println("Bad Request");break;
              case 403: System.out.println("Forbidden");break;
              case 500: System.out.println("Internal Server Error");break;
              case 404: System.out.println("Not Found");break;
              case 502: System.out.println("Bad Gateway");break;
          }
      }
    }
    //题目描述
    //KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用数字组成的数字三角形图案。
    //输入描述:
    //多组输入，一个整数（3~20），表示数字三角形边的长度，即数字的数量，也表示输出行数。
    //输出描述:
    //针对每行输入，输出用数字组成的对应长度的数字三角形，每个数字后面有一个空格。
    public static void SZSJ(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            for(int i=1;i<=x;++i){
                for(int j=1;j<=i;++j){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }
    //题目描述
    //公务员面试现场打分。有7位考官，从键盘输入若干组成绩，每组7个分数（百分制），去掉一个最高分和一个最低分，输出每组的平均成绩。
    //输入描述:
    //一行，输入7个整数（0~100），代表7个成绩，用空格分隔。
    //输出描述:
    //一行，输出去掉最高分和最低分的平均成绩，小数点后保留2位，每行输出后换行。
    public static void PJCJ(){
        Scanner input=new Scanner(System.in);
        int []num=new int [7];
        for(int i=0;i<7;++i){
            num[i]=input.nextInt();
        }
        Arrays.sort(num);
        int sum=0;
        for(int i=1;i<6;++i){
            sum+=num[i];
        }
        System.out.printf("%.2f\n",sum/5.0);
    }
    //题目描述
    //有一个有序数字序列，从小到大排序，将一个新输入的数插入到序列中，保证插入新数后，序列仍然是升序。
    //输入描述:
    //第一行输入一个整数(0≤N≤50)。
    //第二行输入N个升序排列的整数，输入用空格分隔的N个整数。
    //第三行输入想要进行插入的一个整数。
    //输出描述:
    //输出为一行，N+1个有序排列的整数。
    public static void XL(){
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int[]num=new int[N+1];
        for(int i=0;i<N;++i){
            num[i]=input.nextInt();
        }
        int x=input.nextInt();
        num[N]=x;
        Arrays.sort(num);
        for(int m:num){
            System.out.print(m+" ");
        }
        System.out.println();
    }
    //题目描述
    //用筛选法求n以内的素数。筛选法求解过程为：将2~n之间的正整数放在数组内存储，将数组中2之后的所有能被2整除的数清0，再将3之后的所有能被3整除的数清0 ，
    // 以此类推，直到n为止。数组中不为0 的数即为素数。
    //输入描述:
    //多组输入，每行输入一个正整数（不大于100）。
    //输出描述:
    //针对每行输入的整数n，输出两行，第一行，输出n之内（包括n）的素数，用空格分隔，
    //第二行，输出数组中2之后0 的个数。每行输出后换行。
    public static void SZ(){
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()){
            int x=input.nextInt();
            int []num=new int[x];
            for(int i=0;i<x-1;++i){
                num[i]=i+2;
            }
            for(int i=0;i<x-1;++i){
                for(int j=i+1;j<x-1;++j){
                    if(num[j]%(i+2)==0){
                        num[j]=0;
                    }
                }
            }
            int count=0;
            for(int i=0;i<x-1;++i){
                if(num[i]!=0){
                    System.out.print(num[i]+" ");
                }else{
                    count++;
                }
            }
            System.out.println();
            System.out.println(count);
        }
    }
}
