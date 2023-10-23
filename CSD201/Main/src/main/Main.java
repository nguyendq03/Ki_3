/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static  Scanner scanner = new Scanner(System.in);
    public static void inputArr(int a[])
    {
        //nhập giá trị các phần tử của mảng
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < a.length; i++){
            System.out.print("a["+i+"] = ");
            a[i] = scanner.nextInt();
        }
    }
    public static void showArr(int a[])
    {
        System.out.println("Show array:");
        for(int i = 0; i < a.length - 1; i++){
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1]);
    }
    //insert first, last, index
    public static int insertLast(int a[], int n)
    {
        int[] newArr = new int[a.length + 1];
        for(int i = 0; i < a.length; i++)
            newArr[i] = a[i];
        newArr[newArr.length - 1] = n;
        System.out.println("--Array has been inserted at the last index--");
        showArr(newArr);
        return -1;   
    }
    public static int insertFirst(int a[], int n)
    {
        int[] newArr = new int[a.length + 1];
        newArr[0] = n;
        for(int i = 1; i < newArr.length; i++)
            newArr[i] = a[i - 1];
        System.out.println("--Array has been inserted at the first index--");
        showArr(newArr);
        return -1;   
    }
    public static int insertIndex(int a[], int n)
    {
        int[] newArr = new int[a.length + 1];
        System.out.print("Enter index to insert: ");
        int pos = scanner.nextInt();
        newArr[pos] = n;
        for(int i = 0; i < pos; i++)
            newArr[i] = a[i];
        for(int i = pos + 1; i < newArr.length; i++)
            newArr[i] = a[i - 1];
        System.out.println("--Array has been inserted at the " + " index of " + pos + "--");
        showArr(newArr);
        return -1;   
    }
    //search index
    public static int searchIndex(int a[], int n)
    {
        int idx = -1;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == n) {
                idx = i;
                break;
            }
        }
        if(idx != -1)
            System.out.println("Found " + n + " at index of " + idx);
        else
            System.out.println("Not found!");
        return -1;
    }
    //Delete index
    public static  int deleteIndex(int a[], int n)
    {
        int[] newArr = new int[a.length - 1];
        int idx = -1;
        for(int i = 0; i < a.length; i++)
            if(a[i] == n)
                idx = i;
        System.out.println("Array has been deleted first value: " + n);
        if(idx != -1) {
            for(int i = 0; i < idx; i++)
                newArr[i] = a[i];
            for(int i = idx + 1; i <= newArr.length; i++)
                newArr[i - 1] = a[i];
        showArr(newArr);
        }
        else {
            showArr(a);
        }
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        int size = 10; //kích thước của mảng
        //nhập số phần tử thực tế của mảng
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        int a[] = new int [size];
        inputArr(a);
        showArr(a); 
    
    }
    
}
