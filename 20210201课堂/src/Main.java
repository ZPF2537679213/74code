import java.util.Arrays;
import java.util.Stack;

public class Main {
    //直接插入排序
    public static void insertSortBount(int[] array,int low,int high) {
        Arrays.sort(array);
     int i,j;
     for(i=1;i<=high;++i){
         int tmp=array[i];
         for(j=i-1;j>=low;--j){
             if (array[j] > tmp) {
                 array[j + 1] = array[j];
             } else {
                 break;
             }
         }
         array[j + 1] = tmp;
     }
    }
    public static void insertSort(int[] array) {
        int i, j;
        for (i = 1; i < array.length; ++i) {
            int tmp = array[i];
            for (j = i - 1; j >= 0; --j) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 3, 2, 7, 19, 78, 65, 127};
        guiBing(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        //insertSort(array);
        //System.out.println(Arrays.toString(array));
    }

    //希尔排序
    public static void shell(int[] array, int gap) {
        int i, j;
        for (i = gap; i < array.length; ++i) {
            int tmp = array[i];
            for (j = i - gap; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {7, 5, 1};//增量数组

        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length-1;
        int piv = pivot(array,low,high);//
        if(piv > low + 1) {
            stack.push(low);
            stack.push(piv-1);
        }
        if(piv < high-1) {
            stack.push(piv+1);
            stack.push(high);
        }
        while (!stack.empty()) {
            high=stack.pop();
            low=stack.pop();
            piv = pivot(array,low,high);
            if(piv > low + 1) {
                stack.push(low);
                stack.push(piv-1);
            }
            if(piv < high-1) {
                stack.push(piv+1);
                stack.push(high);
            }
        }
    }
    public static int pivot(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end--;
            }
            //把数据赋值给start
            array[start] = array[end];
            while (start < end && array[start] < tmp) {
                start++;
            }
            //把start下标的值给end
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }

    public static void Kuaipai(int[] arr, int low, int high) {
        if (low < high) {
            int piv = pivot(arr, low, high);
            Kuaipai(arr, low, piv - 1);
            Kuaipai(arr, piv + 1, high);
        }
    }
    //归并排序
    public static void guiBing(int[]array,int low,int high){
    if(low>=high){
        return;
    }
    int mid=(low+high)/2;
        guiBing(array,low,mid);
        guiBing(array,mid+1,high);
        sort(array,low,mid,high);
    }
    public static void sort(int[]array,int low,int mid,int high){
        int s1=low;
        int s2=mid+1;
        int []tmp=new int[high-low+1];
        int k=0;
        while(s1<=mid&&s2<=high){
            if(array[s1]<=array[s2]){
                tmp[k++]=array[s1++];
            }else{
                tmp[k++]=array[s2++];
            }
        }
        while(s1<=mid){
            tmp[k++]=array[s1++];
        }
        while(s2<=high){
            tmp[k++]=array[s2++];
        }
        for(int i=0;i<tmp.length;++i){
            array[i+low]=tmp[i];
        }
    }
}
