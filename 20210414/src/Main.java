import java.util.Arrays;

/**
 * @author:飞哥
 * @date: 2021/4/14 18:04
 */
public class Main {
    public static void main(String[] args) {

    }
}
/*
* 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。

示例 1：

输入：[4,2,1]

输出：4

解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/na-ying-bi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int minCount(int[] coins) {
        int count=0;
        for(int i=0;i<coins.length;++i){
            count=coins[i]%2==0?count+coins[i]/2:count+coins[i]/2+1;
        }
        return count;
    }
}
/*
* 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。*/
class Solution2 {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int url=1;
        while(n!=0){
            sum+=(n%10);
            url*=(n%10);
            n/=10;
        }
        return url-sum;
    }
}
/*
* 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：

目标数组 target 最初为空。
按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
重复上一步，直到在 nums 和 index 中都没有要读取的元素。
请你返回目标数组。

题目保证数字插入位置总是存在。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[]target=new int[nums.length];
        for(int i=0;i<nums.length;++i){
            insert(target,index[i],nums[i]);
        }
        return target;
    }
    public void insert(int []num,int index,int key){
        for(int i=num.length-2;i>=index;--i){
            num[i+1]=num[i];
        }
        num[index]=key;
    }
}
/*
* 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。

给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/goal-parser-interpretation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution4 {
    public String interpret(String command) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<command.length()-1;++i){
            if(command.charAt(i)=='('&&command.charAt(i+1)==')'){
                str.append("o");
                i++;
            }
            if(command.charAt(i)!='('&&command.charAt(i)!=')'){
                str.append(command.charAt(i));
            }
        }
        if(command.charAt(command.length()-1)!='('&&command.charAt(command.length()-1)!=')'){
            str.append(command.charAt(command.length()-1));
        }
        return str.toString();
    }
}
/*
* 给你一个以行程长度编码压缩的整数列表 nums 。

考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

请你返回解压后的列表。

 

示例 1：

输入：nums = [1,2,3,4]
输出：[2,4,4,4]
解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution5 {
    public int[] decompressRLElist(int[] nums) {
        int[]target=null;
        int i=0,j=1;
        while(j<nums.length){
            int[]x=new int[nums[i]];
            Arrays.fill(x,nums[j]);
            if(target==null){
                target= Arrays.copyOf(x,nums[i]);
            }else{
                int end=target.length;
                int t=0;
                target=Arrays.copyOf(target,target.length+nums[i]);
                while(end<target.length){
                    target[end]=x[t];
                    end++;
                    t++;
                }

            }
            i+=2;
            j+=2;
        }
        return target;
    }
}
/*
* 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。

请你返回 words 数组中 一致字符串 的数目。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution6 {
    public int countConsistentStrings(String allowed, String[] words) {
        int number=0;
        int[]letter=new int[26];
        for(int i=0;i<allowed.length();++i){
            char x=allowed.charAt(i);
            if(letter[x-97]==0){
                letter[x-97]++;
            }
        }
        for(int i=0;i<words.length;++i){
            boolean flag=true;
            for(int j=0;j<words[i].length();++j){
                if(letter[words[i].charAt(j)-97]==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                number++;
            }
        }
        return number;
    }
}
/*MySql
* 题目已经先执行了如下语句:
 1
2
3
4
5
6
7
drop table if exists actor;
CREATE TABLE actor (
   actor_id  smallint(5)  NOT NULL PRIMARY KEY,
   first_name  varchar(45) NOT NULL,
   last_name  varchar(45) NOT NULL,
   last_update  DATETIME NOT NULL);
insert into actor values ('3', 'WD', 'GUINESS', '2006-02-15 12:34:33');

对于表actor插入如下数据,如果数据已经存在，请忽略(不支持使用replace操作)
* 代码:
* insert ignore into actor values(3,'ED','CHASE','2006-02-15 12:34:33');
* */