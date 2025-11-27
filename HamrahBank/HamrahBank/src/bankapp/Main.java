package bankapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Commands handler = new Commands(bank);

        Scanner scn = new Scanner(System.in);

        System.out.println("Type commands (register, login, show balance, deposit, withdraw, transfer, logout, exit)");

        while(true) {
            String line = scn.nextLine();

            String response = handler.handle(line);

            if(response == null){
                continue;
            }

            if(response.equals("")){
                continue;
            }

            if(response.equals("EXIT")){
                System.out.println("Goodbye!");
                break;
            }

            System.out.println(response);
        }

        scn.close();
    }
}