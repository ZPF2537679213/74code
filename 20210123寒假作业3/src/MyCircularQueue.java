//循环队列

public class MyCircularQueue {

    private int front;
    private int rear;//代表当前可以存放数据元素的下标
    private int[] elem;

    public MyCircularQueue(int k) {
        this.elem = new int[k];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队
     * (rear+1)  % len
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        //放到数组的rear下标  rear往后走
        this.elem[this.rear]=value;
        this.rear=(this.rear)%this.elem.length;
        return true;
    }

    /**
     * 队列是否为满
     * @return
     */
    public boolean isFull() {
   return (this.rear+1)%this.elem.length==this.front;
    }

    /**
     * 出队
     * @return
     */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        //只需要挪动front这个下标就好了
        this.front=(this.front+1)%this.elem.length;
        return true;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
    return this.rear==this.front;
    }

    /**
     * 得到队头元素
     * @return
     */
    public int Front() {
     return this.elem[this.front];
    }

    /**
     * 得到队尾元素
     * @return
     */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = -1;
        if(this.rear == 0) {
            index = this.elem.length-1;
        }else {
            index = this.rear-1;
        }
        return this.elem[index];
    }
}
