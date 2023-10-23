package quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Rearrange element in such a way, that all element which are lesser than the
 * pivot go the left part of the array and all elements greater than can stay in
 * any part of the array.Notice, that array may be divided in non-equal parts.
 *
 * @author Admin
 */
public class QuickSort {

    /**
     * The main() method takes user input for the size of the array, creates an
     * array of random integers using the createArray() method, displays the
     * unsorted array using the display() method, sorts the array using the
     * quickSort() method, and displays the sorted array using the display()
     * method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: Enter a positive number
        int sizeArray = getInt("Enter number of array:");
        //Step 2: Create array by generate random integer in range
        int[] array = createArray(sizeArray);
        //Step 3:Display first sort
        System.out.println("Unsorted array: ");
        display(array);
        //Step 4: Sort by Bubble sort
        quickSort(array, 0, array.length - 1);
        //Step 5:Display last sort
        System.out.println("Sorted array: ");
        display(array);
    }

    /**
     * The partition() method rearranges the elements in the array so that all
     * elements less than the middle element are on the left and all elements
     * greater are on the right.
     *
     * @param array is the array we want to sort
     * @param first is the first index of array
     * @param last is the last index of array
     * @return index to first partition next time
     */
    public static int partition(int[] array, int first, int last) {
        //Create variable for swapping element in array
        int temp;
        //Middle is the middle element of array
        int middle = array[(first + last) / 2];
        //Loop using array parses into two parts: a part with smaller elements in the middle, 
        //and a part with larger elements in the middle.
        while (first <= last) {
            //Find the first element from the first to the right that is less than middle
            while (array[first] < middle) {
                first++;
            }
            //Find the first element from the last to the left that has a value greater than middle
            while (array[last] > middle) {
                last--;
            }
            //If first less than or equal last, then first and last will swap position
            if (first <= last) {
                //temp save value make swap
                temp = array[first];
                array[first] = array[last];
                array[last] = temp;
                first++;
                last--;
            }
        }
        return first;
    }

    /**
     * The quickSort() method uses recursion to apply the partition() method to
     * divide the array into two parts, with elements less than the middle
     * element on the left and elements greater on the right. The method then
     * applies the partition() method again to each of the two parts until the
     * array is sorted.
     *
     * @param array is the array we want to sort
     * @param start is element left side of array
     * @param last is element right side of array
     */
    public static void quickSort(int[] array, int start, int last) {
        //Call method partition
        int index = partition(array, start, last);
        //If left side of middle, at least two element, using recursive for left side
        if (start < index - 1) {
            quickSort(array, start, index - 1);
        }
        //If right side of middle, at least two element, using recursive for right side
        if (last > index) {
            quickSort(array, index, last);
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
     * The createArray() method generates an array of random integers based on
     * the user input.
     *
     * @param sizeArray the size of array to create
     * @return the array of random integers
     */
    public static int[] createArray(int sizeArray) {
        //Initialize array integer
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
