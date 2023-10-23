package changebase;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        
    
      Scanner scanner = new Scanner(System.in);
        //loop until user wants to exit
        while (true) {
            int choice = Manager.menu(scanner);
            switch (choice) {
                case 1:
                    String binary = Validate.checkInputBinary(scanner);
                    Manager.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = Validate.checkInputDecimal(scanner);
                    Manager.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexadecimal = Validate.checkInputHexaDecimal(scanner);
                    Manager.convertFromHexadecimal(hexadecimal);
                    break;
                case 4:
                    System.exit(0);
                    return;
            }
        }
    }
}
