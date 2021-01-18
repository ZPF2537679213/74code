package user;

abstract public class User {
    public String name;
    public User(String name){
        this.name=name;
    }
   abstract public void menu();
}
