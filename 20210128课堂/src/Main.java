import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BTNode{
   public int val;
   public BTNode left;
   public BTNode right;
}
public class Main {
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(BTNode root) {
     if(root==null){
         return true;
     }
     Queue<BTNode> queue=new LinkedList<>();
     queue.offer(root);
     while(!queue.isEmpty()){
         BTNode cur=queue.poll();
         if(cur==null){
             break;
         }else{
            queue.offer(cur.left);
            queue.offer(cur.right);
         }
     }
     while(!queue.isEmpty()){
     BTNode cur=queue.peek();
     if(cur!=null){
         return false;
     }
     }
     return true;
    }
    //中序非递归
public void midShow(BTNode root){
        if(root==null){
            return;
        }
        Stack<BTNode> stack=new Stack<>();
        BTNode cur=root;
        while(cur!=null||stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            BTNode top=stack.pop();
            System.out.print(top.val+" ");
            cur=top.right;
        }
    System.out.println();
}
//后序非递归
    public void lastShow(BTNode root){
        if(root==null){
            return;
        }
        Stack<BTNode> stack=new Stack<>();
        BTNode cur=root;
        BTNode prev=null;
        while(cur!=null||stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            BTNode top=stack.peek();
            if(top.right!=null&&top.right!=prev){
             cur=top.right;
            }else{
                top=stack.pop();
                System.out.print(top.val+" ");
                prev=top;
            }
        }
        System.out.println();
    }

}
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//示例 1:
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//示例 2:
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
class Solution {
    public BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q) {
        if(root == null) return null;

        if(root == p || root == q) {
            return root;
        }
        BTNode left = lowestCommonAncestor(root.left,p,q);
        BTNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }
}
//二叉搜索树转排好序的双向链表

 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

 class Solution2 {
    public TreeNode prev = null;
    public void ConvertChild(TreeNode pCur) {
        if(pCur == null) return;
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }
}
//给定一个二叉树，确定它是否是一个完全二叉树。
//百度百科中对完全二叉树的定义如下：
//若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
//示例 1：
//输入：[1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
//示例 2：
//输入：[1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
class Solution3 {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            if(queue.poll()!=null){
                return false;
            }
        }
        return true;
    }
}
