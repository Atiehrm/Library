package ir.maktab.library;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        String commandUser;
        String[] commandUserArray = new String[3];
        do {
            System.out.println("*****enter exit to end******");
            commandUser = scanner.nextLine();
            commandUserArray = commandUser.toLowerCase().trim().split(" ");
            if (commandUserArray.length == 3) {
                switch (commandUserArray[0]) {
                    case "addbook":
                        if (commandUserArray[2].matches("[0-9]+")) {
                            admin.addBook(commandUserArray[1], Integer.parseInt(commandUserArray[2]));
                        } else System.out.println("only numbers for bookcounter");
                        break;
                    case "addmember":
                        if (commandUserArray[2].matches("[0-9]+")) {
                            admin.addMember(commandUserArray[1], Integer.parseInt(commandUserArray[2]));
                        } else System.out.println("only numbers for age like 1990");
                        break;
                    case "return":
                        if (commandUserArray[1].matches("[0-9]+") && commandUserArray[2].matches("[0-9]+")) {
                            admin.returnBook(Integer.parseInt(commandUserArray[1]), Integer.parseInt(commandUserArray[2]));
                        } else System.out.println("only numbers valid");
                        break;
                    case "get":
                        if (commandUserArray[1].matches("[0-9]+") && commandUserArray[2].matches("[0-9]+")) {
                            admin.getBook(Integer.parseInt(commandUserArray[1]), Integer.parseInt(commandUserArray[2]));
                        } else System.out.println("only numbers valid");
                        break;
                }
            } else if (!commandUserArray[0].equals("exit") && !commandUserArray[0].equals("bookstat") && !commandUserArray[0].equals("memberstat")) {
                System.out.println("wrong command");
            }//switch case
            if (commandUserArray[0].equalsIgnoreCase("bookstat")) {
                admin.bookStat();
            } else if (commandUserArray[0].equalsIgnoreCase("memberstat")) {
                admin.memberStat();
            }
        }
        while (!commandUser.equals("exit"));
    }
}
