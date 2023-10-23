package selectionsort;

import java.util.*;

/**
 * Selection sort is a simple sorting algorithm, based on in-place comparison.
 * Select the smallest of the initial n elements, returning this element to the
 * correct first position in the current sequence. Then ignore it, see that the
 * current sequence has only n-1 elements of the original sequence, starting
 * from position 2.
 *
 * @author Admin
 */
public class SelectionSort {

    /**
     * The main() method takes user input for the size of the array, creates an
     * array of random integers using the createArray() method, displays the
     * unsorted array using the display() method, sorts the array using the
     * sortArrayBySelectionSort() method, and displays the sorted array using
     * the display() method.
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
        sortArrayBySelectionSort(array);
        // Step 5: Display last sort
        System.out.println("Sorted array: ");
        display(array);
    }

    /**
     * Selection Sort is a selects the minimum element from the unsorted portion
     * of the array and places it at the beginning. It works by dividing the
     * input array into two parts: the sorted part at the beginning and the
     * unsorted part at the end. Initialize, the sorted part is empty, and the
     * unsorted part contains the entire array
     *
     * @param array: array integer need to arrange
     *
     */
    public static void sortArrayBySelectionSort(int[] array) {
        // Loop through the array from the first element to the second-to-last element
        for (int i = 0; i < array.length - 1; i++) {
            //Initialize the index of the smallest element to the current index
            int minIndex = i;
            //Check over the elements from position i+1 to the end of the array
            //j:The smallest element from the current position to the end of the array is found
            //Looping through the array and finding the smallest element from the current position to the end of the array
            for (int j = i + 1; j < array.length; j++) {
                //Compare with values smallest current and find new values smallest
                //and if a smaller element is found, its index is stored
                if (array[minIndex]> array[j]) {
                    minIndex = j;
                }
            }
            //Check if min Index different i,then will find values smallest
            //Then swapping position between element array[i] and element array[minIndex] by using variable temp
            if (minIndex != 1) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
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
