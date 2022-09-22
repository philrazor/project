import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.println("Hello world "+name);
    }
}