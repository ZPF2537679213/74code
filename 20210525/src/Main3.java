import java.util.Random;

/**
 * @author:飞哥
 * @date: 2021/5/25 21:17
 */
public class Main3 {
    static class MyBlockingQueue{
        private int[]values;//实际存储数据的数组
        private int first;//队首
        private int last;//队尾
        private int size;//队列元素的实际大小
        public MyBlockingQueue(int inition){//初始化变量
            values=new int[inition];
            first=0;
            last=0;
            size=0;
        }
        public void offer(int val){//添加元素到队尾
            synchronized (this){
            //判断边界值
            if(size==values.length){
                //队列已满
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            values[last++]=val;
            size++;
            //判断是否为最后一个元素
                if(last==values.length){
                    last=0;
                }
                //尝试唤醒消费者
                this.notify();
            }
        }
        public int poll(){
            int result=-1;
            synchronized (this){
                //判断边界值
                if(size==0){
                    //队列为空，阻塞等待
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                result=values[first++];
                size--;
                if(first==values.length){
                    first=0;
                }
                //尝试唤醒生产者
                this.notify();
            }

            return result;
        }
    }
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue=new MyBlockingQueue(100);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    //每隔200毫秒生产一个数据
                    int num=new Random().nextInt(10);
                    System.out.println(num);
                    myBlockingQueue.offer(num);
                    System.out.println("生产者："+num);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    int result=myBlockingQueue.poll();
                    System.out.println("消费者："+result);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
