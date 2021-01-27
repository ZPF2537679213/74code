public class LK {
}
//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
//你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
//
//示例 1:
//
//输入:
//	Tree 1                     Tree 2
//          1                         2
//         / \                       / \
//        3   2                     1   3
//       /                           \   \
//      5                             4   7
//输出:
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \
//	 5   4   7
//注意: 合并必须从两个树的根节点开始。
//公式：合成树=左合成树+右合成树
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode root=new TreeNode(t1.val+t2.val);
        root.left=mergeTrees(t1.left, t2.left);
        root.right= mergeTrees(t1.right, t2.right);
        return root;
    }
}
//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
//
// 
//
//示例 ：
//
//输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \
//1        7   9
//
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9
//
class Solution4 {
    private TreeNode root2;
    public TreeNode increasingBST(TreeNode root) {
        if(root!=null){
            increasingBST(root.left);
            add(root.val);
            increasingBST(root.right);
        }
        return this.root2;
    }
    public void add(int val){
        TreeNode node=new TreeNode(val);
        if(this.root2==null){
            root2=node;
        }else{
            TreeNode cur=this.root2;
            while(cur.right!=null){
                cur=cur.right;
            }
            cur.right=node;
        }
    }
}