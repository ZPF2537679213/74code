import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author:飞哥
 * @date: 2021/4/24 21:05
 */
public class Main {

}
/*
*给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：

二叉树的根是数组 nums 中的最大元素。
左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
返回有给定数组 nums 构建的 最大二叉树 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree
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
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        int maxIndex=maxNum(nums);
        TreeNode root=new TreeNode(nums[maxIndex]);
        int[]nl= Arrays.copyOf(nums,maxIndex);
        int[]nr=Arrays.copyOfRange(nums,maxIndex+1,nums.length);
        TreeNode left=constructMaximumBinaryTree(nl);
        TreeNode right=constructMaximumBinaryTree(nr);
        root.left=left;
        root.right=right;
        return root;
    }
    public int maxNum(int[]nums){
        int index=0;
        int max=nums[0];
        for(int i=1;i<nums.length;++i){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
}
/*
* 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.val%2==0){
            if(root.left!=null&&root.left.left!=null){
                sum+=root.left.left.val;
            }
            if(root.left!=null&&root.left.right!=null){
                sum+=root.left.right.val;
            }
            if(root.right!=null&&root.right.right!=null){
                sum+=root.right.right.val;
            }
            if(root.right!=null&&root.right.left!=null){
                sum+=root.right.left.val;
            }
        }
        int left=sumEvenGrandparent(root.left);
        int right=sumEvenGrandparent(root.right);
        sum+=(right+left);
        return sum;
    }
}
/*
* 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。
示例：
输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public int matrixScore(int[][] A) {
        int result=A.length;
        for(int i=1;i<A[0].length;++i){
            int count=0;
            for(int j=0;j<A.length;++j){
                if(A[j][i]==A[j][0]){
                    count++;
                }
            }
            result=(result<<1)+Math.max(count,A.length-count);
        }
        return result;
    }
}
/*
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
示例1
输入
2.00000,3
返回值
8.00000
示例2
输入
2.10000,3
返回值
9.26100
* 示例3
2.00000,-2
返回值
0.25000
*/
class Solution4 {
    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }
        if(exponent<0){
            base=1/base;
            exponent=-exponent;
        }
        double end=base;
        for(int i=2;i<=exponent;++i){
            end*=base;
        }
        return end;
    }
}
/*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，
* 偶数和偶数之间的相对位置不变。
示例1
输入
[1,2,3,4]
返回值
[1,3,2,4]
示例2
输入
[2,4,6,5,7]
返回值
[5,7,2,4,6]*/
class Solution5 {
    public int[] reOrderArray (int[] array) {
        LinkedList<Integer> listo=new LinkedList<>();
        LinkedList<Integer>listj=new LinkedList<>();
        for(int i=0;i<array.length;++i){
            if(array[i]%2==0){
                listo.add(array[i]);
            }else{
                listj.add(array[i]);
            }
        }
        int i=0;
        for(int x:listj){
            array[i]=x;
            i++;
        }
        for(int x:listo){
            array[i]=x;
            i++;
        }
        return array;
    }
}
/*
* 输入一个链表，输出该链表中倒数第k个结点。
如果该链表长度小于k，请返回空。
示例1
输入
{1,2,3,4,5},1
返回值
{5}*/
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
class Solution6 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if(pHead==null){
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
        while(fast!=null&&k>0){
            fast=fast.next;
            k--;
        }
        if(fast==null&&k!=0){
            return null;
        }
        if(fast==null&&k==0){
            return slow;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}

