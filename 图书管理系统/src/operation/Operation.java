package operation;
import book.BookList;

public interface Operation {
    void add(BookList bookList);
    void borrow(BookList bookList);
    void change(BookList bookList);
    void delete(BookList bookList);
    void returned(BookList bookList);
    void search(BookList bookList);
    void display(BookList bookList);
}
