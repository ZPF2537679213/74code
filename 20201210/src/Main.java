import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //System.out.printf("%.2f",avg());
        //System.out.printf("%.2f",sum());
        //int[]num={1,2,3};
       /* String str= Arrays.toString(num);
        System.out.println(str);
        transform(num);
        str= Arrays.toString(num);
        System.out.println(str);*/
        //printArray(num);
        int[]num=sz();
        System.out.println(Arrays.toString(num));
    }
    //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
    public static double avg(){
        Scanner input=new Scanner(System.in);
        double[]sz=new double[300];
        System.out.println("请输入数组长度：");
        int x=input.nextInt();
        double sum=0;
        for(int i=0;i<x;++i){
            sz[i]=input.nextDouble();
            sum+=sz[i];
        }
       return sum/x;
    }
    //实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
    public static double sum(){
        Scanner input=new Scanner(System.in);
        double[]sz=new double[300];
        System.out.println("请输入数组长度：");
        int x=input.nextInt();
        double sum=0;
        for(int i=0;i<x;++i){
            sz[i]=input.nextDouble();
            sum+=sz[i];
        }
        return sum;
    }
    //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static void transform(int []num){
        for(int i=0;i<num.length;++i){
            num[i]=num[i]*2;
        }
    }
    //实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
    public static void printArray(int []num){
        for(int i=0;i<num.length;++i){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
    //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
    public static int[] sz(){
       int[]num=new int[100];
       for(int i=0;i<100;++i){
           num[i]=i+1;
       }
       return num;
    }
}

