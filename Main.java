import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Main{
    Map<String, Account> accounts = new HashMap<String, Account>();
    Scanner scanner = new Scanner(System.in);
    int action = 0;

    class Account {
        String name;
        String id;
        int balance = 0;

        public Account(){}
    }

    void start() {
        System.out.print("1 - Create An Account\n2 - Delete An Account\n3 - Make An Account Deposit\n4 - Make An Account Withdrawal\n5 - Check An Account Balance\n6 - Exit\n7 - Show all accounts ");

        action = scanner.nextInt();

        if(action < 1 || action > 7){
            System.err.println("Error: Please enter a valid choice (1 thru 7)");
        }

        if(action == 1){
            Account temp = new Account();

            System.out.print("Enter your name: ");
            temp.name = scanner.next();
            System.out.print("Enter your id: ");
            temp.id = scanner.next();

            if(accounts.containsKey(temp.id)){
                System.err.println("ID already exists, cannot add account");
            }else{
                accounts.put(temp.id, temp);
            }
        } else if(action == 6){
            System.exit(0);
        } else if(action == 7){
            for (Map.Entry<String, Account> account : accounts.entrySet()) {
                System.out.println("Account: "+account.getValue().name+" ID: "+account.getValue().id+" Balance: "+account.getValue().balance);                
            }
        } else if(action == 3){
            System.out.print("Enter your id: ");
            String id = scanner.next();

            if(accounts.containsKey(id)){
                System.out.print("Enter deposit amount: ");
                int amount = scanner.nextInt();
                accounts.get(id).balance += amount;
                System.out.println("Deposit was successful, new balance "+accounts.get(id).balance);
            }else{
                System.err.println("You dont have an account. Please create one");
            }
        }

        System.out.println("----------------------------------------------------------");
        start();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}