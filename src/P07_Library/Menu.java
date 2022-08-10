package P07_Library;

public class Menu {

    private final String[] typeIn = {"Type in 0 to ", "Type in 1 to ", "Type in 2 to ", "Type in 3 to ", "Type in 4 to ",
            "Type in 5 to ", "Type in 6 to ", "Type in 7 to ", "Type in 8 to ", "Type in 9 to ",
            "Type in 10 to ", "Type in 11 to ", "Type in 12 to ", "Type in 13 to ", "Type in 14 to "};
    private String[] logIn;
    private String[] LibrarianMenu;

    private String[] StudentMenu;

    public Menu() {
        setLogIn();
        setLibrarianMenu();
        setStudentMenu();
    }


    private void setLogIn() {
        this.logIn = new String[4];
        this.logIn[0] = "exit";
        this.logIn[1] = "log in";
        this.logIn[2] = "register";
        this.logIn[3] = "help";
    }

    public void setLibrarianMenu() {
        this.LibrarianMenu = new String[8];
        this.LibrarianMenu[0] = "exit from librarian manu";
        this.LibrarianMenu[1] = "add new book in library";
        this.LibrarianMenu[2] = "delete a book from library base of ISBN";
        this.LibrarianMenu[3] = "delete a copy of a book base on ISBN";
        this.LibrarianMenu[4] = "display the details for all the books";
        this.LibrarianMenu[5] = "display the book details base on ISBN";
        this.LibrarianMenu[6] = "display all the books borrowed by a student";
        this.LibrarianMenu[7] = "help";
    }

    public void setStudentMenu() {
        this.StudentMenu = new String[6];
        this.StudentMenu[0] = "exit from student menu";
        this.StudentMenu[1] = "check if a book is available to borrow base on ISBN";
        this.StudentMenu[2] = "display all available books to borrow";
        this.StudentMenu[3] = "borrow a book base on ISBN";
        this.StudentMenu[4] = "return a book base on ISBN";
        this.StudentMenu[5] = "help";

    }

    public String[] getTypeIn() {
        return typeIn;
    }

    public String[] getLogIn() {
        return logIn;
    }

    public String[] getLibrarianMenu() {
        return LibrarianMenu;
    }

    public String[] getStudentMenu() {
        return StudentMenu;
    }
}
