import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:飞哥
 * @date: 2021/6/3 13:29
 */
public class Main8 {
    public static void cardinalSort(int[]num,int size,int maxSize){
        ArrayList<ArrayList<Integer>>list=new ArrayList<>(10);
        for(int i=0;i<10;++i){
            list.add(new ArrayList<>());
        }
        int k=0;
        while(k<maxSize){
            for(int i=0;i<size;++i){
                int n=(num[i]/(int)Math.pow(10,k))%10;
                if(list.get(n)==null){
                    list.set(n,new ArrayList<>());
                }
                list.get(n).add(num[i]);
            }
            k++;
            int t=0;
            for(int i=0;i<10;++i){
                if(list.get(i)!=null){
                    for(int x:list.get(i)){
                        num[t++]=x;
                    }
                    list.get(i).clear();
                }
            }
        }
    }
    public static void main(String[] args) {
        int[]num=new int[]{1,190,8,7,10,6,5,40,3,2};
        System.out.println("基数排序之前："+ Arrays.toString(num));
        cardinalSort(num,10,3);
        System.out.println("基数排序之后："+Arrays.toString(num));
    }
}
