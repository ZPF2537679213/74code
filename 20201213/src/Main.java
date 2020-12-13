import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int []num={1,2,3,4,5,6,7,8};
        //mySort(num);
        //System.out.println(Arrays.toString(num));
        //System.out.println(isSort(num));
        //int []n=myCopy(num,8);
        //System.out.println(Arrays.toString(n));
        //System.out.println(myBinarySearch(num, 3));
        System.out.println(myToString(num));
    }
    //给定一个整型数组, 实现冒泡排序(升序排序)
    public static void mySort(int []num){
        for(int i=1;i<num.length;++i){
            boolean flag=false;
            for(int j=0;j<num.length-i;++j){
                if(num[j]>num[j+1]){
                    int tmp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=tmp;
                    flag=true;
                }
            }
            if(flag==false){
                return;
            }
        }
    }
    //给定一个整型数组, 判定数组是否有序（递增）
    public static boolean isSort(int[]num){
      for(int i=0;i<num.length-1;++i){
          if(num[i]>num[i+1]){
            return false;
          }
      }
      return true;
    }
    //给定一个有序整型数组, 实现二分查找
    public static int myBinarySearch(int []num,int key){
      int start=0;
      int end=num.length-1;
      int mid;
      while(start<=end){
         mid=(start+end)>>2;
         if(num[mid]==key){
             return mid;
         }else if(num[mid]>key){
             end=mid-1;
         }else{
             start=mid+1;
         }
      }
      return -1;
    }
    //实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
    public static int[] myCopy(int []num,int len){
        int []n=new int[len];
        for(int i=0;i<len;++i){
            n[i]=num[i];
        }
        return n;
    }
    //实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
    public static String myToString(int []num){
        String str="[";
        for(int i=0;i<num.length;++i){
            str+=num[i];
            if(i!=num.length-1){
                str+=", ";
            }
        }
        str+="]";
        return str;
    }
}
