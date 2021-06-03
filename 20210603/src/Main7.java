/**
 * @author:飞哥
 * @date: 2021/6/3 12:31
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序
 * **/
public class Main7 {
    public static void quickSort(int[]num,int start,int end){//快排递归
        if(start>=end){
            return;
        }
        int left=start;
        int right=end;
        int tmp=num[start];
        while(left<right){
            while(right>left&&num[right]>=tmp){
                right--;
            }
            num[left]=num[right];
            while(right>left&&num[left]<=tmp){
                left++;
            }
            num[right]=num[left];
        }
        num[left]=tmp;
        quickSort(num,start,left-1);
        quickSort(num,left+1,end);
    }
    public static void quickSort2(int[]num,int start,int end){
        Stack<Integer>stack=new Stack<>();
        stack.push(start);
        stack.push(end);
        while (!stack.isEmpty()){
            end=stack.pop();
            start=stack.pop();
            int left=start;
            int right=end;
            int tmp=num[start];
            while(left<right){
                while(right>left&&num[right]>=tmp){
                    right--;
                }
                num[left]=num[right];
                while(right>left&&num[left]<=tmp){
                    left++;
                }
                num[right]=num[left];
            }
            num[left]=tmp;
            if(left-1>start){
                stack.push(start);
                stack.push(left-1);
            }
            if(left+1<end){
                stack.push(left+1);
                stack.push(end);
            }
        }
    }
    public static void main(String[] args) {
        int[]num=new int[]{1,9,18,7,0,6,5,-4,-3,2};
        System.out.println("快排之前："+ Arrays.toString(num));
        quickSort(num,0,9);
        System.out.println("快排之后："+Arrays.toString(num));
    }
}
