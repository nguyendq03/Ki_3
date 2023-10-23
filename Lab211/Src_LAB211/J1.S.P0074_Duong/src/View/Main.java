/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Calculator;
import Control.Manager;
import Utils.GetData;


/**
 * Main only calls method and display function
 * @author Admin
 */
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        GetData getdata = new GetData();
        Manager manage = new Manager();
        do {

            //Step1: Display menu
            manage.displayMenu();
            //Step 2: Display choice
            int choice = getdata.getInt("Your choice: ", 1, 4);
            //Step 3: Perform based user's choice
            switch (choice) {
                //Option 1: Addition matrix
                case 1:
                    manage.displayAddition();
                    //input matrix 1
                    double[][] matrix1 = manage.getMatrixFirst();
                    //input matrix2
                    double[][] matrix2 = manage.getMatrixSecond(matrix1, choice);
                    //Add 2 matrix: matrix 1 and matrix 2
                    double[][] result = calculator.additionMatrix(matrix1, matrix2);
                    //Display result
                    manage.displayResult(matrix1, matrix2, result, choice);
                    break;

                //Option 2: Subtraction matrix
                case 2:
                    manage.displaySubtraction();
                    //input matrix 1
                    matrix1 = manage.getMatrixFirst();
                    //input matrix2
                    matrix2 = manage.getMatrixSecond(matrix1, choice);
                    //Subtract 2 matrix: matrix 1 and matrix 2
                    result = calculator.subtractionMatrix(matrix1, matrix2);
                    //Display result
                    manage.displayResult(matrix1, matrix2, result, choice);
                    break;

                case 3:
                    manage.displayMultiplication();
                    //input matrix 1
                    matrix1 = manage.getMatrixFirst();
                    //input matrix2
                    matrix2 = manage.getMatrixSecond(matrix1, choice);
                    //Mutiplicate 2 matrix: matrix 1 and matrix2
                    result = calculator.multiplicationMatrix(matrix1, matrix2);
                    //Display result
                    manage.displayResult(matrix1, matrix2, result, choice);

                    System.out.println("The result the matrix2 multiply the matrix 1: ");
                    result = calculator.multiplicationMatrix(matrix2, matrix1);
                    //Display result
                    manage.displayResult(matrix2, matrix1, result, choice);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

        } while (true);
    }
}
