import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // NSZ();
        // ZFS();
       // Sum();
       // MLC();
       // YXXL();
        Sort();
    }

    //题目描述
    //输入10个整数，要求按输入时的逆序把这10个数打印出来。逆序输出，就是按照输入相反的顺序打印这10个数。
    //输入描述:
    //一行，输入10个整数（范围-231~231-1），用空格分隔。
    //输出描述:
    //一行，逆序输出输入的10个整数，用空格分隔。
    public static void NSZ() {
        Scanner input = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 9; i >= 0; --i) {
            num[i] = input.nextInt();
        }
        for (int x : num) {
            System.out.print(x + " ");
        }
        System.out.println();
        input.close();
    }

    //题目描述
    //输入10个整数，分别统计输出正数、负数的个数。
    //输入描述:
    //输入10个整数（范围-231~231-1），用空格分隔。
    //输出描述:
    //两行，第一行正数个数，第二行负数个数，具体格式见样例。
    //输入
    //-1 2 3 -6 7 8 -1 6 8 10
    //输出
    //positive:7
    //negative:3
    public static void ZFS() {
        Scanner input = new Scanner(System.in);
        int positive = 0;
        int negative = 0;
        for (int i = 1; i <= 10; ++i) {
            int num = input.nextInt();
            if (num > 0) {
                positive++;
            }
            if (num < 0) {
                negative++;
            }
        }
        System.out.println("positive:" + positive);
        System.out.println("negative:" + negative);
        input.close();
    }

    //题目描述
    //输入数字N，然后输入N个数，计算这N个数的和。
    //输入描述:
    //第一行输入一个整数N(0≤N≤50)，第二行输入用空格分隔的N个整数。
    //输出描述:
    //输出为一行，为第二行输入的“N个整数之和”的计算结果。
    public static void Sum() {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int N = input.nextInt();
        for (int i = 1; i <= N; ++i) {
            sum += input.nextInt();
        }
        System.out.println(sum);
    }
    //题目描述
    //输入n个成绩，换行输出n个成绩中最高分数和最低分数的差。
    //输入描述:
    //两行，第一行为n，表示n个成绩，不会大于10000。
    //第二行为n个成绩（整数表示，范围0~100），以空格隔开。
    //输出描述:
    //一行，输出n个成绩中最高分数和最低分数的差。
    public static void MLC() {
        Scanner input = new Scanner(System.in);
        int max = 0;
        int min =-1;
        int n=input.nextInt();
        for (int i = 1; i <= n; ++i) {
            int num=input.nextInt();
            if(max<num){
              max=num;
            }if(min<0||min>num){
                min=num;
            }
        }
        System.out.println(max-min);
    }
    //题目描述
    //输入一个整数序列，判断是否是有序序列，有序，指序列中的整数从小到大排序或者从大到小排序。
    //输入描述:
    //第一行输入一个整数N(3≤N≤50)。
    //第二行输入N个整数，用空格分隔N个整数。
    //输出描述:
    //输出为一行，如果序列有序输出sorted，否则输出unsorted。
    public static void YXXL(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        boolean flag;
        int []num=new int[50];
      for(int i=0;i<n;++i){
      num[i]=input.nextInt();
      }
      if(num[0]>num[1]){
        flag=true;
      }else{
          flag=false;
      }
      for(int i=2;i<n;++i){
          if(num[i]>num[i-1]){
              if(flag==true){
                  System.out.println("unsorted");
                 return;
              }
          }else if(num[i]<num[i-1]){
              if(flag==false){
                  System.out.println("unsorted");
                  return;
              }
          }
      }
        System.out.println("sorted");
    }
    //题目描述
    //有一个有序数字序列，从小到大排序，将一个新输入的数插入到序列中，保证插入新数后，序列仍然是升序。
    //输入描述:
    //第一行输入一个整数N(0≤N≤50)。
    //第二行输入N个升序排列的整数，输入用空格分隔的N个整数。
    //第三行输入想要进行插入的一个整数。
    //输出描述:
    //输出为一行，N+1个有序排列的整数。
    public static void Sort(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int []num=new int[n+1];
        for(int i=0;i<n;++i){
        num[i]=input.nextInt();
        }
        num[n]=input.nextInt();
        Arrays.sort(num);
        for(int i=0;i<n+1;++i){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
