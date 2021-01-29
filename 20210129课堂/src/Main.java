public class Main {

}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {


    public void tree2strChild(TreeNode t,StringBuilder sb) {
        if(t == null) return;
        sb.append(t.val);
        if(t.left == null) {
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else {
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }
}
