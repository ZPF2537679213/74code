import java.util.*;

/**
 * @author:飞哥
 * @date: 2021/5/3 17:50
 */
public class Main {
}
/*
n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
每 3 个士兵可以组成一个作战单位，分组规则如下：
从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
示例 1：
输入：rating = [2,5,3,4,1]
输出：3
解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
示例 2：
输入：rating = [2,1,3]
输出：0
解释：根据题目条件，我们无法组建作战单位。
示例 3：
输入：rating = [1,2,3,4]
输出：4
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-number-of-teams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int numTeams(int[] rating) {
        int count=0;
        for(int i=0;i<rating.length;++i){
            int[]ileft=group(rating,0,i-1,rating[i]);
            int[]iright=group(rating,i+1,rating.length-1,rating[i]);
            count+=(ileft[0]*iright[1]+ileft[1]*iright[0]);
        }
        return count;
    }
    public int[] group(int[]num,int start,int end,int key){
        int[]resulted=new int[2];
        for(int i=start;i<=end;++i){
            if(num[i]<key){
                resulted[0]++;
            }else{
                resulted[1]++;
            }
        }
        return resulted;
    }
}
/*
牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
现在，重复执行以下步骤，直到显示所有卡牌为止：
从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。
答案中的第一张牌被认为处于牌堆顶部。
示例：
输入：[17,13,11,2,3,5,7]
输出：[2,13,3,11,5,17,7]
解释：
我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
我们显示 17。
由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reveal-cards-in-increasing-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution2 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[]flag=new int[deck.length];
        LinkedList<Integer> queue=new LinkedList<>();
            Arrays.sort(deck);
        for(int i=deck.length-1;i>=0;--i){
            if(queue.isEmpty()){
                queue.offer(deck[i]);
            }else{
                int x=queue.pollLast();
                queue.addFirst(x);
                queue.addFirst(deck[i]);
            }
        }
        for(int i=0;i<deck.length;++i){
            flag[i]=queue.poll();
        }
        return flag;
    }
}
/*
* 如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。
例如，下面这些都是 等差数列 ：
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
下面的数列 不是等差数列 ：
1, 1, 2, 5, 7
给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[i], r[i]] 。所有数组的下标都是 从 0 开始 的。
返回 boolean 元素构成的答案列表 answer 。如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]] 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；否则answer[i] 的值就是 false 。
示例 1：
输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
输出：[true,false,true]
解释：
第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arithmetic-subarrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean>list=new ArrayList<>();
        for(int i=0;i<l.length;++i){
            list.add(trueOrFalse(nums,l[i],r[i]));
        }
        return list;
    }
    public boolean trueOrFalse(int[]nums,int left,int right){
        if(left>right){
            return false;
        }
        int[]nn=Arrays.copyOfRange(nums,left,right+1);
        if(nn.length==0){
            return false;
        }
        Arrays.sort(nn);
        int ch=Integer.MAX_VALUE;
        for(int i=0;i<nn.length-1;++i){
            if(ch==Integer.MAX_VALUE){
                ch=nn[i+1]-nn[i];
            }
            if(nn[i+1]-nn[i]!=ch){
                return false;
            }
        }
        return true;
    }
}
/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
示例1
输入
[4,8,6,12,16,14,10]
返回值
true*/
class Solution4 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return TOrF(sequence,0,sequence.length-1);
    }
    public boolean TOrF(int[]sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int i=start;
        while(i<end&&sequence[i]<sequence[end]){
            i++;
        }
        for(int j=i;j<end;++j){
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
        return TOrF(sequence,start,i-1)&&TOrF(sequence,i,end-1);
    }
}
/*
* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class Solution5 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        RandomListNode root=null;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode cur=pHead;
        while(cur!=null){
            if(!map.containsKey(cur)){
                map.put(cur,new RandomListNode(cur.label));
            }
            cur=cur.next;
        }
        cur=pHead;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(pHead);
    }
}
/*
* 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
示例1
输入
{10,5,12,4,7},22
返回值
[[10,5,7],[10,12]]
示例2
输入
{10,5,12,4,7},15
返回值
[]*/

 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

class Solution6 {
    public ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        path(root,target,0,new ArrayList<>());
        return list;
    }
    public void path(TreeNode root,int target,int sum,ArrayList<Integer>l){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            l.add(root.val);
            if(sum+root.val==target){
                list.add(new ArrayList<>(l));
            }
            l.remove(l.size()-1);
            return;
        }
        if(sum+root.val>target){
            return;
        }
        l.add(root.val);
        path(root.left,target,sum+root.val,l);
        path(root.right,target,sum+root.val,l);
        l.remove(l.size()-1);
    }
}
/*
* 对于如下表actor，其对应的数据为:
actor_id	first_name	last_name	last_update
1	PENELOPE	GUINESS	2006-02-15 12:34:33
2	NICK	WAHLBERG	2006-02-15 12:34:33
请你创建一个actor_name表，并且将actor表中的所有first_name以及last_name导入该表.
actor_name表结构如下：
列表	类型	是否为NULL	含义
first_name	varchar(45)	not null	名字
last_name	varchar(45)	not null	姓氏*/
/**
 * create table actor_name(
 * first_name varchar(45) not null comment '名字',
 * last_name varchar(45) not null comment '姓氏'
 * );
 * insert into actor_name select first_name,last_name from actor;*/
/*
* 针对如下表actor结构创建索引：
(注:在 SQLite 中,除了重命名表和在已有的表中添加列,ALTER TABLE 命令不支持其他操作，
mysql支持ALTER TABLE创建索引)
CREATE TABLE actor  (
   actor_id  smallint(5)  NOT NULL PRIMARY KEY,
   first_name  varchar(45) NOT NULL,
   last_name  varchar(45) NOT NULL,
   last_update  datetime NOT NULL);
对first_name创建唯一索引uniq_idx_firstname，对last_name创建普通索引idx_lastname*/
/**
 * create unique index uniq_idx_firstname on actor(first_name);
 * create index idx_lastname on actor(last_name);*/