import java.lang.Enum;

public enum Main{
    RED("红色",1),GREEN("绿色",2),BLACK("黑色",3);
    private String name;
    private int key;
    Main(String name,int key){
        this.name=name;
        this.key=key;
    }
public static String color(int key){
        for(Main x:Main.values()){
            if(x.key==key){
                return x.name;
            }
        }
        return "";
}
    public static void main(String[] args) {
        System.out.println(Main.color(2));
        Main2 m=Main2.GREEN;
        System.out.println(m.ordinal());
        System.out.println(m.valueOf("RED"));
        System.out.println(m);
    }
}
enum Main2{
    RED,GREEN
}

