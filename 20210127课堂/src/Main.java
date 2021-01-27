import java.util.LinkedList;
import java.util.Queue;

//时间复杂度：O(min(m,n))
//给定两个二叉树，编写一个函数来检验它们是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//示例 1:
//
//输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//示例 2:
//
//输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//示例 3:
//
//输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
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
 public class Main {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p !=null && q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
//判断子树
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p !=null && q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) {
            return false;
        }
        if(isSameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }
}
//给定一个二叉树，检查它是否是镜像对称的。
//
// 
//
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
class Solution3 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p !=null && q == null) return false;
        if(p == null && q == null) return true;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        if(isSameTree(root.left, root.right)) return true;
        return false;
    }
}
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
// 
//
//示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//示例 3：
//
//输入：root = []
//输出：true
class Solution {
    //法一：时间复杂度O(N^2)
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;


        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);


        return leftHeight  > rightHeight  ?
                leftHeight +1 : rightHeight +1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(maxDepth(root.left)-maxDepth(root.right)>1||maxDepth(root.left)-maxDepth(root.right)<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //法二：
    public int hight(TreeNode root) {
        if(root == null) return 0;
        int leftHight = hight(root.left);
        int rightHight = hight(root.right);
        //----------------------------------------------------------------
         if(leftHight >= 0 && rightHight >= 0 &&
         Math.abs(leftHight-rightHight) <= 1) {
             return Math.max(leftHight,rightHight) + 1;
         }else {
             return -1;
        }
         //--------------------------------------------------------------
        if(leftHight == -1 || rightHight == -1 ||
                Math.abs(leftHight-rightHight) > 1) {
            return -1;
        }else {
            return Math.max(leftHight,rightHight) + 1;
        }
        //-------------------------------------------------------------------
    }
    public boolean isBalanced2(TreeNode root) {
        if(hight(root) >= 0) {
            return true;
        }
        return false;
        //return hight(root) >= 0;
    }
    // 层序遍历
    void levelOrderTraversal(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.
        while (!queue.isEmpty()) {
        TreeNode cur=queue.poll();
            System.out.print(cur.val+" ");
        if(cur.left!=null){
            queue.offer(cur.left);
        }
        if(cur.right!=null){
            queue.offer(cur.right);
        }
        }

    }
}