package P05_BankingApp;

public class BankingApp {
    public static void main(String[] args) {
        double amount = 1000;
        BankAccount studentAccount1 = new StudentAccount(10000, "student1", 50000);
        BankAccount spendingAccount1 = new SpendingAccount(10000, "spanding1", 50000);
        BankAccount studentAccount2 = new StudentAccount(10000, "student2", 50000);
        BankAccount spendingAccount2 = new SpendingAccount(10000, "spanding2", 50000);

        //debug student acount
        /*
        System.out.println(studentAccount.getBalance());
        studentAccount.deposit(1000);
        System.out.println(studentAccount.getBalance());
        studentAccount.deposit(100000);
        System.out.println(studentAccount.getBalance());
        studentAccount.withdraw(2000);
        System.out.println(studentAccount.getBalance());
        studentAccount.withdraw(200000);
        System.out.println(studentAccount.getBalance());


        System.out.println(studentAccount.getBalance());
        spendingAccount.deposit(1000);
        System.out.println(spendingAccount.getBalance());
        spendingAccount.deposit(100000);
        System.out.println(spendingAccount.getBalance());
        spendingAccount.withdraw(2000);
        System.out.println(spendingAccount.getBalance());
        spendingAccount.withdraw(200000);
        System.out.println(spendingAccount.getBalance());
        */

        Person person = new Person("Ioan", "Popescu", 5);
        person.addAccount(spendingAccount1);
        person.addAccount(spendingAccount2);
        person.addAccount(studentAccount1);
        person.addAccount(studentAccount2);
        person.listAccount();
        person.deposit("student1", amount);
        person.withdraw("student1", amount);


    }
}
