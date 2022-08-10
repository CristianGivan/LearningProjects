package P07_Library;

import P07_Library.Exceptions.BookNoInsertedCorrect;
import P07_Library.Exceptions.NoMoreSpaceToAddBooks;

public class Librarian extends User {

    private Library library;

    public Librarian(String name, Library library) {
        super(name);
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void addBook (Book book) throws NoMoreSpaceToAddBooks, BookNoInsertedCorrect {
        //tratez exceptiile

        library.addBook(book);
    }

    public void deleteBook(String isbn) {
        library.deleteBook(isbn);
    }

    public void deleteOneCopyOfBook(String isbn) {
        library.deleteCopyOfBook(isbn);

    }

    public void deleteMoreCopiesOfBook(String isbn, int numberOfCopiesToDelete) {
        library.deleteCopyOfBook(isbn, numberOfCopiesToDelete);
    }

    public void displayBookDetails(String isbn) {
        library.displayBookDetails(isbn);
    }

    public void displayAllBooksDetails() {
        library.printAllBooks();
    }

    public void displayBooksBorrowedByUser(Student student) {
        student.displayBorrowedBooks();
    }


}
