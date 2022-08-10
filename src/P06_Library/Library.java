package P06_Library;

import P06_Library.Exceptions.BookNoInsertedCorrect;
import P06_Library.Exceptions.NoMoreSpaceToAddBooks;

public class Library {
    private Book[] allBooks;
    private int numberOfBooks;

    public Library(Book[] allBooks) {
        this.allBooks = allBooks;
        numberOfBooks = countNumberOfElementsNotNullFromArray(allBooks);
    }

    public Book[] getAllBooks() {
        return this.allBooks;
    }

    public void addBook(Book book) throws NoMoreSpaceToAddBooks, BookNoInsertedCorrect {

        if (numberOfBooks == allBooks.length) {
            throw new NoMoreSpaceToAddBooks("You have reached the maximum space in library, " +
                    "you cannor add more books!");
        }
        if (book.getName().equals("")) {
            throw new BookNoInsertedCorrect("The book has no title inserted");
        }
        if (book.getAuthor().equals("")) {
            throw new BookNoInsertedCorrect("The book has no author inserted");
        }
        if (book.getIsbn().equals("")) {
            throw new BookNoInsertedCorrect("The book has no ISBN inserted");
        }
        if (book.getNumberOfCopies() <= 0) {
            throw new BookNoInsertedCorrect("The book cannot have the number of copies smallest then 1");
        }
        if (book.getNumberOfBooksBorrowed() < 0) {
            throw new BookNoInsertedCorrect("The book cannot have the number of borrowed copies " +
                    "smallest then 0");
        }
        if (book.getNumberOfCopies() <= book.getNumberOfBooksBorrowed()) {
            throw new BookNoInsertedCorrect("The book cannot have the number of borrowed copies " +
                    "more then the number of copies");
        }
        allBooks[numberOfBooks] = book;
        numberOfBooks++;
    }

    public void deleteBook(String isbn) {
        // Exception no book in found
        int index = indexFindByIsbn(isbn);
        deleteBookAtIndex(index);

    }

    public void deleteCopyOfBook(String isbn) {
        // Exception there are no books  available to ve delete or all the books are borrowed
        int index = indexFindByIsbn(isbn);
        deleteCopyOfBookAtIndex(index);

    }

    public void deleteCopyOfBook(String isbn, int numberOfCopiesToDelete) {
        int index = indexFindByIsbn(isbn);
        deleteCopyOfBookAtIndex(index, numberOfCopiesToDelete);
    }

    private int indexFindByIsbn(String isbn) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (allBooks[i].getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

    private void deleteBookAtIndex(int index) {
        System.out.println(index);
        for (int i = index + 1; i < numberOfBooks; i++) {
            allBooks[i - 1] = allBooks[i];
        }
        numberOfBooks--;
    }

    private void deleteCopyOfBookAtIndex(int index) {
        int newNumberOfCopy = allBooks[index].getNumberOfCopies() - 1;
        allBooks[index].setNumberOfCopies(newNumberOfCopy);
    }

    private void deleteCopyOfBookAtIndex(int index, int numberOfCopiesToDelete) {
        int newNumberOfCopy = allBooks[index].getNumberOfCopies() - numberOfCopiesToDelete;
        allBooks[index].setNumberOfCopies(newNumberOfCopy);
    }

    public void displayBookDetails(String isbn) {
        int index = indexFindByIsbn(isbn);
        System.out.println(allBooks[index].toString());
    }


    public void displayListOfBooks(String[] bookList) {
        int index;
        for (int i = 0; i < bookList.length; i++) {
            index = indexFindByIsbn(bookList[i]);
            System.out.println(allBooks[index].toString());
        }

    }

    public void printAllBooks() {
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(this.allBooks[i].toString());

        }
    }

    // ToDo ? create exception or use if
    public boolean isTheBookAvailableToBorrow(String isbn) /*throws BookNotAvailable*/ {
        int index = indexFindByIsbn(isbn);
        if (allBooks[index].getNumberOfCopies() <= allBooks[index].getNumberOfBooksBorrowed()) {
            return false;
            //throw new BookNotAvailable ("All books are borrowed");
        }
        return true;
    }

    public Book[] findAllAvailableBooks() {
        int index = 0;
        Book[] booksWithNull = new Book[numberOfBooks];
        for (int i = 0; i < numberOfBooks; i++) {
            if (allBooks[i].getNumberOfCopies() > allBooks[i].getNumberOfBooksBorrowed()) {
                booksWithNull[index] = allBooks[i];
                index++;
            }
        }
        Book[] books = new Book[index];
        for (int i = 0; i < index; i++) {
            books[i] = booksWithNull[i];
        }
        return books;
    }

    public Book borrowBook(String isbn) {
        int index = indexFindByIsbn(isbn);
        allBooks[index].setNumberOfBooksBorrowed(allBooks[index].getNumberOfBooksBorrowed() + 1);
        return allBooks[index];
    }

    public Book returnBook(String isbn) {
        int index = indexFindByIsbn(isbn);
        allBooks[index].setNumberOfBooksBorrowed(allBooks[index].getNumberOfBooksBorrowed() - 1);
        return allBooks[index];
    }

    public static int countNumberOfElementsNotNullFromArray(Object[] objects) {
        int numberOfElementsNotNull = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                numberOfElementsNotNull = i + 1;
            }
        }
        return numberOfElementsNotNull;
    }
}
