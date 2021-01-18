package operation;
import java.util.Scanner;
import book.BookList;
import book.Book;
import book.Link;

public class MyOperation implements Operation {

    @Override
    public void add(BookList bookList) {//添加
        Scanner scanner=new Scanner(System.in);
        System.out.print("书名：");
        String name=scanner.nextLine();
        System.out.print("作者：");
        String Authour=scanner.nextLine();
        System.out.print("单价：");
        double price=scanner.nextDouble();
        System.out.print("数量：");
        int useSize=scanner.nextInt();
        System.out.print("类型：");
        String type=scanner.next();
        Book book=new Book(name,Authour,price,useSize,type);
        Link node=new Link(book);
        if(bookList.head==null){
         bookList.head=node;
        }else{
            Link cur=bookList.head;
            while(cur.getNext()!=null){
                cur=cur.getNext();
            }
            cur.setNext(node);
        }
        System.out.println("添加成功！");
    }

    @Override
    public void borrow(BookList bookList) {//借阅
        Scanner scanner=new Scanner(System.in);
        System.out.print("书名：");
        String name=scanner.nextLine();
        System.out.print("数量：");
        int borrowNum=scanner.nextInt();
    if(bookList.head!=null){
        Link node=bookList.head;
        if(borrowNum<=node.getBook().getUseSize()){
       while(node!=null){
           if(node.getBook().getName().equals(name)){
               node.getBook().setBorrowNum(node.getBook().getBorrowNum()+borrowNum);
               node.getBook().setUseSize(node.getBook().getUseSize()-borrowNum);
               System.out.println("借阅成功！");
               return;
           }
            node=node.getNext();
         }
        }else{
            System.out.println("借阅数量太多！");
            return;
        }
    }
        System.out.println("没有你要借阅的书！");
    }

    @Override
    public void change(BookList bookList) {//修改
    Scanner scanner=new Scanner(System.in);
    if(bookList.head!=null) {
        System.out.println("书名：");
        String name = scanner.nextLine();
        Link node=bookList.head;
        while(node!=null){
            if(node.getBook().getName().equals(name)){
                System.out.print("修改项（1-》书名 2-》作者 3-》价格 4-》数量）：");
                int score=scanner.nextInt();
                switch(score){
                    case 1:System.out.print("书名：");
                           name=scanner.nextLine();
                           node.getBook().setName(name);
                           break;
                    case 2:System.out.print("作者：");
                           String Authour=scanner.nextLine();
                           node.getBook().setAuthour(Authour);
                           break;
                    case 3: System.out.print("价格：");
                            double price=scanner.nextDouble();
                            node.getBook().setPrice(price);
                            break;
                    case 4: System.out.print("数量：");
                            int useSize=scanner.nextInt();
                            node.getBook().setUseSize(useSize);
                            break;
                    default: System.out.println("操作错误！");
                            break;
                }
                System.out.println("修改成功！");
                return;
            }
            node=node.getNext();
        }
    }
        System.out.println("没有你要改的书！");
    }

    @Override
    public void delete(BookList bookList) {//删除
        Scanner scanner=new Scanner(System.in);
        if(bookList.head!=null) {
            System.out.println("书名：");
            String name = scanner.nextLine();
            if(bookList.head.getBook().getName().equals(name)){
                bookList.head=bookList.head.getNext();
                System.out.println("删除成功！");
                return;
            }
            Link node = bookList.head.getNext();
            Link cur=bookList.head;
            while(node!=null){
                if(node.getBook().getName().equals(name)){
                  cur.setNext(node.getNext());
                    System.out.println("删除成功！");
                    return;
                }
                cur=node;
                node=node.getNext();
            }
        }
        System.out.println("没有要删除的书籍！");
    }

    @Override
    public void returned(BookList bookList) {//归还
        Scanner scanner=new Scanner(System.in);
        System.out.print("书名：");
        String name=scanner.nextLine();
        System.out.print("数量：");
        int borrowNum=scanner.nextInt();
        Link node = bookList.head;
        while(node!=null){
            if(node.getBook().getName().equals(name)){
            node.getBook().setUseSize(node.getBook().getUseSize()+borrowNum);
            node.getBook().setBorrowNum(node.getBook().getBorrowNum()-borrowNum);
                System.out.println("归还成功！");
                return;
            }
            node=node.getNext();
        }
        System.out.println("操作错误！");
    }

    @Override
    public void search(BookList bookList) {//查找
        Scanner scanner=new Scanner(System.in);
        System.out.print("书名：");
        String name=scanner.nextLine();
    if(bookList.head!=null){
        Link node = bookList.head;
        while(node!=null){
            if(node.getBook().getName().equals(name)){
                System.out.println("已找到书-》"+name);
                System.out.println(node.getBook());
                return;
            }
            node=node.getNext();
        }
    }
        System.out.println("没找到你要的书籍！");
    }

    @Override
    public void display(BookList bookList) {
        if(bookList.head!=null){
            Link node = bookList.head;
            while(node!=null){
                System.out.println(node.getBook());
                node=node.getNext();
            }
        }else{
        System.out.println("空书架！");
        }
    }
}
