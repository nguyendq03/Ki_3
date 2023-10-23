package j1sp0010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The above code is a Java program that implements linear search algorithm to
 * find the indices of a given search value in an array.
 *
 * @author Admin
 */
public class J1SP0010 {

    /**
     * The above code is a Java program that prompts the user to enter the number of elements in an array and a search value.
     * It then generates random numbers for the array and sorts them. The program then displays the index of the array
     * and performs a linear search for the search value.
     * If the search value is found in the array, the program displays its index. Otherwise, it outputs "Not found".
     *
     */
    //Create a static variable array
    static int[] array;

    /**
     * The above code is the main method of a program that performs linear search on an array of random integers.
     * It prompts the user to enter the number of elements in the array and the value to be searched.
     * It then calls the method generateRandomNumber to create an array of random integers and sorts it.
     * The method display is called to print the index of the array. The method linearSearch is called to search for the value in the array.
     * If the value is found, the index is printed, otherwise, a message "Not found" is displayed.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Enter input for user
        System.out.println("Enter number of array: ");
        int numberArray = scanner.nextInt();
        System.out.println("Enter search value: ");
        int searchValue = scanner.nextInt();
        //Create generateRandomNumber
        generateRandomNumber(numberArray);
        //Sort array random
        System.out.println("Array:");
        //Create display index
        display();
        //Check if list is empty, if not empty then display index to user
        List<Integer> list = linearSearch(array, searchValue);
        if (list.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println("Found" + searchValue + " at index: " + list);
        }
    }

    /**
     * Displays the array using the display function

     */
    public static void display() {

        System.out.println(Arrays.toString(array));
    }
    /**
     * Generates random numbers for the array using the generateRandomNumber function
     * @param numberArray is integers numbers of array
     */
    public static void generateRandomNumber(int numberArray) {
        //Create array have elements equal elements enter input
        array = new int[numberArray];
        Random random = new Random();
        //Use loop for run from 0 to array_length and display number in array
        for (int i = 0; i < array.length; i++) {
            //Initialize array random
            int randomNumber = random.nextInt(numberArray);
            array[i] = randomNumber;
        }
    }

    /**
     * The linearSearch function is used to find the indices of the search value in the arrayThe linearSearch function
     * is used to find the indices of the search value in the array
     * @param array : The array to be searched in
     * @param searchValue : The value to be searched
     * @return list have added
     */
    public static List<Integer> linearSearch(int[] array, int searchValue) {
        //Create a List to add the indices
        List<Integer> list = new ArrayList<>();
        //Loop will pass all elements make check all elements
        for (int i = 0; i < array.length; i++) {
            //If elements equal to searchValue, return index of elements
            if (array[i] == searchValue) {
                //Adds the index of that element to a list
                list.add(i);
            }
        }
        return list;
    }

}
