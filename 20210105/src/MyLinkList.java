public class MyLinkList {
    private int data;
    private MyLinkList next;
    public MyLinkList head;
    public MyLinkList(){

    }
    public MyLinkList(int data){
        this.data=data;
    }
    //实现单向链表(不带傀儡节点)代码.
    public void add(int data){
        MyLinkList p=this.head;
        if(this.head==null){
            this.head=new MyLinkList(data);
        }else{
            MyLinkList cur=new MyLinkList(data);
            while(p.next!=null){
                p=p.next;
            }
            p.next=cur;
        }
    }
    //打印
    public void show(){
        if(this.head==null){
            System.out.println("null");
        }
        MyLinkList cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+"->");
            cur=cur.next;
        }
        System.out.println();
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public void delated(){
        if(this.head==null){
            return;
        }else{
        MyLinkList newHead=new MyLinkList();
        MyLinkList tmp=newHead;
        MyLinkList cur=this.head;
        while(cur!=null){
         if(cur.next!=null&&cur.data==cur.next.data){
             while(cur.next!=null&&cur.data==cur.next.data){
                 cur=cur.next;
             }
             cur=cur.next;
         }else{
             tmp.next=cur;
             cur=cur.next;
             tmp=tmp.next;
         }
        }
        if(newHead.next==null){
            return;
        }
        tmp.next=null;
     }
    }
    //现有一链表的头指针 ListNode* pHead，给一定值x，编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    /*
    *  public ListNode partition(ListNode pHead, int x) {
        ListNode Ls=null;
        ListNode Le=null;
        ListNode Hs=null;
        ListNode He=null;
        if(pHead==null){
            return null;
        }else{
            ListNode cur=pHead;
            while(cur!=null){
                if(cur.val<x){
                    if(Ls==null){
                        Le=Ls=cur;
                    }else{
                        Le.next=cur;
                        Le=Le.next;
                    }
                }else{
                    if(Hs==null){
                        Hs=He=cur;
                    }else{
                        He.next=cur;
                        He=He.next;
                    }
                }
                cur=cur.next;
            }
            if(Ls==null){
                return Hs;
            }else{
                if(He!=null){
                He.next=null;
                }
                Le.next=Hs;
                return Ls;
            }
        }
    }
    * */
}
