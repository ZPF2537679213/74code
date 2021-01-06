class Node{
    public int data;
    public Node next;
    public Node(){

    }
    public Node(int data){
        this.data=data;
    }
}
public class MyLinkList {
    public Node head;
    //头插
    public void headInsert(int data){
        Node cur=new Node(data);
        cur.next=this.head;
        this.head=cur;
    }
    //尾插
    public void endInsert(int data){
        Node cur=new Node(data);
        if(this.head==null){
            this.head=cur;
        }else{
            Node node;
            for(node=this.head;node.next!=null;node=node.next);
           node.next=cur;
        }
    }
    //查找
    public Node search(int key){
        Node cur=this.head;
      while(cur!=null){
          if(cur.data==key){
              break;
          }
          cur=cur.next;
      }
      return cur;
    }
    //删除
    public void deleted(int key){
        Node cur,node;
      for(node=cur=this.head;cur!=null&&cur.data!=key;node=cur,cur=cur.next);
      if(cur!=null){
          if(cur!=this.head){
              node.next=cur.next;
          }else{
              this.head=this.head.next;
          }
      }
    }
    //打印
    public void display(Node head){
        if(head!=null){
            System.out.print(head.data+"->");
            display(head.next);
        }
        System.out.println();
    }
    //删除所有为key的结点
    public void deleted2(int key){
        Node node=this.head,cur=this.head.next;
        if(this.head!=null){
           while(cur!=null){
               if(cur.data!=key){
                   node=cur;
               } else {
                   node.next = cur.next;
               }
               cur=cur.next;
           }
           if(this.head.data==key){
               this.head=this.head.next;
           }
        }
    }
    public void deleted3(int key){
        Node node=this.head,cur=this.head.next;
        if(this.head!=null){
            while(cur!=null){
                if(cur.data!=key){
                    node.next = cur.next;
                    node=cur;
                }
                cur=cur.next;
            }
            if(this.head.data==key){
                this.head=this.head.next;
            }
        }
    }
    //清空
    public void clear(){
        this.head=null;
    }
    //链表逆置（反转链表）
    public void iLink1(){
        if(this.head!=null){
            Node node=this.head;
            Node cur=null;
            Node nodeNext=this.head.next;
            while(nodeNext!=null){
                node.next=cur;
                cur=node;
                node=nodeNext;
                nodeNext=nodeNext.next;
            }
            node.next=cur;
            cur=node;
            this.head=node;
        }
    }
    //返回中间值
    public Node midNode(){
        Node fast=this.head;
        Node low=this.head;
        while(fast.next!=null&&fast!=null){
            fast=fast.next.next;
            low=low.next;
        }
        return low;
    }
}
