package book;
public class Link{
    private Book book;
    private Link next;

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Link getNext() {
        return next;
    }
    public void setNext(Link next) {
        this.next = next;
    }
    public Link(Book book){
        this.book=book;
    }
}

