import java.util.Scanner;

class InvalidAmountException extends Exception {
    InvalidAmountException(String str) {
        super(str);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String str) {
        super(str);
    }
}

class Customer {
    int accountNumber;
    String accountType;
    String customerName;
    int accountBalance;
    Scanner sc = new Scanner(System.in);

    public void setCustomerDetails() {
        System.out.println("Enter the Account Number");
        accountNumber = sc.nextInt();
        System.out.println("Enter the account type");
        accountType = sc.next();
        System.out.println("Enter the Customer Name");
        customerName = sc.next();
        System.out.println("Enter the Account Opening Balance");
        accountBalance = sc.nextInt();
    }

    public void getCustomerDetails() {
        System.out.println("-----------------------------");
        System.out.println("The Customer Details are:");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type : " + accountType);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Balance : " + accountBalance);
        System.out.println("-------------------------------");
    }
}

public class BankApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvalidAmountException amountException = new InvalidAmountException("Invalid Amount");
        InsufficientFundsException fundsException = new InsufficientFundsException("Insufficient Funds");
        int choice;

        System.out.println("Enter the No of Customers");
        int noOfCustomers = sc.nextInt();
        Customer[] customers = new Customer[noOfCustomers];

        // Input customer details
        for (int i = 0; i < noOfCustomers; i++) {
            customers[i] = new Customer();
            customers[i].setCustomerDetails();
        }

        do {
            System.out.println("1. Display Account Details:");
            System.out.println("2. Search by account number:");
            System.out.println("3. Deposit the amount:");
            System.out.println("4. Withdraw the amount:");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Display all customer details
                    for (int i = 0; i < noOfCustomers; i++) {
                        customers[i].getCustomerDetails();
                    }
                    break;
                case 2:
                    // Search for a customer by account number
                    System.out.println("Enter the account number:");
                    int searchAccount = sc.nextInt();
                    boolean accountFound = false;
                    for (Customer customer : customers) {
                        if (customer.accountNumber == searchAccount) {
                            customer.getCustomerDetails();
                            accountFound = true;
                            break;
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account is not found\n");
                    }
                    break;
                case 3: // Deposit Amount
                    System.out.println("Enter the account number:");
                    searchAccount = sc.nextInt();

                    try {
                        System.out.println("Enter the amount to deposit:");
                        int depositAmount = sc.nextInt();
                        if (depositAmount < 0) {
                            throw amountException;
                        } else {
                            for (Customer customer : customers) {
                                if (customer.accountNumber == searchAccount) {
                                    customer.accountBalance += depositAmount;
                                    customer.getCustomerDetails();
                                }
                            }
                        }
                    } catch (InvalidAmountException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4: // Withdraw Amount
                    System.out.println("Enter the account number");
                    searchAccount = sc.nextInt();

                    try {
                        System.out.println("Enter the amount to withdraw");
                        int withdrawAmount = sc.nextInt();
                        if (withdrawAmount <= 0) {
                            throw amountException;
                        } else {
                            for (Customer customer : customers) {
                                if (customer.accountNumber == searchAccount) {
                                    if (withdrawAmount > customer.accountBalance) {
                                        throw fundsException;
                                    } else {
                                        customer.accountBalance -= withdrawAmount;
                                        customer.getCustomerDetails();
                                    }
                                }
                            }
                        }
                    } catch (InvalidAmountException | InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                default:
                    // Invalid choice
                    System.out.println("Thank you for using our service!!!!!");
            }
        } while (choice < 5);
    }
}
