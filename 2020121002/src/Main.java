import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //XSD();
        //ZD();
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 20, 10}));
    }
    //题目描述
    //给出两幅相同大小的黑白图像（用0-1矩阵）表示，求它们的相似度。若两幅图像在相同位置上的像素点颜色相同，则称它们在该位置具有相同的像素点。两幅图像的
    // 相似度定义为相同像素点数占总像素点数的百分比。
    //输入描述:
    //第一行包含两个整数m和n，表示图像的行数和列数，用单个空格隔开。1≤m≤100, 1≤n≤100。之后m行，每行n个整数0或1，表示第一幅黑白图像上各像素点的颜色，
    // 相邻两个数用单个空格隔开。之后m行，每行n个整数0或1，表示第二幅黑白图像上各像素点的颜色，相邻两个数用单个空格隔开。
    //输出描述:
    //一个实数，表示相似度(以百分比的形式给出)，精确到小数点后两位。
    public static void XSD(){
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        int n=input.nextInt();
        int num[][]=new int[m][n];
        int count=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                num[i][j]=input.nextInt();
            }
        }
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                int x=input.nextInt();
                if((x==num[i][j])){
                    count++;
                }
            }
        }
        System.out.printf("%.2f",count/(double)(m*n)*100);
    }//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
    //顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
    //每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
    //注意，一开始你手头没有任何零钱。
    //如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
        public static boolean lemonadeChange(int[] bills) {
            int five=0,ten=0;
            for(int x:bills){
                if(x==5){
                    five++;
                }else{
                    if(x==10&&five!=0){
                        ten++;
                        five--;
                    }else if(x==20&&(ten!=0&&five!=0)){
                        ten--;
                        five--;
                    }else if(x==20&&(five>=3&&ten==0)){
                        five-=3;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
}
