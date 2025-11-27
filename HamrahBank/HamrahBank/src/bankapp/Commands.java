package bankapp;

public class Commands {

    private Bank bank;

    public Commands(Bank bank) {
        this.bank = bank;
    }

    public String handle(String line) {
        if(line == null){
            return "";
        }

        String trimmed = line.trim();
        if(trimmed.length() == 0){
            return "";
        }

        String[] parts = trimmed.split("\\s+");

        String command = parts[0].toLowerCase();

        if(command.equals("register")) {
            // register <UserName> <Password> <FullName> <PhoneNumber> <Email>

            if(parts.length < 6){
                return "Error: invalid command.";
            }
            String username = parts[1];
            String password = parts[2];
            String phone = parts[parts.length - 2];
            String email = parts[parts.length - 1];

            String fullName = "";
            for(int i = 3 ; i <= parts.length - 3 ; i++) {
                if(i > 3){
                    fullName = fullName + " ";
                }
                fullName = fullName + parts[i];
            }
            return bank.register(username , password , fullName , phone , email);
        }

        if(command.equals("login")) {
            if(parts.length != 3){
                return "Error: invalid command.";
            }
            return bank.login(parts[1] , parts[2]);
        }

        if(command.equals("logout")) {
            return bank.logout();
        }

        if(command.equals("show") && parts.length >= 2 && parts[1].equalsIgnoreCase("balance")) {
            return bank.showBalance();
        }

        if(command.equals("deposit")) {
            if(parts.length != 2){
                return "Error: invalid command";
            }
            return bank.deposit(parts[1]);
        }

        if(command.equals("withdraw")) {
            if(parts.length != 2){
                return "Error: invalid command";
            }
            return bank.withdraw(parts[1]);
        }

        if(command.equals("transfer")) {
            if(parts.length != 3){
                return "Error: invalid command";
            }
            return bank.transfer(parts[1] , parts[2]);
        }

        if (command.equals("exit")) {
            return "EXIT";
        }

        return "Error: unknown command";
    }
}


