import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:飞哥
 * @date: 2021/5/23 16:41
 */
public class Main4 {
    static ThreadLocal<String>threadLocal=new ThreadLocal<>();
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000)
        );
        for(int i=0;i<2;++i){
            MyTask t=new MyTask();
            executor.execute(t);
        }
    }
    static class MyTask extends Thread{
        static boolean first=true;
        @Override
        public void run() {
          if(first){
              threadLocal.set(this.getName());
              first=false;
          }
            System.out.println(this.getName()+":"+threadLocal.get());
        }
    }
}
