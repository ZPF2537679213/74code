import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/5/19 21:23
 */
public class Main8 {
    public static void main(String[] args) {

    }
}
//给你 root1 和 root2 这两棵二叉搜索树。
//请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>list=new ArrayList<>();
        midShow(root1,list);
        midShow(root2,list);
        Collections.sort(list);
        return list;
    }
    public void midShow(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        midShow(root.left,list);
        list.add(root.val);
        midShow(root.right,list);
    }
}
//根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
//给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
//如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
//下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
class Solution2 {
    public int[][]index=new int[][]{{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int[][]num=new int[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                num[i][j]=board[i][j];
            }
        }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                int count=dfs(num,i,j);
                if(board[i][j]==1){
                    if(count<2||count>3){
                        board[i][j]=0;
                    }
                }else{
                    if(count==3){
                        board[i][j]=1;
                    }
                }
            }
        }
    }
    public int dfs(int[][]board,int x,int y){
        int life=0;
        for(int i=0;i<8;++i){
            int nx=x+index[i][0];
            int ny=y+index[i][1];
            if(nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length&&board[nx][ny]==1){
                life++;
            }
        }
        return life;
    }
}
