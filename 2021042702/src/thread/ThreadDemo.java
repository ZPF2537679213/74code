package thread;

/**
 * @author:飞哥
 * @date: 2021/4/27 19:02
 */
public class ThreadDemo {
    public  static boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()){//用来判断线程是否终止，默认false
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                    System.out.println("别烦我，我正在转账!");
                }
            }
        });
        t1.start();
        Thread.sleep(301);
        System.out.println("有内鬼，停止交易!");
        t1.interrupt();//用来终止线程*/
       /* for(Thread.State item:Thread.State.values()){
            System.out.println(item);
        }*/
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!flag){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hhhhhhhh");
                }
                System.out.println("jiasju");
            }
        });
        t1.start();
        /*Thread.sleep(100);
        flag=true;
        System.out.println("jieshu");*/
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag=true;
            }
        });
        t2.start();
    }
}
