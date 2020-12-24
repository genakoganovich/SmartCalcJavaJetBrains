package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    private static final String EXIT_COMMAND = "/exit";
    private static final String HELP_COMMAND = "/help";
    private static final String HELP_MESSAGE = "The program supports "
            + "the addition + and subtraction - operators. "
            + "\nBoth unary and binary minus operators";
    private static final String INVALID_EXPRESSION = "Invalid expression";
    private static final String UNKNOWN_COMMAND = "Unknown command";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Pattern pattern = Pattern.compile("[-+]?(\\s*\\d+\\s*[-+]+)*\\s*\\d+\\s*");

        do {
            input = scanner.nextLine();
            if (input.startsWith("/")) {
                processCommand(input);
                continue;
            }
            if (input.isEmpty()) {
                continue;
            }
            if (!pattern.matcher(input).matches()) {
                System.out.println(INVALID_EXPRESSION);
                continue;
            }
            System.out.println(addSubtract(input));
        } while (true);
    }

    public static String replaceMultiples(String input) {
        return input
                .replaceAll("--", "+")
                .replaceAll("\\++", "+")
                .replaceAll("\\+-", "-")
                .replaceAll("-\\+", "-")
                .replaceAll("^-", "0-")
                .replaceAll("^\\+", "0+")
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

    public static void processCommand(String command) {
        if (command.equals(EXIT_COMMAND)) {
            System.out.println("Bye!");
            System.exit(0);
        } else if (command.equals(HELP_COMMAND)) {
            System.out.println(HELP_MESSAGE);
            return;
        } else {
            System.out.println(UNKNOWN_COMMAND);
            return;
        }
    }
}