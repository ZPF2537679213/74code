import java.util.List;
import java.util.ArrayList;
class Solution {
    List<String>list=new ArrayList<>();
    public String getHappyString(int n, int k) {
        getHappy(new StringBuilder(""),n);
        /*if(k>list.size()) {
            return "";
        }*/
        return list.get(k-1);
    }
    public void getHappy(StringBuilder s,int n){
        if(s.length()==n){
            String ss=s.toString();
            list.add(ss);
            System.out.println(list.get(list.size()-1));
            return;
        }
        for(char x='a';x<='c';++x){
            if(s.length()==0||s.charAt(s.length()-1)!=x){
                s.append(x);
                getHappy(s,n);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution x=new Solution();
        System.out.println(x.getHappyString(1, 3));
    }
}
