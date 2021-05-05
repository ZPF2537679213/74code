import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:飞哥
 * @date: 2021/5/5 20:46
 */
public class Main {

}
/*
* 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
最后返回经过上色渲染后的图像。
示例 1:
输入:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出: [[2,2,2],[2,2,0],[2,0,1]]
解析:
在图像的正中间，(坐标(sr,sc)=(1,1)),
在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，
因为它不是在上下左右四个方向上与初始点相连的像素点。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flood-fill
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int[][]index=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][]flag=new int[image.length][image[0].length];
        flood(image,sr,sc,image[sr][sc],flag);
        for(int i=0;i<image.length;++i){
            for(int j=0;j<image[i].length;++j){
                image[i][j]=flag[i][j]==1?newColor:image[i][j];
            }
        }
        return image;
    }
    public void flood(int[][]image,int sr,int sc,int key,int[][]flag){
        if(sr>=image.length||sr<0||sc>=image[0].length||sc<0){
            return;
        }
        if(image[sr][sc]==key&&flag[sr][sc]==0){
            flag[sr][sc]=1;
        }else{
            return;
        }
        for(int i=0;i<4;++i){
            int x=sr+index[i][0];
            int y=sc+index[i][1];
            flood(image,x,y,key,flag);
        }
    }
}
/*
* 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
输出：16
解释：它的周长是上面图片中的 16 个黄色的边
示例 2：
输入：grid = [[1]]
输出：4
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/island-perimeter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution2 {
    public int[][]index=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        int sum=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                if(grid[i][j]==1){
                    sum+=island(grid,i,j);
                }
            }
        }
        return  sum;
    }
    public int island(int[][]grid,int x,int y){
        if(x<0||x>=grid.length||y>=grid[0].length||y<0||grid[x][y]==0){
            return 1;
        }
        if(grid[x][y]==2){
            return 0;
        }
        int sum=0;
        grid[x][y]=2;
        for(int i=0;i<4;++i){
            int nx=x+index[i][0];
            int ny=y+index[i][1];
            sum+=island(grid,nx,ny);
        }
        return sum;
    }
}
/*
* 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution3 {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;++i){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }
        for(int i=0;i<board[0].length;++i){
            dfs(board,0,i);
            dfs(board,board.length-1,i);
        }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][]board,int x,int y){
        if(x<0||x==board.length||y<0||y==board[0].length){
            return;
        }
        if(board[x][y]=='X'){
            return;
        }
        if(board[x][y]=='O'){
            board[x][y]='#';
            dfs(board,x+1,y);
            dfs(board,x-1,y);
            dfs(board,x,y+1);
            dfs(board,x,y-1);
        }
    }
}
/*
* 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution4 {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                if(grid[i][j]=='1'){
                    count++;
                    island(grid,i,j);
                }
            }
        }
        return count;
    }
    public void island(char[][]grid,int x,int y){
        if(x<0||x==grid.length||y<0||y==grid[0].length){
            return;
        }
        if(grid[x][y]=='0'){
            return;
        }
        if(grid[x][y]=='1'){
            grid[x][y]='2';
            island(grid,x+1,y);
            island(grid,x-1,y);
            island(grid,x,y+1);
            island(grid,x,y-1);
        }
    }
}
/*
* 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution5 {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                if(grid[i][j]==1){
                    max=Math.max(max,island(grid,i,j));
                }
            }
        }
        return max;
    }
    public int island(int[][]grid,int x,int y){
        if(x<0||x==grid.length||y<0||y==grid[0].length){
            return 0;
        }
        if(grid[x][y]==0){
            return 0;
        }
        int mul=0;
        if(grid[x][y]==1){
            mul++;
            grid[x][y]=2;
            mul+=island(grid,x+1,y)+island(grid,x-1,y)+island(grid,x,y+1)+island(grid,x,y-1);
        }
        return mul;
    }
}
/*
* 在给定的网格中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：
输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
示例 3：
输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotting-oranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution6 {
    public int orangesRotting(int[][] grid) {
        int minute=0;
        if(grid.length==0){
            return -1;
        }
        minute=nfs(grid);
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return minute;
    }
    public int nfs(int[][]grid){
        int minute=0;
        Queue<String> queue=new LinkedList<>();
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[i].length;++j){
                if(grid[i][j]==2){
                    String s=i+" "+j;
                    queue.offer(s);
                }
            }
        }
        while(!queue.isEmpty()){
            int len=queue.size();
            int flag=0;
            while(len>0){
                String s=queue.poll();
                String[]ss=s.split(" ");
                int x=Integer.valueOf(ss[0]);
                int y=Integer.valueOf(ss[1]);
                if(x-1>=0&&grid[x-1][y]==1){
                    grid[x-1][y]=2;
                    queue.offer((x-1)+" "+y);
                    flag=1;
                }
                if(x+1<grid.length&&grid[x+1][y]==1){
                    grid[x+1][y]=2;
                    queue.offer((x+1)+" "+y);
                    flag=1;
                }
                if(y-1>=0&&grid[x][y-1]==1){
                    grid[x][y-1]=2;
                    queue.offer(x+" "+(y-1));
                    flag=1;
                }
                if(y+1<grid[0].length&&grid[x][y+1]==1){
                    grid[x][y+1]=2;
                    queue.offer(x+" "+(y+1));
                    flag=1;
                }
                len--;
            }
            if(flag==1){
                minute++;
            }
        }
        return minute;
    }
}