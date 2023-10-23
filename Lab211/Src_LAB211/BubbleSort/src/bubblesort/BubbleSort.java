package bubblesort;

import java.util.*;

/**
 * Bubble sort is a simple sorting algorithm, with the basic operation is 
 * to compare two adjacent elements, if they are not in the correct order, swap places.
 * Can be done from top down (left to right) or bottom up (right side).
 * @author Admin
 */
public class BubbleSort {

    /**
     * The main() method takes user input for the size of the array, creates an
     * array of random integers using the createArray() method, displays the
     * unsorted array using the display() method, sorts the array using the
     * bubbleSort() method, and displays the sorted array using the display()
     * method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Step 1: Enter a positive number
        int sizeArray = getInt("Enter number of array:");
        // Step 2: Create array by generating random integers in range
        int[] array = createArray(sizeArray);
        // Step 3: Display first sort
        System.out.println("Unsorted array: ");
        display(array);
        // Step 4: Sort by Bubble sort
        bubbleSort(array);
        // Step 5: Display last sort
        System.out.println("Sorted array: ");
        display(array);
    }

    /**
     * The bubbleSort() method takes an array as input and uses nested loops to
     * iterate through the array and perform comparisons and swaps to sort the
     * array in ascending order.
     *
     * @param array is the array we want to sort
     */
    public static void bubbleSort(int[] array) {
        // Loop to first element to the last element
        for (int i = 0; i < array.length; i++) {
            // When loop for, then that will reduce the remaining element
            for (int j = 0; j < array.length - i - 1; j++) {
                // If first elements greater than, will perform permutation
                if (array[j] > array[j + 1]) {
                    // Algorithm swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * The display() method simply prints out the elements in the array.
     *
     * @param array the array to display
     */
    public static void display(int[] array) {
        System.out.println(Arrays.toString(array));
    }


    /**
     * The createArray() method takes the size of the array as input and
     * generates an array of random integers using the Random class.
     *
     * @param sizeArray the size of array to create
     * @return the array of random integers
     */
    public static int[] createArray(int sizeArray) {
        // Initialize array of integers
        int[] array = new int[sizeArray];
        //Create array random
        Random random = new Random();
        //This loop run from the firsts to sizeArray
        for (int i = 0; i < sizeArray; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    /**
     * The getInt() method takes a message as input and prompts the user to
     * enter a positive integer. It validates the input and returns the integer
     * value.
     *
     * @param mess the message to display to the user
     * @return the positive integer entered by the user
     *
     */
    public static int getInt(String mess) {
        // Scanner object to read user input from the console
        Scanner sc = new Scanner(System.in);
        // Create variable integer is sizeArray
        int sizeArray;
        String input;
        //The method uses a do-while loop to ensure that the user enters a valid input
        do {
            System.out.println(mess);
            input = sc.nextLine();
            // it displays an error message and prompts the user to enter a non-empty input
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty");
              //  If the input is less than 0, it displays an error message and prompts the user to enter a positive integer.
            } else {
                sizeArray = Integer.parseInt(input);
                break;
            }
          //This loop unique true
        } while (true);
        return sizeArray;
    }
}
