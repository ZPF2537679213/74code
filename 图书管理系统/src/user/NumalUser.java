package user;

public class NumalUser extends User{
    public NumalUser(String name){
        super(name);
    }
    @Override
    public void menu() {
        System.out.println("=============================");
        System.out.println("**********1浏览书架1**********");
        System.out.println("**********2查找图书2**********");
        System.out.println("**********3借阅图书3**********");
        System.out.println("**********4归还图书4**********");
        System.out.println("**********0用户退出0**********");
        System.out.println("=============================");
    }
}
