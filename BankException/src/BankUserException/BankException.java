package BankUserException;

import java.util.Scanner;

class InvalidAmountException extends Exception {
    InvalidAmountException(String str) {
        super(str);
    }
}

class InsufficientAmountException extends Exception{
	InsufficientAmountException(String str){
		super(str);
	}
}
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class Customer{
    int accountNumber;
	String accountType;
	String customerName;
	float accountBalance;
	
	Scanner input = new Scanner(System.in);
	
	public void setCustomerDetails() throws AccountNotFoundException{
		System.out.println("Enter your name: ");
		customerName = input.next();
		System.out.println("Enter the Account Number");
	    accountNumber = input.nextInt();
	    if (accountNumber <= 0) {
	        throw new AccountNotFoundException("Invalid account number");
	    }
	    System.out.println("Enter the account type");
	    accountType = input.next();
	    System.out.println("Enter the Account Opening Balance");
        accountBalance = input.nextFloat();
	}
	
	public void getCustomerDetails() {
		System.out.println("_______________________________");
        System.out.println("The Customer Details are:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("_______________________________");
	}
}

public class BankException {
	public static void main(String[] args) throws AccountNotFoundException {
		Scanner sc = new Scanner(System.in);
	    InvalidAmountException amountException = new InvalidAmountException("Invalid Amount");
	    InsufficientAmountException fundsException = new InsufficientAmountException("Insufficient Funds");
	    int choice;

		System.out.println("Enter the number of customers: ");
		int noOfCustomers = sc.nextInt();
		Customer [] customer = new Customer[noOfCustomers];
		
		for(int i=0; i<noOfCustomers; i++) {
			customer[i] = new Customer();
			customer[i].setCustomerDetails();
		}
		do {
			System.out.println("1. View Account Details");
	        System.out.println("2. Find Account by account number");
	        System.out.println("3. Deposit amount");
	        System.out.println("4. Withdraw amount");
	        System.out.println("5. Exit");
	        System.out.println("Enter your choice:");
	        choice = sc.nextInt();
	        
	        switch(choice) {
	        	case 1:
	        		for(int i=0; i<noOfCustomers; i++) {
	        			customer[i].getCustomerDetails();
	        		}
	        	break;
	        	
	        	case 2:
	        		System.out.println("Enter the account Number");
	        	    int searchAccount = sc.nextInt();
	        	    boolean accountFound = false;
	        	    try {
	        	    	for (int i = 0; i < noOfCustomers; i++) {
		        	        if (customer[i].accountNumber == searchAccount) {
		        	            customer[i].getCustomerDetails();
		        	            accountFound = true;
		        	        }
		        	        else {
		        	        	if (!accountFound) {
		    	        	        throw new AccountNotFoundException("Account not found");
		    	        	    }
		        	        }
		        	    }
	        	    } catch (AccountNotFoundException e) {
	                    System.out.println("Account not found");
	                }
	        	  
	        	    break;
	        	case 3: 
	                System.out.println("Enter the account number");
	                searchAccount = sc.nextInt();
	                try {
	                    System.out.println("Enter the amount to deposit");
	                    int depositAmount = sc.nextInt();
	                    if (depositAmount < 0) {
	                        throw amountException;
	                    } else {
	                        for (int i = 0; i < noOfCustomers; i++) {
	                            if (customer[i].accountNumber == searchAccount) {
	                                customer[i].accountBalance = customer[i].accountBalance + depositAmount;
	                                customer[i].getCustomerDetails();
	                            }else {
	                            	throw new AccountNotFoundException("Account not found");
	                            }
	                        }
	                    }

	                } catch (InvalidAmountException e) {
	                    System.out.println(e.getMessage());
	                }catch (AccountNotFoundException e) {
	                    System.out.println("Account not found");
	                }
	                break;
	            case 4:
	                System.out.println("Enter the account number");
	                searchAccount = sc.nextInt();
	                try {
	                    System.out.println("Enter the amount to withdraw");
	                    int withdrawAmount = sc.nextInt();
	                    if (withdrawAmount <= 0) {
	                        throw amountException;
	                    } else {
	                        for (int i = 0; i < noOfCustomers; i++) {
	                            if (customer[i].accountNumber == searchAccount) {
	                                if (withdrawAmount > customer[i].accountBalance) {
	                                    throw fundsException;
	                                } else {
	                                    customer[i].accountBalance = customer[i].accountBalance - withdrawAmount;
	                                    customer[i].getCustomerDetails();
	                                }
	                            }else {
	                            	throw new AccountNotFoundException("Account not found");
	                            }
	                        }
	                    }
	                } catch (InvalidAmountException e) {
	                    System.out.println("Invalid amount entered. please try again");
	                } catch (InsufficientAmountException e) {
	                    System.out.println("Insufficient funds.");
	                } catch (AccountNotFoundException e) {
	                    System.out.println("Account not found");
	                }
	                
	                break;
	            default:
	            	System.out.println("Invalid choice");
	            	break;
	        }
	    } while (choice < 5);
	    sc.close();
	}
}
