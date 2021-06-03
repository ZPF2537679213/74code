/**
 * @author:飞哥
 * @date: 2021/6/3 8:12
 */
/**
 * 冒泡排序
 * **/
import java.util.Arrays;
public class Main {
    public static void mP(int[]num,int size){
        for(int i=1;i<size;++i){
            boolean flag=true;
            for(int j=0;j<size-i;++j){
                if(num[j]>num[j+1]){
                    int tmp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=tmp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    public static void show(int[]num){
        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        int[]num=new int[]{2,8,1,5,6,7,3};
        System.out.print("冒泡排序前:");
        show(num);
        System.out.print("冒泡排序后:");
        mP(num,7);
        show(num);
    }
}
