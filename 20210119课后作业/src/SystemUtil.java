public class SystemUtil{
    public static boolean isAdmin(String userId){
        String str=userId.toLowerCase();//返回一个new String
        System.out.println(str);
        return str=="admin";//所以为false
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }
}