import java.util.Scanner;
import java.util.Arrays;
public class Main {
    //private int count;
    public static void main(String[] args) {
        /*String s;
        System.out.println(s);//报错*/
        //static int i = 0;//报错
   //Main text=new Main(88);
      //  System.out.println(text.count);
      /*int []num={1,2,3,4,5,6,7,8,9,10};
        numJ(num);
        System.out.println(Arrays.toString(num));*/
        int[]num1={1,3,5,7,9};
        int[]num2={2,4,6,8,10};
        exchangeNum(num1,num2);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }
    //Main(int a){
    //    count=a;
    //}
    //给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
    public static void numJ(int []num){
        int i,j;
        boolean flag=true;
      for(i=0;i<num.length;++i){
          if(num[i]%2!=0){
              for(j=i;j<num.length;++j){
                if(num[j]%2==0){
                    num[i]^=num[j];
                    num[j]^=num[i];
                    num[i]^=num[j];
                    flag=false;
                    break;
                }
              }
              if(flag==true){
                 break;
              }
          }
      }
    }
    //给定两个整型数组, 交换两个数组的内容.
    public static void exchangeNum(int[]num1,int[]num2){
       for(int i=0;i<num1.length;++i){
           num1[i]^=num2[i];
           num2[i]^=num1[i];
           num1[i]^=num2[i];
       }
    }
}
