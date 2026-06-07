package com.jlw.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerDAO dao = new CustomerDAO();
        BankingService service = new BankingService();

        while (true) {

            System.out.println("\n1.Create Account");
            System.out.println("2.View Account");
            System.out.println("3.Update Customer");
            System.out.println("4.Delete Customer");
            System.out.println("5.Transfer Money");
            System.out.println("6.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Account No: ");
                    long acc = sc.nextLong();

                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Balance: ");
                    double bal = sc.nextDouble();

                    dao.createAccount(
                            new Customer(acc, name, bal));
                    break;

                case 2:
                    System.out.print("Account No: ");
                    dao.viewAccount(sc.nextLong());
                    break;

                case 3:
                    System.out.print("Account No: ");
                    long accountNo = sc.nextLong();

                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    dao.updateCustomer(accountNo, newName);
                    break;

                case 4:
                    System.out.print("Account No: ");
                    dao.deleteCustomer(sc.nextLong());
                    break;

                case 5:
                    System.out.print("Sender Account: ");
                    long sender = sc.nextLong();

                    System.out.print("Receiver Account: ");
                    long receiver = sc.nextLong();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    service.transferMoney(
                            sender,
                            receiver,
                            amount);
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}