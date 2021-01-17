//继承
class Animal{
    public void eat(){
        System.out.println("animal eat");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("cat eat");
    }
}
//接口
interface Fish{
void swim();
}
interface  Dog{
    void run();
}
public class Main implements Fish,Dog{
    public String name;
    public Main(String name){
        this.name=name;
    }
    public void swim() {
        System.out.println(this.name+"Swiming");
    }
    public void run() {
        System.out.println(this.name+"Runing");
    }

    public static void main(String[] args) {
        Main m=new Main("fish");
        m.swim();
    }
}
