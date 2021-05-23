import java.util.Random;
import java.util.concurrent.*;

/**
 * @author:飞哥
 * @date: 2021/5/23 10:00
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                5,
                5,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("执行了自定义的拒绝策略");
                    }
                }//显示错误信息
        );
        /*for (int i = 0; i < 11; i++) {
            final int n=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n+" "+Thread.currentThread().getName());
                }
            });
        }*/
        for (int i = 0; i < 10; i++) {
            Future<Integer>future=executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Random random=new Random();
                    return random.nextInt(10);
                }
            });
            System.out.println(future.get());
        }
    }
}
