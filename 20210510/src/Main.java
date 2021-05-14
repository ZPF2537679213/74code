import java.util.concurrent.locks.LockSupport;

/**
 * @author:飞哥
 * @date: 2021/5/10 15:28
 */
public class Main{
    public static int i=0;
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
       Runnable runnable=new Runnable() {
           @Override
           public void run() {
               synchronized (o1){
                   LockSupport.park();
                   System.out.println(i);
                   i++;
               }
           }
       };
       Thread[]threads=new Thread[20];
       for(int i=0;i<20;++i){
           threads[i]=new Thread(runnable);
       }
       for(Thread t:threads){
           t.start();
           LockSupport.unpark(t);
       }
        Thread.sleep(100);
        System.out.println("OK");
    }
}
