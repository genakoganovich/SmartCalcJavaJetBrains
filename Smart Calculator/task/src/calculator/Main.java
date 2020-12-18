package calculator;

import java.util.Scanner;

public class Main {
    private static final String EXIT_COMMAND = "/exit";
    private static final String HELP_COMMAND = "/help";
    private static final String HELP_MESSAGE = "The program calculates the sum of numbers";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            input = scanner.nextLine();
            if (input.equals(EXIT_COMMAND)) {
                break;
            }
            if (input.isEmpty()) {
                continue;
            }
            if (input.equals(HELP_COMMAND)) {
                System.out.println(HELP_MESSAGE);
                continue;
            }
            System.out.println(calculateSum(input));
        } while (true);

        System.out.println("Bye!");
    }

    public static void stageTwo() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            input = scanner.nextLine();
            if (input.equals(EXIT_COMMAND)) {
                break;
            }
            if (input.isEmpty()) {
                continue;
            }
            String[] operands = input.split("\\s+");
            if (operands.length == 2) {
                System.out.println(Integer.parseInt(operands[0])
                        + Integer.parseInt(operands[1]));
            } else if (operands.length == 1) {
                System.out.println(operands[0]);
            }
        } while (true);

        System.out.println("Bye!");

    }

    public static int calculateSum(String input) {
        String[] operands = input.split("\\s+");
        int sum = 0;
        for (int i = 0; i < operands.length; i++) {
            sum += Integer.parseInt(operands[i]);
        }
        return sum;
    }
}
