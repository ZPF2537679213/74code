//双向链表
class ListNode{
    private int val;
    private ListNode next;
    private ListNode prev;
    public ListNode(){

    }
    public ListNode(int val){
        this.val=val;
    }
    public int getVal(){
        return this.val;
    }
    public ListNode getNext(){
        return this.next;
    }
    public ListNode getPrev(){
        return this.prev;
    }
    public void setVal(int val){
        this.val=val;
    }
    public void setNext(ListNode next){
        this.next=next;
    }
    public void setPrev(ListNode prev){
        this.prev=prev;
    }
}
public class DoubleLinkList {
    ListNode head;
    ListNode last;
    //头插
    public void addHead(int val){
    ListNode cur=new ListNode(val);
    if(this.head==null){
    this.head=cur;
    this.last=cur;
    }else{
     cur.setNext(this.head);
     this.head.setPrev(cur);
     this.head=cur;
    }
    }
    //尾插
    public void addLast(int val){
      ListNode cur=new ListNode(val);
    if(this.head==null){
     this.head=cur;
     this.last=cur;
    } else{
     this.last.setNext(cur);
     cur.setPrev(this.last);
     this.last=cur;
    }
    }
    //打印
    public void display(){
        ListNode cur=this.head;
      while(cur!=null){
          System.out.print(cur.getVal()+"->");
          cur=cur.getNext();
      }
        System.out.println();
    }

}
