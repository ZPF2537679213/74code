

class Shape2{
public void draw(){
    System.out.println("==");
}
}
class Circle extends Shape2{
public void draw(){
    System.out.println("⚪");
}
}
class LX extends Shape2{
    public void draw(){
        System.out.println("*");
    }
}
public class Shape {
public static void draw(Shape2 shape){
    shape.draw();
}
    public static void main(String[] args) {
    Circle cir=new Circle();
    draw(cir);
    LX lx=new LX();
    draw(lx);
    }
}
