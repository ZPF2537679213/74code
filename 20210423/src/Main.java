/**
 * @author:飞哥
 * @date: 2021/4/23 16:50
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        /*LCA lac=new LCA();
        System.out.println(lac.getLCA(4, 10));*/
        BinInsert binInsert=new BinInsert();
        System.out.println(binInsert.binInsert(1024, 19, 2, 6));
    }
}


class LCA {
    public int root=1;
    public int getLCA(int a, int b) {
        return get(a,b);
    }
    public int get(int a,int b){
        boolean left=search(a,b,root*2);
        boolean right=search(a,b,root*2+1);
        if(!(left&&right)){
            if(!left){
                root=root*2+1;
            }else if(!right){
                root=root*2;
            }
            get(a,b);
        }
        return root;
    }
    public boolean search(int a,int b,int root){
        if(root>a&&root>b){
            return false;
        }
        if(root==a){
            return true;
        }
        if(root==b){
            return true;
        }
        return search(a,b,root*2)||search(a,b,root*2+1);
    }
}
class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        // write code here
        StringBuilder sn=numToStr(n);
        StringBuilder sm=numToStr(m);
        for(int k=0;k<sm.length();++k){
            char x=sm.charAt(k);
            sn.insert(j,x);
            j++;
        }
        int sum=0;
        for(int k=0;k<sn.length();++k){
            int x=sn.charAt(k)-'0';
            sum+=x*(int)Math.pow(2,i);
        }
        return sum;
    }
    public StringBuilder numToStr(int n){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<32;++i){
            str.append(n&1);
            n=n>>1;
        }
        return str;
    }
}
/*
* 有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位数到高位且以0开始。
给定两个数int n和int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为零，且m的二进制位数小于等于i-j+1。
测试样例：
1024，19，2，6
返回：1100
做法：m左移j位后和n进行按位或
* */

class BinInsert2 {
    public int binInsert(int n, int m, int j, int i) {
        // m左移j位
        m <<= j;
        return n | m;
    }
};
