package thread;

/**
 * @author:飞哥
 * @date: 2021/4/25 19:39
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t1=new Thread(){
            @Override
            public void run() {
                System.out.println("线程名称"+Thread.currentThread().getName());
            }
        };
        t1.start();
        System.out.println(Thread.currentThread().getName());
    }
}
