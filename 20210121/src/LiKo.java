public class LiKo {
}
//在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
//
//如果小镇的法官真的存在，那么：
//
//小镇的法官不相信任何人。
//每个人（除了小镇法官外）都信任小镇的法官。
//只有一个人同时满足属性 1 和属性 2 。
//给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
//
//如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
class Solution {
    public int findJudge(int N, int[][] trust) {
        int i,j;
        for(i=1;i<=N;++i){
            int top1=0;
            int top2=0;
            for(j=0;j<trust.length;++j){
                if(trust[j][0]==i){
                    top1++;
                }
                if(trust[j][1]==i){
                    top2++;
                }
            }
            if(top1==0&&top2==N-1){
                top1=0;
                for(j=0;j<trust.length;++j){
                    if(trust[j][0]!=i&&trust[j][1]==i){
                        top1++;
                    }
                }
                if(top1<N-1){
                    return -1;
                }else{
                    return i;
                }
            }
        }
        return -1;
    }
}
//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//
//形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
//
// 
//
//示例 1：
//
//输入：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//示例 2：
//
//输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
//示例 3：
//
//输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
class Solution2 {
    public boolean canThreePartsEqualSum(int[] arr) {
        if(arr!=null&&arr.length!=0){
            int val=0;
            for(int x:arr){
                val=val+x;
            }
            val/=3;
            int count=0;
            int sum=0;
            for(int i=0;i<arr.length;++i){
                sum+=arr[i];
                if(val==sum&&count<2&&i<arr.length-1){
                    count++;
                    sum=0;
                }else if(sum==val&&i==arr.length-1){
                    count++;
                }
            }
            if(count==3){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
class Link{
    public  int val;
    public  Link next;
    public  Link prev;
    public Link(int val){
        this.val=val;
    }
}
class MyLinkedList {
    public Link head;
    public Link last;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(this.head==null){
            return -1;
        }
        Link node =this.head;
        int count=0;
        while(node!=null&&count!=index){
            node=node.next;
            count++;
        }
        if(node!=null){
            return node.val;
        } else{
            return -1;
        }

    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Link node=new Link(val);
        if(this.head==null){
            this.head=this.last=node;
        }else{
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Link node=new Link(val);
        if(this.head==null){
            this.head=this.last=node;
        }else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int count=0;
        Link node=new Link(val);
        Link cur=this.head;
        if(index==0){
            addAtHead(val);
        }else{
            while(count!=index){
                cur=cur.next;
                count++;
            }
            if(cur!=null){
                cur.prev.next=node;
                node.next=cur;
                node.prev=cur.prev;

                cur.prev=node;
            }else{
                node.prev=this.last;
                this.last.next=node;
                this.last=node;

            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Link cur =this.head;
        int count=0;
        while(cur!=null){
            if(index==0){
                this.head=this.head.next;
                return;
            }
            if(index==count){
                if(cur.next!=null){
                    cur.next.prev=cur.prev;
                    cur.prev.next=cur.next;
                }else{
                    this.last=this.last.prev;
                    cur.prev.next=null;
                }

                return;
            }
            cur=cur.next;
            count++;
        }
    }
}

