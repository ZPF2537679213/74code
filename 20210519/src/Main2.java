import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author:飞哥
 * @date: 2021/5/19 19:54
 */
public class Main2 {
    public static int count=0;
    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread=new Thread(r);
            thread.setName("myThreadPoll-"+count++);
            thread.setPriority(10);
            return thread;
        }
    }
    public static void main(String[] args) {
        //线程工厂
        MyThreadFactory myThreadFactory=new MyThreadFactory();
        ExecutorService executorService= Executors.newFixedThreadPool(10,myThreadFactory);
        for(int i=0;i<10;++i){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
                }
            });
        }
    }
}
