package ir.maktab.library;

public class Book {
    private static int bookIdCounter = 1000;
    private String bookName;
    private int bookId = 1000;
    private int numberOfEachBook;

    public Book() {
        setBookId(bookIdCounter++);
    }

    public Book(String bookName, int numberOfEachBook) {
        this();
        this.bookName = bookName;
        this.numberOfEachBook = numberOfEachBook;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public static int getBookIdCounter() {
        return bookIdCounter;
    }

    public static void setBookIdCounter(int bookIdCounter) {
        Book.bookIdCounter = bookIdCounter;
    }

    public int getNumberOfEachBook() {
        return numberOfEachBook;
    }

    public void setNumberOfEachBook(int numberOfEachBook) {
        this.numberOfEachBook = numberOfEachBook;
    }


}
