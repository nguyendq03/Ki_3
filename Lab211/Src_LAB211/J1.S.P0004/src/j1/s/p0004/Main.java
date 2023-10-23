package j1.s.p0004;
//Quick sort
import java.util.*;

/**
 * Main only call method
 *
 * @author Admin
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array;
        int array_size;
        //Step 1: Display user's input
        array_size = getInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        //Step 2: Generate array
       array =  generateArray(array_size);
        //Step 3: Display unsorted array
        array = displayUnsorted(array);
        //Step 4: Use Quicksort to sort array:
        quickSort(array, 0, array_size - 1);
        //Step 5: Display Sorted array
        displaySorted(array);
    }

    public static int getInt(String msg, int min, int max) {
        String input;
        double number = 0;
        boolean check;
        // loop until true input
        do {
            System.out.println(msg);
            check = true;
            input = sc.nextLine();
            // check if input is empty
            if (input.trim().isEmpty()) {
                System.out.println("Input can not be empty, please input positive integer number!");
                check = false;
            } else {
                try {
                    number = Double.parseDouble(input);
                    // check if input is real number
                    if (number != (int) number) {
                        System.out.println("Input can not be double number, please input positive integer number!");
                        check = false;
                    } else {
                        // check if input is out of range min-max
                        if (number < min || number > max) {
                            System.out.println("Input can not out of range " + min + " to " + max);
                            check = false;
                        } else {
                            return (int) number;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input can not be string, please input positive integer number!");
                    check = false;
                }
            }
        } while (check == false);
        return (int) number;
    }

    public static int[] generateArray(int array_size) {
        int[] array = new int[array_size];
        Random random = new Random();
        // Loop from first element to the last element 
        for (int i = 0; i < array_size; i++) {
            array[i] = random.nextInt(array_size);
        }
        return array;
    }

    //Function to displayUnsorted array
    public static int[] displayUnsorted(int[] array) {
        System.out.print("Unsorted array: [");
        Random rd = new Random();
        // loop to display from first element to before the last element 
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
        return array;
    }

    public static int partition(int[] array, int left, int right) {
        int i = left, j = right;
        int temp;
        int pivot = array[(left + right) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;

            }
            while (array[j] > pivot) {

                j--;
            }
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;

            }

        }
        return i;
    }

    public static void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {

            quickSort(array, index, right);

        }

    }
    
    
     //Function to displayUnsorted array
    public static int[] displaySorted(int[] array) {
        System.out.print("Sorted array: [");
      
        // loop to display from first element to before the last element 
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
        return array;
    }

}
