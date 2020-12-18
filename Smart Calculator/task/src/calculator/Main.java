package calculator;

import java.util.Scanner;

public class Main {
    private static final String EXIT = "/exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            input = scanner.nextLine();
            if (input.equals(EXIT)) {
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
}
