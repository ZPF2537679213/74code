import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:飞哥
 * @date: 2021/5/19 21:12
 */
public class Main7 {
    public static void main(String[] args) {
        //根据当前工作环境来创建
      ExecutorService service=Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        while(!service.isTerminated()){

        }
    }
}
