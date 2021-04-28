import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/4/28 20:52
 */
public class LeetCodeDemo {
}
/*
* 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
Alice 将会取走硬币数量最多的那一堆。
你将会取走硬币数量第二多的那一堆。
Bob 将会取走最后一堆。
重复这个过程，直到没有更多硬币。
给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
返回你可以获得的最大硬币数目。
示例 1：
输入：piles = [2,4,1,2,7,8]
输出：9
解释：选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 7 枚硬币的那堆，Bob 取走最后一堆。
选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 2 枚硬币的那堆，Bob 取走最后一堆。
你可以获得的最大硬币数目：7 + 2 = 9.
考虑另外一种情况，如果选出的是 (1, 2, 8) 和 (2, 4, 7) ，你就只能得到 2 + 4 = 6 枚硬币，这不是最优解。
示例 2：
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int start=0;
        int end=piles.length-1;
        int maxNum=0;
        while(start<end){
            end--;
            start++;
            maxNum+=piles[end];
            end--;
        }
        return maxNum;
    }
}
/*
* 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
一开始，排列 P=[1,2,3,...,m]。
对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
请你以数组形式返回待查数组  queries 的查询结果。
示例 1：
输入：queries = [3,1,2,1], m = 5
输出：[2,1,2,1]
解释：待查数组 queries 处理如下：
对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3,1,2,4,5] 。
对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,3,2,4,5] 。
对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2,1,3,4,5] 。
对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,2,3,4,5] 。
因此，返回的结果数组为 [2,1,2,1] 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int[] processQueries(int[] queries, int m) {
        int[]p=new int[m+1];
        for(int i=0;i<m;++i){
            p[i]=i+1;
        }
        int[]end=new int[queries.length];
        for(int i=0;i<queries.length;++i){
            int index=search(p,queries[i]);
            if(index<0){
                continue;
            }
            end[i]=index;
            swap(p,index);
        }
        return end;
    }
    public int search(int[]p,int key){
        for(int i=0;i<p.length-1;++i){
            if(p[i]==key){
                return i;
            }
        }
        return -1;
    }
    public void swap(int[]p,int index){
        int tmp=p[index];
        for(int i=index-1;i>=0;--i){
            p[i+1]=p[i];
        }
        p[0]=tmp;
    }
}
/*
* 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
答案中每个树的每个结点都必须有 node.val=0。
你可以按任何顺序返回树的最终列表。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution3 {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>list=new ArrayList<>();
        if(n==1){
            TreeNode root=new TreeNode(0);
            list.add(root);
            return list;
        }
        for(int i=1;i<n-1;i+=2){
            List<TreeNode>leftTree=allPossibleFBT(i);
            List<TreeNode>rightTree=allPossibleFBT(n-i-1);
            for(TreeNode l:leftTree){
                for(TreeNode r:rightTree){
                    TreeNode root=new TreeNode(0);
                    root.left=l;
                    root.right=r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
