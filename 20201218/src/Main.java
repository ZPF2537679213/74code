import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //time();
        //dT();
        //sum();
        changeNum();
    }
    //题目描述
    //小乐乐比较懒惰，他现在想睡觉，然后再去学习。他知道现在的时刻，以及自己要睡的时长，想设定一个闹钟叫他起床学习，但是他太笨了，不知道应该把闹钟设
    //定在哪个时刻，请你帮助他。(只考虑时和分，不考虑日期)
    //输入描述:
    //输入现在的时刻以及要睡的时长k（单位：minute），中间用空格分开。
    //输入格式：hour:minute k(如hour或minute的值为1，输入为1，而不是01)
    //(0 ≤ hour ≤ 23，0 ≤ minute ≤ 59，1 ≤ k ≤ 109)
    //输出描述:
    //对于每组输入，输出闹钟应该设定的时刻，输出格式为标准时刻表示法（即时和分都是由两位表示，位数不够用前导0补齐）。
    public static void time(){
        Scanner input=new Scanner(System.in);
        String str=input.next();
        String []s=str.split(":");
        int hour=Integer.valueOf(s[0]);
        int minute=Integer.valueOf(s[1]);
        int k=input.nextInt();
        hour+=k/60;
        minute+=k%60;
        hour=(hour+minute/60)%24;
        minute%=60;

        if(hour<10&&minute<10){
            System.out.println("0"+hour+":"+"0"+minute);
        }else{
            if(hour>10&&minute>10){
            System.out.println(hour+":"+minute);
             }else if(hour<10&&minute>10){
                System.out.println("0"+hour+":"+minute);
            }else{
                System.out.println(hour+":"+"0"+minute);
            }
        }
    }
    //题目描述
    //小乐乐学校教学楼的电梯前排了很多人，他的前面有n个人在等电梯。电梯每次可以乘坐12人，每次上下需要的时间为4分钟（上需要2分钟，下需要2分钟）。请
    // 帮助小乐乐计算还需要多少分钟才能乘电梯到达楼上。（假设最初电梯在1层）
    //输入描述:
    //输入包含一个整数n (0 ≤ n ≤ 109)
    //输出描述:
    //输出一个整数，即小乐乐到达楼上需要的时间。
    public static void dT(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int time=0;
       time=(n/12)*4+2;
        System.out.println(time);
    }
    //题目描述
    //小乐乐最近在课上学习了如何求两个正整数的最大公约数与最小公倍数，但是他竟然不会求两个正整数的最大公约数与最小公倍数之和，请你帮助他解决这个问题。
    //输入描述:
    //每组输入包含两个正整数n和m。(1 ≤ n ≤ 109，1 ≤ m ≤ 109)
    //输出描述:
    //对于每组输入，输出一个正整数，为n和m的最大公约数与最小公倍数之和。
    public static void sum(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        if(n<m){
            n^=m;
            m^=n;
            n^=m;
        }
        int b=0,l=n%m;
        for(int i=1;i<=m;++i){
            if(n%i==0&&m%i==0){
                b=i;
            }
        }
       for(int i=n;;++i){
           if(i%n==0&&i%m==0){
               l=i;
               break;
           }
       }
        System.out.println(b+l);
    }
    //题目描述
    //小乐乐喜欢数字，尤其喜欢0和1。他现在得到了一个数，想把每位的数变成0或1。如果某一位是奇数，就把它变成1，如果是偶数，那么就把它变成0。请你回答他
    // 最后得到的数是多少。
    //输入描述:
    //输入包含一个整数n (0 ≤ n ≤ 109)
    //输出描述:
    //输出一个整数，即小乐乐修改后得到的数字。
    public static void changeNum(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        while(n!=0){
            if((n%10)%2==0){
                System.out.print(0);
            }else{
                System.out.print(1);
            }
            n/=10;
        }
    }
}
