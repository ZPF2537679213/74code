package linklist;
//实现 LinkedList 类
public class MyLinkList <T>{
private T val;
private MyLinkList<T> next;
public MyLinkList<T> head;
    public MyLinkList(T val){
        this.val=val;
    }
    public MyLinkList(){

    }
    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public MyLinkList<T> getNext() {
        return next;
    }

    public void setNext(MyLinkList<T> next) {
        this.next = next;
    }
    //头插
   public void addHead(T val){
    MyLinkList<T> node=new MyLinkList<>(val);
    if(this.head==null){
        this.head=node;
    }else{
        node.next=this.head;
        this.head=node;
    }
   }
   //尾插
    public void addLast(T val){
        MyLinkList<T> node=new MyLinkList<>(val);
    if(this.head==null){
        this.head=node;
    }else{
        MyLinkList<T> cur=this.head;
        while(cur.next!=null){
          cur=cur.next;
        }
        cur.next=node;
    }
    }
    //打印
    public void show(){
        MyLinkList<T> cur=this.head;
        System.out.println("-----------------------------------");
        while(cur!=null){
            System.out.print("["+cur.val+"]"+"->");
            cur=cur.next;
        }
        System.out.println();
        System.out.println("-----------------------------------");
    }
    //删除
    public void remove(T val){
        MyLinkList<T> cur=this.head;
        if(cur.val==val){
          this.head=this.head.next;
        }else{
            while(cur.next!=null){
             if(cur.next.val==val){
                 cur.next=cur.next.next;
                 break;
             }
             cur=cur.next;
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        MyLinkList<Integer> arr=new MyLinkList<>();
        arr.addHead(1);
        arr.addHead(3);
        arr.addHead(6);
        arr.show();
        arr.addLast(6);
        arr.remove(3);
        arr.show();
    }
}