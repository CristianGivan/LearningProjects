package P06_Library;

import P06_Library.Exceptions.BookNoInsertedCorrect;
import P06_Library.Exceptions.NoMoreSpaceToAddBooks;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int selectedInMenu;

        final int MAXIM_BOOKS_IN_LIBRARY = 10;
        Book[] books = new Book[MAXIM_BOOKS_IN_LIBRARY];
        books = initializeLibrary(books);
        Library library = new Library(books);
        Librarian librarian = new Librarian("Librarian1", library);
        Student student = new Student("Student1", library);
        Menu menu = new Menu();
/*

        do {
            displayMenu(menu.getTypeIn(), menu.getLogIn());
            System.out.println("\nYour chose is:");
             choice = numberTypedByUser(console);

            switch (selectedInMenu) {
                case 0:
                    System.out.println("You chose to exit, bye for now!");
                    break;
                case 1:
                    System.out.println("You chose to " + menu.getLogIn()[1] + "\n");
                    logIn(librarian, student, menu, console);
                    break;
                case 2:
                    System.out.println("You chose to " + menu.getLogIn()[2] + "\n");
                    register();
                    break;
                case 3:
                    System.out.println("You chose to " + menu.getLogIn()[3] + "\n");
                    help();
                    break;
                default:
                    System.out.println("Unexpected chose, please try again from 0 to " +
                            (menu.getLogIn().length - 1) + " or type 0 to exit");

                    break;
            }


        } while (selectedInMenu != 0);
*/

        debugApp(librarian, student);
        actionByLibrarian(librarian, student, menu, console);
        //actionsByStudent(student, menu, console);
    }

    public static String typedByUser(Scanner console1) {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    public static int numberTypedByUser(Scanner console1) {
        Scanner console = new Scanner(System.in);
        int numberOfTryes = 2;
        int numberTyped = 1;
        try {
            numberTyped = console.nextInt();
            return numberTyped;
        } catch (InputMismatchException e) {

            while (numberOfTryes != 0) {
                System.out.println("You didn't typed a number, you have " + numberOfTryes + " to type the desired number");
                numberTypedByUser(console);
                numberOfTryes--;
            }
        }
        return numberTyped;
    }

    //todo a better way to try 3 times or to try at infinite to insert
    public static void tryAgainToInsertBook(Librarian librarian, Book newBook, Scanner console) {
        int choice;
        System.out.println("What do you want to do? You can: \n");
        System.out.println("Type 0 to exit");
        System.out.println("Type 1 to insert again the book\n");
        int maxNumberOfTries=3;

        choice = numberTypedByUser(console);

        switch (choice) {
            case 0:
                break;
            case 1:
                //newBook = new Book("Book1", "", "B109", 3, 0);
                //newBook = new Book(console);
                try {
                    librarian.addBook(newBookByUser(librarian));
                    System.out.println("The book was inserted.");
                } catch (NoMoreSpaceToAddBooks e) {
                    throw new RuntimeException(e);
                } catch (BookNoInsertedCorrect e) {
                    System.out.println(e.getMessage());
                    //e.printStackTrace();
                    System.out.println("What do you want to do? You can: \n");
                    System.out.println("Type 0 to exit");
                    System.out.println("Type 1 to insert again the book\n");
                    choice = numberTypedByUser(console);
                    switch (choice) {
                        case 0:
                            break;
                        case 1:
                            //newBook = new Book("Book99", "Author1", "B109", 3, 0);
                            //newBook = new Book(console);
                            try {
                                librarian.addBook(newBookByUser(librarian));
                                System.out.println("The book was inserted.");
                            } catch (NoMoreSpaceToAddBooks ex) {
                                throw new RuntimeException(ex);
                            } catch (BookNoInsertedCorrect ex) {
                                System.out.println(ex.getMessage());
                                //ex.printStackTrace();
                                System.out.println("\nYou tried three times to insert the book and you fail," +
                                        " the book will not be inserted!!!\n");
                            }
                            break;
                        default:
                            System.out.println("error!");
                            break;
                    }
                }
                break;
            default:
                System.out.println("error!");
                break;
        }
    }

    public static void displayMenu(String[] typeIn, String[] menu) {
        System.out.println("Select from 0 to " + (menu.length - 1) + " from the to options: \n");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(typeIn[i] + menu[i]);
        }
    }

    public static void logIn(Librarian librarian, Student student, Menu menu, Scanner console) {
        String fromConsole;
        System.out.println("Log in with user name (librarian or student): ");
        fromConsole = typedByUser(console);
        if (fromConsole.contains("lib")) {
            actionByLibrarian(librarian, student, menu, console);

        } else {
            actionsByStudent(student, menu, console);
        }
    }

    public static void register() {
    }

    public static void help() {
    }

    public static void actionByLibrarian(Librarian librarian, Student student, Menu menu, Scanner console) {

        int choice = 7;
        int previousChose;
        boolean redoAction = false;
        String debugS;
        do {
            if (!redoAction) {
                displayMenu(menu.getTypeIn(), menu.getLibrarianMenu());
                System.out.println("\nYour chose is:");
                // todo a function to return only numbers
                choice = numberTypedByUser(console);

            }


            switch (choice) {
                case 1:
                    System.out.println("You chose to " + menu.getLibrarianMenu()[1] + "\n");
                    //Book newBook = new Book(console);
                    Book newBook = new Book("", "Author1", "B109", 3, 0);
                    try {
                        librarian.addBook(newBook);
                        System.out.println(newBook.toString());
                        System.out.println("The book was inserted.");
                    } catch (NoMoreSpaceToAddBooks noMoreSpaceToAddBooks) {
                        System.out.println(noMoreSpaceToAddBooks.getMessage());
                        noMoreSpaceToAddBooks.printStackTrace();
                    } catch (BookNoInsertedCorrect bookNoInsertedCorrect) {
                        System.out.println(bookNoInsertedCorrect.getMessage());
                        //bookNoInsertedCorrect.printStackTrace();
                        tryAgainToInsertBook(librarian, newBook, console);

                    }
                    break;
                case 2:
                    //delete a book from library base of ISBN
                    System.out.println("You chose to " + menu.getLibrarianMenu()[2] + "\n");
                    //todo display a list of all available isbn
                    System.out.println("Insert ISBN of the book:");
                    librarian.deleteBook(typedByUser(console));
                    break;
                case 3:
                    //delete a copy of a book base on ISBN
                    System.out.println("You chose to " + menu.getLibrarianMenu()[3] + "\n");
                    System.out.println("Insert ISBN of the book:");
                    //todo could be used also the method with more copies deleted
                    librarian.deleteOneCopyOfBook(typedByUser(console));
                    break;
                case 4:
                    //display the details for all the books
                    System.out.println("You chose to " + menu.getLibrarianMenu()[4] + "\n");
                    librarian.displayAllBooksDetails();
                    break;
                case 5:
                    //display the book details base on ISBN
                    System.out.println("You chose to " + menu.getLibrarianMenu()[5] + "\n");
                    System.out.println("Insert ISBN of the book:");
                    librarian.displayBookDetails(typedByUser(console));
                    break;
                case 6:
                    //display all the books borrowed by a student
                    System.out.println("You chose to " + menu.getLibrarianMenu()[6] + "\n");
                    // todo how to choose the student
                    librarian.displayBooksBorrowedByUser(student);
                    break;
                case 7:
                    //help
                    System.out.println("You chose to " + menu.getLibrarianMenu()[8] + "\n");
                    break;
                default:
                    //error
                    System.out.println("Unexpected chose, please try again from 0 to " +
                            (menu.getLibrarianMenu().length - 1) + " or type 0 to exit");
                    break;
            }

            previousChose = choice;
            System.out.println("\nType " + previousChose + " to redo the action" +
                    ", type 0 to exit from librarian manu" +
                    "  or type any other key to return to the manu!\n");
            choice = numberTypedByUser(console);

            if (choice == previousChose) {
                redoAction = true;
            } else {
                redoAction = false;
            }
        } while (choice != 0);
    }

    public static void actionsByStudent(Student student, Menu menu, Scanner console) {

        int choice = 6;
        int previousChose;
        boolean redoAction = false;

        do {
            if (!redoAction) {
                displayMenu(menu.getTypeIn(), menu.getStudentMenu());
                System.out.println("\nYour chose is:");
                choice = numberTypedByUser(console);
            }

            switch (choice) {
                case 1:
                    //check if a book is available to borrow base on ISBN
                    System.out.println("You chose to " + menu.getStudentMenu()[1] + "\n");
                    System.out.println("Insert ISBN of the book:");
                    student.isTheBookAvailableToBorrow(typedByUser(console));
                    break;
                case 2:
                    //display all available books to borrow
                    System.out.println("You chose to " + menu.getStudentMenu()[2] + "\n");
                    student.showAllAvailableBooks();
                    break;
                case 3:
                    //borrow a book base on ISBN
                    System.out.println("You chose to " + menu.getStudentMenu()[3] + "\n");
                    System.out.println("Insert ISBN of the book:");
                    student.borrowBook(typedByUser(console));
                    break;
                case 4:
                    //return a book base on ISBN
                    System.out.println("You chose to " + menu.getStudentMenu()[4] + "\n");
                    System.out.println("Insert ISBN of the book:");
                    student.returnBook(typedByUser(console));
                    break;
                case 5:
                    //help
                    System.out.println("You chose to " + menu.getStudentMenu()[5] + "\n");
                    break;
                default:
                    System.out.println("Unexpected chose, please try again from 0 to " +
                            (menu.getStudentMenu().length - 1) + " or type 0 to exit");
                    break;
            }

            previousChose = choice;
            System.out.println("\nType " + previousChose + " to redo the action" +
                    ", type 0 to exit from student manu" +
                    "  or type any other key to return to the manu!\n");
            choice = numberTypedByUser(console);
            if (choice == previousChose) {
                redoAction = true;
            } else {
                redoAction = false;
            }
        } while (choice != 0);
    }


    public static Book newBookByUser(Librarian librarian) throws NoMoreSpaceToAddBooks, BookNoInsertedCorrect {
        String bookName;
        String bookAuthor;
        String bookISBN;
        int bookNumberOfCopies;
        Scanner console = new Scanner(System.in);
        System.out.println("Insert the name of the book: ");
        bookName = (console.nextLine());
        System.out.println("Insert the author of the book: ");
        bookAuthor = (console.nextLine());
        System.out.println("Insert the ISBN of the book: ");
        bookISBN = (console.nextLine());
        System.out.println("Insert the number of copies for the book: ");
        bookNumberOfCopies = (console.nextInt());
        Book newBook = new Book(bookName, bookAuthor, bookISBN, bookNumberOfCopies, 0);
        librarian.addBook(newBook);
        return newBook;
    }

    public static void debugApp(Librarian librarian, Student student) {
        //Debug

        //admin.displayBookDetails("B103");


        //student.showAllAvailableBooks();
        student.borrowBook("B101");
        student.borrowBook("B101");
        student.borrowBook("B103");
        student.borrowBook("B102");
        /*
        student.showAllAvailableBooks();
        System.out.println("\n Books borrowed");
        student.displayBorrowedBooks();

        student.returnBook("B101");
        student.returnBook("B102");
        student.showAllAvailableBooks();
        System.out.println("\n Books borrowed");
        librarian.displayBooksBorrowedByUser(student);
        student.isTheBookAvailableToBorrow("B101");
*/
        /*
        student.borrowBook("B101");
        student.showAllAvailableBooks();
        student.borrowBook("B101");
        student.showAllAvailableBooks();
*/
        /*
        admin.deleteBook("B102");
        admin.displayAllBooksDetails();
        System.out.println("\n");
        admin.deleteOneCopyOfBook("B103");
        admin.displayAllBooksDetails();
        System.out.println("\n");
        admin.deleteMoreCopiesOfBook("B104",2);
        admin.displayAllBooksDetails();
        System.out.println("\n");



       System.out.println(library.getAllBo` oks()[1]);
        System.out.println(library.getAllBooks()[2]);*/
    }

    public static Book[] initializeLibrary(Book[] books) {

        books[0] = new Book("Book1", "Author1", "B100", 3, 0);
        books[1] = new Book("Book2", "Author2", "B101", 4, 1);
        books[2] = new Book("Book3", "Author3", "B102", 5, 2);
        books[3] = new Book("Book4", "Author4", "B103", 6, 3);
        books[4] = new Book("Book5", "Author5", "B104", 7, 4);
        return books;
    }
}


