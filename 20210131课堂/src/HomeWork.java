import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HomeWork {

}
//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
//
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
//
//找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
//
//示例 1:
//
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//示例 2:
//
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//示例 3:
//
//输入: nums1 = [1,2], nums2 = [3], k = 3
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>>list=new ArrayList<>();
        PriorityQueue<List<Integer>>qu=new PriorityQueue<>(Comparator.comparing(o->o.get(0)+o.get(1)));
        PriorityQueue<List<Integer>>queue=new PriorityQueue<>(k,new Comparator<List<Integer>>(){
            public int compare(List<Integer>nums1,List<Integer>nums2){
                return -nums1.get(0)-nums1.get(1)+nums2.get(0)+nums2.get(1);
            }
        });
        for(int i=0;i<nums1.length;++i){
            for(int j=0;j<nums2.length;++j){
                List<Integer> arr=new ArrayList<>();
                if(k>0){
                    arr.add(nums1[i]);
                    arr.add(nums2[j]);
                    queue.offer(arr);
                    k--;
                }else{
                    List<Integer> n=queue.peek();
                    if(nums1[i]+nums2[j]<n.get(0)+n.get(1)){
                        arr.add(nums1[i]);
                        arr.add(nums2[j]);
                        queue.poll();
                        queue.offer(arr);
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            List<Integer>num=queue.poll();
            list.add(num);
        }
        return list;
    }
}