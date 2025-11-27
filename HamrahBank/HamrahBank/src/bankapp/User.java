package bankapp;

public class User {

    private String username;
    private String password;
    private String fullName;
    private String cardNumber;
    private String phoneNumber;
    private String email;
    private String balance;


    public User(String username , String password , String fullName , String cardNumber , String phoneNumber , String email){
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = "0.0";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }



}