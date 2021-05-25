/**
 * @author:飞哥
 * @date: 2021/5/25 18:40
 */
class Singleton{
    //1.先创建一个私有的构造函数(防止其他类直接创建，因为是单例)
    private Singleton(){

    }
    //2.定义一个私有变量
    private static Singleton singleton=new Singleton();
    //3.提供公共的获取实例的方法
    public static Singleton getInstance(){
        return singleton;
    }
}
public class Main {
    public static void main(String[] args) {
        //饿汉模式
        Singleton singleton=Singleton.getInstance();
        System.out.println(singleton);
    }
}
