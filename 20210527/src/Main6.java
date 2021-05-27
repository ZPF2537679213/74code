/**
 * @author:飞哥
 * @date: 2021/5/27 22:10
 */
public class Main6 {
}
/**
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 *
 * 示例1
 * 输入：
 * {1,2,3,4,5},2
 * 复制
 * 返回值：
 * {2,1,4,3,5}
 * **/
class ListNode {
    int val;
    ListNode next = null;
  }
class Solution {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */

    public ListNode reverseKGroup (ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newhead=null;
        ListNode node=head;
        int x=k;
        while(x>1){
            node=node.next;
            x--;
            if(node==null){
                return head;
            }
        }
        ListNode next=head;
        ListNode pre=null;
        ListNode cur=head;
        ListNode c=node.next;
        while(next!=c){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        newhead=pre;
        head.next=reverseKGroup(c,k);
        return newhead;
    }
}
/**
 * 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和 **/
class Solution2 {
    public void merge(int A[], int m, int B[], int n) {
        int i=0,j=0;
        while(i<m&&j<n){
            if(j<n&&A[i]>B[j]){
                for(int k=m;k>i;--k){
                    A[k]=A[k-1];
                }
                A[i]=B[j];
                m++;
                j++;
            }else{
                i++;
            }
        }
        while(j<n){
            A[m++]=B[j++];
        }
    }
}
/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度的解法么？**/
class Solution3 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        return !(fast==null||fast.next==null);
    }
}
/**
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。**/
class Solution4 {
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][]end=new int[n][m];
        end[0][0]=matrix[0][0];
        for(int i=1;i<n;++i){
            end[i][0]=matrix[i][0]+end[i-1][0];
        }
        for(int i=1;i<m;++i){
            end[0][i]=end[0][i-1]+matrix[0][i];
        }
        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                end[i][j]=Math.min(end[i-1][j],end[i][j-1])+matrix[i][j];
            }
        }
        return end[n-1][m-1];
    }
}
/**
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null**/
class Solution5 {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)break;
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}