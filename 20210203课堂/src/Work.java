import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Work {

}
//给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//整数 a 比整数 b 更接近 x 需要满足：
//|a - x| < |b - x| 或者
//|a - x| == |b - x| 且 a < b
//示例 1：
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
//示例 2：
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null){
            return null;
        }
        arr= Arrays.copyOf(arr,arr.length+1);
        List<Integer> list=new LinkedList<>();
        int i=insert(arr,x);
        int start=i-1;
        int end=i+1;
        while(k>0){
            if(start>=0&&end<arr.length){
                if(x-arr[start]>arr[end]-x){
                    list.add(arr[end++]);
                }else{
                    list.add(arr[start--]);
                }
                k--;
            }else{
                if(start<0&&end<arr.length){
                    list.add(arr[end++]);
                }else{
                    list.add(arr[start--]);
                }
                k--;
            }
        }
        Collections.sort(list);
        return list;
    }
    public int insert(int[]arr,int x){
        int i,j;
        for(i=0;i<arr.length-1;++i){
            if(arr[i]>x){
                for(j=arr.length-2;j>=i;--j){
                    arr[j+1]=arr[j];
                }
                break;
            }
        }
        arr[i]=x;
        return i;
    }
}