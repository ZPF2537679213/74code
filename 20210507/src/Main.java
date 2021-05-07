import java.util.*;

/**
 * @author:飞哥
 * @date: 2021/5/7 14:52
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(((char)('a'+1)));
        int[]num=new int[10];
    }
}
/*
* 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:

输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/open-the-lock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        HashSet<String>lockSet=new HashSet<>();
        for(String x:deadends){
            lockSet.add(x);
        }
        HashSet<String>visited=new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        if(lockSet.contains("0000")){
            return -1;
        }
        int result=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                String cur=queue.poll();
                if(cur.equals(target)){
                    return result;
                }
                char[]cc=cur.toCharArray();
                for(int i=0;i<4;++i){
                    char x=cc[i];
                    cc[i]=(x=='9'?'0':(char)(x+1));
                    String s1=new String(cc);
                    cc[i]=(x=='0'?'9':(char)(x-1));
                    String s2=new String(cc);
                    if(!lockSet.contains(s1)&&(!visited.contains(s1))){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if(!lockSet.contains(s2)&&(!visited.contains(s2))){
                        queue.offer(s2);
                        visited.add(s2);
                    }
                    cc[i]=x;
                }
                size--;
            }
            result++;
        }
        return -1;
    }
}
/*
* 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意：

起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
 

示例 1：

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

返回值: 1
示例 2：

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

返回值: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String>queue=new LinkedList<>();
        HashSet<String>set=new HashSet<>();
        HashSet<String>visited=new HashSet<>();
        String s="ACGT";
        for(String x:bank){
            set.add(x);
        }
        queue.offer(start);
        visited.add(start);
        int result=1;
        while(!queue.isEmpty()){
            int len=queue.size();
            while(len>0){
                String word=queue.poll();
                char[]cc=word.toCharArray();
                for(int i=0;i<cc.length;++i){
                    char xx=cc[i];
                    for(int j=0;j<4;++j){
                        if(xx!=s.charAt(j)){
                            cc[i]=s.charAt(j);
                            String newWord=new String(cc);
                            if(!visited.contains(newWord)&&set.contains(newWord)){
                                queue.offer(newWord);
                                visited.add(newWord);
                            }
                            if(visited.contains(newWord)&&newWord.equals(end)){
                                return result;
                            }
                        }
                    }
                    cc[i]=xx;
                }
                len--;
            }
            result++;
        }
        return -1;
    }
}