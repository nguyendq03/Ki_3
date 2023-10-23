package j1.s.p0050;

import java.util.*;

/**
 *
 * @author Khánh Trang
 */
public class J1SP0050 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        // loop until the user choose to exit the program
        while (true) {
            int choice = Manager.menu(scanner);
            switch (choice) {
                case 1: {
                    List<Float> isEven = new ArrayList<>();
                    List<Float> isOdd = new ArrayList<>();
                    List<Float> isPerfectSquare = new ArrayList<>();
                    System.out.print("Enter A: ");
                    String a = scanner.nextLine();
                    Float valueA = Validate.checkin(a);
                    while (valueA == null) {
                        System.out.print("Please input number: ");
                        a = scanner.nextLine();
                        valueA = Validate.checkin(a);
                    }
                    if (Validate.isOdd(valueA)) {
                        isOdd.add(valueA);
                    } else {
                        isEven.add(valueA);
                    }
                    if (Validate.isPerfectSquare(valueA)) {
                        isPerfectSquare.add(valueA);
                    }
                    System.out.print("Enter B: ");
                    String b = scanner.nextLine();
                    Float valueB = Validate.checkin(b);
                    while (valueB == null) {
                        System.out.print("Please input number: ");
                        b = scanner.nextLine();
                        valueB = Validate.checkin(b);
                    }
                    if (Validate.isOdd(valueB)) {
                        isOdd.add(valueB);
                    } else {
                        isEven.add(valueB);
                    }
                    if (Validate.isPerfectSquare(valueB)) {
                        isPerfectSquare.add(valueB);
                    }
                    List<Float> solution = Manager.calculateEquation(valueA, valueB);
                    if (solution == null) {
                        System.out.println("No solution");
                    } else if (solution.isEmpty()) {
                        System.out.println("Infinite solution");
                    } else {
                        System.out.println("Solution: x = " + solution.get(0));

                        float result = solution.get(0);
                        if (Validate.isOdd(result)) {
                            isOdd.add(result);
                        } else {
                            isEven.add(result);
                        }
                        if (Validate.isPerfectSquare(result)) {
                            isPerfectSquare.add(result);
                        }
                        if (isOdd.isEmpty()) {
                            return;
                        } else {
                            System.out.println("Number is odd : " + isOdd);
                        }
                        if (isEven.isEmpty()) {
                            return;
                        } else {
                            System.out.println("Number is even : " + isEven);
                        }

                        if (isPerfectSquare.isEmpty()) {
                            return;
                        } else {
                            System.out.println("Number is perfect square : " + isPerfectSquare);
                        }
                        break;
                    }
                }
                case 2:
                    List<Float> isEven = new ArrayList<>();
                    List<Float> isOdd = new ArrayList<>();
                    List<Float> isPerfectSquare = new ArrayList<>();
                    System.out.print("Enter A: ");
                    String a = scanner.nextLine();
                    Float valueA = Validate.checkin(a);
                    while (valueA == null) {
                        System.out.print("Please input number: ");
                        a = scanner.nextLine();
                        valueA = Validate.checkin(a);
                    }
                    if (Validate.isOdd(valueA)) {
                        isOdd.add(valueA);
                    } else {
                        isEven.add(valueA);
                    }
                    if (Validate.isPerfectSquare(valueA)) {
                        isPerfectSquare.add(valueA);
                    }
                    System.out.print("Enter B: ");
                    String b = scanner.nextLine();
                    Float valueB = Validate.checkin(b);
                    while (valueB == null) {
                        System.out.print("Please input number: ");
                        b = scanner.nextLine();
                        valueB = Validate.checkin(b);
                    }
                    if (Validate.isOdd(valueB)) {
                        isOdd.add(valueB);
                    } else {
                        isEven.add(valueB);
                    }
                    if (Validate.isPerfectSquare(valueB)) {
                        isPerfectSquare.add(valueB);
                    }
                    System.out.print("Enter C: ");
                    String c = scanner.nextLine();
                    Float valueC = Validate.checkin(c);
                    while (valueC == null) {
                        System.out.print("Please input number: ");
                        c = scanner.nextLine();
                        valueC = Validate.checkin(c);
                    }
                    if (Validate.isOdd(valueC)) {
                        isOdd.add(valueC);
                    } else {
                        isEven.add(valueC);
                    }
                    if (Validate.isPerfectSquare(valueC)) {
                        isPerfectSquare.add(valueC);
                    }
                    List<Float> solution = Manager.calculateQuadraticEquation(valueA, valueB, valueC);
                    if (solution == null) {
                        System.out.println("No solution");
                    } else if (solution.isEmpty()) {
                        System.out.println("Infinite solution");
                    } else {
                        System.out.println("Solution: x1 = " + solution.get(0) + " and x2 = " + solution.get(1));

                        float result = solution.get(0);
                        float result2 = solution.get(1);
                        if (Validate.isOdd(result)) {
                            isOdd.add(result);
                        } else {
                            isEven.add(result);
                        }
                        if (Validate.isPerfectSquare(result)) {
                            isPerfectSquare.add(result);
                        }
                        if (Validate.isOdd(result2)) {
                            isOdd.add(result2);
                        } else {
                            isEven.add(result2);
                        }
                        if (Validate.isPerfectSquare(result2)) {
                            isPerfectSquare.add(result2);
                        }
                        if (isOdd.isEmpty()) {
                            return;
                        } else {
                            System.out.println(" Number is odd : " + isOdd);
                        }
                        if (isEven.isEmpty()) {
                            return;
                        } else {
                            System.out.println(" Number is even : " + isEven);
                        }
                        if (isPerfectSquare.isEmpty()) {
                            return;
                        } else {
                            System.out.println(" Number is perfect square : " + isPerfectSquare);
                        }
                        break;
                    }
                case 3:
                    scanner.close();
                    return;

            }
        }
    }

}
