package P03_Products;/*
Cum ar trebui sa definit facem cu consola mai bine ar trebui sa o definim in obiect
sau sa o pasam la obiect dim main
*/

public class ProductCatalog {

    final static int Max = 100;
    Product[] productList;// = new Product[Max];
    int a =1;
    public  int nrProducts;

    public ProductCatalog(){
        this.productList=new Product[Max];
        this.nrProducts = 0;
    }

    public void addProduct(Product product) {

        this.productList[nrProducts] = product;
        this.nrProducts++;

    }

    public String printProduct(int i) {

        return this.productList[i].toString();

    }

    public void printProducts() {
        for (int i = 0; i < this.nrProducts; i++) {
            System.out.println(this.productList[i].toStringProductAt(i));
        }
    }

    public int indexOf(String productName) {

        int r = 0;
        for (int i = 0; i < this.nrProducts; i++) {

            //for debugging a == a is false, string converted in byte
            /*
            stringToByte(this.productList[i].productName);
            stringToByte(productName);
            boolean test = this.productList[i].productName == productName;
            System.out.println(this.productList[i].productName + " = " +
                    productName + " is " + test);
*/

            if (this.productList[i].name.equals(productName)){
                r = i+1;
                break;
            } else {
                r = -1;


            }
        }
        return r;
    }




    // daca vreau sa stearga toate produsele cu acest nume,
    // in cazul in care sunt duplicate trebuie sa modific un pic functia
    public boolean deleteProduct(String productName) {
        int indexDelete;
        indexDelete = indexOf(productName);
        if (indexDelete != -1) {
            this.productList[indexDelete] = this.productList[nrProducts - 1];
            this.nrProducts--;
            return true;
        } else {
            return false;
        }
    }

    public void productsNames() {
        for (int i = 0; i < this.nrProducts; i++) {
            System.out.println("For Product " + (i + 1) + " the name is " + this.productList[i].name);
        }
    }

    // ar trebui sa mai adaug o functie care sa imi adauge produsele random
    public void predifineProducts(){

        this.addProduct(new Product("t0", 10, 32, 43));
        this.addProduct(new Product("t1", 10, 32, 43));
        this.addProduct(new Product("t2", 10, 32, 43));
        this.addProduct(new Product("t3", 10, 32, 43));
        this.addProduct(new Product("t4", 10, 32, 43));


    }

    //used for debugging to compare two strings
    static public void stringToByte(String s) {

        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        System.out.println("'" + s + "' to binary: " + binary);
    }
}