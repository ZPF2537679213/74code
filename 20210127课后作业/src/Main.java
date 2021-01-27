import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder("fgfd");

        String str="ghfghfghf";
    }
}
//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
//
//每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue <TreeNode>queue=new LinkedList<>();
        LinkedList <Integer> num=new LinkedList<>();
        queue.offer(root);
        num.offer(1);
        int size=1;
        while(!queue.isEmpty()){
            int sum=queue.size();
            size=Math.max(size,Math.abs(num.peek()-num.peekLast())+1);
            while(sum>0){
                TreeNode cur=queue.poll();
                int x=num.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                    num.offer(2*x);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                    num.offer(2*x+1);
                }
                sum--;
            }
        }
        return size;
    }
}
//题目描述
//编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
//输入描述:
//输入包括1行字符串，长度不超过100。
//输出描述:
//可能有多组测试数据，对于每组数据，
//输出将输入字符串建立二叉树后中序遍历的序列，每个字符后面都有一个空格。
//每个输出结果占一行。
 class Main2{
    //法一：
    public static int i;
    public static TreeNode show(String str,TreeNode root){
        if(i==str.length()){
            return null;
        }
        if(str.charAt(i)=='#'){
            i++;
            return null;
        }
        TreeNode node=new TreeNode(str.charAt(i));
        if(root==null){
            root=node;
        }
        i++;
        TreeNode left= show(str,root.left);
        root.left=left;
        TreeNode right= show(str,root.right);
        root.right=right;
        return root;
    }
    //法二：先序遍历的入栈顺序就是中序遍历的出栈顺序
    //先序遍历是先访问在入栈，而中序遍历是出栈后访问
    public static void show2(String str,TreeNode root){
        char[]ch=str.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<ch.length;++i){
            if(ch[i]!='#'){
                stack.push(ch[i]);
            }else{
                if(!stack.empty()){
                    System.out.print(stack.pop()+" ");
                }
            }
        }
    }
    public static void midShow(TreeNode root){
        if(root!=null){
            midShow(root.left);
            System.out.print(root.val+" ");
            midShow(root.right);
        }
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String  str=input.nextLine();
        TreeNode root =null;
        root=show(str,root);
        midShow(root);
    }
}