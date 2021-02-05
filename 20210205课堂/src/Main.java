import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put();
    }
}
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//
//要求返回这个链表的 深拷贝。 
//
//我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
//
//val：一个表示 Node.val 的整数。
//random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val);//新的节点
            map.put(cur,node);
            cur = cur.next;
        }
        //cur == null  说明第一遍历结束了   map当中存储了映射关系
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //cur再次为空 此时说明 新的；链表的next和random已经维护完成
        return map.get(head);
    }
}
// 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
//
//J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
//
//示例 1:
//
//输入: J = "aA", S = "aAAbbbb"
//输出: 3
//示例 2:
//
//输入: J = "z", S = "ZZ"
//输出: 0
class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<jewels.length();++i){
            String str=jewels.substring(i,i+1);
            set.add(str);
        }
        int num=0;
        for(int i=0;i<stones.length();++i){
            String str=stones.substring(i,i+1);
            if(set.contains(str)){
                num++;
            }
        }
        return num;
    }
}
//链接：https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
//来源：牛客网
//
//旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
//肯定坏掉的那些键。
//
//输入描述:
//输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
//以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
//
//
//输出描述:
//按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
//示例1
//输入
//7_This_is_a_test<br/>_hs_s_a_es
//输出
//7TI

 class Main2 {
    public static void function(String strExc,String strAct){
        //
        HashSet<Character> setAct = new HashSet<>();
        for(char ch : strAct.toUpperCase().toCharArray()) {
            setAct.add(ch);
        }

        HashSet<Character> set = new HashSet<>();
        //setAct就存储了 我实际输入的数据
        //遍历strExc 看哪个键不在setAct集合当中
        for(char ch : strExc.toUpperCase().toCharArray()) {
            if(!setAct.contains(ch)&&!set.contains(ch)  ) {
                //1、把他放到集合  2、
                System.out.print(ch);
                set.add(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String strExc = scan.nextLine();//期望输入的
        String strAct = scan.nextLine();//实际输入的
        function(strExc,strAct);
    }
}