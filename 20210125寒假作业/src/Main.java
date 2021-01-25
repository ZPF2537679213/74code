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
