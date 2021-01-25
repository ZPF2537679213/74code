import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        StringBuilder str=new StringBuilder(s);
        StringBuilder istr=str.reverse();
        s=String.valueOf(x);
        str=new StringBuilder(s);
        String a=str.toString();
        String b=istr.toString();
        return a.equals(b);

    }
}