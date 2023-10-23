package insertionsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Insertion sort, also known as insertion sort algorithm, works somewhat
 * similar to bubble sort. The insertion sort algorithm selects the values of
 * the elements in the array (from the 2nd to the last) in turn and compares
 * them with the values before their positions. If a suitable position is found,
 * the element will be inserted in the appropriate position between the previous
 * values, but still ensuring the array is sorted in order.
 *
 * @author Admin
 */
public class InsertionSort {

    /**
     * The main() method takes user input for the size of the array, creates an
     * array of random integers using the createArray() method, displays the
     * unsorted array using the display() method, sorts the array using the
     * insertionSort() method, and displays the sorted array using the display()
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
        insertionSort(array);
        //Step 5:Display last sort
        System.out.println("Sorted array: ");
        display(array);
    }

    /**
     * The function takes an integer array as input and sorts it in ascending
     * order. The algorithm works by iterating through the array and comparing
     * each element to the elements before it. If the element is smaller than
     * the previous element, it is moved to the left until it reaches its
     * correct position in the sorted array. This process is repeated until the
     * entire array is sorted. The time complexity of this algorithm is O(n^2)
     * in the worst case.
     *
     * @param array is numbers integer of array
     */
    public static void insertionSort(int[] array) {
        //This loop run from 1 to the last element.
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
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
        Random rd = new Random();
        for (int i = 0; i < sizeArray; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    /**
     * The getInt() method is a utility method that prompts the user to enter a
     * positive integer and returns it. It checks if the input is empty or less
     * than zero and prompts the user to enter a valid input.
     *
     * @param message the message to display to the user
     * @return the positive integer entered by the user
     */
    public static int getInt(String message) {

        Scanner sc = new Scanner(System.in);
        int sizeArray;
        String input;
        do {
            System.out.println(message);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty");
                //If less than 0
            } else {
                sizeArray = Integer.parseInt(input);
                break;
            }
        } while (true);
        return sizeArray;
    }

}
