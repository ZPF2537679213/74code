public class Main {
    public static void main(String[] args) {
        int re=1;
        int len=0;
        while(len<=10){
           re=re*10+re;
            System.out.println(re);
            len++;
        }
        System.out.println(re);
    }
}
//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
//
//函数 myAtoi(string s) 的算法如下：
//
//读入字符串并丢弃无用的前导空格
//检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
//读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
//将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
//如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
//返回整数作为最终结果。
//注意：
//
//本题中的空白字符只包括空格字符 ' ' 。
//除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
// 
//
//示例 1：
//
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        int result = 0;
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        boolean flag = true;
        int pos = 0;
        char ch = chars[pos];
        if (chars[pos] == '-' || chars[pos] == '+'){
            flag = chars[pos] == '+';
            pos++;
        }
        while (pos < s.length() && chars[pos] >= '0' && chars[pos] <= '9'){
            int compare = result;
            int n = chars[pos] - '0';
            result = result * 10 + n;
            pos++;
            if (compare != result/10){
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        if (!flag){
            result *= -1;
        }
        return result;
    }
}
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
//
//进阶：
//
//你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
// 
//
//示例 1：
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//示例 2：
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int first=binaryFirstSearch(nums,0,nums.length-1,target);
        int last=binaryLastSearch(nums,0,nums.length-1,target);
        if(first>last||first==nums.length||first<0){
            return new int[]{-1,-1};
        }
        return new int[]{first,last};
    }
    public int binaryFirstSearch(int[]num,int start,int end,int key){
        while(start<=end){
            int mid=(start+end)/2;
            if(num[mid]>=key){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return end+1;
    }
    public int binaryLastSearch(int []num,int start,int end,int key){
        while(start<=end){
            int mid=(start+end)/2;
            if(num[mid]<=key){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start-1;
    }
}