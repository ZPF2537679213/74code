import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/5/8 20:53
 */
public class Main {
}
/*
52. N皇后 I
* n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    List<List<String>>list=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]quen=new char[n][n];
        solve(quen,new ArrayList<String>(),0);
        return list;
    }
    public void solve(char[][]quen,List<String>l,int cow){
        if(l.size()==quen.length){
            list.add(new ArrayList<String>(l));
            return;
        }
        for(int j=0;j<quen.length;++j){
            if(findQ(cow,j,quen)){
                quen[cow][j]='Q';
                StringBuilder s=new StringBuilder();
                for(int i=0;i<quen.length;++i){
                    if(i==j){
                        s.append('Q');
                    }else{
                        s.append('.');
                    }
                }
                l.add(s.toString());
                solve(quen,l,cow+1);
                quen[cow][j]=' ';
                l.remove(l.size()-1);
            }
        }
    }
    public boolean findQ(int x,int y,char[][]quen){
        for (int r = 0; r < quen.length; r++) {
            if (quen[r][y] == 'Q')
                return false;
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < quen.length; i--, j++) {
            if (quen[i][j] == 'Q')
                return false;
        }

        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--)
            if (quen[i][j] == 'Q')
                return false;
        return true;
    }
}
/*
* 52. N皇后 II
* n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
输入：n = 4
输出：2
解释：如上图所示，4 皇后问题存在两个不同的解法。
* */
class Solution2 {
    public  int count=0;
    public int totalNQueens(int n) {
        char[][]quen=new char[n][n];
        queen(n,quen,0);
        return count;
    }
    public void queen(int n,char[][] quen,int cow){
        if(cow==n){
            count++;
            return;
        }
        for(int j=0;j<n;++j){
            if(findQ(cow,j,quen)){
                quen[cow][j]='Q';
                queen(n,quen,cow+1);
                quen[cow][j]=' ';
            }
        }
    }
    public boolean findQ(int x,int y,char[][]quen){
        for (int r = 0; r < quen.length; r++) {
            if (quen[r][y] == 'Q')
                return false;
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < quen.length; i--, j++) {
            if (quen[i][j] == 'Q')
                return false;
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--)
            if (quen[i][j] == 'Q')
                return false;

        return true;
    }
}
/*
* 有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
注意：本题中，每个活字字模只能使用一次。
示例 1：
输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
示例 2：
输入："AAABBC"
输出：188
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-tile-possibilities
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution3 {
    public int count=0;
    public int numTilePossibilities(String tiles) {
        numTile(new StringBuilder(),tiles,new boolean[tiles.length()],new HashSet<>());
        return count;
    }
    public void numTile(StringBuilder s,String tiles,boolean[]flag,HashSet<String>set){
        for(int i=0;i<tiles.length();++i){
            if(!flag[i]){
                flag[i]=true;
                s.append(tiles.charAt(i));
                String ss=s.toString();
                if(!set.contains(ss)){
                    set.add(ss);
                    count++;
                }
                numTile(s,tiles,flag,set);
                flag[i]=false;
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}
/*
* 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
例如，下面的二进制手表读取 "3:25" 。
给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
小时不会以零开头：
例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
分钟必须由两位数组成，可能会以零开头：
例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
示例 1：
输入：turnedOn = 1
输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
示例 2：
输入：turnedOn = 9
输出：[]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-watch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution4 {
    public List<String> readBinaryWatch(int num) {
        List<String>list=new ArrayList<>();
        time(new StringBuilder(),0,list,num,0);
        return list;
    }
    public void time(StringBuilder t,int count,List<String>list,int num,int index){
        if(index>10){
            return;
        }
        if(count>num){
            return;
        }
        if(t.length()==10&&count==num){
            String end="";
            int hour=0;
            int minute=0;
            for(int i=0;i<t.length();++i){
                int x=t.charAt(i)-'0';
                if(i<6){
                    minute=minute+x*(int)Math.pow(2,i);
                }else{
                    hour=hour+x*(int)Math.pow(2,i-6);
                }
            }
            if(minute>=60||hour>=12){
                return;
            }
            if(minute<10){
                end=hour+":0"+minute;
            }else{
                end=hour+":"+minute;
            }
            list.add(end);
            return;
        }
        t.append(0);
        time(t,count,list,num,index+1);
        t.setCharAt(t.length()-1,'1');
        time(t,count+1,list,num,index+1);
        t.deleteCharAt(t.length()-1);
    }
}
/*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
* 示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：
输入：digits = ""
输出：[]
示例 3：
输入：digits = "2"
输出：["a","b","c"]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution5 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        String str="abc def ghi jkl mno pqrs tuv wxyz";
        char i='2';
        for(String x:str.split(" ")){
            map.put(i,x);
            i++;
        }
        ArrayList<String>list=new ArrayList<>();
        letter(digits,0,new StringBuilder(),map,list);
        if(digits.length()==0){
            return new ArrayList<>();
        }
        return list;
    }
    public void letter(String digits,int index,StringBuilder ss,HashMap<Character,String>map,List<String>list){
        if(index>digits.length()){
            return;
        }
        if(ss.length()==digits.length()){
            list.add(ss.toString());
            return;
        }
        char x=digits.charAt(index);
        String s=map.get(x);
        for(int i=0;i<s.length();++i){
            char y=s.charAt(i);
            ss.append(y);
            letter(digits,index+1,ss,map,list);
            ss.deleteCharAt(ss.length()-1);
        }
    }
}