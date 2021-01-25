import java.util.*;
//约瑟夫环
import java.util.*;


public class MyQueue {
    public  int getResult(int n) {
        if(n<=2){
            return 1;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;++i){
            queue.offer(i);
        }
        int m=2;
        int start=0;
        int i;
        while(queue.size()>1){
            i=0;
            while(queue.size()>1&&i<queue.size()){
                start=(start+1)%m;
                if(start!=1){
                    queue.remove(i);
                }else{
                    i++;
                }
            }
            int x=queue.remove(queue.size()-1);
            queue.add(0,x);
            start=0;
            m++;
        }
        return queue.get(0);
    }
}
//给定一个栈及一个操作序列int[][2] ope(C++中为vector<vector<int>>)，代表所进行的入栈出栈操作。第一个元素为1则入栈，第二个元素为数的正负号；第一个元素为2则出栈，第二个元素若为0则出最先入栈的那个数，为1则出最先入栈的正数，为-1则出最先入栈的负数。请按顺序返回出栈的序列，并做异常处理忽略错误操作。
//
//测试样例：
//[[1,1],[1,-1],[2,0],[2,-1]]
//返回：[1,-1]
 class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        LinkedList<Integer>queue=new LinkedList<>();
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<ope.length;++i){
            if(ope[i][0]!=2){
                queue.offer(ope[i][0]*ope[i][1]);
            }else{
                if(queue.isEmpty()){
                    continue;
                }
                if(ope[i][1]==0){
                    arr.add(queue.poll());
                }else{
                    int j=0;
                    if(ope[i][1]==-1){
                        while(j<queue.size()&&queue.get(j)>0){
                            j++;
                        }
                    }
                    if(ope[i][1]==1){
                        while(j<queue.size()&&queue.get(j)<0){
                            j++;
                        }
                    }
                    if(j<queue.size()){
                        arr.add(queue.remove(j));
                    }
                }
            }
        }
        return arr;
    }
}