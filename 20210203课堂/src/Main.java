import java.util.*;

public class Main {
    public static void main(String[] args) {
     List<Integer> list=new LinkedList<Integer>();
    Collections.sort(list);
    }
    static class Main2{
        public static void haha(){

        }
    }
}
class BinarySearchTree {

    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;
        public BSNode(int val) {
            this.val = val;
        }
    }
    public BSNode root = null;

    public BSNode search(int val) {
        BSNode cur = root;
      while(cur!=null){
          if(cur.val==val){
              return cur;
          }
          if(cur.val>val){
              cur=cur.left;
          }else{
              cur=cur.right;
          }
      }
      return null;
    }

    public boolean insert(int val) {
  BSNode node =new BSNode(val);
  BSNode cur=root;
  if(root==null){
      root=node;
      return true;
  }else{
      BSNode prev=null;
   while(cur!=null){
       prev=cur;
       if(cur.val>val){
           cur=cur.left;
       }
       if(cur.val<=val){
           cur=cur.right;
       }
   }
   if(prev.left==null){
       prev.left=node;
       return true;
   }else{
       prev.right=node;
       return true;
   }
  }
    }

    public void remove(int val) {

    }
}
 class TestDemo {

    public static void main(String[] args) {

    }
}

