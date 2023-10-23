package binary;
 import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
 public class Binary {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.println("Enter number of array:");
        int length = scanner.nextInt();
         System.out.println("Enter search value:");
        int search = scanner.nextInt();
         int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
         bubbleSortAscending(array);
        System.out.print("Sorted array: ");
        printArray(array);
         List<Integer> foundIndices = binarySearchAll(array, search, 0, length - 1);
        if (!foundIndices.isEmpty()) {
            System.out.println("Value " + search + " found at: " + foundIndices);
        } else {
            System.out.println("Value " + search + " not found.");
        }
    }
     /**
     * Prints the given array to the console.
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
     /**
     * Sorts the given array in ascending order using the bubble sort algorithm.
     */
    public static void bubbleSortAscending(int[] arr) {
        boolean swapped;
        int tmp;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
     /**
     * Searches for all occurrences of the given search value in the given array using binary search.
     * Returns a list of indices where the search value was found.
     */
    public static List<Integer> binarySearchAll(int[] array, int searchValue, int left, int right) {
        List<Integer> indices = new ArrayList<>();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == searchValue) {
                indices.add(mid);
                for (int i = mid - 1; i >= 0 && array[i] == searchValue; i--) {
                    indices.add(i);
                }
                for (int i = mid + 1; i < array.length && array[i] == searchValue; i++) {
                    indices.add(i);
                }
                return indices;
            } else if (array[mid] < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return indices;
    }

}