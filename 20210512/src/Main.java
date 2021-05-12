import java.util.*;

/**
 * @author:飞哥
 * @date: 2021/5/12 20:22
 */
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer>heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
/*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
示例1
输入
[3,32,321]
返回值
"321323"*/
class Solution {
    public String PrintMinNumber(int [] numbers) {
        HashSet<String> set=new HashSet<>();
        all(numbers,0,set,"",new boolean[numbers.length]);
        String min="";
        for(String x:set){
            if(min.length()==0){
                min=x;
            }else{
                for(int i=0;i<min.length();++i){
                    if(min.charAt(i)-'0'>x.charAt(i)-'0'){
                        min=x;
                        break;
                    }else if(min.charAt(i)-'0'<x.charAt(i)-'0'){
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }
        return min;
    }
    public void all(int[]num,int count,HashSet<String>set,String str,boolean[]flag){
        if(count==num.length){
            set.add(str);
            return;
        }
        for(int i=0;i<num.length;++i){
            if(!flag[i]){
                flag[i]=true;
                all(num,count+1,set,str+num[i],flag);
                flag[i]=false;
            }
        }
    }
}
/*
* 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
示例1
输入
13
返回值
6*/
class Solution2 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;++i){
            int x=i;
            while(x!=0){
                int y=x%10;
                count=y==1?count+1:count;
                x/=10;
            }
        }
        return count;
    }
}
/*
* 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
示例1
输入
[4,5,1,6,2,7,3,8],4
返回值
[1,2,3,4]*/
class Solution3 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length||k<=0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer>heap=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        for(int i=0;i<input.length;++i){
            if(k>0){
                heap.offer(input[i]);
                k--;
            }else{
                if(input[i]<heap.peek()){
                    heap.poll();
                    heap.offer(input[i]);
                }
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        while(!heap.isEmpty()){
            int x=heap.poll();
            list.add(x);
        }
        return list;
    }
}
/*
* 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
你可以以任意顺序返回这些节点编号。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution4 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       /** List<Integer>list=new ArrayList<>();
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        for(List<Integer>x:edges){
            int start=x.get(0);
            int end=x.get(1);
            if(!map.containsKey(start)){
                map.put(start,new HashSet<>());
            }
            map.get(start).add(end);
        }
        boolean[]flag=new boolean[n];
        for(int x:map.keySet()){
            if(!flag[x]){
                list.add(x);
                flag[x]=true;
                dfs(flag,list,map.get(x),map);
            }
        }
        return list;
    }
    public void dfs(boolean[]flag,List<Integer>list,HashSet<Integer>set,HashMap<Integer,HashSet<Integer>>map){
        if(set==null||set.isEmpty()){
            return;
        }
        for(int x:set){
            if(!flag[x]){
                flag[x]=true;
                dfs(flag,list,map.get(x),map);
            }else{
                list.remove(Integer.valueOf(x));
            }
        }*/
        HashSet<Integer>set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<edges.size();++i){
            int x=edges.get(i).get(0);
            int y=edges.get(i).get(1);
            set.add(x);
            list.add(y);
        }
        for(int x:list){
            if(set.contains(x)){
                set.remove(x);
            }
        }
        return new ArrayList<>(set);
    }
}
/*
* 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
给你一个有效的甲板，仅由战舰或者空位组成。
战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
示例 :
X..X
...X
...X
在上面的甲板中有2艘战舰。
无效样例 :
...X
XXXX
...X
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/battleships-in-a-board
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution5 {
    public int countBattleships(char[][] board) {
        int count=0;
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j]=='X'&&(i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.')){
                    count++;
                }
            }
        }
        return count;
    }
}
/*
* 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
并返回一个包含给定查询 queries 所有结果的数组。
示例 1：
输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
输出：[2,7,14,8]
解释：
数组中元素的二进制表示形式是：
1 = 0001
3 = 0011
4 = 0100
8 = 1000
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution6 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[]end=new int[queries.length];
        for(int i=0;i<queries.length;++i){
            int left=queries[i][0];
            int right=queries[i][1];
            for(int j=left;j<=right;++j){
                end[i]^=arr[j];
            }
        }
        return end;
    }
}