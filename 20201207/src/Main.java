import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        //System.out.println(Value());
        //ZM();
        //System.out.println(String.format("%.2f",Money()));
       // Lily();
        Socre();
    }
    //输入描述:
    //一行，连续输入5个整数（范围0~100），用空格分隔。
    //输出描述:
    //一行，输出5个数的平均数（保留一位小数）。
    public static double Value(){
        Scanner input=new Scanner(System.in);
       int sum=0;
       for(int i=1;i<=5;++i){
           sum+=input.nextInt();
       }
       input.close();
       return sum/5.0;
    }
    //输入描述:
    //多组输入，每行输入包括一个字符。
    //输出描述:
    //针对每行输入，输出该字符是字母（YES）或不是（NO）。
    public static void ZM(){
        Scanner input=new Scanner(System.in);
        String[]str=new String[1000];
        int i=0;
        while(input.hasNext()){
            String s=input.next();
            if(s.charAt(0)>='a'&&s.charAt(0)<='z'||s.charAt(0)>='A'&&s.charAt(0)<='Z'){
                str[i]="YES";
            }else{
                str[i]="NO";
            }
            i++;
        }
        for(int j=0;j<i;++j){
            System.out.println(str[j]);
        }
    }
    //KiKi非常喜欢网购，在一家店铺他看中了一件衣服，他了解到，如果今天是“双11”（11月11日）则这件衣服打7折，“双12” （12月12日）则这件衣服打8折，
    // 如果有优惠券可以额外减50元（优惠券只能在双11或双12使用），求KiKi最终所花的钱数。
    //输入描述:
    //一行，四个数字，第一个数表示小明看中的衣服价格，第二和第三个整数分别表示当天的月份、当天的日期、第四个整数表示是否有优惠券（有优惠券用1表示，
    // 无优惠券用0表示）。
    //输出描述:
    //一行，小明实际花的钱数（保留两位小数）。（提示：不要指望商家倒找你钱）
    //输入
    //1000.0 11 11 1
    //输出
    //650.00
    public static double Money(){
        Scanner input=new Scanner(System.in);
        double M=input.nextDouble();
        int month=input.nextInt();
        int Day=input.nextInt();
        int YH=input.nextInt();
       if(month==Day){
           if(month==12){
               if(M*0.8-YH*50>=0.00)
               return M*0.8-YH*50;
               else return 0;
           }else{
               if(M*0.7-YH*50>=0.00)
               return M*0.7-YH*50;
               else return 0;
           }
       }else{
           return M;
       }
    }
    //题目描述
    //变种水仙花数 - Lily Number：把任意的数字，从中间拆分成两个数字，比如1461 可以拆分成（1和461）,（14和61）,（146和1),如果所有拆分后的乘积之和等于自身，则是一个Lily Number。
    //655 = 6 * 55 + 65 * 5
    //1461 = 1*461 + 14*61 + 146*1
    //求出 5位数中的所有 Lily Number。
    //一行，5位数中的所有 Lily Number，每两个数之间间隔一个空格。
    public static void Lily(){
        for(int i=10000;i<100000;++i){
        int sum=0;
        for(int j=1;j<5;++j){
            sum+=(i%((int)Math.pow(10,j)))*(i/((int)Math.pow(10,j)));
        }
        if(sum==i){
            System.out.print(i+" ");
        }
    }
        System.out.println();
    }
    //期中考试开始了，大家都想取得好成绩，争夺前五名。从键盘输入n个学生成绩（不超过40个），输出每组排在前五高的成绩。
    public static void Socre(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]num=new int [40];
        Arrays.fill(num,0);
        for(int i=0;i<n;++i){
           num[i]=input.nextInt();
        }
        Arrays.sort(num);
        for(int i=39;i>34;--i){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
