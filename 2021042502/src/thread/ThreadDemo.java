package thread;

/**
 * @author:飞哥
 * @date: 2021/4/25 19:35
 */
public class ThreadDemo extends Thread{
@Override
    public void run(){
    //线程执行任务
    System.out.println("线程名称"+Thread.currentThread().getName());
}

    public static void main(String[] args) {
        Thread t1=new ThreadDemo();
        t1.start();
        System.out.println("主线程方法"+Thread.currentThread().getName());
    }
}
