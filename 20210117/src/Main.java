public class Main {
    public static void main(String[] args) {
      Animal animal=new Cat();
      animal.eat();
      Cat cat=new Cat();
      cat.eat();
    }
}
class Animal {
 public void eat(){
     System.out.println("Animal");
 }
}
class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("cat");
    }
}
abstract class Vitural{
    public abstract void eat();
    public void shape(){
        
    }
}