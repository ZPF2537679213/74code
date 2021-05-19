import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;//juc，并发包

/**
 * @author:飞哥
 * @date: 2021/5/19 18:40
 */
public class Main {
    public static void main(String[] args) {
        //创建固定个数的线程池
      ExecutorService executorService=Executors.newFixedThreadPool(5);
      //执行一个任务
       /* executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名"+Thread.currentThread().getName());
            }
        });*/
       //执行多个任务
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名"+Thread.currentThread().getName());
                }
            });
        }

    }
}
