/**
 * @author:飞哥
 * @date: 2021/5/26 19:00
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution3 solution3=new Solution3();
        System.out.println(solution3.getLongestPalindrome("ababababa",9));
    }
}
/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * 示例1
 * 输入：
 * "["
 * 返回值：
 * false
 * 示例2
 * 输入：
 * "[]"
 * 返回值：
 * true
 * **/

class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();++i){
            char x=s.charAt(i);
            if(x=='['||x=='('||x=='{'){
                stack.push(x);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if((x==')'&&stack.peek()=='(')||(x=='}'&&stack.peek()=='{')||(x==']'&&stack.peek()=='[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
/**
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * 示例1
 * 输入：
 * [1,2,4,4,5],4
 * 返回值：
 * 2
 * 说明：
 * 从左到右，查找到第1个为4的，下标为2，返回2
 * 示例2
 * 输入：
 * [1,2,4,4,5],3
 * 返回值：
 * -1
 * 示例3
 * 输入：
 * [1,1,1,1,1],1
 * 返回值：
 * 0**/
class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        if(nums[start]!=target){
            return -1;
        }
        return start;
    }
}
/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 *
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。**/
class Solution3 {
    public int getLongestPalindrome(String A, int n) {
        int maxlen=0;
        for(int i=0;i<A.length();++i){
            maxlen=Math.max(maxlen,getMaxLength(A,i-1,i,i+1,n));
            maxlen=Math.max(maxlen,getMaxLength(A,i-1,i,i,n));
        }
        return maxlen;
    }
    public int getMaxLength(String s,int start,int i,int end,int n){
        if(start<0||(end<n&&s.charAt(start)!=s.charAt(end)&&s.charAt(end)==s.charAt(i))){
            while(end<n&&s.charAt(end)==s.charAt(i)){
                end++;
            }
            return end-i;
        }else if(end>=n||(start>=0&&s.charAt(end)!=s.charAt(start)&&s.charAt(start)==s.charAt(i))){
            while(start>=0&&s.charAt(start)==s.charAt(i)){
                start--;
            }
            if(start<0){
                return i;
            }
            return i-start;
        }else{
            while(start>=0&&end<n&&s.charAt(start)==s.charAt(end)){
                start--;
                end++;
            }
            if(start<0){
                return end;
            }else{
                return end-start-1;
            }
        }
    }
}
/**
 *链接：https://www.nowcoder.com/questionTerminal/5973a31d58234b068fa1fe34f7290855
 * 来源：牛客网
 *
 * NowCoder每天要给许多客户写电子邮件。正如你所知，如果一封邮件中包含多个收件人，收件人姓名之间会用一个逗号和空格隔开；如果收件人姓名也包含空格或逗号，则姓名需要用双引号包含。
 * 现在给你一组收件人姓名，请你帮他生成相应的收件人列表。
 *
 * 输入描述:
 * 输入包含多组数据。
 *
 * 每组数据的第一行是一个整数n (1≤n≤128)，表示后面有n个姓名。
 *
 * 紧接着n行，每一行包含一个收件人的姓名。姓名长度不超过16个字符。
 *
 *
 * 输出描述:
 * 对应每一组输入，输出一行收件人列表。
 * 示例1
 * 输入
 * 3
 * Joe
 * Quan, William
 * Letendre,Bruce
 * 2
 * Leon
 * Kewell
 * 输出
 * Joe, "Quan, William", "Letendre,Bruce"
 * Leon, Kewell
 * **/
class Main2{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String x =input.nextLine();
            int n=Integer.valueOf(x);
            String[]ss=new String[n];
            for(int i=0;i<n;++i){
                ss[i]=input.nextLine();
            }
            StringBuilder str=new StringBuilder();
            for(int i=0;i<n;++i){
                if(ss[i].contains(",")||ss[i].contains(" ")){
                    if(i<n-1){
                        str.append("\""+ss[i]+"\""+", ");
                    }else{
                        str.append("\""+ss[i]+"\"");
                    }
                }else{
                    if(i<n-1){
                        str.append(ss[i]+", ");
                    }else{
                        str.append(ss[i]);
                    }
                }
            }
            System.out.println(str.toString());
        }
    }
}
/**
 * 链接：https://www.nowcoder.com/questionTerminal/71d3849a19f04a1591c415964ac148f1
 * 来源：牛客网
 *
 * 一只成熟的兔子每天能产下一胎兔子。每只小兔子的成熟期是一天。 某人领养了一只小兔子，请问第N天以后，他将会得到多少只兔子。
 *
 * 输入描述:
 * 测试数据包括多组，每组一行，为整数n(1≤n≤90)。
 *
 *
 * 输出描述:
 * 对应输出第n天有几只兔子(假设没有兔子死亡现象)。
 * 示例1
 * 输入
 * 1<br/>2
 * 输出
 * 1<br/>2
 * **/
class Main3{
    public static long[]num=new long[91];
    static{
        num[1]=1;
        num[2]=2;
        for(int i=3;i<91;++i){
            num[i]=num[i-1]+num[i-2];
        }
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            System.out.println(num[n]);
        }
    }
}