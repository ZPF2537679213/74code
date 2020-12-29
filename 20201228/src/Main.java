import java.util.Arrays;
class MyArrayList{
    private int useSize;
    private int[]elem;
    //构造方法
    public MyArrayList(){
        this.elem=new int[6];
    }
    //打印顺序表
    public void display(){
        if(this.useSize==0){
            System.out.println("null");
            return;
        }
        for(int i=0;i<this.useSize;++i){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //在顺序表中插入元素
    public void insert(int pos,int key){
        if(pos<0||pos>this.useSize){
            System.out.println("格式不合法");
            return;
        }
        if(this.useSize==this.elem.length){
            System.out.println("顺序表已满，扩容为两倍!");
            this.elem=Arrays.copyOf(this.elem,2*(this.elem.length));
        }
        for(int i=this.useSize-1;i>=pos;--i){
            this.elem[i+1]=this.elem[i];
        }
        this.elem[pos]=key;
        this.useSize++;
    }
    //尾插
    public void add(int key){
        if(this.useSize==this.elem.length){
            System.out.println("顺序表已满，扩容为两倍!");
            this.elem=Arrays.copyOf(this.elem,2*(this.elem.length));
        }
        this.elem[this.useSize]=key;
        this.useSize++;
    }
    //判定是否包含某个元素
    public boolean contains(int key){
        if(this.useSize>0){
            for(int i=0;i<this.useSize;++i){
                if(this.elem[i]==key){
                    return true;
                }
            }
        }
        return false;
    }
    //查找某个元素对应位置
    public int search(int key){
        if(this.useSize>0){
            for(int i=0;i<this.useSize;++i){
                if(this.elem[i]==key){
                    return i;
                }
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos){
        if(pos>=0&&pos<this.useSize){
            return this.elem[pos];
        }
        return -1;
    }
    //给pos位置设置为value
    public void setPos(int pos,int value){
        if(pos>=0&&pos<this.useSize){
            this.elem[pos]=value;
        }else{
            System.out.println("pos不合法");
        }
    }
    //删除第一次出现的关键字key
    public void remove(int key){
        if(this.useSize>0){
            if(search(key)!=-1){
                for(int i=search(key);i<this.useSize-1;++i){
                    this.elem[i]=this.elem[i+1];
                }
                this.useSize--;
                System.out.println("已删除!");
            }else{
                System.out.println("没有找到要删除的关键字!");
            }
        }else{
            System.out.println("顺序表为空，不需要删除!");
        }
    }
    //获取顺序表长度
    public int size(){
        return this.useSize;
    }
    //清空顺序表
    public void clear(){
        this.useSize=0;
    }
}
public class Main {
    public static void main(String[] args) {
    MyArrayList num=new MyArrayList();
    num.insert(0,8);
    num.add(9);
    num.insert(1,18);
    num.display();
    num.remove(8);
    num.display();
    num.add(99);
    num.display();
        System.out.println(num.search(99));
        System.out.println(num.contains(8));
        System.out.println(num.getPos(4));
        num.clear();
        num.display();
    }
}
