import java.util.Scanner;
public class Main {
    public static void sign(){
        Scanner input=new Scanner(System.in);
        System.out.print("用户名：");
        String str=input.nextLine();
        System.out.print("密码：");
        String password=input.nextLine();
        try{
          if(!("飞哥好帅呀".equals(str))){
              throw new MyException("用户名不存在");
          }else{
              if(!("666666".equals(password))){
                throw new MyException("密码错误");
              }
              System.out.println("登陆成功");
          }
        }catch(MyException e){
            e.printStackTrace();
            System.out.println("登陆失败");
           }
    }
    public static void main(String[] args) {
    sign();
    }
}
