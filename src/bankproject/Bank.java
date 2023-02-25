package bankproject;

import java.util.Scanner;
import java.util.ArrayList;

public class Bank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Customer> c = new ArrayList();
        long nationalID = 0;
        long accountNumber = 0;
        boolean isAccount;
        boolean exit = false;
        printMsg("Welcome 'S BANK");

        int var = 0;

        do {

            System.out.println("\n\t----------------- 'S Bank ----------------");
            System.out.println("Please enter the number of your choice (enter 8 to exit) : ");
            System.out.println("1. Create a new account.");
            System.out.println("2. Deposit an amount on an existing account. ");
            System.out.println("3. Withdrawal an amount from an existing account.");
            System.out.println("4. Check account");
            System.out.println("5. Get a new loan");
            System.out.println("6. Check a loan");
            System.out.println("7. Pay for a loan");
            System.out.println("8.Exit");
            var = in.nextInt();

            switch (var) {
                case 1:
                    System.out.println("Enter the national ID :");
                    nationalID = in.nextLong();
                    System.out.println("Enter the name :");
                    String name = in.next();
                    System.out.println("Enter the address :");
                    String address = in.next();
                    System.out.println("Enter the email :");
                    String email = in.next();
                    System.out.println("Enter the mobile :");
                    String mobile = in.next();
                    c.add(new Customer(nationalID, name, address, email, mobile));
                    printMsg(c);
                    break;
                case 2:
                    isAccount = false;
                    System.out.println("Enter the account number :");
                    accountNumber = in.nextLong();
                    for (Customer ac : c) {
                        if (ac.account.getAccountNumber() == accountNumber) {
                            System.out.println("Enter the amount : ");
                            double amount = in.nextDouble();
                            ac.account.Deposit(amount);
                            isAccount = true;
                        }
                    }
                    if (isAccount == false) {
                        printMsg("Account number is incorrect!");
                    }
                    break;
                case 3:
                    isAccount = false;
                    System.out.println("Enter the account number :");
                    accountNumber = in.nextLong();
                    for (Customer ac : c) {
                        if (ac.account.getAccountNumber() == accountNumber) {
                            System.out.println("Enter the amount :");
                            double amount = in.nextDouble();
                            ac.account.Withdrawal(amount);
                            isAccount = true;
                        }
                    }
                    if (isAccount == false) {
                        printMsg("Account number is incorrect!");
                    }
                    break;
                case 4:
                    isAccount = false;
                    System.out.println("Enter the account number :");
                    accountNumber = in.nextLong();
                    for (Customer ac : c) {
                        if (ac.account.getAccountNumber() == accountNumber) {
                            printMsg("The balance : " + ac.account.getBalance());
                            isAccount = true;
                        }
                    }
                    if (isAccount == false) {
                        printMsg("Account number is incorrect!");
                    }
                    break;
                case 5:
                    isAccount = false;
                    System.out.println("Enter the account number :");
                    accountNumber = in.nextLong();
                    for (Customer ac : c) {
                        if (ac.account.getAccountNumber() == accountNumber) {
                            if (ac.account.loan.isLoan() == false) {
                                System.out.println("Enter the value of the loan : ");
                                double loan = in.nextDouble();
                                System.out.println("Enter the number of years to repay the loan :");
                                int years = in.nextInt();
                                System.out.println("Enter the value of the interest rate of the loan :");
                                double rate = in.nextDouble();
                                printMsg(ac.account.newLoan(loan, years, rate));
                            } else {
                                printMsg("The customer has a loan ..!");
                            }

                            isAccount = true;
                        }
                    }
                    if (isAccount == false) {
                        printMsg("Account number is incorrect!");
                    }
                    break;
                case 6:
                    isAccount = false;
                    System.out.println("Enter the account number :");
                    accountNumber = in.nextLong();
                    for (Customer ac : c) {
                        if (ac.account.getAccountNumber() == accountNumber) {
                            printMsg(ac.account.loan);
                            isAccount = true;
                        }
                    }
                    if (isAccount == false) {
                        printMsg("Account number is incorrect!");
                    }
                    break;
                case 7:
                    isAccount = false;
                    System.out.println("Enter the account number :");
                    accountNumber = in.nextLong();
                    for (Customer ac : c) {
                        if (ac.account.getAccountNumber() == accountNumber) {
                            printMsg(ac.account.payMonthlyPayment());
                            isAccount = true;
                        }
                    }
                    if (isAccount == false) {
                        printMsg("Account number is incorrect!");
                    }
                    break;

                case 8:
                    exit = true;
            }
        } while (!exit);
    }

    public static void printMsg(Object msg) {
        System.out.println("\t***************************************");
        System.out.println("\t\t" + msg + "");
        System.out.println("\t***************************************");
    }
}
