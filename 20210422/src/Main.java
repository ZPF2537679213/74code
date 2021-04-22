import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:飞哥
 * @date: 2021/4/22 16:16
 */
public class Main {
    public static void main(String[] args) {

    }
}
/*
给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
其中，克隆树 cloned 是原始树 original 的一个 副本 。
请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
注意：
你 不能 对两棵二叉树，以及 target 节点进行更改。
只能 返回对克隆树 cloned 中已有的节点的引用。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

 class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
     TreeNode1(int x) { val = x; }
  }


class Solution {
    public final TreeNode1 getTargetCopy(final TreeNode1 original, final TreeNode1 cloned, final TreeNode1 target) {
        if(original==null){
            return null;
        }
        if(original==target){
            return cloned;
        }
        final TreeNode1 end=getTargetCopy(original.left,cloned.left,target);
        return end==null?getTargetCopy(original.right,cloned.right,target):end;
    }
}
/*
* 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
示例 1：
输入：n = 3
输出：2
解释：arr = [1, 3, 5]
第一次操作选出 x = 2 和 y = 0，使数组变为 [2, 3, 4]
第二次操作继续选出 x = 2 和 y = 0，数组将会变成 [3, 3, 3]
示例 2：
输入：n = 6
输出：9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int minOperations(int n) {
       /*法一：
       int count=0,avg=n;
       for(int i=0;i<n;++i){
           int x=2*i+1;
          count+=Math.abs(x-n);
       }
       return count/2;*/
        /* 法二：* */
        return n*n/4;
    }
}
/*
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
示例 2：
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：19
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/deepest-leaves-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            while(size>0){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            list.add(sum);
        }
        return list.get(list.size()-1);
    }
}
/*
* 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
输入
10
返回值
2*/
class Solution4 {
    public int NumberOf1(int n) {
        int count=0;
        for(int i=1;i<33;++i){
            count=((n&1)==1)?count+1:count;
            n=n>>1;
        }
        return count;
    }
}



