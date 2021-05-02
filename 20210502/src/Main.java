import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:飞哥
 * @date: 2021/5/2 16:18
 */
public class Main {
    public static void main(String[] args) {

    }
}
/*
*
有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
A 或 B 中的元素在原字符串中可以不连续。
A.length + B.length = seq.length
深度最小：max(depth(A), depth(B)) 的可能取值最小。 
划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
answer[i] = 0，seq[i] 分给 A 。
answer[i] = 1，seq[i] 分给 B 。
如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
示例 1：
输入：seq = "(()())"
输出：[0,1,1,1,1,0]
示例 2：
输入：seq = "()(())()"
输出：[0,0,0,1,1,0,1,1]
解释：本示例答案不唯一。
按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {//奇数偶数交替赋值
        int[]end=new int[seq.length()];
        int depth=0;
        for(int i=0;i<seq.length();++i){
            char x=seq.charAt(i);
            if(x=='('){
                depth++;
                end[i]=depth%2==0?1:0;
            }else{
                end[i]=depth%2==0?1:0;
                depth--;
            }
        }
        return end;
    }
}
/*
*
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int num=1;
        num=num+countNodes(root.left)+countNodes(root.right);
        return num;
    }
}
/*
矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-the-matrix-diagonally
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<Math.min(mat.length,mat[0].length);++i){
            for(int k=0;k<mat.length-1;++k){
                for(int j=0;j<mat[k].length-1;++j){
                    if(mat[k][j]>mat[k+1][j+1]){
                        mat[k][j]=mat[k][j]+mat[k+1][j+1];
                        mat[k+1][j+1]=mat[k][j]-mat[k+1][j+1];
                        mat[k][j]=mat[k][j]-mat[k+1][j+1];
                    }
                }
            }
        }
        return mat;
    }
}
/*
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。说白了，就是层序遍历*/
class Solution4 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer>list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            while(len>0){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                len--;
            }
        }
        return list;
    }
}
/*
* 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。*/
class Solution5 {

    Stack<Integer> stack1=new Stack<>();
    Stack<Integer>stack2=new Stack<>();
    Stack<Integer>stack3=new Stack<>();
    public void push(int node) {
        if(stack1.isEmpty()){
            stack1.push(node);
        }else{
            if(stack1.peek()>node){
                stack1.push(node);
            }else{
                while(!stack1.isEmpty()&&stack1.peek()<node){
                    int x=stack1.pop();
                    stack2.push(x);
                }
                stack1.push(node);
                while(!stack2.isEmpty()){
                    int x=stack2.pop();
                    stack1.push(x);
                }
            }
        }
        stack3.push(node);
    }

    public void pop() {
        int x=stack3.pop();
        while(!stack1.isEmpty()&&stack1.peek()!=x){
            int y=stack1.pop();
            stack2.push(y);
        }
        stack1.pop();
        while(!stack2.isEmpty()){
            int y=stack2.pop();
            stack1.push(y);
        }
    }

    public int top() {
        int x=stack3.peek();
        return x;
    }

    public int min() {
        return stack1.peek();
    }
}
/*
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
* 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/
class Solution6 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int top=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        ArrayList<Integer>list=new ArrayList<>();
        if(matrix.length==1&&matrix[0].length==1){
            list.add(matrix[0][0]);
            return list;
        }
        while(true){
            for(int i=left;i<=right;++i){
                list.add(matrix[top][i]);
            }
            top++;
            if(top>down){
                break;
            }
            for(int i=top;i<=down;++i){
                list.add(matrix[i][right]);
            }
            right--;
            if(right<left){
                break;
            }
            for(int i=right;i>=left;--i){
                list.add(matrix[down][i]);
            }
            down--;
            if(down<top){
                break;
            }
            for(int i=down;i>=top;--i){
                list.add(matrix[i][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return list;
    }
}