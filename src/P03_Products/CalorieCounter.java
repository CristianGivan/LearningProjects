package P03_Products;/*
cum ar fi mai eficient sa pun consola in fiecare metoda sau sa o folosesti ca parametru transims?
*/


import java.util.Scanner;

public class CalorieCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //TestProd();
        //TestProductCatalog();
        Product p = new Product();

        String[] options = options(0);
        int option;

        do {
            System.out.println("\nAlege  din meniu obtiunea dorita apasand cifra corespunzatoare" +
                    " (1 pana la 6): \n");

            displayMenu(options);
            option = console.nextInt();
            options = options(option);
            performSelectedAction(option, options, console);

        } while (option != 6);

    }

    public static String[] options(int option) {
        String[] options = new String[0];


        String option1 = "Adauga produs in calculator si calculeaza-i caloriile";
        String option2 = "Calculeaza caloriile pentru un produs fara a fi adaugat in catalog";
        String option3 = "Afiseaza toate produsele din catalog si caloriile pentru fiecare";
        String option4 = "Sterge un produs din catalog";
        String option5 = "Gaseste produs dupa nume";
        String option6 = "Iesi din aplicatie";
        String option7 = "Added a predefined products, for testing";

        if (option < 7) {
            options = new String[]{option1, option2, option3, option4, option5, option6};
        } else if (option == 7) {
            options = new String[]{option1, option2, option3, option4, option5, option6, option7};

        }
        return options;
    }

    public static void displayMenu(String[] options) {
        int maxDisplay;
        if (options.length > 6) {
            maxDisplay = 6;
        } else {
            maxDisplay = options.length;
        }

        System.out.println("MENIU: ");

        for (int i = 0; i < maxDisplay; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("\n");
    }

    public static void performSelectedAction(int option, String[] options, Scanner console) {
        ProductCatalog products = new ProductCatalog();
        Product product = new Product();

        String tempS;
        tempS = console.nextLine();
        System.out.println("You selected the option: \n" + option + ". " +
                options[option - 1]);
        switch (option) {


            case 1:
                product.newProduct();
                products.addProduct(product);
                break;

            case 2:
                //prima varianta
                Product calculateCalories = new Product();
                System.out.println("Insert the grams of Fat: ");
                calculateCalories.gFat = console.nextInt();


                System.out.println("Insert the grams of Carbohydrates: ");
                calculateCalories.gCarbo = console.nextInt();

                System.out.println("Insert the grams of Protein: ");
                calculateCalories.gProtein = console.nextInt();

                System.out.println("\nThe total calories are: " + calculateCalories.totalCalories);
                break;

            case 3:
                products.printProducts();
                break;

            case 4:
                System.out.println("Specified the name of the product" +
                        " that you want to delete from the list: ");
                products.productsNames();

                System.out.println(products.deleteProduct(console.nextLine()));
                break;

            case 5:
                System.out.println("Specified the name of the product" +
                        " that you want to search in the list: ");
                products.productsNames();
                //Scanner console1 = new Scanner(System.in);
                //tempS = console1.nextLine();
                //tempS="t2";
                tempS = console.nextLine();
                System.out.println("The product is product : " + (products.indexOf(tempS)+1));
                break;

            case 6:
                System.out.println("Thank you for using the program, you chose to exit the program!");
                break;

            case 7:
                products.predifineProducts();
                break;

            default:
                System.out.println("Error!");
                break;
        }

    }

    //test methods
    public static void TestProd() {
        //Product prod1 = new Product();
        //System.out.println(prod1.toString());
        Product prod = new Product("t1", 10, 32, 43);
        System.out.println(prod.toString());
        prod.computeCalories();
        System.out.println(prod.toString());

    }

    public static void TestProductCatalog() {
        ProductCatalog prodC = new ProductCatalog();
        //prodC=predifineProducts();
        prodC.predifineProducts();


/*
        Product prod = new Product("t0", 10, 32, 43);
        Product prod1 = new Product("t1", 10, 32, 43);
        Product prod2 = new Product("t2", 10, 32, 43);
        Product prod3 = new Product("t3", 10, 32, 43);
        Product prod4 = new Product("t4", 10, 32, 43);

        prodC.addProduct(prod);
        prodC.addProduct(prod1);
        prodC.addProduct(prod2);
        prodC.addProduct(prod3);
        prodC.addProduct(prod4);
        */

        String ProductS = "t1";
        int index = prodC.indexOf(ProductS);
        System.out.println(prodC.printProduct(index));
/*
        for (int i = 0; i < prodC.getNrProducts(); i++) {
            System.out.println(prodC.printProduct(i));
        }
        */
        prodC.printProducts();
        System.out.println(prodC.deleteProduct("t2"));
        System.out.println("noua lista: ");
        prodC.printProducts();

        //System.out.println(prodC.indexOf("t0"));
    }

/*
    public static ProductCatalog predifineProducts() {
        ProductCatalog predefined = new ProductCatalog();
        Product prod = new Product("t0", 10, 32, 43);
        Product prod1 = new Product("t1", 10, 32, 43);
        Product prod2 = new Product("t2", 10, 32, 43);
        Product prod3 = new Product("t3", 10, 32, 43);
        Product prod4 = new Product("t4", 10, 32, 43);
        predefined.addProduct(prod);
        predefined.addProduct(prod1);
        predefined.addProduct(prod2);
        predefined.addProduct(prod3);
        predefined.addProduct(prod4);
        return predefined;
    }*/

}
