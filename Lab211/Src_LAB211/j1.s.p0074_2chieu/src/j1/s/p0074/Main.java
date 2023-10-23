package j1.s.p0074;

import java.util.Scanner;

public class Main {

    // Scanner use in this class.
    public static final Scanner in = new Scanner(System.in);
    public static int[][] matrix1;
    public static int[][] matrix2;
    
    
    /**
     * This is the main method of the program. It contains a while loop that
     * continuously prompts the user for a choice. The user can choose between
     * performing addition, subtraction, multiplication of matrices, or exiting
     * the program. The checkIntLimit method is used to ensure that the user
     * enters a valid choice within the given range. Depending on the user's
     * choice, the corresponding method for matrix addition, subtraction, or
     * multiplication is called. If the user chooses to exit the program, the
     * loop is terminated and the program ends.
     *
     * @param args the command line argument
     */
    public static void main(String[] args) {
        while (true) {
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                // Addition matrix
                case 1:
                    additionMatrix();
                    break;
                // Subtraction matrix
                case 2:
                    subtractionMatrix();
                    break;
                // Multiplication matrix
                case 3:
                    multiplicationMatrix();
                    System.out.println("Reverse matrix");
                    reverseMultiplicationMatrix(matrix1, matrix2);
                   
                    break;
                //Exit program
                case 4:
                    return;
            }
        }
    }

    /**
     * This method generates the menu for the calculator program. Displays the
     * available options for the user to choose from, such as addition,
     * subtraction, multiplication, and quitting the program.It prompts the user
     * to enter their choice.
     */
    public static void menu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
    }

    /**
     * This method generates the menu for the calculator program. Displays the
     * available options for the user to choose from, such as addition,
     * subtraction, multiplication, and quitting the program. Prompts the user
     * to enter their choice.
     *
     * @param minValue the minimum value allowed for the user's choice
     * @param maxValue the maximum value allowed for the user's choice
     * @return the user's valid choice
     */
    public static int checkIntLimit(int minValue, int maxValue) {
        while (true) {
            try {
                menu();
                //Convert a string to an integer value and assign it to the variable number
                int number = Integer.parseInt(in.nextLine());
                //Check if value in range or not
                if (number < minValue || number > maxValue) {
                    System.out.println("Value must in range [" + minValue + ", " + maxValue + "]");
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println("Value must be digit");
            }
        }
    }

    /**
     * This method is a public static method that checks the user input and
     * ensures that it is an integer.
     *
     * @return by the method
     */
    public static int checkInputInt() {
        // while loop to continuously prompt the user for input until a valid integer is entered
        while (true) {
            try {
                //Convert a string to an integer value and assign it to the variable number
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Value must be digit");
                System.out.print("Enter again: ");
            }
        }

    }

    /**
     * The function allow user to enter number of rows and columns of matrix and
     * values in it.
     *
     * @param matrixNumber is the number represent for the first or the second
     * matrix
     * @return the inputted matrix
     */
    public static int[][] inputMatrix(int matrixNumber) {
        System.out.print("Enter Row Matrix " + matrixNumber + ": ");
        int row = checkInputInt();
        System.out.print("Enter Colum Matrix " + matrixNumber + ": ");
        int column = checkInputInt();
        int[][] matrix = new int[row][column];
        // Iterate over each row and each column of the matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int indexI = i + 1;
                int indexJ = j + 1;
                System.out.print("Enter Matrix" + matrixNumber + "[" + indexI + "]" + "[" + indexJ + "]:");
                matrix[i][j] = checkInputInt();
            }
        }
        return matrix;
    }

    /**
     * This method is used to display a matrix. It takes a 2D array as input and
     * prints each element of the matrix in a formatted manner. The method
     * iterates over each row and column of the matrix and prints the
     * corresponding element enclosed in square brackets. After printing all
     * elements of a row, a new line is printed to separate rows. This method is
     * useful for visualizing the contents of a matrix in a readable format.
     *
     * @param matrix array representing the matrix to be displayed
     */
    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    /**
     * The function performs matrix addition by taking two matrices as input,
     * checking if they are of the same size, and then adding them element-wise
     * and displaying the result.
     */
    public static void additionMatrix() {
        System.out.println("------ Addition ------");
         matrix1 = inputMatrix(1);
         matrix2 = inputMatrix(2);
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        // Check matrix 1 and matrix 2 same size
        if (row1 != row2 || column1 != column2) {
            System.out.println("Can't addition");
            return;
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    /**
     * The function performs matrix subtraction by taking two matrices as input.
     * checking if they are of the same size, and then subtracting them
     * element-wise and displaying the result.
     */
    public static void subtractionMatrix() {
        System.out.println("------ Subtraction ------");
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        // Check matrix 1 and matrix 2 same size
        if (row1 != row2 || column1 != column2) {
            System.out.println("Can't subtract");
            return;
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    /**
     * The function first takes input for two matrices, display them. If number
     * of column in a row of the first matrix not equal to number of row in a
     * column of the second matrix, can not multiply. Each value of a multiplied
     * number store in matrixResult array and finally display it.
     */
    public static void multiplicationMatrix() {
        System.out.println("------ Multiplication ------");
        matrix1 = inputMatrix(1);
        matrix2 = inputMatrix(2);
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        // A two-dimensional array is an array of arrays.
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        if (column1 != row2 || column2 != row1) {
            System.out.println("Can't multiply");
            return;
        }
        //Create two-dimensional array for save the result
        int[][] matrixResult = new int[row1][column2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        //This loop iterates over each row of "matrix1" and sum of each pair multiplication of a row matrix 1 and a column matrix 2.
        for (int i = 0; i < row1; i++) {
            //This loop iterates over each column of "matrix2"
            for (int j = 0; j < column2; j++) {
                // This loop iterates over each column of "matrix1" or each row of "matrix2"
                for (int k = 0; k < column1; k++) {
                    //In each iteration, perform the sum of the corresponding element products
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }

     /**
     * The function performs the reverse matrix multiplication by taking two matrices as input,
     * checking if they can be multiplied in reverse order, and then multiplying them
     * element-wise and displaying the result.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     */
    public static void reverseMultiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("------ Reverse Multiplication ------");
        System.out.println("Matrix2 * Matrix1 =");
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        if (column2 != row1) {
            System.out.println("Cannot perform reverse multiplication. The number of columns in Matrix2 must be equal to the number of rows in Matrix1.");
            return;
        }
        // Create result for save row2 and column1             `
        int[][] result = new int[row2][column1];
        //This loop iterates over each row of "matrix2"
        for (int i = 0; i < row2; i++) {
            // This loop iterates over each column of "matrix1"
            for (int j = 0; j < column1; j++) {
                int sum = 0;
                // This loop iterates over each column of "matrix2" or each row of "matrix1"
                for (int k = 0; k < column2; k++) {
                    //In each iteration, perform the sum of the corresponding element products
                    sum += matrix2[i][k] * matrix1[k][j];
                }
                result[i][j] = sum;
            }
        }
        displayMatrix(result);
    }
}





