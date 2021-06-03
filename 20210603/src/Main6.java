/**
 * @author:飞哥
 * @date: 2021/6/3 11:31
 */

import java.util.Arrays;

/**
 * 堆排序
 * **/
public class Main6 {
    public static void adjustDown(int[]num,int parent,int size){//向下调整
        int child=parent*2+1;
        while(child<size){
            if(child+1<size&&num[child+1]>num[child]){
                child++;
            }
            if(num[parent]<num[child]){
                int tmp=num[parent];
                num[parent]=num[child];
                num[child]=tmp;
            }else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }
    public static void adjustUp(int[]num,int child){//向上调整，建堆插入元素的时候用
        int parent=(child-1)/2;
        while(parent>0){
            if(num[parent]<num[child]){
                int tmp=num[parent];
                num[parent]=num[child];
                num[child]=tmp;
            }else{
                break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }
    public static void heapSort(int[]num,int size){
        int len=size-1;
        while(len>0){
            int tmp=num[0];
            num[0]=num[len];
            num[len]=tmp;
            adjustDown(num,0,len--);
        }
    }
    public static void main(String[] args) {
        int[]num=new int[]{1,18,-800,-7,0,6,5,-40,3,2};
        System.out.println("堆排之前："+Arrays.toString(num));
        for(int i=1;i<=10;++i){//构建大根堆
            adjustDown(num,0,i);
            adjustUp(num,i-1);
        }
        heapSort(num,10);
        System.out.println("堆排之后："+Arrays.toString(num));
    }
}
