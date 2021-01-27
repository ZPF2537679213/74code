public class Main {


}
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//如果不存在最后一个单词，请返回 0 。
//说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//示例:
//输入: "Hello World"
//输出: 5
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.isEmpty()||s==null){
            return 0;
        }
        s=s.trim();
        if(s.indexOf(" ")<0){
            return s.length();
        }
        int index=s.lastIndexOf(" ");
        return s.length()-index-1;
    }
}
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
//示例 1：
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//示例 2：
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//提示：
//nums1.length == m + n
//nums2.length == n
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        while(j<n){
            if(i<m&&nums1[i]<nums2[j]){
                i++;
            }else{
                for(int k=m-1;k>=i;--k){
                    nums1[k+1]=nums1[k];
                }
                nums1[i]=nums2[j];
                j++;
                m++;
            }
        }
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-01-26
 * Time: 9:43
 */
class BTNode {
    public char val;
    public BTNode left;//左子树的引用
    public BTNode right;//右子树的引用

    public BTNode(char val) {
        this.val = val;
    }
}
class BinaryTree {

    /**
     * 我们要首先创建二叉树，但是为了好理解，我们先以穷举的方式
     * 创建二叉树
     * 后期我们会以遍历的方式 创建二叉树
     * 当前只是权宜之计
     * @return
     */
    static int size=0;
    static int leftSize;
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }


    // 前序遍历
    void preOrderTraversal(BTNode root) {
        if(root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }



    // 中序遍历
    void inOrderTraversal(BTNode root) {
        if(root!=null){
            preOrderTraversal(root.left);
            System.out.print(root.val);
            preOrderTraversal(root.right);
        }
    }

    // 后序遍历
    void postOrderTraversal(BTNode root) {
        if(root!=null){
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            System.out.print(root.val);
        }
    }
    //求节点个数
    void getSize1(BTNode root){
        if(root!=null){
            size++;
            getSize1(root.left);
            getSize1(root.right);
        }
    }
    int getSize2(BTNode root){
        if(root==null){
            return 0;
        }
        return 1+getSize2(root.left)+getSize2(root.right);
    }
    //求叶子节点个数
    void leftSize1(BTNode root){
        if(root !=null){
            leftSize1(root.left);
            leftSize1(root.right);
        }
       leftSize++;
    }
    int leftSize2(BTNode root){
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        return leftSize2(root.left)+leftSize2(root.right);
    }
    //求树的高度
    public int treeHigh(BTNode root){
        if(root==null){
            return 0;
        }
        return Math.max(treeHigh(root.left),treeHigh(root.right))+1;
    }
    //求第K层节点个数
    public int kSize(BTNode root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return kSize(root.right,k-1)+kSize(root.left,k-1);
    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        BTNode root=bt.createTree();
        bt.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(bt.getSize2(root));
        System.out.println(BinaryTree.leftSize);
        System.out.println(bt.leftSize2(root));
        System.out.println(bt.treeHigh(root));
    }
}
