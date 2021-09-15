package ir.maktab.library;

import java.util.Arrays;

public class Admin {
    private Book[] books = new Book[50];
    private Member[] members = new Member[50];
    private int indexBook = 0;
    private int indexMember = 0;

    public Book[] getBooks() {
        return books;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void addBook(String name, int numberOfEachBook) {
        if (indexBook == 0) {
            books[indexBook] = new Book(name, numberOfEachBook);
            indexBook++;
        } else if (indexBook < 50) {
            for (int i = 0; i < indexBook; i++) {
                if (books[i].getBookName().equals(name)) {
                    int newCounterOfBook = books[i].getNumberOfEachBook() + numberOfEachBook;
                    books[i].setNumberOfEachBook(newCounterOfBook);

                } else {
                    books[indexBook] = new Book(name, numberOfEachBook);
                    indexBook++;
                    break;
                }
                break;
            }

        } else System.out.println("more than 50 books not valid");
    }

    public void addMember(String name, int birthDate) {
        if (indexMember == 0) {
            members[indexMember] = new Member(name, birthDate);
            indexMember++;
        } else if (indexMember < 50) {
            for (int i = 0; i < indexMember; i++) {
                if (members[i].getMemberName().equals(name))
                    System.out.println("member exist! ");
                else {
                    members[indexMember] = new Member(name, birthDate);
                    indexMember++;
                    break;
                }
                break;
            }
        } else System.out.println("more than 50 members not valid");

    }

    public void maxReached(String memberName, int memberId) {
        for (int i = 0; i < indexMember; i++) {
            if (members[i].getMemberName().equals(memberName) && Member.getMemberIdCounter() == memberId) {
                if (members[i].getIndexBookBorrowed() == 5)
                    System.out.println("max reached: " + memberName + " " + memberId);
            }
            break;
        }
    }

    public void notAvailable(String bookName, int bookId) {
        for (int i = 0; i < indexMember; i++) {
            if (books[i].getBookName().equals(bookName) && books[i].getBookId() == bookId)
                System.out.println("not available: " + books[i].getBookName() + " " + books[i].getBookId());
            break;
        }
    }

    public void getBook(int memberId, int bookId) {
        String nameOfMember = "";
        int numberOfPerBook = 0;
        int counterOfMember = 0;
        int counterOfBook = 0;
        int newCounterBook = 0;
        boolean foundBook = false;
        boolean foundMember = false;
        for (int i = 0; i < indexMember; i++) {
            if (members[i].getMemberId() == memberId) {
                nameOfMember = members[i].getMemberName();
                counterOfMember = i;
                foundMember = true;
                break;
            }
        }
        for (int j = 0; j < indexBook; j++) {
            if (books[j].getBookId() == bookId) {
                numberOfPerBook = books[j].getNumberOfEachBook();
                counterOfBook = j;
                foundBook = true;
                break;
            }

        }
        if (foundBook && foundMember) {
            if (members[counterOfMember].getIndexBookBorrowed() != 5 && numberOfPerBook != 0) {
                newCounterBook = numberOfPerBook - 1;
                books[counterOfBook].setNumberOfEachBook(newCounterBook);
                members[counterOfMember].addToBookBorrowed(books[counterOfBook]);

            } else if (numberOfPerBook == 0) {
                notAvailable(books[counterOfBook].getBookName(), bookId);
            } else if (members[counterOfMember].getIndexBookBorrowed() == 5) {
                maxReached(nameOfMember, memberId);
            }
        } else {
            System.out.println("wrong input");
        }
    }

    public void returnBook(int memberId, int bookId) {
        int numberOfPerBook = 0;
        int counterOfMember = 0;
        int counterOfBook = 0;
        int newPerBookCounter = 0;
        boolean foundBook = false;
        boolean foundMember = false;
        boolean checkAccess = false;
        for (int i = 0; i < indexMember; i++) {
            if (members[i].getMemberId() == memberId) {
                counterOfMember = i;
                foundMember = true;
                break;
            }
        }
        for (int j = 0; j < indexBook; j++) {
            if (books[j].getBookId() == bookId) {
                numberOfPerBook = books[j].getNumberOfEachBook();
                counterOfBook = j;
                foundBook = true;
                break;
            }
        }
        if (foundBook && foundMember) {
            for (int z = 0; z < members[counterOfMember].getIndexBookBorrowed(); z++) {
                if (members[counterOfMember].getBorrowedBook()[z] == books[bookId]) {
                    newPerBookCounter = numberOfPerBook + 1;
                    books[counterOfBook].setNumberOfEachBook(newPerBookCounter);
                    members[counterOfMember].removeBookBorrowed(books[counterOfBook]);
                    checkAccess = true;
                    break;
                }
            }
            if (!checkAccess) {
                System.out.println("access for " + books[counterOfBook].getBookName() + " is not valid to: " + members[counterOfMember].getMemberName() + " " + members[counterOfMember].getMemberId());
            }
        } else {
            System.out.println("wrong input");
        }
    }

    public void bookStat() {
        if (indexBook != 0) {
            for (int i = 0; i < indexBook; i++) {
                System.out.println(books[i].getBookName() + " " + books[i].getBookId() + " " + books[i].getNumberOfEachBook());
            }
        } else System.out.println("no book added");
    }

    public void memberStat() {
        if (indexMember != 0) {
            for (int i = 0; i < indexMember; i++) {
                System.out.print(members[i].getMemberName() + " " + members[i].getMemberId() + " ");
                members[i].showBorrowedBook();
            }
        } else System.out.println("no member added");
    }
}
