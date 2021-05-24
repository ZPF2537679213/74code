/**
 * @author:飞哥
 * @date: 2021/4/26 20:19
 */
import java.util.*;
interface Description{
    public  int iConverDateToDay(int year,int month,int day);
    public int getOutDay();
}
public class Main implements Description{
    public  int iConverDateToDay(int year,int month,int day){
        int sumday=0;
        if(month>12||day>31){
            return -1;
        }
        int[]mon=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<month;++i){
            sumday+=mon[i];
        }
        sumday+=day;
        if(month>2&&((year%4==0&&year%100!=0)||year%400==0)){
            sumday++;
        }
        return sumday;
    }
    public int getOutDay(){
        Scanner input=new Scanner(System.in);
        int year=input.nextInt();
        int month=input.nextInt();
        int day=input.nextInt();
        return iConverDateToDay(year,month,day);
    }
    public static void main(String[]args){
        Main main=new Main();
        System.out.println(main.getOutDay());
    }
}