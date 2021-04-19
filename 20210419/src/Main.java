
import java.util.*;
/**
 * @author:飞哥
 * @date: 2021/4/19 21:35
 */
public class Main {

}
/*
* 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
* 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->*/
 class Collection{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if (n > 1000) {
                n = 999;
            }
            List<Integer> list=new ArrayList<>();
            int i=0;
            for( i=0;i<n;i++){
                list.add(i);
            }
            while(list.size()>1){
                i=(i+2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
/*
*
* 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
示例 1：
输入：n = "32"
输出：3
解释：10 + 11 + 11 = 32
示例 2：
输入：n = "82734"
输出：8
示例 3：
输入：n = "27346209830709182346"
输出：9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int minPartitions(String n) {
        int maxnum=0;
        for(int i=0;i<n.length();++i){
            char x=n.charAt(i);
            maxnum=Math.max(maxnum,x-'0');
            if(maxnum==9){
                break;
            }
        }
        return maxnum;
    }
}
/*
* 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
2. getValue(int row, int col)
返回矩形中坐标 (row,col) 的当前值。
示例 1：
输入：
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
输出：
[null,1,null,5,5,null,10,5]
解释：
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
// 初始的 (4x3) 矩形如下：
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // 返回 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// 此次更新后矩形变为：
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5
subrectangleQueries.getValue(0, 2); // 返回 5
subrectangleQueries.getValue(3, 1); // 返回 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// 此次更新后矩形变为：
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10
subrectangleQueries.getValue(3, 1); // 返回 10
subrectangleQueries.getValue(0, 2); // 返回 5
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subrectangle-queries
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class SubrectangleQueries {
    public int[][]rectangle=null;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle=rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1;i<=row2;++i){
            for(int j=col1;j<=col2;++j){
                rectangle[i][j]=newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
/*
* 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
示例 1：
输入：boxes = "110"
输出：[1,1,3]
解释：每个盒子对应的最小操作数如下：
1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
示例 2：
输入：boxes = "001011"
输出：[11,8,5,4,3,4]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int[] minOperations(String boxes) {
        int len=boxes.length();
        int[]num=new int[len];
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<len;++i){
            if(boxes.charAt(i)=='1'){
                list.add(i);
            }
        }
        for(int i=0;i<len;++i){
            for(int x:list){
                num[i]+=Math.abs(i-x);
            }
        }
        return num;
    }
}
/*
* TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/encode-and-decode-tinyurl
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
 class Codec {
    public String net="https://leetcode.com/";
    public String words="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public HashMap<String,String>map=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String s="";
        Random rand=new Random();
        for(int i=1;i<=6;++i){
            int x=rand.nextInt(61);
            s+=words.charAt(x);
        }
        net+=s;
        if(!map.containsKey(net)){
            map.put(net,longUrl);
        }
        return net;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
/*
* 题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
示例1
输入
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
返回值
{1,2,5,3,4,6,7}*/
 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 class Solution3 {
    public int index=0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null||index>=pre.length||pre.length==0||in.length==0){
            return null;
        }
        int inindex=search(in,pre[index]);
        TreeNode root=new TreeNode(in[inindex]);
        index++;
        int[]left=Arrays.copyOf(in,inindex);
        int[]right=Arrays.copyOfRange(in,inindex+1,in.length);
        TreeNode lef=reConstructBinaryTree(pre,left);
        TreeNode rig=reConstructBinaryTree(pre,right);
        root.left=lef;
        root.right=rig;
        return root;
    }
    public int search(int []in,int key){
        for(int i=0;i<in.length;++i){
            if(in[i]==key){
                return i;
            }
        }
        return -1;
    }
}
/*
* 题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
示例1
复制
{67,0,24,58}
返回值
[58,24,0,67]*/
 class ListNode {
       int val;
        ListNode next = null;

        ListNode(int val) {
           this.val = val;
        }
    }
class Solution4 {
    ArrayList<Integer>list=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return new ArrayList<>();
        }
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
/*
* 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/
class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            int x=stack1.pop();
            stack2.push(x);
        }
        int end=stack2.pop();
        while(!stack2.isEmpty()){
            int x=stack2.pop();
            stack1.push(x);
        }
        return end;
    }
}
/*
* 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
示例1
输入
[3,4,5,1,2]
返回值
1*/
class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
}
/*
* 题目描述
给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
输入描述:
输入两个只包含小写字母的字符串
输出描述:
输出一个整数，代表最大公共子串的长度*/
class Main2{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        String str1=input.nextLine();
        String str2=input.nextLine();
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<str1.length();++i){
            for(int j=i;j<str1.length();++j){
                String s=str1.substring(i,j+1);
                set.add(s);
            }
        }
        int maxlen=0;
        for(String x:set){
            if(str2.contains(x)){
                maxlen=Math.max(maxlen,x.length());
            }
        }
        System.out.println(maxlen);
    }
}