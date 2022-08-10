package P01_LearningTesting;

public class Menu {

    private final String[] typeIn = {"Type in 0 to ", "Type in 1 to ", "Type in 2 to ", "Type in 3 to ", "Type in 4 to ",
            "Type in 5 to ", "Type in 6 to ", "Type in 7 to ", "Type in 8 to ", "Type in 9 to ",
            "Type in 10 to ", "Type in 11 to ", "Type in 12 to ", "Type in 13 to ", "Type in 14 to "};
    private String[] mainMenu;
    private String[] Menu2;

    private String[] Nenu3;

    public Menu() {
        mainMenu();
        setMenu2();
        setMenu3();
    }


    private void mainMenu() {
        this.mainMenu = new String[2];
        this.mainMenu[0] = "exit";
        this.mainMenu[1] = "test";
        //this.logIn[2] = "register";
       //this.logIn[3] = "help";
    }

    public void setMenu2() {
        this.Menu2 = new String[8];
        this.Menu2[0] = "exit from librarian manu";
        this.Menu2[1] = "add new book in library";
        this.Menu2[2] = "delete a book from library base of ISBN";
        this.Menu2[3] = "delete a copy of a book base on ISBN";
        this.Menu2[4] = "display the details for all the books";
        this.Menu2[5] = "display the book details base on ISBN";
        this.Menu2[6] = "display all the books borrowed by a student";
        this.Menu2[7] = "help";
    }

    public void setMenu3() {
        this.Nenu3 = new String[6];
        this.Nenu3[0] = "exit from student menu";
        this.Nenu3[1] = "check if a book is available to borrow base on ISBN";
        this.Nenu3[2] = "display all available books to borrow";
        this.Nenu3[3] = "borrow a book base on ISBN";
        this.Nenu3[4] = "return a book base on ISBN";
        this.Nenu3[5] = "help";

    }

    public String[] getTypeIn() {
        return typeIn;
    }

    public String[] getMainMenu() {
        return mainMenu;
    }

    public String[] getMenu2() {
        return Menu2;
    }

    public String[] getNenu3() {
        return Nenu3;
    }
}
