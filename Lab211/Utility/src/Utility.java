
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utility {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Get an integer from the input
     *
     * @param message
     * @param error
     * @param min
     * @param max
     * @return number input
     */
    public static int getInteger(String message, String error, int min, int max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.println(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    /**
     * Get an integer from the input
     *
     * @param message
     * @param error
     * @param min
     * @param max
     * @return number input
     */
    public static float getFloat(String message, String error, int min, int max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.println(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }

    }
}
