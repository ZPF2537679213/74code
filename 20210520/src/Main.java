import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.math.*;
/**
 * @author:飞哥
 * @date: 2021/5/20 15:51
 */
public class Main {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        System.out.println(s1);
        //while(sc.hasNext()){
            /*int n=sc.nextInt();
            if(n==0){
                break;
            }
            int[]arr=new int[n+1];
            arr[1]=4;
            for(int i=2;i<=n;++i){
                arr[i]=arr[i-1]*5+1;
            }
            int tz=arr[n];
            int lh=0;
            while(n>0){
                tz=tz/5*4;
                lh++;
                n--;
            }
            lh+=tz;
            System.out.println(arr[arr.length-1]+" "+lh);*/
       // }
    }
}
class Solution {
    /**
     *	奇数位上都是奇数或者偶数位上都是偶数
     *	输入：数组arr，长度大于2
     *	将arr调整成奇数位上都是奇数或者偶数位上都是偶数
     */
    public static void oddInOddEvenInEven(int[] arr) {
        StringBuilder strJ=new StringBuilder();
        StringBuilder strO=new StringBuilder();
        for(int i=0;i<arr.length;++i){
            if(arr[i]%2==0){
                strO.append(arr[i]+" ");
            }else{
                strJ.append(arr[i]+" ");
            }
        }
        int leno=strO.toString().trim().split(" ").length;
        int lenj=strJ.toString().trim().split(" ").length;
        int i=0;
        if(leno<lenj){
            for(String x:strO.toString().trim().split(" ")){
                arr[i]=Integer.parseInt(x);
                i+=2;
            }
            int j=i-1;
            i=1;
            for(String x:strJ.toString().trim().split(" ")){
                arr[i]=Integer.parseInt(x);
                if(i<j){
                    i+=2;
                }else{
                    i++;
                }
            }
        }else{
            i=1;
            for(String x:strJ.toString().trim().split(" ")){
                arr[i]=Integer.parseInt(x);
                i+=2;
            }
            int j=i-1;
            i=0;
            for(String x:strO.toString().trim().split(" ")){
                arr[i]=Integer.parseInt(x);
                if(i<j){
                    i+=2;
                }else{
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]num={1,2,3,4};
        oddInOddEvenInEven(num);
        System.out.println(Arrays.toString(num));
    }
}
/*
斐波那契数列变种
* 链接：https://www.nowcoder.com/questionTerminal/34f17d5f2a8240bea661a23ec095a062
来源：牛客网
星际战争开展了100年之后，NowCoder终于破译了外星人的密码！他们的密码是一串整数，通过一张表里的信息映射成最终4位密码。表的规则是：n对应的值是矩阵X的n次方的左上角，如果这个数不足4位则用0填充，如果大于4位的则只输出最后4位。
|1 1|^n => |Xn ..|
|1 0|      |.. ..|
例如n=2时，
|1 1|^2 => |1 1| * |1 1| => |2 1|
|1 0|      |1 0|   |1 0|    |1 1|
即2对应的数是“0002”。
输入描述:
输入有多组数据。
每组数据两行：第一行包含一个整数n (1≤n≤100)；第二行包含n个正整数Xi (1≤Xi≤10000)
输出描述:
对应每一组输入，输出一行相应的密码。*/
class Main2{
    public static void main(String[]args){
        int[]fibo=new int[100001];
        for(int i=1;i<100001;++i){
            if(i==1){
                fibo[i]=1;
            }
            else if(i==2){
                fibo[i]=2;
            }
            else{
                fibo[i]=(fibo[i-1]+fibo[i-2])%10000;
            }
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            StringBuilder str=new StringBuilder();
            for(int i=1;i<=n;++i){
                int x=sc.nextInt();
                str.append(String.format("%04d",fibo[x]));
            }
            System.out.println(str.toString());
        }
    }
}
/*
Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
Ex：
字符串A:abcdefg
字符串B: abcdef
通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
要求：
给定任意两个字符串，写出一个算法计算它们的编辑距离。
本题含有多组输入数据。
输入描述:
每组用例一共2行，为输入的两个字符串
输出描述:
每组用例输出一行，代表字符串的距离*/
class Main3{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String s1=input.next();
            String s2=input.next();
            int len1=s1.length();
            int len2=s2.length();
            int[][]minlen=new int[len1+1][len2+1];
            for(int i=0;i<=len1;++i){
                minlen[i][0]=i;
            }
            for(int i=0;i<=len2;++i){
                minlen[0][i]=i;
            }
            for(int i=1;i<=len1;++i){
                for(int j=1;j<=len2;++j){
                    int e1=minlen[i-1][j]+1;
                    int e2=minlen[i][j-1]+1;
                    int e3=minlen[i-1][j-1]+(s1.charAt(i-1)==s2.charAt(j-1)?0:1);
                    minlen[i][j]=Math.min(e1,Math.min(e2,e3));
                }
            }
            System.out.println(minlen[len1][len2]);
        }
    }
}
/*
采用数学类中的BigDecimal包装类，并利用multiply进行乘法，其次，调用BigDecimal的构造方法时，尽量传入字符串，因为可能会有精度问题，其次，基本类型的数值范围可能不够
* 链接：https://www.nowcoder.com/questionTerminal/82424d93369649b98720743c25edc6ce
来源：牛客网
小喵们很喜欢把自己装进容器里的（例如碗），但是要是碗的周长比喵的身长还短，它们就进不去了。
现在告诉你它们的身长，和碗的半径，请判断一下能否到碗里去。
输入描述:
输入有多组数据。
每组数据包含两个整数n (1≤n≤2^128) 和r (1≤r≤2^128)，分别代表喵的身长和碗的半径。
圆周率使用3.14。
输出描述:
对应每一组数据，如果喵能装进碗里就输出“Yes”；否则输出“No”。
* */
class Main4{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            BigDecimal ss1=new BigDecimal(s1);
            BigDecimal ss2=new BigDecimal(s2);
            ss2=ss2.multiply(new BigDecimal("6.28"));
            int end=ss1.compareTo(ss2);
            System.out.println((end>0?"No":"Yes"));
        }
    }
}