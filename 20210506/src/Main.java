import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:飞哥
 * @date: 2021/5/6 22:32
 */
public class Main {
}
/*
字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
序列中第一个单词是 beginWord 。
序列中最后一个单词是 endWord 。
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典 wordList 中的单词。
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
示例 1：
输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
输出：5
解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
示例 2：
输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
输出：0
解释：endWord "cog" 不在字典中，所以无法进行转换。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        HashSet<String> set=new HashSet<>(wordList);
        HashSet<String>visited=new HashSet<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        int end=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                String next=queue.poll();
                char[]x=next.toCharArray();
                for(int i=0;i<x.length;++i){
                    char xx=x[i];
                    for(char c='a';c<='z';++c){
                        if(c!=xx){
                            x[i]=c;
                            String newWord=new String(x);
                            if(set.contains(newWord)){
                                if(newWord.equals(endWord)){
                                    return end+1;
                                }
                                if(!visited.contains(newWord)){
                                    visited.add(newWord);
                                    queue.offer(newWord);
                                }
                            }
                        }
                    }
                    x[i]=xx;
                }
                size--;
            }
            end++;
        }
        return 0;
    }
}
