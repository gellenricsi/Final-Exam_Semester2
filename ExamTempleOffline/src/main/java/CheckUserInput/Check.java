package CheckUserInput;

import java.util.Scanner;

public class Check {
    /**
     * Checking the user input that is valid or not for String input.
     * @return returns the input
     */
    public static String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("The input is empty. Try again.");
            }
            if (!input.isEmpty()) {
                return input;
            }
        }
    }

    /**
     * Checking the user input that is valid or not for Integer input.
     * @return returns the input
     */
    public static int getUserInputNumber() {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException n) {
                System.out.println("Invalid input! Write a number!");
            }
        }
        return input;
    }
}
