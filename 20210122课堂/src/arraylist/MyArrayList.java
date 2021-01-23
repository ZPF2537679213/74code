package arraylist;
//实现 ArrayList 类
public class MyArrayList <T>{
    private T[]elem;
    private int usedSize;
public MyArrayList(){
    this.elem=(T[]) new Object[10];
}
//插入元素
    public void add(T val){
    this.elem[this.usedSize]=val;
    this.usedSize++;
    }
    public void add(int index , T val){
    if(index<this.usedSize){
        int count=this.usedSize-1;
      while(count>=index){
       this.elem[count+1]=this.elem[count];
       count--;
      }
     this.elem[index]=val;
      this.usedSize++;
    } else if(index==this.usedSize){
       this.elem[this.usedSize++]=val;
    }else{
        System.out.println("操作不合法！");
    }
    }
    //删除
    public void remove(T val){
   for(int i=0;i<this.usedSize-1;++i){
       if(this.elem[i]==val){
           for(int j=i;j<this.usedSize-1;++j){
              this.elem[j]=this.elem[j+1];
           }
           this.usedSize--;
           return;
       }
   }
   if(this.elem[this.usedSize-1]==val){
       this.usedSize--;
   }
    }
    //打印
    public void show(){
        System.out.println("-------------------------------------------");
        System.out.print("[");
    for(int i=0;i<this.usedSize;++i){
        System.out.print(this.elem[i]+" ");
    }
        System.out.println("]");
        System.out.println("-------------------------------------------");
    }
}
class Main{
    public static void main(String[] args) {
        MyArrayList<Integer> arr=new MyArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.show();
        arr.add(1,5);
        arr.show();
        arr.remove(3);
        arr.show();
    }
}