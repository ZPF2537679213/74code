import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:飞哥
 * @date: 2021/5/19 20:06
 */
public class Main3 {
    public static void main(String[] args) {
        //创建带缓存的线程池
      ExecutorService service=Executors.newCachedThreadPool();
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
