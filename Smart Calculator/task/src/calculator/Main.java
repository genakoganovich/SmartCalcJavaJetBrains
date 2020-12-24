package calculator;

import java.util.Scanner;

public class Main {
    private static final String EXIT_COMMAND = "/exit";
    private static final String HELP_COMMAND = "/help";
    private static final String HELP_MESSAGE = "The program supports "
            + "the addition + and subtraction - operators. "
            + "\nBoth unary and binary minus operators";

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
            System.out.println(addSubtract(input));
        } while (true);

        System.out.println("Bye!");
    }

    public static String replaceMultiples(String input) {
        return input
                .replaceAll("--", "+")
                .replaceAll("\\++", "+")
                .replaceAll("\\+-", "-")
                .replaceAll("-\\+", "-")
                .replaceAll("^-", "0-")
                .replaceAll("\\s+", "");
    }


    public static int subtract(String input) {
        String[] operands = input.split("-");
        int result = Integer.parseInt(operands[0]);
        for (int i = 1; i < operands.length; i++) {
            result -= Integer.parseInt(operands[i]);
        }
        return result;
    }

    public static int addSubtract(String input) {
        String[] terms = replaceMultiples(input).split("\\+");
        int result = 0;
        for (String term : terms) {
            result += subtract(term);
        }
        return result;
    }
}
