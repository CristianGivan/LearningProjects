package P03_Products;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        ProductCatalog products = new ProductCatalog();
        products.predifineProducts();


        String productName1 = console.nextLine();
        //productName1 = "t2";

        int r = 0;
        for (int i = 0; i < products.nrProducts; i++) {

            //for debugging a == a is false
            /*
            stringToByte(this.productList[i].productName);
            stringToByte(productName);
            boolean test = this.productList[i].productName == productName;
            System.out.println(this.productList[i].productName + " = " +
                    productName + " is " + test);
*/

            if (products.productList[i].name == productName1) {
                r = i + 1;
                break;
            } else {
                r = -1;

            }
        }
        System.out.println(r);
    }
}
