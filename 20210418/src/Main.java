import java.util.TreeSet;

/**
 * @author:飞哥
 * @date: 2021/4/18 13:04
 */
public class Main {
    public static void main(String[] args) {

    }
}
/*
* 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。

同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。

对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。

请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[]num=new int[queries.length];
        for(int i=0;i<queries.length;++i){
            int x=queries[i][0];
            int y=queries[i][1];
            int r=queries[i][2];
            for(int j=0;j<points.length;++j){
                int left=points[j][0];
                int right=points[j][1];
                int load=(int)Math.pow(left-x,2)+(int)Math.pow(right-y,2);
                if(load<=r*r){
                    num[i]++;
                }
            }
        }
        return num;
    }
}
/*
* 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
* 输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
* */
class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][]num=new int[n][n];
        int left=0;
        int right=n-1;
        int up=0;
        int down=n-1;
        int number=1;
        while(left<=right&&up<=down){
            for(int i=left;i<=right;++i){
                num[up][i]=number;
                number++;
            }
            for(int i=up+1;i<=down;++i){
                num[i][right]=number;
                number++;
            }
            for(int i=right-1;i>=left;--i){
                num[down][i]=number;
                number++;
            } for(int i=down-1;i>up;--i){
                num[i][left]=number;
                number++;
            }
            up++;
            down--;
            left++;
            right--;
        }
        return num;
    }
}
