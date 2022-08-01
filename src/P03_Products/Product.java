package P03_Products;

import java.util.Scanner;

public class Product {
    String name;
    int gFat;
    int gCarbo;

    int gProtein;
    int totalCalories;  //=gFat+gCarbo+gProtein;

    Product() {
    }

    Product(String name, int gFat, int gCarbo, int gProtein) {

        this.name = name;
        this.gFat = gFat;
        this.gCarbo = gCarbo;
        this.gProtein = gProtein;
        computeCalories();
    }

    public void newProduct() {
        Scanner console = new Scanner(System.in);

        System.out.println("Insert the name of the product: ");
        this.name = console.nextLine();

        System.out.println("Insert the grams of Fat: ");
        this.gFat = console.nextInt();

        System.out.println("Insert the grams of Carbohydrates: ");
        this.gCarbo = console.nextInt();

        System.out.println("Insert the grams of Protein: ");
        this.gProtein = console.nextInt();

        computeCalories();

    }

    public void newProductNoName() {
        Scanner console = new Scanner(System.in);


        System.out.println("Insert the grams of Fat: ");
        this.gFat = console.nextInt();

        System.out.println("Insert the grams of Carbohydrates: ");
        this.gCarbo = console.nextInt();

        System.out.println("Insert the grams of Protein: ");
        this.gProtein = console.nextInt();

        computeCalories();

    }

    public static int computeCalories(int fat, int protein, int carbo) {//int fat, int carbo, int protein

        return fat+protein+carbo;

    }
    public int computeCalories() {//int fat, int carbo, int protein

        this.totalCalories = this.gProtein + this.gCarbo + this.gFat;
        return this.totalCalories;

    }
    @Override
    public String toString() {
        return "Product{" +
                "productName='" + name + '\'' +
                ", gFat=" + gFat +
                ", gCarbo=" + gCarbo +
                ", gProtein=" + gProtein +
                ", totalCalories=" + totalCalories +
                '}';
    }

    public String toStringProductAt(int i) {
        return "Product " + (i + 1) + " {" +
                "productName='" + name + '\'' +
                ", gFat=" + gFat +
                ", gCarbo=" + gCarbo +
                ", gProtein=" + gProtein +
                ", totalCalories=" + totalCalories +
                '}';
    }
}