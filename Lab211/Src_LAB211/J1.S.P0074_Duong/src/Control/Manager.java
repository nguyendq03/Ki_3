package Control;

import Utils.GetData;

/**
 * Manager class has methods which display and return the value of matrix
 *
 * @author Admin
 */
@SuppressWarnings("ALL")
public class Manager {

    GetData getdata = new GetData();

    /**
     * displayManu function displays the choice for user to input
     */
    public void displayMenu() {
        System.out.println("=========Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    /**
     * displayAddition function display format addition
     */
    public void displayAddition() {
        System.out.println("---------Addition---------");
    }

    public void displaySubtraction() {
        System.out.println("----------Subtraction-------");
    }

    public void displayMultiplication() {
        System.out.println("----------Multiplication--------");
    }

    /**
     * getMatrixFirst function take value of matrixFirst
     * @return the matrix first
     */
    public double[][] getMatrixFirst() {
       //Initialize rowMatrixFirst to get the input value of rowMatrixFirst
        int rowMatrixFirst = getdata.getInt("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        //Initialize columnMatrixFirst get the input of columnMatrixFirst 
        int columnMatrixFirst = getdata.getInt("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        double[][] matrix = new double[rowMatrixFirst][columnMatrixFirst];
        // Traverse from first element of row to last element of row of matrix
        for (int i = 0; i < rowMatrixFirst; i++) {
            // Traverse from first element of row to last element of column of matrix
            for (int j = 0; j < columnMatrixFirst; j++) {
                String message = String.format("Enter Matrix1" + "[%d][%d]:", (i + 1), (j + 1));
                matrix[i][j] = getdata.getMatrix(message);

            }

        }

        return matrix;

    }

    /**
     * getMatrixSecond function returns the matrix of second of user's input
     * @param matrixFirst returns matrix value
     * @param choice returns value choice
     * @return value of matrixSecond
     */
    @SuppressWarnings("UnnecessaryContinue")
    public double[][] getMatrixSecond(double[][] matrixFirst, double choice) {
        //Initialize matrixSecond equals null
        @SuppressWarnings("UnusedAssignment")
        double[][] matrixSecond = null;
        int rowMatrixFirst = matrixFirst.length;
        int columnMatrixFirst = matrixFirst[0].length;
        int rowMatrixSecond, columnMatrixSecond;
        if (choice == 3) {
            do {
                rowMatrixSecond = getdata.getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //Check row of matrix2 equal or not column of matrix 1
                if (rowMatrixSecond != columnMatrixFirst) {
                    System.out.println("Row matrix 2 must be equal column matrix 1");
                    continue;

                }
                //Input the column Matrix Second
                columnMatrixSecond = getdata.getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                break;

            } while (true);

        } else {
            do {
                //Prompt user to input choice
                rowMatrixSecond = getdata.getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //Check row of matrix2 equal or not of matrix 1
                if (rowMatrixSecond != rowMatrixFirst) {
                    System.out.println("Row matrix2 must be equal row matrix 1");
                    continue;
                } else {
                    break;
                }

            } while (true);
            do {
                columnMatrixSecond = getdata.getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                //Check column of matrix2 equal or not column of matrix 1
                if (columnMatrixSecond != columnMatrixFirst) {
                    System.out.println("Column matrix 2 must be equal column matrix 1");
                    continue;

                } else {
                    break;
                }

            } while (true);

        }
       
        matrixSecond = new double[rowMatrixSecond][columnMatrixSecond];
        //Traverse from first element of row to last element of row of matrix
        for (int i = 0; i < rowMatrixSecond; i++) {
            //Traverse from first element of row to last element of column of matrix
            for (int j = 0; j < columnMatrixSecond; j++) {
                String message = String.format("Enter Matrix2" + "[%d][%d]:", i + 1, j + 1);
                matrixSecond[i][j] = getdata.getMatrix(message);
            }

        }

        return matrixSecond;

    }

    public void displayMatrix(double[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        //Travese from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //Travese from first element of row to last element of column of matrix
            for (int j = 0; j < column; j++) {
                System.out.format("[%.2f]", matrix[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * displayResult function displays the result
     *
     * @param matrixFirst returns matrixFirst value
     * @param matrixSecond returns matrixSecond value
     * @param result returns value of result
     * @param choice returns choice value
     */
    public void displayResult(double[][] matrixFirst, double[][] matrixSecond, double[][] result, double choice) {

        System.out.println("--------Result---------");
        displayMatrix(matrixFirst);
        switch ((int)choice) {
            //If the input is add
            case 1:
                System.out.println("+");
                break;
            //If the input is subtract
            case 2:
                System.out.println("-");
                break;
            //If the the input is multiply
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrixSecond);
        System.out.println("=");
        displayMatrix(result);

    }
}
