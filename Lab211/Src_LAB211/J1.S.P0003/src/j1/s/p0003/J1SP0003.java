package j1.s.p0003;

import java.util.*;
//Merge sort
public class J1SP0003 {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Main function only call method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array;
        int array_size;
        //Step 1: Display user's input
        array_size = getInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        //Step 2: Generate array
        array = generateArray(array_size);
        //Step 3: Display unsorted array
        displayUnsorted(array);
        //Step 4: Use MergeSort algorithm to sort array
         sort(array);
         //Step 5: Display sorted array
        displaysorted(array);
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
    public static int[] array;
    private static int[] tempMergArr;
    private static int array_size;

    public static void sort(int[] inputArray) {
        array = inputArray;
        array_size = inputArray.length;
        tempMergArr = new int[array_size];
        doMergeSort(0, array_size-1);
    }
    private static void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = (lowerIndex + higherIndex) / 2;
            //Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            //Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            //Nowmerger both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            while (i <= middle && j <= higherIndex) {
                if (tempMergArr[i] <= tempMergArr[j]) {
                    array[k] = tempMergArr[i];
                    i++;
                } else {
                    array[k] = tempMergArr[j];
                    j++;
                }
                k++;
            }
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
      public static int[] displaysorted(int[] array) {
        System.out.print("Sorted array: [");
        Random rd = new Random();
        // loop to display from first element to before the last element 
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
        return array;
    }

}
