import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:飞哥
 * @date: 2021/5/19 21:05
 */
public class Main6 {
    public static void main(String[] args) {
        //创建单个线程的线程池
      ExecutorService service=Executors.newSingleThreadExecutor();
      service.execute(new Runnable() {
          @Override
          public void run() {
              System.out.println(Thread.currentThread().getName());
          }
      });
      for(int i=0;i<10;++i){
          service.execute(new Runnable() {
              @Override
              public void run() {
                  System.out.println(Thread.currentThread().getName());
              }
          });
      }
    }
}
