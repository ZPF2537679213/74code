public class Main {

}
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//你可以按任意顺序返回答案。
//
// 
//
//示例 1：
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//示例 2：
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        int i,j;
        for(i=0;i<len;++i){
            for(j=i+1;j<len&&(nums[i]+nums[j]!=target);++j);
            if(j!=len){
                return new int[]{i,j};
            }
        }
        return null;
    }
}
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
//输入为 非空 字符串且只包含数字 1 和 0。
//
// 
//
//示例 1:
//
//输入: a = "11", b = "1"
//输出: "100"
//示例 2:
//
//输入: a = "1010", b = "1011"
//输出: "10101"
class Solution {//结果不会超范围
    public String addBinary(String a, String b) {
        int count=0;
        while(a.length()<b.length())a="0"+a;
        while(a.length()>b.length())b="0"+b;
        StringBuilder str=new StringBuilder();
        for(int i=a.length()-1;i>=0;--i){
            int x=a.charAt(i)-48;
            int y=b.charAt(i)-48;
            int sum=x+y+count;
            count=sum>>1;
            str.append(sum%2);
            if(i==0&&count!=0){
                str.append(count);
            }
        }
        return str.reverse().toString();
    }
}
class Solution3 {//可能结果会超范围
    public static String addBinary(String a, String b) {
        int x=twoToTen(a);
        int y=twoToTen(b);
        int sum=x+y;
        StringBuilder str=new StringBuilder("");
        while(sum!=0){
            str.append(sum%2);
            sum/=2;
        }
        return str.reverse().toString();
    }
    public static int twoToTen(String s){
        int sum=0;
        for(int i=s.length()-1,j=0;i>=0;--i,++j){
            int x= s.charAt(i)-48;
            sum+=x*(int)Math.pow(2,j);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(twoToTen("111"));
        System.out.println(addBinary("11", "10"));
    }
}