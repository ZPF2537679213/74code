/**
 * @author:飞哥
 * @date: 2021/5/25 20:29
 */
public class Main2 {
    static class Singleton{
        //1.创建私有构造方法
        private Singleton(){}
        //2.创建一个私有的类对象
        private volatile static Singleton singleton=null;
        //3.提供统一的访问入口
        public static Singleton getInstance(){
            if(singleton==null){
                synchronized (Singleton.class) {
                    if(singleton==null){
                    singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }
    public static Singleton s1=null;
    public static Singleton s2=null;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                s1=Singleton.getInstance();
            }
        });
        thread.start();
        s2=Singleton.getInstance();
        thread.join();
        System.out.println(s1==s2);
    }
}
