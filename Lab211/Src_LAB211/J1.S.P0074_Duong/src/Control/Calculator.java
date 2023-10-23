/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 * Calculator class have 3 methods addition, subtraction and multiplication
 *
 * @author Admin
 */
public class Calculator {

    /**
     * additionMatrix function
     *
     * @param matrixFirst returns matrix First
     * @param matrixSecond returns matrixSecond
     * @return the value of matrixFirst add matrixSecond
     */
    public double[][] additionMatrix(double[][] matrixFirst, double[][] matrixSecond) {
        //Initialize row equals length of matrixFirst
        int row = matrixFirst.length;
        //Initialize column equals length of matrix length
        int column = matrixFirst[0].length;
        double[][] result = new double[row][column];
        //Traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //Traverse from first element of row to last element of column of matrix
            for (int j = 0; j < column; j++) {
                // Result equals matrixFirst add matrixSecond
                result[i][j] = matrixFirst[i][j] + matrixSecond[i][j];

            }
        }
        return result;

    }

    /**
     * subtractionMatrix function will subtract matrixFirst and matrixSecond
     *
     * @param matrixFirst returns matrixFirst value
     * @param matrixSecond returns matrixSecond value
     * @return the result after subtracting
     */
    public double[][] subtractionMatrix(double[][] matrixFirst, double[][] matrixSecond) {
        //Initialize rowMatrixFirst equals length
        int rowMatrixFirst = matrixFirst.length;
        //Initialize columnMatrixFirst equals length of column
        int columnMatrixFirst = matrixFirst[0].length;
        double[][] result = new double[rowMatrixFirst][columnMatrixFirst];
        //Traverse from first element of row to last element of row of matrix
        for (int i = 0; i < rowMatrixFirst; i++) {
            //Traverse from first element of row to last element of column of matrix
            for (int j = 0; j < columnMatrixFirst; j++) {
                //Result is the matrixFirst subtract matrixSecond
                result[i][j] = matrixFirst[i][j] - matrixSecond[i][j];

            }
        }
        return result;

    }

    /**
     * multiplicationMatrix function multiply matrixFirst with matrixSecond
     *
     * @param matrixFirst returns matrixFirst
     * @param matrixSecond returns matrixSecond
     * @return the result after multiplying
     */
    public double[][] multiplicationMatrix(double[][] matrixFirst, double[][] matrixSecond) {
        int rowMatrixFirst = matrixFirst.length;
        int rowMatrixSecond = matrixSecond.length;
        int columnMatrixSecond = matrixSecond[0].length;
        double[][] result = new double[rowMatrixFirst][columnMatrixSecond];
        //Loop from first element of row to last element of row of matrix 1
        for (int i = 0; i < rowMatrixFirst; i++) {
            //Loop from first element of column to last element of column of matrix 2
            for (int j = 0; j < columnMatrixSecond; j++) {
                //traverse from first element of row to last element of row of matrix 2
                for (int k = 0; k < rowMatrixSecond; k++) {
                    //Multiply  the matrix Second and the matrix First
                    result[i][j] += matrixSecond[k][j] * matrixFirst[i][k];
                }
            }
        }
        return result;

    }
}
