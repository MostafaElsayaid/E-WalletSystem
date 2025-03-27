package Models;

public class Transaction {
    private static int transactionCounter = 0;
    private int transactionId;
    private String sender;
    private String recipient;
    private double amount;
    private String timestamp;

    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.transactionId = ++transactionCounter;
        this.timestamp = getCurrentTimestamp();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getCurrentTimestamp() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount=" + amount +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
