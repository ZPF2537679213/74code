import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Deleted();
        Dele();
    }
   //题目描述
    //有一个整数序列（可能有重复的整数），现删除指定的某一个整数，输出删除指定数字之后的序列，序列中未被删除数字的前后位置没有发生改变。
    //输入描述:
    //第一行输入一个整数(0≤N≤50)。
    //第二行输入N个整数，输入用空格分隔的N个整数。
    //第三行输入想要进行删除的一个整数。
    //输出描述:
    //输出为一行，删除指定数字之后的序列。
    public static void Deleted(){
        Scanner input=new Scanner(System.in);
        int i,j;
        int N=input.nextInt();
        int[]num=new int[N];
        for(i=0;i<N;++i){
            num[i]=input.nextInt();
        }
        Arrays.sort(num);
        int n=input.nextInt();
       for(i=0,j=0;i<N;++i){
       if(num[i]!=n){
           num[j]=num[i];
           j++;
       }
       }
       for(i=0;i<j;++i){
           System.out.print(num[i]+" ");
       }
        System.out.println();
    }
    //题目描述
    //输入n个整数的序列，要求对这个序列进行去重操作。所谓去重，是指对这个序列中每个重复出现的整数，只保留该数第一次出现的位置，删除其余位置。
    //输入描述:
    //输入包含两行，第一行包含一个正整数n（1 ≤ n ≤ 1000），表示第二行序列中数字的个数；第二行包含n个整数（范围1~5000），用空格分隔。
    //输出描述:
    //输出为一行，按照输入的顺序输出去重之后的数字，用空格分隔。
    public static void Dele(){
        Scanner input=new Scanner(System.in);
        int i,j,k;
        int n=input.nextInt();
        int[]num=new int[1000];
        for(i=0;i<n;++i){
            num[i]=input.nextInt();
        }
        for(i=0;i<n-1;++i){
            for(j=i+1,k=j;j<n;++j){
                if(num[i]!=num[j]){
                    num[k]=num[j];
                    k++;
                }
            }
            n=k;
        }
        for(i=0;i<n;++i){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
