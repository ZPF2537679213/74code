package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/4/27 22:38
 */
public class Main {
    public static void main(String[] args) {

    }
}
/*
* 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    ArrayList<List<Integer>>list=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[]pp=new int[nums.length];
        premu(nums,pp,new ArrayList<>());
        return list;
    }
    public void premu(int[]num,int[]pp,List<Integer>l){
        if(l.size()==num.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<num.length;++i){
            if(pp[i]!=1){
                pp[i]=1;
                l.add(num[i]);
                premu(num,pp,l);
                pp[i]=0;
                if(l.size()!=0){
                    l.remove(l.size()-1);
                }
            }
        }
    }
}
/*
* 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
提醒一下，二叉搜索树满足下列约束条件：
节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
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
class Solution2 {
    public int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        bstSum(root);
        return root;
    }
    public void bstSum(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            root.val+=sum;
            sum=root.val;
            return;
        }
        bstSum(root.right);
        root.val+=sum;
        sum=root.val;
        bstSum(root.left);
    }
}

