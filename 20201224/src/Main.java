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
      int []num={1,2,3,4,5,6,7,8,9,10};
        numJ(num);
        System.out.println(Arrays.toString(num));
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
}
