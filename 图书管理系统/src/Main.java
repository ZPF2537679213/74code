import java.util.Scanner;

import user.User;
import user.NumalUser;
import user.RootUser;
import book.BookList;
import operation.MyOperation;
public class Main {
    public static void user(User u){
     u.menu();
    }
    public static void work(){
        Scanner scanner=new Scanner(System.in);
        BookList bookList=new BookList();
        MyOperation operation=new MyOperation();
        int score,choice;
        do{
        System.out.print("用户名：");
        String name=scanner.nextLine();
        System.out.println("欢迎"+name+"进入图书管理系统！");
        System.out.print("身份（1-》管理员 2-》普通用户 3-》退出系统）：");
        choice=scanner.nextInt();
        switch(choice){
            case 1:RootUser rootUser=new RootUser(name);
                   user(rootUser);
                do{
                    System.out.print("请输入你的操作：");
                    score=scanner.nextInt();

                switch(score){
                    case 1:operation.display(bookList);break;
                    case 2:operation.search(bookList);break;
                    case 3:operation.delete(bookList);break;
                    case 4:operation.add(bookList);break;
                    case 5:operation.change(bookList);break;
                    case 0: System.out.println("用户已退出！");break;
                    default: System.out.println("操作错误！");break;
                }
                }while(score!=0);
                   break;
            case 2:NumalUser numalUser=new NumalUser(name);
                   user(numalUser);
                do{
                System.out.print("请输入你的操作：");
                score=scanner.nextInt();
                switch(score){
                    case 1:operation.display(bookList);break;
                    case 2:operation.search(bookList);break;
                    case 3:operation.borrow(bookList);break;
                    case 4:operation.returned(bookList);break;
                    case 0:System.out.println("用户已退出！");break;
                    default: System.out.println("操作错误！");break;
                  }
                }while(score!=0);
                   break;
            case 3: System.out.println("退出系统！");break;
            default:
                System.out.println("操作错误！");break;
            }
        }while(choice!=3);
    }
    public static void main(String[] args) {
    work();
    }
}
