import java.util.Arrays;

/**
 * @author:飞哥
 * @date: 2021/4/15 16:30
 */
public class Main {
    public static void main(String[] args) {

    }
}
/*
* 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
示例 1:
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean flag=false;
        for(int i=0;i<nums.length-1;++i){
            if(nums[i]>nums[i+1]){
                if(flag==false){
                    if(i>=1&&nums[i-1]>nums[i+1]){
                        if(i<nums.length-2&&nums[i]>nums[i+2]){
                            return false;
                        }
                    }
                    flag=true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
/*
* 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
示例 1：
输入： A = "ab", B = "ba"
输出： true
解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
示例 2：
输入： A = "ab", B = "ab"
输出： false
解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/buddy-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public boolean buddyStrings(String a, String b) {
        if(a==null&&b!=null||a!=null&&b==null||a.length()!=b.length()){
            return false;
        }
        if(a.equals(b)){
            int[]list=new int[26];
            for(int i=0;i<a.length();++i){
                char x=a.charAt(i);
                list[x-97]++;
                if(list[x-97]>=2){
                    return true;
                }
            }
            return false;
        }
        int dif=0;
        int x=0;
        int y=0;
        for(int i=0;i<a.length();++i){
            if(a.charAt(i)!=b.charAt(i)){
                dif++;
                if(dif==1){
                    x=i;
                }
                if(dif==2){
                    y=i;
                }
            }
            if(dif>2){
                return false;
            }
        }

        return a.charAt(x)==b.charAt(y)&&a.charAt(y)==b.charAt(x);
    }
}
/*
* 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/2vYnGI
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(drinks);
        Arrays.sort(staple);
        int count=0;
        int i=0;
        int j=drinks.length-1;
        while(i<staple.length){
            while(j>=0&&drinks[j]+staple[i]>x){
                j--;
            }
            if(j<0){
                break;
            }
            count+=(j+1);
            count%=1000000007;
            i++;
        }
        return count;
    }
}