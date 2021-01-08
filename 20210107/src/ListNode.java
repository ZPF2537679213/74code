public class ListNode {
    private int val;
    private ListNode next;
    public ListNode (){

    }
    public ListNode (int val){
        this.val=val;
    }
    //实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
    public int kthToLast(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        while(k>1){
            if(fast.next==null){
                return -1;
            }
            fast=fast.next;
            k--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.val;
    }
    //输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
    // 从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null;
        }else{
            ListNode fast=head;
            ListNode slow=head;
            while(k>1){
                if(fast.next==null){
                    return null;
                }
                fast=fast.next;
                k--;
            }
            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }
    //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    //示例 1:
    //输入: 1->2->3->4->5->NULL, k = 2
    //输出: 4->5->1->2->3->NULL
    //解释:
    //向右旋转 1 步: 5->1->2->3->4->NULL
    //向右旋转 2 步: 4->5->1->2->3->NULL
    //示例 2:
    //输入: 0->1->2->NULL, k = 4
    //输出: 2->0->1->NULL
    //解释:
    //向右旋转 1 步: 2->0->1->NULL
    //向右旋转 2 步: 1->2->0->NULL
    //向右旋转 3 步: 0->1->2->NULL
    //向右旋转 4 步: 2->0->1->NULL
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }else{
            if(head.next!=null&&k>0){
                ListNode fast=head;
                ListNode slow=head;
                while(k>0){
                    if(fast.next==null&&k==1){
                        return head;
                    }
                    if(fast.next==null){
                        fast=head;
                    }else{
                        fast=fast.next;
                    }
                    k--;
                }
                while(fast.next!=null){
                    fast=fast.next;
                    slow=slow.next;
                }
                ListNode tmp=slow.next;
                fast.next=head;
                head=tmp;
                slow.next=null;
            }
            return head;
        }
    }
//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//示例：
//输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
public void deleteNode(ListNode node) {
    if(node!=null){
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1==null){
        return l2;
    }
    if(l2==null){
        return l1;
    }
    if(l1==null&&l2==null){
        return null;
    }
    ListNode newHead=new ListNode(-1);
    ListNode cur=newHead;
    while(l1!=null&&l2!=null){
        if(l1.val>l2.val){
            cur.next=l2;
            l2=l2.next;
        }else{
            cur.next=l1;
            l1=l1.next;
        }
        cur=cur.next;
    }
    if(l1==null&&l2!=null){
        cur.next=l2;
    }
    if(l2==null&&l1!=null){
        cur.next=l1;
    }
    return newHead.next;
}
}




