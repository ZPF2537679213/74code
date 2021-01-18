package user;

public class RootUser extends User{
public RootUser(String name){
    super(name);
}
    @Override
    public void menu() {
        System.out.println("=============================");
        System.out.println("**********1浏览书架1**********");
        System.out.println("**********2查找图书2**********");
        System.out.println("**********3删除图书3**********");
        System.out.println("**********4添加图书4**********");
        System.out.println("**********5修改图书5**********");
        System.out.println("**********0用户退出0**********");
        System.out.println("=============================");
    }

}
