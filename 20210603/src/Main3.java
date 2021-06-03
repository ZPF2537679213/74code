/**
 * @author:飞哥
 * @date: 2021/6/3 9:23
 */

import java.util.Arrays;

/**
 * 插入排序
 * **/
public class Main3 {
    public static void insertSort(int[]num,int size){
        for(int i=1;i<size;++i){
           int tmp=num[i];
          int j=i-1;
          while(j>=0&&num[j]>tmp){
              num[j+1]=num[j];
              j--;
          }
          num[j+1]=tmp;
        }
    }
    public static void show(int[]num){
        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        int[]num=new int[]{2,8,1,5,0,6,7,3,1};
        System.out.print("插入排序前:");
        show(num);
        System.out.print("插入排序后:");
        insertSort(num,9);
        show(num);
    }
}
