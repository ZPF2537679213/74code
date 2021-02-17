import java.util.*;

public class Main {
    public static void main(String[] args) {
List<Integer> list=new ArrayList<>();
    }
}
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
// 
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]
//法一：追加回溯
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        for(int x:nums){
            int len=list.size();
            for(int i=0;i<len;++i){
                List<Integer>arr=new ArrayList<>(list.get(i));
                arr.add(x);
                list.add(arr);
            }
        }
        return list;
    }
}
//法二：递归
 class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, 0);
        return res;
    }
    public void backtrack(int[] nums, List<Integer> track, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.remove(track.size()-1);
        }
    }
}
//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
//对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
/*
输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
        输出：4
        解释：最长递增路径为 [1, 2, 6, 9]。*/
//深度搜索
class Solution3 {
    private int m, n;
    private int[][] matrix;
    private int[][] max;
    private int maxLen = 0;
    private int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        m= matrix.length;
        n = m == 0 ? 0 : matrix[0].length;
        this.matrix = matrix;
        max=new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(max[i][j] == 0)
                    longestIncreasingPath(i, j);
        return maxLen;
    }
    private int longestIncreasingPath(int x, int y)
    {
        if(max[x][y] != 0)
            return max[x][y];
        max[x][y] = 1;
        for(int k = 0; k < 4; k++)
        {
            int newX = x + dir[k][0];
            int newY = y + dir[k][1];
            if((newX>=0&&newY>=0&&newX<m&&newY<n)&& matrix[x][y] < matrix[newX][newY])
                max[x][y] = Math.max(max[x][y], longestIncreasingPath(newX, newY) + 1);
        }
        maxLen = Math.max(maxLen, max[x][y]);
        return max[x][y];
    }
}
//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
//例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
//现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
//求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
//示例 1：
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
//示例 2：
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
class Solution4 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source ==target) {//起始位置就在目标站台
            return 0;
        }
        Map<Integer, Set<Integer>> stopMap = new HashMap<>();//利用hash表：key为站台，value为经过此站台的公交
        for (int i = 0; i < routes.length; ++i) {
            for (int j = 0; j < routes[i].length; ++j) {
                int stop = routes[i][j];
                if (!stopMap.containsKey(stop)) {
                    stopMap.put(stop, new HashSet<Integer>());
                }
                stopMap.get(stop).add(i);
            }
        }
        Queue<Integer>queue=new LinkedList<>();//存放和终点站不同且需要进行处理的站台
        Set<Integer>set=new HashSet<>();//存放已经坐过的公交
        queue.offer(source);//起始站台入队
        int count=1;//上第一辆公交
        while(!queue.isEmpty()){
            int len=queue.size();
            while(len>0){//对队中的待处理站台一一判断
                int stop=queue.poll();
                Set<Integer>s=stopMap.get(stop);
                for(int x:s){
                    if(!set.contains(x)){
                        set.add(x);
                        for(int i=0;i<routes[x].length;++i){
                            int st=routes[x][i];
                            if(st==target){
                                return count;
                            }else{
                                queue.offer(st);
                            }
                        }
                    }
                }
                len--;
            }
            count++;//因为换乘了公交
        }
        return -1;//到达不了目标站台
    }
}