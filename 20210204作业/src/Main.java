import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer>set=new HashSet<>();
        String str="gfhghfg";
      List<Integer>list=new LinkedList<>();
      list.add(1);
      for(int x:list){
          System.out.println(x);
      }
      PriorityQueue<Integer>queue=new PriorityQueue<>();
      queue.offer(1);
      queue.offer(2);
      for(int x:queue){
          System.out.println(x);
      }
      Stack<Integer>stack=new Stack<>();
      stack.push(20);
      stack.push(30);
      for(int x:stack){
          System.out.println(x);
      }
      Map<Integer,Integer>map=new HashMap<>();
        Map.Entry<String, Integer> all = Map.entry("xlu" , 1);
        String key = all.getKey();
        Integer value = all.getValue();
        System.out.println(key);
        System.out.println(value);
        System.out.println(all.getClass().getName());

    }
}
//给定两个字符串 s 和 t，判断它们是否是同构的。
//如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//示例 1:
//输入：s = "egg", t = "add"
//输出：true
//示例 2：
//输入：s = "foo", t = "bar"
//输出：false
//示例 3：
//输入：s = "paper", t = "title"
//输出：true
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            char m=t.charAt(i);
            if(map.get(c)==null){
                int index=t.indexOf(m+"");
                if(s.charAt(index)!=c){
                    return false;
                }
                map.put(c,m);
            }else{
                if(map.get(c)!=m){
                    return false;
                }
            }
            Set<Integer> set=new HashSet<>();
           Integer[]num=set.toArray(new Integer[10]);
        }
        return true;
    }
}
//给定两个数组，编写一个函数来计算它们的交集。
//示例 1：
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//示例 2：
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        if(nums1.length==0||nums2.length==0){
            return new int[0];
        }else{
            for(int x:nums1){
                set1.add(x);
            }
            for(int y:nums2){
                if(set1.contains(y)){
                    set2.add(y);
                }
            }
            Integer[]n=set2.toArray(new Integer[set2.size()]);
            int[]num=new int[set2.size()];
            for(int i=0;i<set2.size();++i){
                num[i]=n[i];
            }
            return num;
        }
    }
}
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//示例：
//s = "leetcode"
//返回 0
//s = "loveleetcode"
//返回 2
class Solution3 {
    public int firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return -1;
        }
        Map<String,Integer> map=new HashMap<>();
        int i;
        for(i=0;i<s.length();++i){
            String str=s.substring(i,i+1);
            if(map.get(str)==null){
                map.put(str,1);
            }else{
                map.put(str,map.get(str)+1);
            }
        }
        for(i=0;i<s.length();++i){
            String str=s.substring(i,i+1);
            if(map.get(str)==1){
                return i;
            }
        }
        return -1;
    }
}
