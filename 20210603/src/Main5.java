/**
 * @author:飞哥
 * @date: 2021/6/3 10:23
 */

import java.util.Arrays;

/**
 * 归并排序
 * **/
public class Main5 {
    public static void gb(int[]num,int start,int end){//递归版本
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        gb(num,start,mid);
        gb(num,mid+1,end);
        int[]index=new int[end-start+1];
        int k=0;
        int left1=mid+1;
        int left2=start;
        while(left2<=mid&&left1<=end){
            if(num[left2]<num[left1]){
                index[k++]=num[left2++];
            }else{
                index[k++]=num[left1++];
            }
        }
        while(left2<=mid){
            index[k++]=num[left2++];
        }
        while(left1<=end){
            index[k++]=num[left1++];
        }
        for (int i = 0; i < k; i++) {
            num[start+i]=index[i];
        }
    }
    public static void gb2(int[]num,int index){//非递归
        int left1=0;
        int right1=index;
        int left2=index+1;
        int right2=left2+index>=num.length?num.length-1:left2+index;
        while(left1<=right1&&left2<=right2&&right2<num.length){
            int[]nn=new int[right2-left1+1];
            int k=0;
            int left=left1;
            while(left1<=right1&&left2<=right2){
               if(num[left1]<num[left2]){
                   nn[k++]=num[left1++];
               } else{
                   nn[k++]=num[left2++];
               }
            }
            while(left1<=right1){
                nn[k++]=num[left1++];
            }
            while(left2<=right2){
                nn[k++]=num[left2++];
            }
            for(int i=0;i<k;++i){
                num[left+i]=nn[i];
            }
            left1=right2+1;
            right1=left1+index;
            left2=right1+1;
            right2=left2+index>=num.length?num.length-1:left2+index;
        }
    }
    public static void show(int[]num){
        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        int[]num=new int[]{10,9,8,70,600,512,-4,3,2};
        System.out.print("归并排序前:");
        show(num);
        System.out.print("归并排序后:");
        gb(num,0,8);
        show(num);
    }

    public static void main1(String[] args) {
        int[]num=new int[]{10,19,80,70,6,5,40,3,2};
        System.out.print("归并排序前:");
        show(num);
        System.out.print("归并排序后:");
        for(int i=0;i<9;++i){
            gb2(num,i);
        }
        show(num);
    }
}
