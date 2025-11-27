package bankapp;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private static ArrayList<User> users = new ArrayList<>();

    private static Integer loggedInIdx = null;

    private static Random rand = new Random();



    private boolean isUsernameUnique(String username){
        return findUserByUsername(username) == null;
    }

    private Integer findUserByUsername(String username){
        for(int i = 0 ; i < users.size() ; i++){
            if(users.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return null;
    }

    private Integer findUserByCard(String card){
        for(int i = 0 ; i < users.size() ; i++){
            if(users.get(i).getCardNumber().equals(card)){
                return i;
            }
        }
        return null;
    }

    private boolean isLoggedIn(){
        return loggedInIdx != null;
    }

    private boolean validatePhone(String p){
        if(p == null){
            return false;
        }
        if(p.length() != 11){
            return false;
        }
        if(!p.startsWith("09")){
            return false;
        }
        for(int i = 0 ; i < p.length() ; i++){
            if(!Character.isDigit(p.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean validateEmail(String em){
        if(em == null){
            return false;
        }
        int atsign = em.indexOf('@');
        if(atsign <= 0){ // @نداره یا قبل از @ هیچی نیست
            return false;
        }
        if(em.charAt(0) == '.'){
            return false;
        }
        String condition = em.substring(atsign + 1);
        if(!condition.equals("aut.com")){
            return false;
        }
        return true;
    }


    private boolean validatePassword(String pass){
        if(pass == null){
            return false;
        }
        if(pass.length() < 8){
            return false;
        }

        boolean upper = false , lower = false , digit = false , special = false;

        for (int i = 0 ; i < pass.length() ; i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c)) {
                upper = true;
            } else if (Character.isLowerCase(c)) {
                lower = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (c == '@' || c == '!' || c == '&' || c == '$' || c == '؟'){
                    special = true;
                }

        }
        return upper && lower && digit && special;
    }



    private String generateUniqueCard(){
        while(true){
            char[] digits = new char[16];
            digits[0] = '6';
            digits[1] = '0';
            digits[2] = '3';
            digits[3] = '7';
            for(int i= 4 ; i < 16 ; i++){
                int cn = rand.nextInt(10);
                digits[i] = (char) ('0' + cn);
            }
            String card = new String(digits);
            if(findUserByCard(card) == null){
                return card;
            }
        }

    }




    public String register(String username , String password , String fullName , String phone , String email){
        if(!isUsernameUnique(username)){
            return "Error: username already exists.";
        }

        if(!validatePhone(phone)) {
            return "Error: invalid phone number.";
        }


        if(!validateEmail(email)) {
            return "Error: invalid email.";
        }


        if(!validatePassword(password)) {
            return "Error: invalid password.";
        }



        String card = generateUniqueCard();
        User u = new User(username , password , fullName , card , phone , email);
        users.add(u);

        return "Registered successfully. \nAssigned card number:" + card;
    }

    public String login(String username , String password) {
        Integer idx = findUserByUsername(username);
        if(idx == null){
            return "Error: invalid username.";
        }
        User u = users.get(idx);
        if(!u.getPassword().equals(password)){
            return "Error: invalid password.";
        }
        loggedInIdx = idx;
        return "Login successful.";
    }


    public String logout() {
        if(!isLoggedIn()){
            return "Error: You should login first.";
        }
        loggedInIdx = null;
        return "Logout successful.";
    }


    public String showBalance() {
        if(!isLoggedIn()){
            return "Error: You should login first.";
        }
        return "Current balance: " + users.get(loggedInIdx).getBalance();
    }


    public String deposit(String amountStr) {
        if (!isLoggedIn()) {
            return "Error: You should login first.";
        }
        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (Exception e) {
            return "Error: invalid amount.";
        }

        if (amount <= 0) {
            return "Error: deposit amount must be positive.";
        }

        User u = users.get(loggedInIdx);

        String balanceStr = u.getBalance();
        if(balanceStr == null || balanceStr.trim().length() == 0){
            balanceStr = "0.0";
        }

        double current = Double.parseDouble(u.getBalance());
        current = current + amount;
        u.setBalance(String.valueOf(current));
        return "Deposit successful. Current balance: " + u.getBalance();
    }

    public String withdraw(String amountStr) {
        if(!isLoggedIn()){
            return "Error: You should login first.";
        }

        double amount;
        try{
            amount = Double.parseDouble(amountStr);
        }
        catch(Exception e){
            return "Error: invalid amount.";
        }

        if(amount <= 0){
            return "Error: withdraw amount must be positive.";
        }

        User u = users.get(loggedInIdx);

        double current = Double.parseDouble(u.getBalance());
        if(current < amount){
            return "Error: insufficient balance.";
        }

        current = current - amount;

        u.setBalance(String.valueOf(current));
        return "Withdrawal successful. Current balance: " + u.getBalance();
    }


    public String transfer(String CardNum, String amountStr) {
        if(!isLoggedIn()){
            return "Error: You should login first.";
        }

        double amount;

        try{
            amount = Double.parseDouble(amountStr);
        }
        catch(Exception e){
            return "Error: invalid amount.";
        }
        if(amount <= 0){
            return "Error: transfer amount must be positive.";
        }

        Integer destinationIdx = findUserByCard(CardNum);

        if(destinationIdx == null){
            return "Error: invalid card number.";
        }

        User from = users.get(loggedInIdx);

        double fromBalance = Double.parseDouble(from.getBalance());
        if (fromBalance < amount){
            return "Error: insufficient balance.";
        }

        User to = users.get(destinationIdx);
        double toBalanace = Double.parseDouble(to.getBalance());

        fromBalance -= amount;
        toBalanace += amount;

        from.setBalance(String.valueOf(fromBalance));
        to.setBalance(String.valueOf(toBalanace));

        return "Transferred successfully.";
    }




}


