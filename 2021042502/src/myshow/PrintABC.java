package myshow;

/**
 * @author:飞哥
 * @date: 2021/4/25 22:21
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        PrintABC printABC=new PrintABC();
        for(int i=0;i<10;++i){
            printABC.showA();
            printABC.showB();
            printABC.showC();
        }
    }
    public  void showA() throws InterruptedException {
           Thread thread=new Thread(new Runnable() {
               @Override
               public void run() {
                       System.out.print('A');
               }
           });
           thread.run();
        }
    public  void showB() throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.print('B');
            }
        });
        thread.run();
        }
    public  void showC() throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println('C');
                }
        });
        thread.run();
        }
}
