package MyRunnable;

/**
 * @author:飞哥
 * @date: 2021/4/25 19:45
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        //新建Runnable类
        MyRunnable runnable=new MyRunnable();
        //新建Thread
        Thread thread=new Thread(runnable);
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
