import java.util.Arrays;

/**
 * @author:飞哥
 * @date: 2021/6/3 9:52
 */
/**
 * 希尔排序
 * **/
public class Main4 {
        public static void xEr(int[]num,int size,int group){
            for(int i=1;i<size;++i){
                int tmp=num[i];
                int j=i-group;
                while(j>=0&&num[j]>tmp){
                    num[j+group]=num[j];
                    j-=group;
                }
                num[j+group]=tmp;
            }
        }
        public static void show(int[]num){
            System.out.println(Arrays.toString(num));
        }
        public static void main(String[] args) {
            int[]num=new int[]{2,8,-1,5,0,6,7,3,1};
            int[]group=new int[]{5,3,1};
            System.out.print("希尔排序前:");
            show(num);
            System.out.print("希尔排序后:");
            for(int x:group){
                xEr(num,9,x);
            }
            show(num);
        }
}
