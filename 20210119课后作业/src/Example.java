public class Example{
    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main(String args[]){
        Example ex = new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[ ]){//str为局部变量，所以没有被改变，但是数组名代表数组首元素地址，所以0号位置被改变
        this.str = "test ok";
        ch[0] = 'g';
    }
}