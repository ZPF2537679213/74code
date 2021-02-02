import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class Main {
    //直接插入排序
    public static void insertSort(int[] array) {
        int i,j;
    for(i=1;i<array.length;++i){
        int tmp=array[i];
        for(j=i-1;j>=0;--j){
            if(array[j]>tmp){
                array[j+1]=array[j];
            }else{
                break;
            }
        }
        array[j+1]=tmp;
    }
    }

    public static void main(String[] args) {
        int[] array = {10,3,2,7,19,78,65,127};
        shellSort(array);
        System.out.println(Arrays.toString(array));
        //insertSort(array);
        //System.out.println(Arrays.toString(array));
    }
    //希尔排序
    public static void shell(int[] array ,int gap) {
        int i,j;
    for(i=gap;i<array.length;++i){
        int tmp=array[i];
        for(j=i-gap;j>=0;j-=gap){
            if(array[j]>tmp){
                array[j+gap]=array[j];
            }else{
                break;
            }
        }
        array[j+gap]=tmp;
    }
    }
    public static void shellSort(int[] array) {
        int[] drr = {7,5,1};//增量数组

        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    //选择排序
    public static void selectSort(int[] array) {
for(int i=0;i<array.length;++i){
    for(int j=i+1;j<array.length;++j){
        if(array[j]<array[i]){
            int tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }
    }
}
    }
}
