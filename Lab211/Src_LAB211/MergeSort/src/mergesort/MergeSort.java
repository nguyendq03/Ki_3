/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: Enter a positive number
        int size_array = getInt("Enter number of array:");
        //Step 2: Create array by generate random integer in range
        int[] array = createArray(size_array);
        //Step 3:Display first sort
        System.out.println("Unsorted array: ");
        display(array);
        //Step 4: Sort by Bubble sort
        mergeSort(array);
        //Step 5:Display last sort
        System.out.println("Sorted array: ");
        display(array);
    }

    /**
     * Rearrange element in such a way, that all element which are lesser than
     * th pivot go the left part of the array and all elements greater than can
     * stay in any part of the array.Notice, that arrat may be divided in
     * non-equal parts.
     *
     * @param array is the array we want to sort
     * @param start is the first index of array
     * @param last is the last index of array
     */
    public static int partition(int[] array, int start, int last) {
        int temp;
        //Middle is tbe middle element of array
        int middle = array[(start + last) / 2];
        while (start <= last) {
            while (array[start] < middle) {
                start++;
            }
            while (array[last] > middle) {
                last--;
            }
            if (start <= last) {
                temp = array[start];
                array[start] = array[last];
                array[last] = temp;
                start++;
                last--;
            }
        }
        return start;
    }

    public static void quickSort(int[] array, int start, int last) {
        int index = partition(array, start, last);
        if (start < index - 1) {
            quickSort(array, start, index - 1);
        }
        if (last > index) {
            quickSort(array, index, last);
        }
    }

    /**
     * Apply quick sort algorithm recursively to the left and the right parts
     *
     * @param array
     * @param start
     * @param last
     */
    /**
     *
     * @param array
     */
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i]);
            }
        }
    }

    /**
     *
     * @param size_Array
     * @return
     */
    public static int[] createArray(int size_Array) {
        //Intialize array integer
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    /**
     *
     * @param mess
     * @return
     */
    public static int getInt(String mess) {

        Scanner sc = new Scanner(System.in);
        int size_Array;
        String input;
        do {
            System.out.println(mess);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input counldn't be empty");
                continue;
                //If less than 0
            } else {
                size_Array = Integer.parseInt(input);
                break;
            }
        } while (true);
        return size_Array;
    }

    /**
     * A function use to Merge sort, if array don't have any elements, or only
     * have one elements,so it will stop
     *
     * @param array is the array we need to sort
     */
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] temp = new int[array.length];
        divideArray(array, temp, 0, array.length - 1);
    }

    /**
     * A function to divide the array to start Merger sort.This function divide
     * an array to 2 parts, left part and right part, divide it from
     * mid=(right+left)/2 and copy it to temp, which consists unsorted array
     *
     * @param array is the array we need to sort
     * @param temp is the array we copied original array into
     * @param leftSide is left point of the array
     * @param rightSide is the last point of the array
     */
    public static void divideArray(int[] array, int[] temp, int leftSide, int rightSide) {
        if (leftSide >= rightSide) {
            return;
        }
        int mid = (leftSide + rightSide) / 2;
        divideArray(array, temp, leftSide, mid);
        divideArray(array, temp, mid + 1, rightSide);
        mergeArray(array, temp, leftSide, mid, rightSide);

    }

    /**
     * Merge sort takes advantage of the case of merging already sorted lists
     * into a new sorted list.it start by comparing every two elements. 1 with
     * 2, then 3 with 4, and swapping them if the first should come after the
     * second. It then merge each of the resulting lists of two into two lists
     * are merge into the final sorted list
     *
     * @param array is the array we need to sort
     * @param temp is the array consists of an unsorted array
     * @param leftSide is the left side of the array
     * @param mid is the mid point of the array
     * @param rightSide
     */
    public static void mergeArray(int[] array, int[] temp, int leftSide, int mid, int rightSide) {
        //Copy all unsorted array to temperature array temp
        for (int copy = leftSide; copy <= rightSide; copy++) {
            temp[copy] = array[copy];
        }
        int halfLast = leftSide;
        int halfRight = mid + 1;
        int unsortedIndex = leftSide;
        //We compare temp (halfLast) and temp (halfRight) and insert result to temp array
        while (halfLast <= mid && halfRight <= rightSide) {
            if (temp[halfLast] <= temp[halfRight]) {
                array[unsortedIndex] = temp[halfLast];
                halfLast++;
            } else {
                array[unsortedIndex] = temp[halfRight];
                halfRight++;
            }
            unsortedIndex++;
        }
        //Copy the result temperature array to main unsorted array
        while (halfLast <= mid) {
            array[unsortedIndex] = temp[halfLast];
            halfLast++;
            unsortedIndex++;
        }
    }
}
