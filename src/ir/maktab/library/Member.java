package ir.maktab.library;

public class Member {
    private String memberName;
    private static int memberIdCounter = 20;
    private int memberId = 20;
    private Book[] borrowedBook = new Book[5];
    private int indexBookBorrowed = 0;
    private int birthDate;

    public Member() {
        setMemberId(memberIdCounter++);
    }

    public Member(String memberName, int birthDate) {
        this();
        this.memberName = memberName;
        this.birthDate = birthDate;
    }

    public int getIndexBookBorrowed() {
        return indexBookBorrowed;
    }

    public void setIndexBookBorrowed(int indexBookBorrowed) {
        this.indexBookBorrowed = indexBookBorrowed;
    }

    public Member(Book[] borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public static int getMemberIdCounter() {
        return memberIdCounter;
    }

    public static void setMemberIdCounter(int memberIdCounter) {
        Member.memberIdCounter = memberIdCounter;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Book[] getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book[] borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public void addToBookBorrowed(Book book) {
        borrowedBook[indexBookBorrowed] = book;
        indexBookBorrowed++;
    }

    public void removeBookBorrowed(Book book) {
        for (int i = 0; i < indexBookBorrowed; i++) {
            if (borrowedBook[i] == book)
                for (int j = i; j < indexBookBorrowed - 1; j++) {
                    borrowedBook[j] = borrowedBook[j + 1]; //check null
                }
            break;
        }
        indexBookBorrowed--;
    }

    public void showBorrowedBook() {
        System.out.print("[");
        for (int i = 0; i < indexBookBorrowed; i++) {
            System.out.print(borrowedBook[i].getBookName() + " " + borrowedBook[i].getBookId());
            if (i != indexBookBorrowed - 1) {
                System.out.print("-");
            }
        }
        System.out.println("]");

    }
}