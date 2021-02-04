import java.util.*;

class BSNode{
    public int val;
    public BSNode left;
    public BSNode right;
    public BSNode(int val){
        this.val=val;
    }
}
public class Main {
    public BSNode root;
    public void remove(int val) {
        if(root == null) return;
        BSNode cur = root;
        BSNode parent = null;
        while (cur != null) {
            if(cur.val == val) {
                removeNode(parent,cur,val);
                return;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    /**
     * 删除二叉搜索树的节点
     * @param parent
     * @param cur
     * @param val
     */
    public void removeNode(BSNode parent,BSNode cur,int val) {
        if(cur.left == null) {
        if(parent.left==cur){
            parent.left=cur.right;
        }else if(parent.right==cur){
            parent.right=cur.right;
        }else{
            root=cur.right;
        }
        }else if(cur.right == null) {
            if(parent.left==cur){
                parent.left=cur.left;
            }else if(parent.right==cur){
                parent.right=cur.left;
            }else{
                root=cur.left;
            }
        }else {
            BSNode targetParent = cur;
            BSNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //target指向的节点就是 右边的最小值
            cur.val = target.val;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>list=new LinkedList<>();
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        HashMap<Integer,Integer>map=new HashMap<>();

    }
}
