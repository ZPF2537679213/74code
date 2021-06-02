/**
 * @author:飞哥
 * @date: 2021/6/2 17:42
 */
import java.util.*;
public class Main3 {

}
/**
 * 给定两个字符串S和T，返回S子序列等于T的不同子序列个数有多少个？
 * 字符串的子序列是由原来的字符串删除一些字符（也可以不删除）在不改变相对位置的情况下的剩余字符（例如，"ACE"is a subsequence of"ABCDE"但是"AEC"不是）
 * 例如：
 * S="nowcccoder", T = "nowccoder"
 * 返回3
 * **/
class Solution {
    /**
     *
     * @param S string字符串
     * @param T string字符串
     * @return int整型
     */
    public int numDistinct (String S, String T) {
        int size1=S.length();
        int size2=T.length();
        int[][]end=new int[size1+1][size2+1];
        for(int i=0;i<=size1;++i){
            end[i][0]=1;
        }
        for(int i=1;i<=size1;++i){
            for(int j=1;j<=size2;++j){
                char x=S.charAt(i-1);
                char y=T.charAt(j-1);
                if(x==y){
                    end[i][j]=end[i-1][j-1]+end[i-1][j];
                }else{
                    end[i][j]=end[i-1][j];
                }
            }
        }
        return end[size1][size2];
    }
}
/**
 * 给定两个单词word1和word2，请计算将word1转换为word2至少需要多少步操作。
 * 你可以对一个单词执行以下3种操作：
 * a）在单词中插入一个字符
 * b）删除单词中的一个字符
 * c）替换单词中的一个字符
 * 示例1
 * 输入：
 * "b",""
 * 复制
 * 返回值：
 * 1
 * **/
class Solution2 {
    /**
     *
     * @param word1 string字符串
     * @param word2 string字符串
     * @return int整型
     */
    public int minDistance (String word1, String word2) {
        int size1=word1.length();
        int size2=word2.length();
        int[][]end=new int[size1+1][size2+1];
        for(int i=0;i<=size1;++i){
            end[i][0]=i;
        }
        for(int j=0;j<=size2;++j){
            end[0][j]=j;
        }
        for(int i=1;i<=size1;++i){
            for(int j=1;j<=size2;++j){
                end[i][j]=Math.min(end[i-1][j],end[i][j-1])+1;
                char x=word1.charAt(i-1);
                char y=word2.charAt(j-1);
                if(x==y){
                    end[i][j]=Math.min(end[i-1][j-1],end[i][j]);
                }else{
                    end[i][j]=Math.min(end[i-1][j-1]+1,end[i][j]);
                }
            }
        }
        return end[size1][size2];
    }
}
/**
 * 给出一个字符串s，分割s使得分割出的每一个子串都是回文串
 * 计算将字符串s分割成回文分割结果的最小切割数
 * 例如:给定字符串s="aab",
 * 返回1，因为回文分割结果["aa","b"]是切割一次生成的。
 * 示例1
 * 输入：
 * "aab"
 * 复制
 * 返回值：
 * 1
 * **/
class Solution3 {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
   /* public boolean isPal(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
              return false;
            }
            start++;
            end--;
        }
        return true;
    }*/
    public boolean[][] isPal2(int len,String s){
        boolean[][]flag=new boolean[len][len];
        for(int i=len-1;i>=0;--i){
            for(int j=i;j<len;++j){
                if(i==j){
                    flag[i][j]=true;
                }else if(i+1==j){
                    flag[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    flag[i][j]=flag[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
            }
        }
        return flag;
    }
    public int minCut (String s) {
        int size=s.length();
        boolean[][]flag=isPal2(size,s);
        int[]end=new int[size+1];
        for(int i=1;i<=size;++i){
            end[i]=i-1;
        }
        for(int i=2;i<=size;++i){
            if(flag[0][i-1]){
                end[i]=0;
                continue;
            }
            for(int j=1;j<i;++j){
                if(flag[j][i-1]){
                    end[i]=Math.min(end[i],end[j]+1);
                }
            }
        }
        return end[size];
    }
}
/**
 * 判断回文串的方式：动态规划版与非动归版
 * **/
class Test{
    public boolean isPal(String s,int start,int end){//非动归
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean[][] isPal2(int len,String s){//动归
        boolean[][]flag=new boolean[len][len];
        for(int i=len-1;i>=0;--i){
            for(int j=i;j<len;++j){
                if(i==j){
                    flag[i][j]=true;
                }else if(i+1==j){
                    flag[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    flag[i][j]=flag[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
            }
        }
        return flag;
    }
}