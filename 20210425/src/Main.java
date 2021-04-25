import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/4/25 17:22
 */
public class Main {
}
/*
* 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。

给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-center-of-star-graph
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int findCenter(int[][] edges) {
        if(edges==null){
            return -1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<edges.length;++i){
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0],1);
            }else{
                map.put(edges[i][0],map.get(edges[i][0])+1);
            }
            if(!map.containsKey(edges[i][1])){
                map.put(edges[i][1],1);
            }else{
                map.put(edges[i][1],map.get(edges[i][1])+1);
            }
        }
        for(int x:map.keySet()){
            if(map.get(x)==edges.length){
                return x;
            }
        }
        return -1;
    }
}
/*
* 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
示例 1:
输入: 2
输出: [0,1,1]
示例 2:
输入: 5
输出: [0,1,1,2,1,2]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/counting-bits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int[] countBits(int num) {
        int[]nums=new int[num+1];
        /*for(int i=0;i<=num;++i){
            nums[i]=nums[i>>1]+(i&1);//当前i的值与右移一位后i的值的大小关系取决于i的最后一位是否是1，是1就加一，否则相等
        }*/
        for(int i=1;i<=num;++i){
            nums[i]=nums[i&(i-1)]+1;
        }
        return nums;
    }
}
/*
* 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
示例 1：
输入：groupSizes = [3,3,3,3,3,1,3]
输出：[[5],[0,1,2],[3,4,6]]
解释：
其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<groupSizes.length;++i){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i],new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        for(int x:map.keySet()){
            while(map.get(x).size()!=0){
                List<Integer>ll=new ArrayList<>();
                while(ll.size()<x){
                    int y=map.get(x).get(0);
                    ll.add(y);
                    map.get(x).remove(0);
                }
                list.add(new ArrayList<>(ll));
            }
        }
        return list;
    }
}
/*
* 输入一个链表，反转链表后，输出新链表的表头。*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution4 {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
/*
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/

class Solution5 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null&&list2!=null){
            return list2;
        }
        if(list1!=null&&list2==null){
            return list1;
        }
        ListNode newHead=new ListNode(-1);
        ListNode cur=newHead;
        while(list1!=null&&list2!=null){
            if(list1.val>=list2.val){
                cur.next=list2;
                list2=list2.next;
            }else{
                cur.next=list1;
                list1=list1.next;
            }
            cur=cur.next;
        }
        cur.next=list1==null?list2:list1;
        return newHead.next;
    }
}
