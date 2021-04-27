package MyRunnable;

/**
 * @author:飞哥
 * @date: 2021/4/25 19:49
 */
public class MyRunnable3 {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
