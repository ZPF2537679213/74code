/**
 * @author:飞哥
 * @date: 2021/6/3 14:28
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 * */
public class Main9 {
    public static void bucketSort(int[]num,int size,int max,int min){
        ArrayList<ArrayList<Integer>>list=new ArrayList<>((max-min)/size+1);
        for(int i=0;i<(max-min)/size+1;++i){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<size;++i){
            list.get((num[i]-min)/size).add(num[i]);
        }
        int k=0;
        for(int i=0;i<(max-min)/size+1;++i){
            Collections.sort(list.get(i));
            for(int x:list.get(i)){
                num[k++]=x;
            }
        }
    }
    public static void main(String[] args) {
        int[]num=new int[]{1,90,8,7,10,-6,5,40,3,2};
        System.out.println("桶排序之前"+ Arrays.toString(num));
        bucketSort(num,10,90,-6);
        System.out.println("桶排序之后："+Arrays.toString(num));
    }
}
