import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

}
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//示例 4:
//
//输入: s = ""
//输出: 0
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Set<String> set=new HashSet<>();
        int maxSize=0;
        for(int i=0;i<s.length();++i){
            String str=s.substring(i,i+1);
            if(!set.contains(str)){
                set.add(str);
            }else{
                i=i-set.size();
                set.clear();
            }
            if(set.size()>maxSize){
                maxSize=set.size();
            }
        }
        if(maxSize==0){
            return s.length();
        }
        return maxSize;
    }
}
//定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
//
//例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
//
//现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
//
//请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
//
// 
//
//示例 1：
//
//输入：queries = ["cbd"], words = ["zaaaz"]
//输出：[1]
//解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
//示例 2：
//
//输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//输出：[1,2]
//解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
class Solution2 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        int []ens=new int[queries.length];
        int[]num=new int[26];
        for(int i=0;i<words.length;++i){
            String str=words[i];
            for(int j=0;j<str.length();++j){
                char c=str.charAt(j);
                num[c-97]++;
            }
            for(int j=0;j<num.length;++j){
                if(num[j]!=0){
                    map.put(str,num[j]);
                    Arrays.fill(num,0);
                    break;
                }
            }
        }
        for(int i=0;i<queries.length;++i){
            int x=0;
            String str=queries[i];
            for(int j=0;j<str.length();++j){
                char c=str.charAt(j);
                num[c-97]++;
            }
            for(int j=0;j<num.length;++j){
                if(num[j]!=0){
                    for(int l=0;l<words.length;++l){
                        if(num[j]<map.get(words[l])){
                            x++;
                        }
                    }
                    ens[i]=x;
                    Arrays.fill(num,0);
                    break;
                }
            }
        }
        return ens;
    }
}
//给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
//
//题目保证至少有一个词不在禁用列表中，而且答案唯一。
//
//禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
//
// 
//
//示例：
//
//输入:
//paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//banned = ["hit"]
//输出: "ball"
//解释:
//"hit" 出现了3次，但它是一个禁用的单词。
//"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
//注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
//"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
class Solution3 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer>map=new HashMap<>();
        Set<String>set=new HashSet<>();
        for(int i=0;i<banned.length;++i){
            set.add(banned[i]);
        }
        paragraph=paragraph.trim();
        paragraph=paragraph.replace(","," ");
        paragraph=paragraph.replace("!"," ");
        paragraph=paragraph.replace(";"," ");
        paragraph=paragraph.replace("."," ");
        paragraph=paragraph.replace("?"," ");
        paragraph=paragraph.replace("\'"," ");
        String[]str=paragraph.split(" ");
        for(int i=0;i<str.length;++i){
            str[i]=str[i].trim();
            str[i]=str[i].toLowerCase();
            if(!set.contains(str[i])){
                if(map.get(str[i])==null){
                    map.put(str[i],1);
                }else{
                    map.put(str[i],map.get(str[i])+1);
                }
            }
        }
        String s=null;
        int max=0;
        for(int i=0;i<str.length;++i){
            str[i]=str[i].trim();
            if(!str[i].equals("")&&map.get(str[i])!=null&&map.get(str[i])>max){
                s=str[i];
                max=map.get(str[i]);
            }
        }
        return s;
    }
}
//不使用任何内建的哈希表库设计一个哈希映射
//
//具体地说，你的设计应该包含以下的功能
//
//put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
//get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
//remove(key)：如果映射中存在这个键，删除这个数值对。
class MyHashMap {
    static class Node{
        public  int key;
        public  int value;
        public Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public Node[]elem;
    public int usedSize;
    public MyHashMap() {
        this.elem=new Node[1000];
    }

    public void put(int key, int value) {
        Node node=new Node(key,value);
        int index=key%this.elem.length;
        if(this.elem[index]==null){
            this.elem[index]=node;
            this.usedSize++;
        }else{
            Node cur=this.elem[index];
            while(cur!=null){
                if(cur.key==key){
                    cur.value=value;
                    return;
                }
                cur=cur.next;
            }
            node.next=this.elem[index];
            this.elem[index]=node;
            this.usedSize++;
        }
    }

    public int get(int key) {
        int index=key%this.elem.length;
        Node cur=this.elem[index];
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }
            cur=cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index=key%this.elem.length;
        if(this.elem[index]==null){
            return;
        }
        if(this.elem[index].key==key){
            this.elem[index]=this.elem[index].next;
            return;
        }
        Node cur=this.elem[index].next;
        Node prev=this.elem[index];
        while(cur!=null){
            if(cur.key==key){
                prev.next=cur.next;
                return;
            }
            prev=cur;
            cur=cur.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map=new MyHashMap();
        map.put(1,2);
        map.put(2,4);
        System.out.println(map.get(1));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
//实现 MyHashSet 类：
//
//void add(key) 向哈希集合中插入值 key 。
//bool contains(key) 返回哈希集合中是否存在这个值 key 。
//void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
class MyHashSet {
    static class Node{
        public int key;
        public Node next;
        public Node(int key){
            this.key=key;
        }
    }
    public Node[]elem;
    public int usedSize;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.elem=new Node[1000];
    }

    public void add(int key) {
        if(!contains(key)){
            int index=key%this.elem.length;
            Node node=new Node(key);
            if(this.elem[index]==null){
                this.elem[index]=node;
                this.usedSize++;
                return;
            }
            Node cur=this.elem[index];
            while(cur!=null){
                if(cur.key==key){
                    return;
                }
                cur=cur.next;
            }
            node.next=this.elem[index];
            this.elem[index]=node;
            this.usedSize++;
        }
    }

    public void remove(int key) {
        int index=key%this.elem.length;
        if(this.elem[index]==null){
            return;
        }
        if(this.elem[index].key==key){
            this.elem[index]=this.elem[index].next;
            return;
        }
        Node cur=this.elem[index].next;
        Node prev=this.elem[index];
        while(cur!=null){
            if(cur.key==key){
                prev.next=cur.next;
                return;
            }
            prev=cur;
            cur=cur.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=key%this.elem.length;
        Node cur=this.elem[index];
        while(cur!=null){
            if(cur.key==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
}