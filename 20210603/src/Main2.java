/**
 * @author:飞哥
 * @date: 2021/6/3 8:40
 */

import java.util.Arrays;

/**
 * 选择排序
 * **/
public class Main2 {
    public static void xZ(int[]num,int size){
        for(int i=1;i<size;++i){
            int index=0;
            for(int j=1;j<=size-i;++j){
                if(num[index]<num[j]){
                    index=j;
                }
            }
            int tmp=num[index];
            num[index]=num[size-i];
            num[size-i]=tmp;
        }
    }
    public static void show(int[]num){
        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        int[]num=new int[]{2,8,1,5,0,6,7,3,1};
        System.out.print("选择排序前:");
        show(num);
        System.out.print("选择排序后:");
        xZ(num,9);
        show(num);
    }
}
