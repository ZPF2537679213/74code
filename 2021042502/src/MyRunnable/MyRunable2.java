package MyRunnable;

/**
 * @author:飞哥
 * @date: 2021/4/25 19:48
 */
public class MyRunable2 {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
