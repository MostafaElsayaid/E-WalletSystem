package services;




public interface WalletOpreations {
    void start();
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
    void transfer(String targetName, double amount);
    void printTransactionHistory();

    void showAccountDetails();
}
