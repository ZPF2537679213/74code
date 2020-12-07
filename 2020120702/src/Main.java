import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // System.out.println(PS());
        //SJ();
        //Genius();
        //Perfect();
        //JO();
        //YY();
        BL();
    }
    //题目描述
    //假设你们社团要竞选社长，有两名候选人分别是A和B，社团每名同学必须并且只能投一票，最终得票多的人为社长.
    //输入描述:
    //一行，字符序列，包含A或B，输入以字符0结束。
    //输出描述:
    //一行，一个字符，A或B或E，输出A表示A得票数多，输出B表示B得票数多，输出E表示二人得票数相等。
    //输入
    //ABBABBAAB0
    //输出
    //B
    public static char PS(){
    Scanner input=new Scanner(System.in);
    String str=input.next();
    int count1=0,count2=0;
    for(int i=0;i<str.length()&&str.charAt(i)!='0';++i){
        if(str.charAt(i)=='A'){
            count1++;
        }else{
            count2++;
        }
    }
    if(count1==count2){
        return 'E';
    }else if(count1>count2){
        return 'A';
    }else{
        return 'B';
    }
    }
    //输入描述:
    //题目有多组输入数据，每一行输入三个a，b，c(0<a,b,c<1000)，作为三角形的三个边，用空格分隔。
    //输出描述:
    //针对每组输入数据，输出占一行，如果能构成三角形，等边三角形则输出“Equilateral triangle!”，等腰三角形则输出“Isosceles triangle!”，
    // 其余的三角形则输出“Ordinary triangle!”，反之输出“Not a triangle!”。
    public static void SJ(){
        Scanner input=new Scanner(System.in);
        String []str=new String[1000];
        int i=0;
        while(input.hasNextInt()){
            int a=input.nextInt();
            int b=input.nextInt();
            int c=input.nextInt();
           if(a+b>c){
               if(a==b&&b==c){
                   str[i]="Equilateral triangle!";
               }else if(a==b||a==c||b==c){
                   str[i]="Isosceles triangle!";
               }else{
                   str[i]="Ordinary triangle!";
               }
           } else{
               str[i]="Not a triangle!";
           }
           i++;
        }
       for(int j=0;j<i;++j){
           System.out.println(str[j]);
       }
        System.out.println();
    }
    //题目描述
    //据说智商140以上者称为天才，KiKi想知道他自己是不是天才，请帮他编程判断。输入一个整数表示一个人的智商，如果大于等于140，则表明他是一个天才，输出“Genius”。
    //输入描述:
    //多组输入，每行输入包括一个整数表示的智商。
    //输出描述:
    //针对每行输入，输出“Genius”。
    //输入
    //160
    //输出
    //Genius
    public static void Genius(){
        Scanner input=new Scanner(System.in);
        String []str=new String[1000];
        int i=0;
        while(input.hasNextInt()){
            int G=input.nextInt();
            if(G>=140){
                str[i]="Genius";
                i++;
            }
        }
        for(int j=0;j<i;++j){
            System.out.println(str[j]);
        }
        System.out.println();
        input.close();
    }
    //KiKi想知道他的考试成绩是否完美，请帮他判断。从键盘输入一个整数表示的成绩，编程判断成绩是否在90~100之间，如果是则输出“Perfect”。
    //输入描述:
    //多组输入，每行输入包括一个整数表示的成绩（90~100）。
    //输出描述:
    //针对每行输入，输出“Perfect”。
    //输入
    //98
    //输出
    //Perfect
    public static void Perfect(){
        Scanner input=new Scanner(System.in);
        String []str=new String[1000];
        int i=0;
        while(input.hasNextInt()){
            int G=input.nextInt();
            if(G>=90&&G<=100){
                str[i]="Perfect";
                i++;
            }
        }
        for(int j=0;j<i;++j){
            System.out.println(str[j]);
        }
        System.out.println();
        input.close();
    }
    //KiKi想知道一个整数的奇偶性，请帮他判断。从键盘任意输入一个整数（范围-231~231-1），编程判断它的奇偶性。
    //输入描述:
    //多组输入，每行输入包括一个整数。
    //输出描述:
    //针对每行输入，输出该数是奇数（Odd）还是偶数（Even）。
    public static void JO(){
        Scanner input=new Scanner(System.in);
        String []str=new String[1000];
        int i=0;
        while(input.hasNextInt()){
            int G=input.nextInt();
            if(G%2!=0){
                str[i]="Odd";
            }else{
                str[i]="Even";
            }
            i++;
        }
        for(int j=0;j<i;++j){
            System.out.println(str[j]);
        }
        System.out.println();
        input.close();
    }
    //KiKi开始学习英文字母，BoBo老师告诉他，有五个字母A(a), E(e), I(i), O(o),U(u)称为元音，其他所有字母称为辅音，请帮他编写程序判断输入的字母
    // 是元音（Vowel）还是辅音（Consonant）。
    //输入描述:
    //多组输入，每行输入一个字母。
    //输出描述:
    //针对每组输入，输出为一行，如果输入字母是元音（包括大小写），输出“Vowel”，如果输入字母是非元音，输出“Consonant”。
    public static void YY(){
        Scanner input=new Scanner(System.in);
        String []str=new String[1000];
        int i=0;
        while(input.hasNext()){
            String G=input.next();
           char c=G.charAt(0);
           if(c=='A'||c=='a'||c=='E'||c=='e'||c=='I'||c=='i'||c=='O'||c=='o'||c=='U'||c=='u'){
               str[i]="Vowel";
           }else{
               str[i]="Consonant";
           }
            i++;
        }
        for(int j=0;j<i;++j){
            System.out.println(str[j]);
        }
        System.out.println();
        input.close();
    }
    //KiKi想知道从键盘输入的两个数的大小关系，请编程实现。
    //输入描述:
    //题目有多组输入数据，每一行输入两个整数（范围（1 ~231-1），用空格分隔。
    //输出描述:
    //针对每行输入，输出两个整数及其大小关系，数字和关系运算符之间没有空格，详见输入输出样例。
    //输入
    //1 1
    //输出
    //1=1
   public static void BL(){
       Scanner input=new Scanner(System.in);
       while(input.hasNextInt()){
           int a=input.nextInt();
           int b=input.nextInt();
           if(a>b){
               System.out.println(a+">"+b);
           }else if(a<b){
           System.out.println(a+"<"+b);
           }else{
               System.out.println(a+"="+b);
           }
       }
       input.close();
   }
}
