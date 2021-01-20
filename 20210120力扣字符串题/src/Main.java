public class Main {
    //替换？为小写字母，不能重复
    public String modifyString(String s) {
        if(s!=null){
            int i;
            byte[]by=s.getBytes();
            for(i=0;i<by.length;++i){
                if(by[i]=='?'){
                    byte word='a';
                    if(i==0&&by.length==1){
                        by[i]=word;
                        continue;
                    }else if(i==0&&by.length>1){
                        while(by[i+1]==word){
                            word++;
                        }
                    }else if(i<by.length-1){
                        while(by[i+1]==word||by[i-1]==word){
                            word++;
                        }
                    }else{
                        while(by[i-1]==word){
                            word++;
                        }
                    }
                    by[i]=word;
                }
            }
            return new String(by);
        }
        return null;
    }
}
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
//示例 1:
//
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
//示例 2:
//
//输入: "aba"
//
//输出: False
//示例 3:
//
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i;
        for(i=1;i<s.length()/2+1;++i){
            String str=s.substring(0,i);
            int j=str.length();
            while(s.indexOf(str,j)==j){
                j+=str.length();
            }
            if(j==s.length()&&!str.equals(s)){
                return true;
            }
        }
        return false;
    }
}
