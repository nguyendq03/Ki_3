/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 * this class will display 45 sequence Fibonacci
 */

/**
 *
 * @author Admin
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Print 45 sequence fibonacci
        System.out.println("The 45 sequence fibonacci:");
        //this is loop display from 0 to 44
        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacci(i) + ", ");
        }
    }

    //this is recursion base
    static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }

}
