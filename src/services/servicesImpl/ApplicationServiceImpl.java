package services.servicesImpl;

import Models.Account;

import services.AccountService;
import services.ApplicationService;
import services.DataValidation;
import services.WalletOpreations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {

    private Scanner scanner = new Scanner(System.in);
    private AccountService accountService = new AccountServiceImpl();

    @Override
    public void start() {

        int counter = 0;
        while (true){
            showMainMenu();
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid Input. Please enter a number.");
                 scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            boolean exit = false;
            switch (choice){
                case 1:
                    Register();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    System.out.println("Exiting from Main Menu");
                    exit = true;
                    break;
                default:
                    counter ++;
                    if(counter != 4){
                        System.out.println("Invalid Choice. Please Try Again.");;

                    }

            }

            if(exit) break;
            if(counter == 4){
                System.out.println("Too many invalid choices. Exiting the application.");
                break;
            }
            System.out.println("--------------------------------------------------------------");
           // Wallet wallet = Wallet.getInstance();
           // System.out.println(wallet.getAccounts());
        }

    }
    private void Login(){
        String [] userNameAndPassword = extractUserNameAndPassword().split(" ");
        Account account = accountService.login(userNameAndPassword[0], userNameAndPassword[1]);
        if(account!= null){
            System.out.println("Login Successfully ");
            WalletOpreations walletOpreation = new WalletOpreationsImpl(account);

           walletOpreation.start();

        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    private void Register(){

        String [] userNameAndPassword = extractUserNameAndPassword().split(" ");
        Account account = new Account(userNameAndPassword[0], userNameAndPassword[1]);
        boolean res = accountService.isAccountCreated(account);
        if(res){
            System.out.println("Account Created Successfully");
        }else{
            System.out.println("Account already exists. Please try again.");
        }
    }
    private  String extractUserNameAndPassword (){
        DataValidation dataValidation = new DataValidationImpl();
        System.out.println("Enter your username");
        String userName = scanner.nextLine();
        boolean checkUserName = dataValidation.validateUserName(userName);
        if(!checkUserName){
            System.out.println("Invalid Username. Username should contain only alphabets and numbers and length should be between 5 and 20 characters.");
            return extractUserNameAndPassword();
        }
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        boolean checkPassword = dataValidation.validatePassword(password);
        if(!checkPassword){
            System.out.println("Invalid Password. Password should contain at least one uppercase letter, one lowercase letter, one number, and one special character and length should be between 8 and 20 characters.");
            return extractUserNameAndPassword();
        }
        if (checkPassword && checkUserName){
            return userName +" "+ password;
        }
        return "";
    }
    private void showMainMenu(){
            System.out.println("---------> Welcome to Mostafa E-Wallet <------------");
            System.out.println("Welcome to Main Menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice");

    }
}
