import java.util.Scanner;
public class HelloWord {//public:引用限制符；class：申明一个类；HelloWord：类名，注意用public class申明的类只能有一个，并且类名要和文件名相同
    public static void main(String[]args){//（固定写法）static:静态；String[]args:形式参数
        Scanner input=new Scanner(System.in);
        System.out.println("HelloWorld");//输出
    }
}
