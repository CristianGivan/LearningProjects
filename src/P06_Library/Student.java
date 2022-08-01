package P06_Library;

public class Student extends User {
    private Library library;
    private Book[] borrowedBooks;
    private int numberOfUserBorrowedBooks;

    public Student(String name, Library library) {
        super(name);
        this.library = library;
        numberOfUserBorrowedBooks = 0;
        borrowedBooks = new Book[library.getAllBooks().length];

    }

    public Book[] getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void isTheBookAvailableToBorrow(String isbn) {

        if (library.isTheBookAvailableToBorrow(isbn)) {
            System.out.println("The book with ISBN: " + isbn + " is available to borrow!");
        } else {
            System.out.println("The book with ISBN: " + isbn + " is not availeble to borrow!");
        }

    }

    public void showAllAvailableBooks() {
        Book[] availableBooks = library.findAllAvailableBooks();
        for (int i = 0; i < availableBooks.length; i++) {
            System.out.println(availableBooks[i].toString());
        }
    }

    //todo exception book already borrowed
    public void borrowBook(String isbn) {
        if (library.isTheBookAvailableToBorrow(isbn)) {
            borrowedBooks[numberOfUserBorrowedBooks] = library.borrowBook(isbn);
            numberOfUserBorrowedBooks++;
            System.out.println("The book was borrowed!");
        } else {
            System.out.println("The book is not available to borrow!");
        }
    }

    // todo Exception the book was not borrowed
    public void returnBook(String isbn) {
        if (indexOfBorrowedBooks(isbn) > -1) {
            deleteFromBorrowedBooks(isbn);
            library.returnBook(isbn);
        }
        System.out.println("The book wasn't returned!");
    }


    public int indexOfBorrowedBooks(String isbn) {
        for (int i = 0; i < numberOfUserBorrowedBooks; i++) {
            if (borrowedBooks[i].getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteFromBorrowedBooks(String isbn) {
        int index = indexOfBorrowedBooks(isbn);
        for (int i = index; i < numberOfUserBorrowedBooks; i++) {
            borrowedBooks[i] = borrowedBooks[i + 1];
        }
        numberOfUserBorrowedBooks--;
    }

    //todo can be done better?
    public void displayBorrowedBooks() {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] != null)
                System.out.println(borrowedBooks[i]);
        }
    }

}
