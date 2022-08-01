package P05_BankingApp;

public class Person {
    private String firstName;
    private String lastName;

    private int maximNumberOfAcounts;
    private int numberOfAccounts;
    private BankAccount[] accountsList;

    //? cum am putea sa facem o alocare dinamica a numerului de arrayuri

    public Person(String firstName, String lastName, int maximNumberOfAcounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfAccounts = 0;
        this.maximNumberOfAcounts = maximNumberOfAcounts;
        accountsList = new BankAccount[maximNumberOfAcounts];

    }

    public boolean addAccount(BankAccount bankAccount) {
        if (numberOfAccounts < maximNumberOfAcounts) {
            accountsList[numberOfAccounts] = bankAccount;
            numberOfAccounts++;
//            System.out.println(bankAccount.getAccountNumber());
//            System.out.println(accountsList[numberOfAccounts].getAccountNumber());
            return true;
        }
        return false;
    }

    public void listAccount() {
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("Account number " + accountsList[i].getAccountNumber() + " has the balance: " + accountsList[i].getBalance());
        }
    }

    public void deposit(String accountNumber, double amount) {
        int index = findAccountIndex(accountNumber);
        double oldBalance = accountsList[index].getBalance();
        if (accountsList[index].deposit(amount)) {
            System.out.println("The amount " + amount + " was added to the balance " +
                    oldBalance + "\n The new balance is " + accountsList[index].getBalance());
        } else {
            System.out.println("The amount was not deposited");
        }
    }
    public void withdraw(String accountNumber, double amount) {
        int index = findAccountIndex(accountNumber);
        double oldBalance = accountsList[index].getBalance();
        if (accountsList[index].withdraw(amount)) {
            System.out.println("The amount " + amount + " was withdraw to the balance " +
                    oldBalance + "\n The new balance is " + accountsList[index].getBalance());
        } else {
            System.out.println("The amount was not deposited");
        }
    }

    public int findAccountIndex(String accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accountsList[i].getAccountNumber().equals(accountNumber)) {
                return i;
            }
        }
        return -1;
    }
}
